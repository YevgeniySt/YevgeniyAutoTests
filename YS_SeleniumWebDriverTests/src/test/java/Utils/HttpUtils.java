package Utils;

import Objects.PlayerFull;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by Евгений on 09.10.2015.
 */
public class HttpUtils {

    static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static CloseableHttpResponse httpPostLogin(String url) throws IOException {
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("username", "admin"));
        params.add(new BasicNameValuePair("password", "123"));
        params.add(new BasicNameValuePair("logIn", "Log+In"));
        post.setEntity(new UrlEncodedFormEntity(params));

        //execute post
        return httpclient.execute(post);
    }

    public static StringBuffer httpGetUrl(String url) throws IOException {
        HttpGet get = new HttpGet(url);

        //execute get

        CloseableHttpResponse response1= httpclient.execute(get);

        //get response

        BufferedReader rd1 = new BufferedReader(
                new InputStreamReader(response1.getEntity().getContent()));

        StringBuffer result1 = new StringBuffer();
        String line1 = "";
        while ((line1 = rd1.readLine()) != null) {
            result1.append(line1);
        }
       response1.close();
        return result1;
    }

    public static void httpPostCreatePlayer(String url, PlayerFull playerFull) throws IOException {


        HttpPost post2 = new HttpPost(url);

        HttpEntity multipart = MultipartEntityBuilder.create()
                .addTextBody("#requestSender", playerFull.requestSender)
                .addTextBody("submitMode", "save")
                .addTextBody("ff14642ac1c__us_login", playerFull.login)
                .addTextBody("ff14642ac1c__us_email", playerFull.email)
                .addTextBody("ff14642ac1c__us_password", playerFull.password)
                .addTextBody("ff14642ac1c__confirm_password", playerFull.password)
                .addTextBody("ff14642ac1c__us_reg_status", playerFull.regStatus)
                .addTextBody("ff14642ac1c__us_chat_enabled", "0")
                .addTextBody("ff14642ac1c__us_chat_enabled", playerFull.chatEnabled)
                .addTextBody("ff14642ac1c__is_community", playerFull.isCommunity)
                .addTextBody("ff14642ac1c__us_owner_id", playerFull.ownerID)
                .addTextBody("ff14642ac1c__us_fname", playerFull.fName)
                .addTextBody("ff14642ac1c__us_lname", playerFull.lName)
                .addTextBody("ff14642ac1c__us_city", playerFull.city)
                .addTextBody("ff14642ac1c__us_country", playerFull.country)
                .addTextBody("ff14642ac1c__us_address", playerFull.address)
                .addTextBody("ff14642ac1c__us_phone", playerFull.phone)
                .addTextBody("ff14642ac1c__us_gender", playerFull.gender)
                .addTextBody("ff14642ac1c__us_birthday", playerFull.birthday)
                .addTextBody("ff14642ac1c__disable_lp", playerFull.disableLp)
                .addTextBody("ff14642ac1c__payment_chat_enabled", playerFull.chatEnabled)
                .addTextBody("ff14642ac1c__pit_boss_alert_enabled", playerFull.pittBossAlertEnabled)
                .addTextBody("ff14642ac1c__credit_type", playerFull.creditType)
                .addTextBody("ff14642ac1c__credit_amount", playerFull.creditAmount)
                .addTextBody("ff14642ac1c__credit_frequency", playerFull.creditFrequency)
                .addTextBody("ff14642ac1c__credit_next_reset", playerFull.creditNextReset)
                .addTextBody("ff14642ac1c__credit_temp", playerFull.creditTemp)
                .addTextBody("ff14642ac1c__credit_expiration", playerFull.creditExpiration)
                .addTextBody("ff14642ac1c__credit_comment", playerFull.creditComment)
                .addTextBody("ff14642ac1c__stop_weekly_reset", playerFull.stopWeeklyReset).build();

        post2.setEntity(multipart);

        CloseableHttpResponse r = httpclient.execute(post2);
        r.close();

    }

    public static void httpPostSearchPlayer(String url, PlayerFull playerFull) throws IOException {


        HttpPost post2 = new HttpPost(url);

        HttpEntity multipart = MultipartEntityBuilder.create()
                .addTextBody("723a925886__agent", "_unset_")
                .addTextBody("723a925886__city", "")
                .addTextBody("723a925886__email", "")
                .addTextBody("723a925886__external_ip_address", "")
                .addTextBody("723a925886__firstname", "")
                .addTextBody("723a925886__last_login", "")
                .addTextBody("723a925886__lastname", "")
                .addTextBody("723a925886__mac_address", "")
                .addTextBody("723a925886__null1", "")
                .addTextBody("723a925886__reg_date_from", "")
                .addTextBody("723a925886__reg_date_to", "")
                .addTextBody("723a925886__country", "_unset_")
                .addTextBody("723a925886__deleted", "0")
                .addTextBody("723a925886__is_community", "_unset_")
                .addTextBody("723a925886__login", playerFull.login)
                .addTextBody("723a925886__real_amount", "_unset_")
                .addTextBody("723a925886__state_type", "_unset_")
                .addTextBody("723a925886__vip_level", "_unset_")
                .addTextBody("filterpanel_submited_723a925886", "submited").build();

        post2.setEntity(multipart);

        CloseableHttpResponse r =  httpclient.execute(post2);
        r.close();
    }
}
