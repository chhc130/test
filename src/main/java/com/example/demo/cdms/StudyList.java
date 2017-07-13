package com.example.demo.cdms;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

/**
 * Created by hcjang on 2017-07-12.
 */
public class StudyList extends LoadableComponent<StudyList> {
    @FindBy(how = How.CLASS_NAME, using = "study-list-wrap")
    private WebElement studyListWrap;
    @FindBy(how = How.CLASS_NAME, using = "study-list")
    private List<WebElement> studyLists;
    @FindBy(how = How.CLASS_NAME, using = "study-id")
    private List<WebElement> studyIds;
    @FindBy(how = How.CLASS_NAME, using = "study-title")
    private List<WebElement> studyTitles;
    @FindBy(how = How.CLASS_NAME, using = "study-role")
    private List<WebElement> studyRoles;
    @FindBy(how = How.LINK_TEXT, using = "PI")
    private WebElement PIButton;

    private final String URL = "https://dev.cubecdms.com/";

    private WebDriver driver;

    public StudyList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected void load() {
        //driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(URL.equals(driver.getCurrentUrl()));
    }

    public void StudyList() {

    }

}
