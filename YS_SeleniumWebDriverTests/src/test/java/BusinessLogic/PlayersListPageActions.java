package BusinessLogic;

import Pages.PlayersListPage;

/**
 * Created by Евгений on 27.09.2015.
 */
public class PlayersListPageActions {

    public static void searchForPlayer(PlayersListPage playersListPage,String expectedUserName){
        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
    }
}
