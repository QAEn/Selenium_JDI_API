Feature: Selenium

  Background:
    Given I open JDI GitHub site
    Then 'Home Page' page should be opened
    When I login as user 'Roman Iovlev' with password 'Jdi1234'
    Then User name should be displayed and equals to expected result

  Scenario Outline: Exercise 2
    And I click on 'User Table' button in Service dropdown
    Then 'User Table' page should be opened
    And 6 '<Number>' Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 '<User>'names should be displayed on Users Table on User Table Page
    And 6 '<Description>' texts under images should be displayed on Users Table on User Table Page
    And '6' checkboxes should be displayed on Users Table on User Table Page
    And '<Dropdown Values>' should contain values in column Type for user Roman
    Examples:
      | Number | User             | Description                      |Dropdown Values |
      | 1      | Roman            | Wolverine                        |Admin           |
      | 2      | Sergey Ivan      | Spider Man                       |User            |
      | 3      | Vladzimir        | Punisher                         |Manager         |
      | 4      | Helen Bennett    | Captain America some description |                |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |                |
      | 6      | Giovanni Rovelli | Hulksome description             |                |

  Scenario: Exercise 3
    And I click on 'User Table' button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has "Vip: condition changed to true" text in log section