package Utils;

import java.text.ParseException;

/**
 * Created by Евгений on 27.09.2015.
 */
public class ConvertStrToDbl {
    public static double convertStringToDouble(String actualValue) throws ParseException {
        String currentRealMoneySubstring = actualValue;
        currentRealMoneySubstring = currentRealMoneySubstring.replaceAll("[$,]+", "");
        return new Double(currentRealMoneySubstring);
    }
}
