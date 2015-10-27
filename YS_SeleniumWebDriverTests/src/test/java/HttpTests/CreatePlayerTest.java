package HttpTests;

import BusinessLogic.BaseHttp;
import Objects.PlayerFull;
import Objects.PlayerFullBuilder;
import Utils.HttpUtils;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Евгений on 29.09.2015.
 */
public class CreatePlayerTest extends BaseHttp{

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";


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
        HttpUtils.httpPostCreatePlayer(baseUrl + "/players/insert", expectedPlayer);


        HttpUtils.httpPostSearchPlayer(baseUrl + "/players", expectedPlayer);
        //assert
        String us_login = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = (Statement) conn.createStatement();

            String sql ="SELECT us_login FROM players where us_login="+"\""+expectedPlayer.login+"\"";
            //System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

                us_login = rs.getString("us_login");


                //Display values
                System.out.println("us_login: " + us_login);
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");







      //  StringBuffer result6 = HttpUtils.httpGetUrl(baseUrl + "/players");

       // Assert.assertTrue(result6.toString().contains(">" + expectedPlayer.login + "</a>k"));

        Assert.assertEquals(expectedPlayer.login+"f",us_login);





    }

}
