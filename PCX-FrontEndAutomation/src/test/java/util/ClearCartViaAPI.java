package util;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ClearCartViaAPI {

    public void fetchCartId(String pcID){
        String cartId= given().accept("application/json").param("statuses","open").header("X-Loblaw-Tenant-ID","ONLINE_GROCERIES").header("X-Loblaw-Device-Type","WEB").when().get("https://platform-cart-api-qa.useast1-lower-gke1.lblw.cloud/api/v1/customers/"+pcID+"/carts").then()
                .extract().path("response.carts.cart_id").toString().replace("[","").replace("]","");
        Log.info("CartId: "+cartId);

        given().accept("*/*").header("X-Loblaw-Tenant-ID","ONLINE_GROCERIES").header("X-Loblaw-Device-Type","WEB").header("X-Loblaw-PCID",pcID).contentType("application/json").header("business-user-agent","PLATFORM_ORDER_SYSTEM").body("{\n" +
                "  \"event\": \"order-placed\",\n" +
                "  \"is_live_order\": false\n" +
                "}").when().post("https://platform-cart-api-qa.useast1-lower-gke1.lblw.cloud/api/v1/carts/"+cartId+"/order-callback").then().assertThat().statusCode(204);
    }

    public String fetchCartsOfUser(String pcId,String param){
        return given().accept("application/json").param("statuses",param).header("X-Loblaw-Tenant-ID","ONLINE_GROCERIES").header("X-Loblaw-Device-Type","WEB").when().get("https://platform-cart-api-qa.useast1-lower-gke1.lblw.cloud/api/v1/customers/"+pcId+"/carts").then()
                .extract().response().asString();
    }

    public String fetchOpenCartBanner(String banner,String pcId){
        String cartId="";
        boolean live=false;
        JsonPath jsonPath=new JsonPath(fetchCartsOfUser(pcId,"open"));
        int numberOfCarts=jsonPath.getInt("response.carts.size()");
        Log.info("Number of available carts: "+numberOfCarts);
        for(int i=0;i<numberOfCarts;i++){
            if(jsonPath.getString("response.carts["+i+"].banner_id").equalsIgnoreCase(banner)){
                cartId=cartId.concat(jsonPath.getString("response.carts["+i+"].cart_id"));
            }
        }
        Log.info("Open Cart ID: "+cartId);
        return cartId;
    }

    public String fetchTheLiveCart(String banner,String pcId){
        String cartId="";
        JsonPath jsonPath=new JsonPath(fetchCartsOfUser(pcId,"live-order"));
        int numberOfCarts=jsonPath.getInt("response.carts.size()");
        Log.info("Number of available carts: "+numberOfCarts);
        for(int i=0;i<numberOfCarts;i++){
            if(jsonPath.getString("response.carts["+i+"].banner_id").equalsIgnoreCase(banner)){
                cartId=cartId.concat(jsonPath.getString("response.carts["+i+"].cart_id"));
            }
        }
        Log.info("Live Cart: "+cartId);
        return cartId;
    }

    public void clearTheCart(String banner,String pcId){
        if (!fetchOpenCartBanner(banner,pcId).isEmpty()){
            Log.info("Open Cart: "+fetchOpenCartBanner(banner,pcId));
            given().accept("*/*").header("X-Loblaw-Tenant-ID","ONLINE_GROCERIES").header("X-Loblaw-Device-Type","WEB").header("X-Loblaw-PCID",pcId).contentType("application/json").header("business-user-agent","PLATFORM_ORDER_SYSTEM").body("{\n" +
                    "  \"event\": \"order-placed\",\n" +
                    "  \"is_live_order\": false\n" +
                    "}").when().post("https://platform-cart-api-qa.useast1-lower-gke1.lblw.cloud/api/v1/carts/"+fetchOpenCartBanner(banner,pcId)+"/order-callback").then().assertThat().statusCode(204);
        }
        else if (!fetchTheLiveCart(banner,pcId).isEmpty()){
            Log.info("Live Cart: "+fetchTheLiveCart(banner,pcId));
            given().accept("*/*").header("X-Loblaw-Tenant-ID","ONLINE_GROCERIES").header("X-Loblaw-Device-Type","WEB").header("X-Loblaw-PCID",pcId).contentType("application/json").header("business-user-agent","PLATFORM_ORDER_SYSTEM").body("{\n" +
                    "  \"event\": \"order-locked\",\n" +
                    "  \"is_live_order\": false\n" +
                    "}").when().post("https://platform-cart-api-qa.useast1-lower-gke1.lblw.cloud/api/v1/carts/"+fetchTheLiveCart(banner,pcId)+"/order-callback").then().assertThat().statusCode(204);
        }
        else {
            Log.error("There is some error with the given data. Hence,cart cannot be cleared.");
        }
    }


}
