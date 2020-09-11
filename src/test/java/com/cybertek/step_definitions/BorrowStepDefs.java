package com.cybertek.step_definitions;

import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BorrowStepDefs {
    DashboardPage dashboardPage = new DashboardPage();

    @When("click on {string}")
    public void click_on(String function) {
        if (!dashboardPage.borrowBookBtn.isEnabled()){
            dashboardPage.nextBtn.click();
        }else {
            dashboardPage.borrowBookBtn.getText();
            System.out.println("dashboardPage.borrowBookBtn.getText() = " + dashboardPage.borrowBookBtn.getText());
            BrowserUtils.clickWithJS(dashboardPage.borrowBookBtn);
        }
    }

    @Then("verify that {string} message is displayed")
    public void verify_that_message_is_displayed(String message) {
        //System.out.println(" message txt = " + dashboardPage.borrowMessage.getText());
        String expectedMessage = "The book has been borrowed...";
        BrowserUtils.verifyElementDisplayed(dashboardPage.displayMessage);
        Assert.assertEquals("Correct message is successfully displayed",expectedMessage,dashboardPage.displayMessage.getText());
    }
    @And("the user navigate to Borrowing Books")
    public void theUserNavigateToBorrowingBooks() {
        dashboardPage.borrowingBooks.click();
    }

    @When("the user click on {string}")
    public void the_user_click_on(String returnBook) {
        int size = dashboardPage.returnBookBtn.size();
        //System.out.println("size = " + size);
        dashboardPage.returnBookBtn.get(size-1).click();
    }

    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String string) {
        String expectedMessage = "The book has been returned..";
        BrowserUtils.verifyElementDisplayed(dashboardPage.displayMessage);
        Assert.assertEquals("Correct message is successfully displayed",expectedMessage,dashboardPage.displayMessage.getText());
    }
}
