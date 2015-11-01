package utils;

import org.openqa.selenium.WebDriver;

/**
 * Created by Евгений on 27.09.2015.
 */
public class WindowsHandler {
  //  public List<String> listOfWindows = new LinkedList<String>();

    public static String getCurrentWindow(WebDriver driver){
        return driver.getWindowHandle();
    }

    public static void switchToWindow(WebDriver driver, String window){
        driver.switchTo().window(window);
    }

    public static void switchToWindowByTitle(WebDriver driver, String title){
        for(String winHandle :driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();
           // listOfWindows.add(driver.switchTo().window(winHandle).getWindowHandle());

            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }
}
