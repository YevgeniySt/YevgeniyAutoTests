package Tests;


import BusinessLogic.InsertPageActions;
import BusinessLogic.PlayersListPageActions;
import Objects.Player;
import Objects.PlayerBuilder;
import Pages.PlayersEditPage;
import BusinessLogic.Base;
import Pages.InsertPage;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 17.09.2015.
 */
public class CreatePlayerTest extends Base{


    @Test
    public void createPlayerTest() throws InterruptedException {


        Player expectedPlayer =PlayerBuilder.aPlayer()
                .withUserName("UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date())))
                .withPassword("Password1")
                .withEmail("UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()))+"@mail.ru")
                .withPhone("123456")
                .withGender("Male")
                .withPayment(true)
                .withRealMoney("$0.00")
                .withFunMoney("1,00.00")
                .withBonusDollars("$0.005")
                .withLoyaltyPoints("0.00 LP").build();

        //click Insert
        InsertPage insertPage = playersListPage.clickInsert();
        //set values
        InsertPageActions.setValuesForNewPlayer(insertPage, expectedPlayer.userName, expectedPlayer.email, expectedPlayer.password, expectedPlayer.phone);
        //click save
        InsertPageActions.clickSaveButton(insertPage);
        //search for Player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedPlayer.userName);
        //click Edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();


        //get players values

        Player actualPlayer =PlayerBuilder.aPlayer()
                .withUserName(playersEditPage.getUserNameActualValue())
                .withPassword("Password1")
                .withEmail(playersEditPage.getEmailActualValue())
                .withPhone(playersEditPage.getPhoneActualValue())
                .withGender(playersEditPage.getGenderActualValue())
                .withPayment(playersEditPage.getPaymentActualValue())
                .withRealMoney(playersEditPage.getRealMoneyActualValue())
                .withFunMoney(playersEditPage.getFunMoneyActualValue())
                .withBonusDollars(playersEditPage.getBonusDollarsActualValue())
                .withLoyaltyPoints(playersEditPage.getLoyaltyPointsActualValue()).build();

        //check values


        assertCheck.assertEquals(actualPlayer.userName, expectedPlayer.userName);
        assertCheck.assertEquals(actualPlayer.email, expectedPlayer.email);
        assertCheck.assertEquals(actualPlayer.phone, expectedPlayer.phone);
        assertCheck.assertEquals(actualPlayer.gender, expectedPlayer.gender);
        assertCheck.assertEquals(actualPlayer.payment, expectedPlayer.payment);
        assertCheck.assertEquals(actualPlayer.realMoney, expectedPlayer.realMoney);
        assertCheck.assertEquals(actualPlayer.funMoney, expectedPlayer.funMoney);
        assertCheck.assertEquals(actualPlayer.bonusDollars, expectedPlayer.bonusDollars);
        assertCheck.assertEquals(actualPlayer.loyaltyPoints, expectedPlayer.loyaltyPoints);
        //print errors
        assertCheck.printErrors();

    }
}
