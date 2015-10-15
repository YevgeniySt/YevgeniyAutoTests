package HttpTests;

import Objects.PlayerFull;
import Objects.PlayerFullBuilder;
import Utils.HttpUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 29.09.2015.
 */
public class CreatePlayerTest {
    public String baseUrl = "http://193.138.245.222:81";

    @Test
    public void createPlayerTest() throws IOException, InterruptedException {

        //create player
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


        //login

        CloseableHttpResponse response =HttpUtils.httpPostLogin(baseUrl + "/auth/login");

        //get status
        System.out.println(response.getStatusLine().getStatusCode());

        //get result of get

        StringBuffer result1 = HttpUtils.httpGetUrl(baseUrl + "/players");

        //check title

        boolean b =result1.toString().contains("<title>Players</title>");
        System.out.println(b);


        //get post response


        CloseableHttpResponse response5 = HttpUtils.httpPostCreatePlayer(baseUrl+"/players/insert",expectedPlayer);


        //check status
        System.out.println(response5.getStatusLine().getStatusCode());


    }

}
