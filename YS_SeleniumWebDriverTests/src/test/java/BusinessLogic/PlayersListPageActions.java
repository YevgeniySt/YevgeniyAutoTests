package businesslogic;

import test_models.Player;
import pages.PlayersListPage;

/**
 * Created by Евгений on 27.09.2015.
 */
public class PlayersListPageActions {

    public static void searchForPlayer(PlayersListPage playersListPage, Player expectedPlayer){
        playersListPage.setUserNameField(expectedPlayer.userName);
        playersListPage.clickSearchButton();
    }
}
