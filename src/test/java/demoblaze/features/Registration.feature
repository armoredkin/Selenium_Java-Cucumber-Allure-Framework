@regression @registration
Feature: Registration

@registerSuccess
  Scenario: Successfully register using valid user and password
    Given user is at 'demoblaze'
    When user open Sign up form pop up
    And user fill Username with random valid character
    And user fill Password with random valid character
    And user click Sign up in registration pop up
    Then user see pop up with message "Sign up successful."
    And user can click OK to close the pop up

  @registerExist
  Scenario: Failed to register using username that already exist
    Given user is at 'demoblaze'
    When user open Sign up form pop up
    And user fill Username with 'eko'
    And user fill Password with 'eko'
    And user click Sign up in registration pop up
    Then user see pop up with message "This user already exist."
    And user can click OK to close the pop up