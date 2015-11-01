package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Евгений on 17.09.2015.
 */
public class PlayersListPage {


    public WebDriver driver;

    @FindBy(linkText = "Insert")
    private WebElement insertButton;

    @FindBy(id="723a925886__login")
    private WebElement userNameInput;

    @FindBy(xpath="//input[@value='Search']")
    private WebElement searchButton;

    @FindBy(css="img[alt='Edit']")
    private WebElement editButton;

    public PlayersListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public InsertPage clickInsert() {

        insertButton.click();
        return new InsertPage(driver);
    }

    public void setUserNameField(String userNameField) {
        userNameInput.sendKeys(userNameField);
    }

    public void isUserNameDisplayed() {
        userNameInput.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public PlayersEditPage clickEditButton() {
        editButton.click();
        return new PlayersEditPage(driver);
    }
}
