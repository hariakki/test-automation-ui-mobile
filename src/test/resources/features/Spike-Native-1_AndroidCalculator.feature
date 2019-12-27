@AndroidNative
Feature: Spike-Native-1_AndroidCalculator

  @AndroidNative-1
  Scenario: Android calculator add
    Given I am on calculator page
    When Tap number twelve
    And Tap 'delete'
    And Tap 'add' button
    And Tap number six
    And Tap equal button
    Then Calculated result is correct


