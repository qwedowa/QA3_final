Feature: As a user i want to have possibility to contact Shop

  Scenario: Check error pop-up if user send empty contact us form
    Given I open automationpractice website
    When I click on ContactUS link
    And I click on Send button
    Then I will see error popup about invalid email

  Scenario: Check error pop-up if user send message
    Given I open automationpractice website
    When I click on ContactUS link
    And I choose anything in Subject Heading, Email address, Order reference and Product; Message box and attachment is empty
    And I click on Send button
    Then I will see error popup about blank message

  Scenario: Check error pop-up if user send message with only Message form filled
    Given I open automationpractice website
    When I click on ContactUS link
    And I write anything in Message box
    And I click on Send button
    Then I will see error popup about invalid email

  Scenario: Check error pop-up if user send message with all filled forms, without attachment
    Given I open automationpractice website
    When I click on ContactUS link
    And I fill forms, without attachment
    And I click on Send button
    Then I will send message