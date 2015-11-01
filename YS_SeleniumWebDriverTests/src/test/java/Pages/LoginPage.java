package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Евгений on 17.09.2015.
 */
public class LoginPage {

    public WebDriver driver;

    @FindBy(id="username")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="logIn")
    private WebElement loginButton;

    @FindBy(css=".errors>li")
    private WebElement errorLoginText;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void setUserNameField(String userNameField) {
        usernameInput.sendKeys(userNameField);

    }


    public void setPasswordField(String passwordField) {
        passwordInput.sendKeys(passwordField);

    }

    public PlayersListPage clickOnLogin() {
        loginButton.click();
        return new PlayersListPage(driver);
    }

     /*public void clickOnLogin() {
        loginButton.click();

    }*/



    public String getErrorLoginText(){
        return errorLoginText.getText();
    }


}



