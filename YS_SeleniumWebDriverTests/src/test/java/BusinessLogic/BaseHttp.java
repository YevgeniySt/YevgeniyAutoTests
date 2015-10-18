package BusinessLogic;

import Utils.HttpUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Created by Евгений on 18.10.2015.
 */
public class BaseHttp {
    public String baseUrl = "http://193.138.245.222:81";

    @BeforeMethod
    public void login() throws IOException {
        CloseableHttpResponse response = HttpUtils.httpPostLogin(baseUrl + "/auth/login");
        StringBuffer result1 = HttpUtils.httpGetUrl(baseUrl + "/players");
        boolean b =result1.toString().contains("<title>Players</title>");
        System.out.println(b);
    }
}
