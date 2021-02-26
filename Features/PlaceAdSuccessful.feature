Feature: Place advertisement
  Users who have less than 5 (five) advertisements placed on the marketplace should be allowed to place
  an advertisement containing an image
  Rules:
  1. User does not have 5 advertisements
  2. Advertisement contains an image

  Scenario Outline: : User places an advertisement
    Given I login to the application with the credentials <username>/<password>
    And I go to My advertisements page
    And I have less than five advertisements
    When I click on the new button
    And complete the Title field
    And I select the category
    And add the description
    """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
    """
    And add an image
    And click on the Save button
    Then my attachment is added

    Examples:
    |username|password|categories|
    |demo    |1234    |Musicians|
    |demo3   |1234    |Artists  |
    |demo    |1234    |Politics |
