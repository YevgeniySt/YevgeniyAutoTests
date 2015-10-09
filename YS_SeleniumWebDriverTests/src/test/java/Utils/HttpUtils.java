package Utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Евгений on 09.10.2015.
 */
public class HttpUtils {


    public static CloseableHttpResponse httpPostLogin(CloseableHttpClient httpClient,String url) throws IOException {
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("username", "admin"));
        params.add(new BasicNameValuePair("password", "123"));
        params.add(new BasicNameValuePair("logIn", "Log+In"));
        post.setEntity(new UrlEncodedFormEntity(params));

        //execute post
        return httpClient.execute(post);
    }

    public static StringBuffer httpGetUrl(CloseableHttpClient httpclient, String url) throws IOException {
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

    public static CloseableHttpResponse httpPostCreatePlayer(CloseableHttpClient httpclient, String url) throws IOException {

        String name = "UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()));
        String email = "UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()))+"@mail.ru";
        HttpPost post2 = new HttpPost(url);
        System.out.println(name);
        System.out.println(email);
        HttpEntity multipart = MultipartEntityBuilder.create()
                .addTextBody("#requestSender", "ff14642ac1c")
                .addTextBody("submitMode", "save")
                .addTextBody("ff14642ac1c__us_login", name)
                .addTextBody("ff14642ac1c__us_email", email)
                .addTextBody("ff14642ac1c__us_password", "Password1")
                .addTextBody("ff14642ac1c__confirm_password", "Password1")
                .addTextBody("ff14642ac1c__us_reg_status", "1")
                .addTextBody("ff14642ac1c__us_chat_enabled", "0")
                .addTextBody("ff14642ac1c__us_chat_enabled", "1")
                .addTextBody("ff14642ac1c__is_community", "0")
                .addTextBody("ff14642ac1c__is_community", "1")
                .addTextBody("ff14642ac1c__us_owner_id", "1")
                .addTextBody("ff14642ac1c__us_fname", "")
                .addTextBody("ff14642ac1c__us_lname", "")
                .addTextBody("ff14642ac1c__us_city", "")
                .addTextBody("ff14642ac1c__us_country", "_unset_")
                .addTextBody("ff14642ac1c__us_address", "")
                .addTextBody("ff14642ac1c__us_phone", "123456")
                .addTextBody("ff14642ac1c__us_gender", "1")
                .addTextBody("ff14642ac1c__us_birthday", "10-07-1997")
                .addTextBody("ff14642ac1c__disable_lp", "0")
                .addTextBody("ff14642ac1c__payment_chat_enabled", "0")
                .addTextBody("ff14642ac1c__payment_chat_enabled", "1")
                .addTextBody("ff14642ac1c__pit_boss_alert_enabled", "0")
                .addTextBody("ff14642ac1c__pit_boss_alert_enabled", "1")
                .addTextBody("ff14642ac1c__credit_type", "Periodic Credit")
                .addTextBody("ff14642ac1c__credit_amount", "")
                .addTextBody("ff14642ac1c__credit_frequency", "Weekly")
                .addTextBody("ff14642ac1c__credit_next_reset", "10-12-2015 00:00:00")
                .addTextBody("ff14642ac1c__credit_temp", "")
                .addTextBody("ff14642ac1c__credit_expiration", "")
                .addTextBody("ff14642ac1c__credit_comment", "")
                .addTextBody("ff14642ac1c__stop_weekly_reset", "0").build();

        post2.setEntity(multipart);

        return  httpclient.execute(post2);
    }
}
