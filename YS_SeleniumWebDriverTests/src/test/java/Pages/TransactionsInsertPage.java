package Pages;

import BusinessLogic.Base;
import Utils.WindowsHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Евгений on 19.09.2015.
 */
public class TransactionsInsertPage {
    public WebDriver driver;

    @FindBy(id="f6ffb4a0fec__account")
    private WebElement accountCombobox;

    @FindBy(id="f6ffb4a0fec__direction")
    private WebElement directionCombobox;

    @FindBy(id="f6ffb4a0fec__amount")
    private WebElement amountInput;

    @FindBy(id="f6ffb4a0fec__notes")
    private WebElement notesTextArea;

    @FindBy(xpath="//input[@name='button_save']")
    private WebElement saveButton;

    public TransactionsInsertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void setAccountCombobox(String account){
        new Select(accountCombobox).selectByVisibleText(account);
    }

    public void setAmount(String amount) {
        amountInput.sendKeys(amount);
    }

    public void setNotes(String notes) {
        notesTextArea.sendKeys(notes);
    }

    public PlayersEditPage clickSave() {
        saveButton.click();
        WindowsHandler.switchToWindow(driver, Base.mainWindow);
        return new PlayersEditPage(driver);
    }


}
