package HttpTests;

import Utils.HttpUtils;
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

        //login

        CloseableHttpResponse response =HttpUtils.httpPostLogin(httpclient, baseUrl + "/auth/login");

        //get status
        System.out.println(response.getStatusLine().getStatusCode());

        //get result of get

        StringBuffer result1 = HttpUtils.httpGetUrl(httpclient, baseUrl + "/players");

        //check title

        boolean b =result1.toString().contains("<title>Players</title>");
        System.out.println(b);


        //get post response


        CloseableHttpResponse response5 = HttpUtils.httpPostCreatePlayer(httpclient,baseUrl+"/players/insert");


        //check status
        System.out.println(response5.getStatusLine().getStatusCode());


    }

}
