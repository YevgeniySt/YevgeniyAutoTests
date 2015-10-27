package Utils;

import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Евгений on 27.10.2015.
 */
public class DataBaseUtils {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    public static String queryResult(String query){
        String us_login = null;
        com.mysql.jdbc.Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = (Statement) conn.createStatement();

            String sql =query;
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
        return us_login;
    }
}
