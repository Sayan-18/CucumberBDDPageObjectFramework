@Search-Cars
Feature: Acceptance testing to validate Search Car page is working fine
In order to validate that
the search cars page is working fine
we will do the acceptaec testing

  @Search-Cars-Positive
  Scenario: Validate  search car page
    Given I am on the homepage "https://www.cardekho.com/" of Cardekho website
    When I move to the menu
      | Menu           |
      | New Cars       |
      | Used Cars      |
      | News & reviews |
      | Videos         |
    And I clicked on "Explore new cars" link
    And Select Budget as "5-10 Lakh" from Select Budget dropdown
    And Select Vehicle Type as "SUV" from All Vehicle Type dropdown
    And click on search button
    Then I should see list of searched cars
    And the page title should be "SUV Cars Under 10 Lakh in India"
