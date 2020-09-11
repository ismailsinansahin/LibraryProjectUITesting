@edit
Feature: Editing books


  Scenario: A librarian should be able to edit books

    Given the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
    When the user clicks on Books tab
    And the user clicks on first Edit Books button
    And the user change name to "DuMMyNaMe" and click Save changes button
    Then the name should be updated to "DuMMyNaMe"

  Scenario: Students should not be able to edit books

    Given the user enter valid student credentials "student24@library" "ya2nTtvY"
    Then Edit Book button should not be displayed under actions tab
    And table cells should not be modifiable


  Scenario: Every book property should be editable

    Given the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
    When the user clicks on Books tab
    And the user clicks on first Edit Books button
    And Change all properties with below mentioned entries
      | Book Name     | ABCDEFG    |
      | ISBN          | 1122334455 |
      | Year          | 1800       |
      | Author        | JOHN DOE   |
      | Book Category | Classic    |


    Then The updated information should be correctly reflected on the table
      | 1122334455 |
      | ABCDEFG    |
      | JOHN DOE   |
      | Classic    |
      | 1800       |

#  @wip
#    Scenario: Editing books with fake names
#      Given the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
#      When the user clicks on Books tab
#      And the user clicks on first Edit Books button
#      Then changes the properties
