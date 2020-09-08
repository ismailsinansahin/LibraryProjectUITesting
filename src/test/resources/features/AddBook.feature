@addBook

Feature: Only librarians should be able to add books
  Description: The purpose of this feature is to test the add book functionality

  @addBookWithLibrarian
  Scenario: Librarian users should be able to add books
    When the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
    And the user navigate to Books module
    And the user click on Add Book button
    And the user fill the input boxes with valid inputs
    And the user click on Save Changes
    Then "The book has been created." message should be displayed

  @addBookWithStudent
  Scenario: Student users should NOT be able to add books
    When the user enter valid student credentials "student24@library" "ya2nTtvY"
    And the user navigate to Books module
    Then Add Book button should NOT be seen on the page