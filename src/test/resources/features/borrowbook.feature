@halim @smoke
  Feature: Students borrow available books
    Description: The purpose of this feature is to test the borrow functionality

    @borrow @ELE-53
    Scenario: Verify students should be able to borrow
      Given the user enter valid student credentials "student24@library" "ya2nTtvY"
      And the user navigate to Books module
      When click on "Borrow Book"
      Then verify that "The book has been borrowed..." message is displayed

    @return
    Scenario: Verify students should be able to return books
      Given the user enter valid student credentials "student24@library" "ya2nTtvY"
      And the user navigate to Borrowing Books
      When the user click on "Return Book"
      Then verify "The book has been returned.." message is displayed