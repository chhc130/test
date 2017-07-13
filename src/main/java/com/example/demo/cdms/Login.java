package com.example.demo.cdms;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by hcjang on 2017-07-12.
 */
public class Login extends LoadableComponent<Login> {

    @FindBy(how = How.ID, using = "txt_user_id")
    private WebElement userId;
    @FindBy(how = How.ID, using = "txt_password")
    private WebElement password;
    @FindBy(how = How.ID, using = "btn_login")
    private WebElement loginButton;
    @FindBy(how = How.LINK_TEXT, using = "logout")
    private WebElement logout;

    private final String URL = "https://dev.cubecdms.com/login";

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    public StudyList login() {
        userId.clear();
        userId.sendKeys("");
        password.clear();
        password.sendKeys("");
        loginButton.click();
        return PageFactory.initElements(driver, StudyList.class);
    }

    public void close() {
        driver.close();
    }

}
