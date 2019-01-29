Feature: As a user I want to be able to search something in Google

  Scenario: First search in Google
    Given User is on Google page
    When I search Google with phrase "Intive Szczecin"
    Then I can see results

  Scenario: Second test - fails with screenshot
    Given User is on Google page
    When I search Google with phrase "Intive Szczecin"
    Then I am on Intive main page

  Scenario: Third test open Intive website
    Given User is on Google page
    When I search Google with phrase "Intive Szczecin"
    And I open first link from search
    Then I am on Intive main page