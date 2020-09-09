Feature: Editing books

Scenario: A librarian should be able to edit books

  Given the user is logged in as a librarian
  When the user clicks on Books tab
  And the user clicks on first Edit Books button
  And the user change ISBN to 11xx11xx11 and click "Save changes" button
  Then the ISBN should be updated

Scenario: Students should not be able to edit books

  Given the user is logged in as a Student
  Then Edit Book button should not displayed under actions tab
  And table cells should not be modifiable