package BusinessLogic;

import Pages.InsertPage;
import Pages.PlayersListPage;

/**
 * Created by Евгений on 27.09.2015.
 */
public class InsertPageActions {

    public static void setValuesForNewPlayer(InsertPage insertPage,String expectedUserName,String expectedEmail, String expectedPassword, String expectedPhone ){

        //fill fields on Insert page and click Save
        insertPage.setUsernameField(expectedUserName);
        insertPage.setEmailField(expectedEmail);
        insertPage.setPasswordField(expectedPassword);
        insertPage.setPasswordConfirmField(expectedPassword);
        insertPage.setPhoneField(expectedPhone);
    }



    public static void clickSaveButton(InsertPage insertPage) {
        insertPage.clickOnSaveButton();
    }
}
