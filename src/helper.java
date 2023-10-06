import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class helper  {
    // A function that takes a character as input and returns the respective KeyEvent property
public static int getKeyEvent(char c) {
    char cUpper = Character.toUpperCase(c);
    // A switch statement to match the character with the corresponding KeyEvent property
    switch (cUpper) {
      case 'A': return KeyEvent.VK_A;
      case 'B': return KeyEvent.VK_B;
      case 'C': return KeyEvent.VK_C;
      // ... and so on for the rest of the alphabet
      case '0': return KeyEvent.VK_0;
      case '1': return KeyEvent.VK_1;
      case '2': return KeyEvent.VK_2;
      // ... and so on for the rest of the digits
      case ':': return KeyEvent.VK_COLON;
      case ';': return KeyEvent.VK_SEMICOLON;
      case ',': return KeyEvent.VK_COMMA;
      case '.': return KeyEvent.VK_PERIOD;
      // ... and so on for the rest of the punctuation marks
      // You can add more cases for other characters as needed
      default: return -1; // Return -1 if the character is not supported
    }
  }
}
