package httptests;

import businesslogic.BaseHttp;
import test_models.PlayerFull;
import test_models.PlayerFullBuilder;
import utils.DataBaseHelper;
import utils.HttpHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 29.09.2015.
 */
public class CreatePlayerTest extends BaseHttp{

    @Test
    public void createPlayerTest() throws IOException, InterruptedException {

        //arrange
        String login = "UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()));
        String email = "UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()))+"@mail.ru";
        System.out.println(login);
        System.out.println(email);


        PlayerFull expectedPlayer =new PlayerFullBuilder()
                .withRequestSender("ff14642ac1c")
                .withLogin(login)
                .withPassword("Password1")
                .withEmail(email)
                .withPhone("123456")
                .withGender("1")
                .withRegStatus("1")
                .withChatEnabled("1")
                .withIsCommunity("1")
                .withOwnerId("1")
                .withFName("")
                .withLName("")
                .withCity("")
                .withCountry("_unset_")
                .withAddress("")
                .withBirthday("10-07-1997")
                .withDisableLp("0")
                .withPaymentChatEnabled("1")
                .withPittBossAlertEnabled("1")
                .withCreditType("Periodic Credit")
                .withCreditAmount("")
                .withCreditFrequency("Weekly")
                .withCreditNextReset("10-12-2015 00:00:00")
                .withCreditTemp("")
                .withCreditExpiration("")
                .withCreditComment("")
                .withStopWeeklyReset("0")
                .build();

        //act
        HttpHelper.httpPostCreatePlayer(baseUrl + "/players/insert", expectedPlayer);
        HttpHelper.httpPostSearchPlayer(baseUrl + "/players", expectedPlayer);
        //assert
        String us_loginActual = DataBaseHelper.loginByLogin(expectedPlayer.login);

      //  StringBuffer result6 = HttpHelper.httpGetUrl(baseUrl + "/players");

       // Assert.assertTrue(result6.toString().contains(">" + expectedPlayer.login + "</a>k"));

        Assert.assertEquals(expectedPlayer.login+"f",us_loginActual);

    }

}
