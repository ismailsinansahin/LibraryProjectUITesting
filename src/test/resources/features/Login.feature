@login

Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @student
  Scenario: Login as a student
    When the user enter the student information
    Then the user should be able to login

  @librarian
  Scenario: Login as a librarian
    When the user enter librarian information
    Then the user should be able to login

