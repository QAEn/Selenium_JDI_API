Feature: Selenium

  Background:
    Given I open JDI GitHub site
    Then 'Home Page' page should be opened
    When I login as user 'Roman Iovlev' with password 'Jdi1234'
    Then User name should be displayed and equals to expected result

  Scenario: Exercise 1
    When I click on 'Different Elements' button in Service dropdown
    Then 'Different Elements' page should be opened
    When I select 'Earth' and 'Wind' checkboxes
    When I select 'Selen' radiobutton
    When I select 'Yellow' in dropdown
    Then Each element should be corresponds to itself with positive status on Different Elements Page