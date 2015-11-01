package businesslogic;

import utils.HttpHelper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Created by Евгений on 18.10.2015.
 */
public class BaseHttp {
    public String baseUrl = "http://192.168.0.101";

    @BeforeMethod
    public void login() throws IOException {
        CloseableHttpResponse response = HttpHelper.httpPostLogin(baseUrl + "/auth/login");
        StringBuffer result1 = HttpHelper.httpGetUrl(baseUrl + "/players");
        boolean b =result1.toString().contains("<title>Players</title>");
        System.out.println(b);
    }


}
