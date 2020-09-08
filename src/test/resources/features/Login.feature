@Login

Feature: Only authorized users should be able to login
  Description: The purpose of this feature is to test the Login functionality

  @librarian
  Scenario: Login as a librarian
    When the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
    Then the user should be able to login

  @student
  Scenario: Login as a student
    When the user enter valid student credentials "student24@library" "ya2nTtvY"
    Then the user should be able to login



