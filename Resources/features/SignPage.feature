Feature: As a user I want to have possibility to sign up, sign in

  Scenario: Check error pop-up if user send empty sign up form
    Given I open Automationpractice site
    When I click on SignIn button
    And I click on CreateAnAccount button
    Then I will see error popup about invalid email while trying to sign up

  Scenario: Check error pop-up if user send incorrect data in sign up form
    Given I open Automationpractice site
    When I click on SignIn button
    And I write invalid email and click on CreateAnAccount button
    Then I will see error popup about invalid email while trying to sign up

  Scenario: Check error pop-up if user send correct data in sign up form
    Given I open Automationpractice site
    When I click on SignIn button
    And I write valid email and click on CreateAnAccount button
    Then I will able to create an account

  Scenario: Check error pop-up if user sign in with correct data
    Given I open Automationpractice site
    When I click on SignIn button
    And I write correct data and click on SignIn button
    Then I will sign in

  Scenario: Check error pop-up if user sign in with correct e-mail address and incorrect password
    Given I open Automationpractice site
    When I click on SignIn button
    And I write correct e-mail address and incorrect password
    Then I will see error popup about authentication failed

  Scenario: Check error pop-up if user sign in with incorrect e-mail address and correct password
    Given I open Automationpractice site
    When I click on SignIn button
    And I write incorrect e-mail address and correct password
    Then I will see error popup about invalid email while logging in
