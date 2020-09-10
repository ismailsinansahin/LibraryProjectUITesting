package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BooksPage {

    public BooksPage(){PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    public WebElement addBookBtn;

    @FindBy(xpath = "//td//a[starts-with(@onclick,'Books.edit_book')]")
    public List<WebElement> editBookButtons;

    @FindBy(name = "name")
    public WebElement bookNameInputBox;

    @FindBy(name = "isbn")
    public WebElement isbnInputBox;

    @FindBy(name = "year")
    public WebElement yearInputBox;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement authorInputBox;

    @FindBy(id = "book_group_id")
    public WebElement bookCategoryDropDown;



    @FindBy(id = "description")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//td[3]")
    public WebElement firstRowNameCell;

    @FindBy(xpath = "//tr")
    public List<WebElement> rows;


    public void clickEditBook(int numberOfButton) throws Exception {
        if(numberOfButton<editBookButtons.size() || numberOfButton < 1){
            throw new Exception("invalid number of button exception");
        }
        editBookButtons.get(numberOfButton-1).click();
    }

    public List<WebElement> callRowCells(int rowNumber){
        List<WebElement> rowCells = Driver.get().findElements(By.xpath("//tr[" + rowNumber + "]/td"));
        rowCells.remove(0);
        rowCells.remove(rowCells.size()-1);
        return rowCells;
    }

}
