package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//img[@class='d-inline-block align-top']")
    public WebElement logo;

    @FindBy(xpath = "//span[contains(text(),'Books')]")
    public WebElement books;

    @FindBy(xpath = "//span[contains(text(),'Borrowing Books')]")
    public WebElement borrowingBooks;

    @FindBy(xpath = "//a[contains(@onclick,'Books.borrow_book')]")
    public WebElement borrowBookBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement displayMessage;

    @FindBy(xpath = "//i[contains(@class,'fa fa-angle-right')]")
    public WebElement nextBtn;

    @FindBy(linkText = "Return Book")
    public List<WebElement> returnBookBtn;
}
