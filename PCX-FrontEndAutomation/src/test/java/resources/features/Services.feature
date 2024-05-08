Feature: Service

  @Services @Wholesale
  Scenario: Services Pharmacy TC-84
    Given I am a user who is on banner.ca
    When I click into Services > Pharmacy in the navigation
    Then I want to be taken to the pharmacy homepage
    And I should see copy explaining what the Pharmacy service is
    And I should see the location I have in my header repeated on the page
    And I should see Pharmacy hours for today
    And I should see the telephone, fax, pharmacy manager & Pharmacy license # details
    And I should see the licensing body information (incl. licensed by,addrss, tel, fax & logo)
    And I should see Pharmacy hours for the entire week
    And I should be able to select another location where the service is available (clicking this will take me to a store locator page)
    And I should see a banner with Health Matters Here information with a disclaimer drawer
    And I should see six relevant content modules (captured in next test case)
    And I should see pharamcy services description
    And I should see legal disclaimer

  @Services @Wholesale
  Scenario: Services Pharmacy TC-85
    Given I am a user who is on banner.ca
    When I click into Services > Pharmacy in the navigation and go to the Pharmacy Services page,
    Then I should see the following six relevant content modules, with a title, body copy and CTA for each:
    And Flu Shots are Now Available
    # https://www.loblaws.ca/flu?icid=drx_flu%20shots_cta_2_well
    And COVID-19 Vaccines available
    # https://covid19.yourhealthmattershere.ca/
    And Submit a photo of prescription
    # https://access.eforms.loblaw.ca/prescriptionphoto/
    And Naloxone Kits
    # https://www.loblaws.ca/naloxone
    And Opiod Agonist Therapy
    # https://www.loblaws.ca/oat?icid=pharmacy_cta
    And Adult Vaccinations
    # https://www.loblaws.ca/adult-vaccination?icid=pharmacy_cta
    And Medication Plan
    # https://www.loblaws.ca/medication-reviews?icid=pharmacy_cta

#  Flue Shot page show coming soon 'https://www.preprod.loblaws.ca/flu?icid=drx_flu%20shots_cta_2_well'
#  @Services @Wholesale
#  Scenario: Services Pharmacy TC-86
#    Given I am a user who is on banner.ca
#    When I click into Services > Pharmacy and click the Flu Shots content module
#    Then A new tab should open and I shoud be taken to 'flu?icid=drx_flu%20shots_cta_2_well'
#    And then I should see a button to go to 'https://www.shoppersdrugmart.ca/en/health-and-pharmacy/pharmacy-services/flu-shot'

#  NO Naloxone Kit content module found on the Pharmacy Services.
#  @Services @Wholesale
#  Scenario: Services Pharmacy TC-87
#    Given I am a user who is on banner.ca
#    When I click into Services > Pharmacy and click the Naloxone Kit content module
#    Then I should be taken to 'naloxone'
#    And I should see a header module with a title and copy
#    And I should see a description of what Nalaxone is, what is in a kit and who should get a kit

  @Services @Wholesale
  Scenario: Services Pharmacy TC-88
    Given I am a user who is on banner.ca
    When I click into Services > Pharmacy and click the Opiod Agonist content module
    Then I should be taken to 'oat?icid=pharmacy_cta'
    And I should see a header module with a title and copy
    And I should see a description of what Opiod Agonist Therapy is
    And I should be able to click Back to Pharmacy to go back

# NO medication plan content module found on the Pharmacy Services.
#  @Services @Wholesale
#  Scenario: Services Pharmacy TC-89
#    Given I am a user who is on banner.ca
#    When I click into Services > Pharmacy and click the Medication Plan content module
#    Then I should be taken to 'medication-reviews?icid=pharmacy_cta'
#    And I should see a header module with a title and copy
#    And I should see four content modules with a title & CTA:
#    And Medication Review & FAQs: 'medication-reviews-frequently-asked-questions'
#    And Questions for your pharmacist: 'questions-for-your-pharmacist'
#    And Key Benefits of a Medication Review: '4-key-benefits-of-a-medication-review-with-your-pharmacist'
#    And Strategies for Sticking with your Medication: 'strategies-for-sticking-with-your-medication'
#     # NOTE: each of these links is a content page with a text & body copy only

  @Services @Wholesale
  Scenario: Services Pharmacy TC-90
    Given I am a user who is on banner.ca
    When I click into Services > Pharmacy and click the Adult Vaccinations content module
    Then I should be taken to 'adult-vaccination?icid=pharmacy_cta'
    And I should see a header module with a title and copy
    And an CTA to Book Now clicking will take me to 'https://loblawpharmacy.medmeapp.com/schedule/groups/ImmunizationInjection'
    And I should see six content modules with a title & CTA:
    And Vaccinations & Immunizations: 'vaccinations-immunization'
    And Why vaccinate?: 'why-vaccinate'
    And Shingles 'shingles'
    And Pnemococcal Disease: 'pneumococcal-disease'
    And Hep A & B : 'hepatitis-a-b'
    And HPV 'hpv'
     # NOTE: each of these links is a content page with a text & body copy only"

  @Services @Wholesale
  Scenario: Services Pharmacy TC-91
    Given I am a user who is on banner.ca
    When I click into Services > Dietitians in the navigation
    Then A new tab should open and take me to 'https://www.dietitianservices.ca/?navid=flyout-L2-Dietitians'

  @Services @Wholesale
  Scenario: Services Pharmacy TC-92
    Given I am a user who is on banner.ca where there IS an Optical service
    When I click into Services > Optical in the navigation
    Then I want to be taken to the Optical homepage
    And I should see a promotional banner with a CTA to see details
    And I should see copy explaining what the Optical service is
    And I should see the location I have in my header repeated on the page
    And I should see Optical hours for today
    And I should see Optical hours for the entire week
    And I should be able to select another location where the service is available (clicking this will take me to a store locator page)
    And I should see four different images with subtitles, body copy and CTAs (detailed below):
    And Prescription Eyewear link: 'optical-information#prescription'
    And Contact Lenses link: 'optical-information#contact'
    And Warranty link: 'optical-information#warranty'
    And Eye exam link: 'optical-information#eye'
    And I should see a banner with brands we carry
    And I should see optical legal disclaimer

  @Services @Wholesale
  Scenario: Services Pharmacy TC-93
    Given I am a user who is on banner.ca where there IS NOT an Optical service
    When I click into Services > Optical in the navigation
    Then I want to be taken to the Optical homepage
    And I should see a promotional banner with a CTA to see details
    And I should see copy explaining what the Optical service is
    And I should see the location I have in my header repeated on the page
    And I should see Optical hours for today
    And I should see Optical hours for the entire week
    And I should be able to select another location where the service is available (clicking this will take me to a store locator page)
    And I should see four different images with subtitles, body copy and CTAs (detailed below):
    And Prescription Eyewear link: 'optical-information#prescription'
    And Contact Lenses link: 'optical-information#contact'
    And Warranty link: 'optical-information#warranty'
    And Eye exam link: 'optical-information#eye'
    And I should see a banner with brands we carry
    And I should see optical legal disclaimer

  @Services @Wholesale
  Scenario: Services Pharmacy TC-94
    Given I am a user who is on banner.ca
    When I click into Services > Medical Clinics in the navigation
    Then I want to be taken to the medical clinics homepage

  @Services @Wholesale
  Scenario: Services Pharmacy TC-95
    Given I am a user who is on banner.ca where there IS a Medical Clinics service
    When I click into Services > Medical Clinics
    Then I should see Medical Clinics
    And I should see copy explaining what the Medical Clinics services is
    And I should see the location I have in my header repeated on the page
    And I should see Medical Clinic hour for today
    And I should see Medical Clinic hours for the entire week
    And I should be able to select another location where the service is available (clicking this will take me to a store locator page)

  @Services @Wholesale
  Scenario: Services Pharmacy TC-96
    Given I am a user who is on banner.ca where there IS NOT a Medical Clinics service
    When I click into Services > Medical Clinics
    Then I should see Medical Clinics
    And I should see copy explaining what the Medical Clinics services is
    And I should see the location I have in my header repeated on the page
    And I should see Medical Clinic hour for today
    And I should see Medical Clinic hours for the entire week
    And I should be able to select another location where the service is available (clicking this will take me to a store locator page)

#    No such service (C Shop Cannabis) found
#  @Services @Wholesale
#  Scenario: Services Pharmacy TC-97
#    Given I am a user who is on the banners mentioned
#    When I click into Services >C Shop Cannabis in the navigation
#    Then I want to be taken to the C Shop Cannabis homepage
#    And I should see a header with a CTA to take me to c-shop.ca (new tab)
#    And I should see the three locations C shop is available at (Dominion, RCSS, Independent)
#    And I should be able to click Shop Now under each location and be taken to the related menu page for each:
#    And Dominion: 'https://www.cshopcannabis.ca/newfoundland-labrador?icid=cs_cshop-stores-newfoundland_cta_1_hub'
#    And RCSS: 'https://www.cshopcannabis.ca/manitoba?icid=cs_cshop-stores-rcss-manitoba_cta_1_hub'
#    And Independent:  'https://www.cshopcannabis.ca/ontario?icid=cs_cshop-stores-yig-ontario_cta_1_hub'