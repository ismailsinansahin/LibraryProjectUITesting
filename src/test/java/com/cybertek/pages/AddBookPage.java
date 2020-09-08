package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBookPage {

    public AddBookPage(){PageFactory.initElements(Driver.get(),this);}

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "author")
    public WebElement author;

    @FindBy(id = "book_group_id")
    public WebElement bookCategory;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveChanges;
}
