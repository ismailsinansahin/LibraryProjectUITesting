@ELE-81
Feature: 

	
	@ELE-51 @ELE-80 @ELE-54 @ELE-33
	Scenario: Verify that student is able to login with proper credentials
		When the user enter valid student credentials "student24@library" "ya2nTtvY"
		Then the user should be able to login
			

	
	@ELE-58 @ELE-80 @ELE-54 @ELE-33
	Scenario: Verify that librarian is able to login with proper credentials
		When the user enter valid student credentials "student24@library" "ya2nTtvY"
		Then the user should be able to login
			

	#Add a book with librarian credentials
	@ELE-38 @ELE-80 @ELE-43 @ELE-33
	Scenario: Add a book with librarian credentials
		When the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
		And the user navigate to Books module
		And the user click on Add Book button
		And fill the necessary input boxes with valid inputs "A Book Name" "2020" "1234567890"
		And the user click on Save Changes
		Then "The book has been created." message should be displayed	

	#Add a book with student credentials
	@ELE-39 @ELE-80 @ELE-43 @ELE-33
	Scenario: Add a book with student credentials
		When the user enter valid student credentials "student24@library" "ya2nTtvY"
		And the user navigate to Books module
		Then Add Book button should NOT be seen on the page	

	#Check book parameters
	@ELE-40 @ELE-80 @ELE-43 @ELE-33
	Scenario: Check book parameters
		When the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
		And the user navigate to Books module
		And the user click on Add Book button
		Then following book parameters should be displayed on the table
		    | Book Name     |
		    | ISBN          |
		    | Year          |
		    | Author        |
		    | Book Category |
		    | Description   |	

	#Check book categories
	@ELE-41 @ELE-80 @ELE-43 @ELE-33
	Scenario: Check book categories
		When the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
		And the user navigate to Books module
		And the user click on Add Book button
		Then following book categories should be able to selected on the dropdown menu
		    | Action and Adventure    |
		    | Anthology               |
		    | Classic                 |
		    | Comic and Graphic Novel |
		    | Crime and Detective     |
		    | Drama                   |
		    | Fable                   |
		    | Fairy Tale              |
		    | Fan-Fiction             |
		    | Fantasy                 |
		    | Historical Fiction      |
		    | Horror                  |
		    | Science Fiction         |
		    | Biography/Autobiography |
		    | Humor                   |
		    | Romance                 |
		    | Short Story             |
		    | Essay                   |
		    | Memoir                  |
		    | Poetry                  |	

	#Check ISBN Numbers
	@ELE-42 @ELE-80 @ELE-43 @ELE-33
	Scenario Outline: Check ISBN Numbers
		When the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
		And the user navigate to Books module
		And the user click on Add Book button
		And fill the necessary input boxes with valid inputs "A Book Name" "2020" "<ISBN>"
		Then "<Expected Message>" message should be displayed
		Examples:
		  | ISBN           | Expected Message           |
		  | 123456789      | None                       |
		  | 12345678901234 | None                       |
		  | abcdefghij     | None                       |
		  | 123456789/     | None                       |
		  | 1234567890     | The book has been created. |
		  | 1234567890123  | The book has been created. |
		  | 123456789012-  | The book has been created. |	

	#A librarian should be able to edit books
	@ELE-47 @ELE-80 @ELE-77 @ELE-33
	Scenario: Cucumber Verify a librarian can edit an existing book
		    Given the user enter valid librarian credentials "librarian21@library" "aZ849tSZ"
		    When the user clicks on Books tab
		    And the user clicks on first Edit Books button
		    And the user change name to "DuMMyNaMe" and click Save changes button
		    Then the name should be updated to "DuMMyNaMe"	

	#Every book property should be editable.
	@ELE-49 @ELE-80 @ELE-77 @ELE-33
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

	#Students should not be able to edit any book
	@ELE-48 @ELE-80 @ELE-77 @ELE-33
	Scenario: Cucumber Verify that a student cannot edit a book
		Given the user enter valid student credentials "student24@library" "ya2nTtvY"
		Then Edit Book button should not be displayed under actions tab
		And table cells should not be modifiable	

	
	@ELE-75 @ELE-76 @ELE-80 @ELE-33
	Scenario: Cucumber a student can borrow a book
		Given the user enter valid student credentials "student24@library" "ya2nTtvY"
		And the user navigate to Books module
		When click on "Borrow Book"
		Then verify that "The book has been borrowed..." message is displayed