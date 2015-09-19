package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Евгений on 17.09.2015.
 */
public class InsertPage {
    public WebDriver driver;

    @FindBy(id = "ff14642ac1c__us_login")
    private WebElement userNameInput;

    @FindBy(css="input#ff14642ac1c__us_email")
    private WebElement emailInput;

    @FindBy(css="input#ff14642ac1c__us_password")
    private WebElement passwordInput;

    @FindBy(css="input#ff14642ac1c__confirm_password")
    private WebElement confirmPasswordInput;

    @FindBy(css="input#ff14642ac1c__us_phone")
    private WebElement phoneInput;

    @FindBy(xpath="//input[@value='Save']")
    private WebElement saveButton;

    @FindBy(css="select#ff14642ac1c__us_gender")
    private WebElement genderCombobox;

    @FindBy(css="input#ff14642ac1c__payment_chat_enabled")
    private WebElement paymentCheckBox;

    @FindBy(xpath="//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
    private WebElement realMoneyInput;

    @FindBy(xpath="//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")
    private WebElement funMoneyInput;

    @FindBy(xpath="//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")
    private WebElement bonusDollarsInput;

    @FindBy(xpath="//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]")
    private WebElement loyaltyPointsInput;

    @FindBy(xpath="//img[@alt='Add transaction']")
    private WebElement addTransactionButton;

    public InsertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }



    public void setUsernameField(String usernameField) {
        userNameInput.sendKeys(usernameField);
    }

    public void setEmailField(String emailField) {
        emailInput.sendKeys(emailField);
    }

    public void setPasswordField(String passwordField) {
        passwordInput.sendKeys(passwordField);
    }

    public void setPasswordConfirmField(String passwordConfirmField) {
        confirmPasswordInput.sendKeys(passwordConfirmField);
    }

    public void setPhoneField(String phoneField) {
        phoneInput.sendKeys(phoneField);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public String getUserNameActualValue() {
        return userNameInput.getAttribute("value");
    }

    public String getEmailActualValue() {
        return emailInput.getAttribute("value");
    }

    public String getPhoneActualValue() {
        return phoneInput.getAttribute("value");
    }

    public String getGenderActualValue() {
        return new Select(genderCombobox).getFirstSelectedOption().getText();
    }


    public boolean getPaymentActualValue() {
        return paymentCheckBox.isSelected();
    }

    public String getRealMoneyActualValue() {
        return realMoneyInput.getText();
    }

    public String getFunMoneyActualValue() {
        return funMoneyInput.getText();
    }

    public String getBonusDollarsActualValue() {
        return bonusDollarsInput.getText();
    }

    public String getLoyaltyPointsActualValue() {
        return loyaltyPointsInput.getText();
    }

    public void clickOnAddTransactionButton(){
        addTransactionButton.click();
    }
}
