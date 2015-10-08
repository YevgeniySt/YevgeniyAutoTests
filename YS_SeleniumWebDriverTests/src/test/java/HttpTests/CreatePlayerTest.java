package HttpTests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Евгений on 29.09.2015.
 */
public class CreatePlayerTest {
    public String baseUrl = "http://193.138.245.222:81";

    @Test
    public void createPlayerTest() throws IOException, InterruptedException {

        //create http client

        CloseableHttpClient httpclient = HttpClients.createDefault();

        //create post

        HttpPost post = new HttpPost(baseUrl+"/auth/login");
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("username", "admin"));
        params.add(new BasicNameValuePair("password", "123"));
        params.add(new BasicNameValuePair("logIn", "Log+In"));
        post.setEntity(new UrlEncodedFormEntity(params));

        //execute post
        CloseableHttpResponse response = httpclient.execute(post);

        //get status
        System.out.println(response.getStatusLine().getStatusCode());

        //create get

        HttpGet get = new HttpGet(baseUrl+"/players");

        //execute get

        CloseableHttpResponse response1 = httpclient.execute(get);

        //get response

        BufferedReader rd1 = new BufferedReader(
                new InputStreamReader(response1.getEntity().getContent()));

        StringBuffer result1 = new StringBuffer();
        String line1 = "";
        while ((line1 = rd1.readLine()) != null) {
            result1.append(line1);
        }

        //check title

        boolean b =result1.toString().contains("<title>Players</title>");
        System.out.println(b);

        //close response

        response1.close();

        //create post

        String name = "UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()));
        String email = "UN" + String.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date()))+"@mail.ru";
        HttpPost post2 = new HttpPost(baseUrl+"/players/insert");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        builder.addTextBody("#requestSender", "ff14642ac1c");
        builder.addTextBody("submitMode", "save");
        System.out.println(name);
        System.out.println(email);
        builder.addTextBody("ff14642ac1c__us_login", name);
        builder.addTextBody("ff14642ac1c__us_email", email);
        builder.addTextBody("ff14642ac1c__us_password", "Password1");
        builder.addTextBody("ff14642ac1c__confirm_password", "Password1");
        builder.addTextBody("ff14642ac1c__us_reg_status", "1");
        builder.addTextBody("ff14642ac1c__us_chat_enabled", "0");
        builder.addTextBody("ff14642ac1c__us_chat_enabled", "1");
        builder.addTextBody("ff14642ac1c__is_community", "0");
        builder.addTextBody("ff14642ac1c__is_community", "1");
        builder.addTextBody("ff14642ac1c__us_owner_id", "1");
        builder.addTextBody("ff14642ac1c__us_fname", "");
        builder.addTextBody("ff14642ac1c__us_lname", "");
        builder.addTextBody("ff14642ac1c__us_city", "");
        builder.addTextBody("ff14642ac1c__us_country", "_unset_");
        builder.addTextBody("ff14642ac1c__us_address", "");
        builder.addTextBody("ff14642ac1c__us_phone", "123456");
        builder.addTextBody("ff14642ac1c__us_gender", "1");
        builder.addTextBody("ff14642ac1c__us_birthday", "10-07-1997");
        builder.addTextBody("ff14642ac1c__disable_lp", "0");
        builder.addTextBody("ff14642ac1c__payment_chat_enabled", "0");
        builder.addTextBody("ff14642ac1c__payment_chat_enabled", "1");
        builder.addTextBody("ff14642ac1c__pit_boss_alert_enabled", "0");
        builder.addTextBody("ff14642ac1c__pit_boss_alert_enabled", "1");
        builder.addTextBody("ff14642ac1c__credit_type", "Periodic Credit");
        builder.addTextBody("ff14642ac1c__credit_amount", "");
        builder.addTextBody("ff14642ac1c__credit_frequency", "Weekly");
        builder.addTextBody("ff14642ac1c__credit_next_reset", "10-12-2015 00:00:00");
        builder.addTextBody("ff14642ac1c__credit_temp", "");
        builder.addTextBody("ff14642ac1c__credit_expiration", "");
        builder.addTextBody("ff14642ac1c__credit_comment", "");
        builder.addTextBody("ff14642ac1c__stop_weekly_reset", "0");

        HttpEntity multipart = builder.build();
        post2.setEntity(multipart);
        CloseableHttpResponse response5 = httpclient.execute(post2);

        //check status
        System.out.println(response5.getStatusLine().getStatusCode());


    }

}
