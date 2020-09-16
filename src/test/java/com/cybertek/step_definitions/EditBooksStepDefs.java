package com.cybertek.step_definitions;

import com.cybertek.pages.BooksPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class EditBooksStepDefs {
    BooksPage booksPage = new BooksPage();

    @When("the user clicks on Books tab")
    public void the_user_clicks_on_Books_tab() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.books.click();
    }

    @When("the user clicks on first Edit Books button")
    public void the_user_clicks_on_first_Edit_Books_button() throws InterruptedException {
        booksPage.editBookButtons.get(0).click();
    }

    @When("the user change name to {string} and click Save changes button")
    public void the_user_change_name_to_and_click_Save_changes_button(String name) throws InterruptedException {
        BrowserUtils.waitForClickablility(booksPage.bookNameInputBox,5);
        booksPage.bookNameInputBox.click();
        booksPage.bookNameInputBox.clear();
        booksPage.bookNameInputBox.sendKeys(name);
        booksPage.saveChangesButton.click();
    }

    @Then("the name should be updated to {string}")
    public void the_name_should_be_updated_to(String name) throws InterruptedException {
        Thread.sleep(1000);
        booksPage.searchBox.sendKeys(name);
        Thread.sleep(1000);
        String updatedName = booksPage.firstRowNameCell.getText();
        Assert.assertEquals("Name is not updated properly",name,updatedName);
    }

    @Then("Edit Book button should not be displayed under actions tab")
    public void edit_Book_button_should_not_be_displayed_under_actions_tab() {
        Assert.assertTrue("Verify Edit Book button does not exist",booksPage.editBookButtons.isEmpty());
    }

    @Then("table cells should not be modifiable")
    public void table_cells_should_not_be_modifiable() {
        boolean flag = true;

        for(WebElement each:booksPage.callRowCells(1)){
            if(each.getAttribute("href")!= null){
                flag = false;
                break;
            }
        }
        Assert.assertTrue("Verify table cells cannot be modified",flag);
    }

    @When("Change all properties with below mentioned entries")
    public void change_all_properties_with_below_mentioned_entries(Map<String,String> entries) throws InterruptedException {
        Select bookCategoryDD = new Select(booksPage.bookCategoryDropDown);

        for(String each:entries.keySet()){

            switch (each){
                case "Book Name":
                    BrowserUtils.waitFor(2);
                    booksPage.bookNameInputBox.click();
                    booksPage.bookNameInputBox.clear();
                    booksPage.bookNameInputBox.sendKeys(entries.get(each));
                break;
                case "ISBN":
                    booksPage.isbnInputBox.clear();
                    booksPage.isbnInputBox.sendKeys(entries.get(each));
                    break;
                case "Year":
                    booksPage.yearInputBox.clear();
                    booksPage.yearInputBox.sendKeys(entries.get(each));
                    break;
                case "Author":
                    booksPage.authorInputBox.click();
                    booksPage.authorInputBox.clear();
                    booksPage.authorInputBox.sendKeys(entries.get(each));
                    break;
                case "Book Category":
                    bookCategoryDD.selectByVisibleText(entries.get(each));
            }
        }
        booksPage.saveChangesButton.click();
    }

    @Then("The updated information should be correctly reflected on the table")
    public void the_updated_information_should_be_correctly_reflected_on_the_table(List<String> entries) throws InterruptedException {
        Thread.sleep(1000);
        booksPage.searchBox.click();
        booksPage.searchBox.sendKeys(entries.get(1));
        Thread.sleep(1000);

        boolean flag = false;
        for(int i = 1;i<booksPage.rows.size();i++){
           if(BrowserUtils.getElementsText(booksPage.callRowCells(i)).equals(entries)){
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Verify all properties has been updated correctly",flag);
    }

    @Then("changes the properties")
    public void changes_the_properties() {

        Faker faker = new Faker();
        booksPage.bookNameInputBox.click();
        booksPage.bookNameInputBox.clear();

        booksPage.bookNameInputBox.sendKeys(faker.book().title());
        booksPage.isbnInputBox.clear();
        booksPage.isbnInputBox.sendKeys("1234512345");
        booksPage.yearInputBox.clear();
        booksPage.yearInputBox.sendKeys("1998");
        booksPage.authorInputBox.click();
        booksPage.authorInputBox.clear();
        booksPage.authorInputBox.sendKeys(faker.book().author());

        Select bookCategoryDD = new Select(booksPage.bookCategoryDropDown);
        bookCategoryDD.selectByVisibleText("Classic");

        booksPage.saveChangesButton.click();

    }
}
