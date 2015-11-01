package utils;

import test_models.HttpEntityBuilder;
import test_models.PlayerFull;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений on 09.10.2015.
 */
public class HttpHelper {

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

        HttpEntity multipart = HttpEntityBuilder.createHttpEntityForPostCreatePlayer(playerFull);

        post2.setEntity(multipart);

        CloseableHttpResponse r = httpclient.execute(post2);
        r.close();

    }

    public static void httpPostSearchPlayer(String url, PlayerFull playerFull) throws IOException {


        HttpPost post2 = new HttpPost(url);

        HttpEntity multipart = HttpEntityBuilder.createHttpEntityForPostSearchPlayer(playerFull);

        post2.setEntity(multipart);

        CloseableHttpResponse r =  httpclient.execute(post2);
        r.close();
    }
}
