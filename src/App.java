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

    Robot robot = new Robot();

    // Declare an array of book names
    String[] bookNames = {"1-2-3-Magic", "The 7 Habits of Highly Effective People", "Thinking, Fast and Slow"};

    // Iterate over the array of book names
    for (String bookName : bookNames) {
      // Navigate to the book summary page for the book
      driver.get("https://www.shortform.com/app/book/" + bookName + "/1-page-summary");

      // Simulate the Ctrl+S keyboard shortcut to open the Save As dialog box
      robot.delay(2000);
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_S);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_S);
      Thread.sleep(4000);

      // Enter the file name for the book summary, using the book name from the array
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

      // Enter the book name from the array
      for (int i = 0; i < bookName.length(); i++) {
        robot.keyPress(bookName.charAt(i));
        robot.delay(20);
      }

      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(20);
      robot.keyRelease(KeyEvent.VK_ENTER);
    }

    driver.quit();
  }
}