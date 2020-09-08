package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//img[@class='d-inline-block align-top']")
    public WebElement logo;

    @FindBy(xpath = "//span[contains(text(),'Books')]")
    public WebElement books;

}
