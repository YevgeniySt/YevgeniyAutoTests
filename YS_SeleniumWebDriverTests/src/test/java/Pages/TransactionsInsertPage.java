package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ������� on 19.09.2015.
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
}