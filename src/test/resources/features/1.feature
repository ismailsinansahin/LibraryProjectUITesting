
Feature: 

	#A librarian should be able to edit books
	@ELE-47 @ELE-77 @ELE-33
	Scenario: Cucumber Verify a librarian can edit an existing book
		    Given the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
		    When the user clicks on Books tab
		    And the user clicks on first Edit Books button
		    And the user change name to "DuMMyNaMe" and click Save changes button
		    Then the name should be updated to "DuMMyNaMe"	

	#Students should not be able to edit any book
	@ELE-48 @ELE-77 @ELE-33
	Scenario: Cucumber Verify that a student cannot edit a book
		Given the user enter valid student credentials "student24@library" "ya2nTtvY"
		Then Edit Book button should not be displayed under actions tab
		And table cells should not be modifiable	

	#Every book property should be editable.
	@ELE-49 @ELE-77 @ELE-33
	Scenario: Cucumber Every book property should be editable.
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
