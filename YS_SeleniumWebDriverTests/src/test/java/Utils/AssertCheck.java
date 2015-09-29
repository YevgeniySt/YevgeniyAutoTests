package Utils;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений on 19.09.2015.
 */
public class AssertCheck {
    List<String> listOfFails = new ArrayList<String>();



    public  void assertEquals(Object actualValue,Object expectedValue) {

        try {
            Assert.assertEquals(actualValue, expectedValue);
        } catch (AssertionError e) {

            listOfFails.add(e.getMessage());

        }
    }

    public  void printErrors(){

        if (!listOfFails.isEmpty()) {

            for (String r : listOfFails) {
                System.out.println(r + "\n");
            }
            Assert.fail();
        }
    }

    public void clearListOfAsserts() {
        listOfFails.clear();
    }
}
