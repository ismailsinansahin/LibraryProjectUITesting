package com.cybertek.step_definitions;

import com.cybertek.pages.AddBookPage;
import com.cybertek.pages.BooksPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


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

    @And("fill the necessary input boxes with valid inputs {string} {string} {string}")
    public void fillTheNecessaryInputBoxesWithValidInputs(String bookName, String year, String ISBN) {
        BrowserUtils.waitForVisibility(addBookPage.bookName,5);
        addBookPage.bookName.sendKeys(bookName);
        addBookPage.year.sendKeys(year);
        addBookPage.isbn.sendKeys(ISBN);
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

    @Then("following book parameters should be displayed on the table")
    public void following_book_parameters_should_be_displayed_on_the_table(List<String> expectedBookParams) {

        BrowserUtils.waitForVisibility(addBookPage.bookNameTitle,5);
        List <String> actualBookParams = new ArrayList<>();
        actualBookParams.add(addBookPage.bookNameTitle.getText());
        actualBookParams.add(addBookPage.isbnTitle.getText());
        actualBookParams.add(addBookPage.yearTitle.getText());
        actualBookParams.add(addBookPage.authorTitle.getText());
        actualBookParams.add(addBookPage.bookCategoryTitle.getText());
        actualBookParams.add(addBookPage.descriptionTitle.getText());

        Assert.assertEquals(expectedBookParams,actualBookParams);

    }

    @Then("following book categories should be able to selected on the dropdown menu")
    public void following_book_categories_should_be_able_to_selected_on_the_dropdown_menu(List<String> expectedBookCategories) {

        BrowserUtils.waitForVisibility(addBookPage.bookCategory,5);

        List<String> actualBookCategories = new ArrayList<>();
        Select bookCategories = new Select(addBookPage.bookCategory);
        List<WebElement> options = bookCategories.getOptions();
        for (WebElement each : options){
            actualBookCategories.add(each.getText());
        }

        Assert.assertEquals(expectedBookCategories,actualBookCategories);

    }

}
