import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class App {
    public static void main(String[] args) throws InterruptedException, AWTException {
        // Create an object of ChromeOptions class
        ChromeOptions options = new ChromeOptions();
        
        // Add the argument for your profile directory
        // Replace the path with your own profile path
        options.addArguments("--user-data-dir=C:\\Users\\chaiy\\AppData\\Local\\Google\\Chrome\\User Data\\");
        
        // Pass the options object to the ChromeDriver constructor
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.shortform.com/app/book/1-2-3-magic/1-page-summary");

        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(4000);

        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);

        robot.keyPress(KeyEvent.VK_C);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_C);

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_SEMICOLON);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SEMICOLON);

        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_BACK_SLASH);

        robot.keyPress(KeyEvent.VK_A);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_BACK_SLASH);

        robot.keyPress(KeyEvent.VK_2);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_2);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_ENTER);




        // driver.quit();
    }
}
