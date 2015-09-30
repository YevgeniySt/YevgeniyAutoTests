package BusinessLogic;

import Objects.Player;
import Pages.InsertPage;
import Pages.PlayersListPage;

/**
 * Created by Евгений on 27.09.2015.
 */
public class InsertPageActions {

    public static void setValuesForNewPlayer(InsertPage insertPage, Player expectedPlayer){

        //fill fields on Insert page and click Save
        insertPage.setUsernameField(expectedPlayer.userName);
        insertPage.setEmailField(expectedPlayer.email);
        insertPage.setPasswordField(expectedPlayer.password);
        insertPage.setPasswordConfirmField(expectedPlayer.password);
        insertPage.setPhoneField(expectedPlayer.phone);
    }



    public static void clickSaveButton(InsertPage insertPage) {
        insertPage.clickOnSaveButton();
    }
}
