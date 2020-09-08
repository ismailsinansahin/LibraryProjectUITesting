package com.cybertek.step_definitions;

import com.cybertek.pages.AddBookPage;
import com.cybertek.pages.BooksPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AddBookStepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    BooksPage booksPage = new BooksPage();
    AddBookPage addBookPage = new AddBookPage();

    @When("the user navigate to Books module")
    public void the_user_navigate_to_Books_module() {
        BrowserUtils.waitForClickablility(dashboardPage.books,5);
        dashboardPage.books.click();
    }

    @When("the user click on Add Book button")
    public void the_user_click_on_Add_Book_button() {
        BrowserUtils.waitForClickablility(booksPage.addBookBtn,5);
        booksPage.addBookBtn.click();
    }

    @When("the user fill the input boxes with valid inputs")
    public void the_user_fill_the_input_boxes_with_valid_inputs() {
        BrowserUtils.waitForVisibility(addBookPage.bookName,5);
        addBookPage.bookName.sendKeys("A book name");
        addBookPage.isbn.sendKeys("some numbers");
        addBookPage.year.sendKeys("a year");
    }

    @When("the user click on Save Changes")
    public void the_user_click_on_Save_Changes() {
        addBookPage.saveChanges.click();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage = "The book has been created.";
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("Add Book button should NOT be seen on the page")
    public void add_Book_button_should_NOT_be_seen_on_the_page() {
        Assert.assertFalse(booksPage.addBookBtn.isDisplayed());
    }

}
