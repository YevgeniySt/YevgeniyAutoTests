package Tests;


import BusinessLogic.InsertPageActions;
import BusinessLogic.PlayersListPageActions;
import Objects.Player;
import Objects.PlayerBuilder;
import Pages.PlayersEditPage;
import BusinessLogic.Base;
import Pages.InsertPage;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 17.09.2015.
 */
public class CreatePlayerTest extends Base{


    @Test
    public void createPlayerTest() throws InterruptedException {


        Player player =PlayerBuilder.aPlayer()
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
        InsertPageActions.setValuesForNewPlayer(insertPage, player.userName, player.email, player.password, player.phone);
        //click save
        InsertPageActions.clickSaveButton(insertPage);
        //search for Player
        PlayersListPageActions.searchForPlayer(playersListPage, player.userName);
        //click Edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();


        //get players values
        String userNameActualValue = playersEditPage.getUserNameActualValue();
        String actualEmail = playersEditPage.getEmailActualValue();
        String actualPhone = playersEditPage.getPhoneActualValue();
        String actualGender = playersEditPage.getGenderActualValue();
        boolean actualPaymentCheckboxState = playersEditPage.getPaymentActualValue();
        String actualRealMoney = playersEditPage.getRealMoneyActualValue();
        String actualFunMoney = playersEditPage.getFunMoneyActualValue();
        String actualBonusDollars = playersEditPage.getBonusDollarsActualValue();
        String actualLoyaltyPoints = playersEditPage.getLoyaltyPointsActualValue();


        //check values


        assertCheck.assertEquals(userNameActualValue, player.userName);
        assertCheck.assertEquals(actualEmail, player.email);
        assertCheck.assertEquals(actualPhone, player.phone);
        assertCheck.assertEquals(actualGender, player.gender);
        assertCheck.assertEquals(actualPaymentCheckboxState, player.payment);
        assertCheck.assertEquals(actualRealMoney, player.realMoney);
        assertCheck.assertEquals(actualFunMoney, player.funMoney);
        assertCheck.assertEquals(actualBonusDollars, player.bonusDollars);
        assertCheck.assertEquals(actualLoyaltyPoints, player.loyaltyPoints);
        //print errors
        assertCheck.printErrors();

    }
}
