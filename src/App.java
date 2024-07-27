import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

public class App {
  

  public static void main(String[] args) throws InterruptedException, AWTException {
    // Create an object of ChromeOptions class
    ChromeOptions options = new ChromeOptions();
     
    // Add the argument for your profile directory
    // Replace the path with your own profile path
    options.addArguments("--user-data-dir=C:\\Users\\chaiy\\AppData\\Local\\Google\\Chrome\\User Data\\");
    Robot robot = new Robot();
     
    // Pass the options object to the ChromeDriver constructor
    WebDriver driver = new ChromeDriver(options);

    
    String[] bookNames = {"when-genius-failed", "poverty-by-america", "fast-this-way", "working-backwards", "the-mindbody-prescription", "the-woman-in-me", "the-art-of-community", "the-first-20-hours", "working-hard-hardly-working", "the-antidote", "narrative-economics", "irrational-exuberance", "ageless", "it-doesnt-have-to-be-crazy-at-work", "rising-strong", "the-17-indisputable-laws-of-teamwork", "the-joys-of-compounding", "superintelligence", "invent-and-wander", "and-there-was-light"};    

    // Iterate over the array of book names
    for (String bookName : bookNames) {
      // Navigate to the book summary page for the book
      driver.get("https://www.shortform.com/app/book/" + bookName);

      // Simulate the Ctrl+S keyboard shortcut to open the Save As dialog box
      robot.delay(2000);
      WebElement ulEle = driver.findElement(By.cssSelector("ul[class='control-menu__sub']"));
      List<WebElement> liEles = ulEle.findElements(By.cssSelector("li"));
      int fullGuideListLength = liEles.size();
    
      if (fullGuideListLength > 1) {
        savePage(robot, bookName, fullGuideListLength);
      } else {
        savePage(robot, bookName, 0);
      }
    //   robot.keyPress(KeyEvent.VK_CONTROL);
    //   robot.keyPress(KeyEvent.VK_S);
    //   robot.keyRelease(KeyEvent.VK_CONTROL);
    //   robot.keyRelease(KeyEvent.VK_S);
    //   Thread.sleep(1000);

    //   // Enter the file name for the book summary, using the book name from the array
    //   robot.keyPress(KeyEvent.VK_BACK_SPACE);
    // //   robot.delay(20);
    //   robot.keyRelease(KeyEvent.VK_BACK_SPACE);

    // //   robot.keyPress(KeyEvent.VK_C);
    // //   robot.delay(20);
    // //   robot.keyRelease(KeyEvent.VK_C);
    // pressKey(robot, 'c');
    // pressKey(robot, ':');


    //   robot.keyPress(KeyEvent.VK_BACK_SLASH);
    // //   robot.delay(20);
    //   robot.keyRelease(KeyEvent.VK_BACK_SLASH);

    //   pressKey(robot, 'A');



    //   robot.keyPress(KeyEvent.VK_BACK_SLASH);
    // //   robot.delay(20);
    //   robot.keyRelease(KeyEvent.VK_BACK_SLASH);

      
    //   //   Enter the book name from the array
    //   for (int i = 0; i < bookName.length(); i++) {
    //     pressKey(robot, bookName.charAt(i));
    //   }
      
    //   // if summary has full summary, suffix file name
    //   if (fullGuideListLength > 1) {
    //     for (int j = 0; j < fullGuideListLength; j++) {
    //       pressKey(robot, '-');
    //     }
    //   }
    
    robot.keyPress(KeyEvent.VK_ENTER);
      // robot.delay(20);
      robot.keyRelease(KeyEvent.VK_ENTER);

      if (fullGuideListLength <= 1) {
        continue;
      }
      
      WebElement openContents = driver.findElement(By.cssSelector("div[class='control__btn menu-btn']"));
      WebElement closeContents = driver.findElement(By.cssSelector("div[class='control-menu']"));

      for (int k=0; k < fullGuideListLength; k++) {
        robot.delay(500);
        openContents.click();
        robot.delay(200);
        WebElement part = liEles.get(k);
        part.click();
        robot.delay(200);
        closeContents.click();
        savePage(robot, bookName, fullGuideListLength - k - 1);
      }

    }


    // driver.quit();
}

public static void savePage (Robot robot, String bookName, int numberDashes) throws InterruptedException {
  robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_S);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_S);
      Thread.sleep(2000);

      // Enter the file name for the book summary, using the book name from the array
      robot.keyPress(KeyEvent.VK_BACK_SPACE);
    //   robot.delay(20);
      robot.keyRelease(KeyEvent.VK_BACK_SPACE);

    //   robot.keyPress(KeyEvent.VK_C);
    //   robot.delay(20);
    //   robot.keyRelease(KeyEvent.VK_C);
    pressKey(robot, 'c');
    pressKey(robot, ':');


      robot.keyPress(KeyEvent.VK_BACK_SLASH);
    //   robot.delay(20);
      robot.keyRelease(KeyEvent.VK_BACK_SLASH);

      pressKey(robot, 'A');



      robot.keyPress(KeyEvent.VK_BACK_SLASH);
    //   robot.delay(20);
      robot.keyRelease(KeyEvent.VK_BACK_SLASH);

      
      //   Enter the book name from the array
      for (int i = 0; i < bookName.length(); i++) {
        pressKey(robot, bookName.charAt(i));
      }

      for (int j = 0; j < numberDashes; j++) {
          pressKey(robot, '-');
        }

      robot.keyPress(KeyEvent.VK_ENTER);
      // robot.delay(20);
      robot.keyRelease(KeyEvent.VK_ENTER);

}

public static void pressKey(Robot robot, char c) {
    char cUpper = Character.toUpperCase(c);
    // A switch statement to match the character with the corresponding KeyEvent property
    switch (cUpper) {
        case 'A': {
            robot.keyPress(KeyEvent.VK_A);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_A);
            break;
    
        }
        case 'B': {
            robot.keyPress(KeyEvent.VK_B);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_B);
            break;
        }
        case 'C': {
            robot.keyPress(KeyEvent.VK_C);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_C);
            break;
            }
            case 'D': {
                robot.keyPress(KeyEvent.VK_D);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_D);
                break;
            }
            case 'E': {
                robot.keyPress(KeyEvent.VK_E);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_E);
                break;
            }
              case 'F': {
                robot.keyPress(KeyEvent.VK_F);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_F);
                break;
            }
            case 'G': {
                robot.keyPress(KeyEvent.VK_G);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_G);
                break;
            }
            case 'H': {
                robot.keyPress(KeyEvent.VK_H);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_H);
                break;
            }
              case 'I': {
                  robot.keyPress(KeyEvent.VK_I);
                //   robot.delay(20);
                  robot.keyRelease(KeyEvent.VK_I);
                break;
              }
              case 'J': {
                  robot.keyPress(KeyEvent.VK_J);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_J);
                break;
              }
              case 'K': {
                robot.keyPress(KeyEvent.VK_K);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_K);
                break;
              }
              case 'L': {
                  robot.keyPress(KeyEvent.VK_L);
                //   robot.delay(20);
                  robot.keyRelease(KeyEvent.VK_L);
                break;
                }
                case 'M': {
                robot.keyPress(KeyEvent.VK_M);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_M);
                break;
            }
            case 'N': {
                robot.keyPress(KeyEvent.VK_N);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_N);
                break;
            }
              case 'O': {
                robot.keyPress(KeyEvent.VK_O);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_O);
                break;
            }
            case 'P': {
                robot.keyPress(KeyEvent.VK_P);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_P);
                break;
            }
              case 'Q': {
                robot.keyPress(KeyEvent.VK_Q);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_Q);
                break;
            }
            case 'R': {
                robot.keyPress(KeyEvent.VK_R);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_R);
                break;
            }
              case 'S': {
                robot.keyPress(KeyEvent.VK_S);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_S);
                break;
              }
              case 'T': {
                robot.keyPress(KeyEvent.VK_T);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_T);
                break;
            }
            case 'U': {
                robot.keyPress(KeyEvent.VK_U);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_U);
                break;
            }
              case 'V': {
                robot.keyPress(KeyEvent.VK_V);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_V);
                break;
            }
            case 'W': {
                robot.keyPress(KeyEvent.VK_W);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_W);
                break;
            }
            case 'X': {
                robot.keyPress(KeyEvent.VK_X);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_X);
                break;
            }
            case 'Y': {
                robot.keyPress(KeyEvent.VK_Y);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_Y);
                break;
            }
            case 'Z': {
                robot.keyPress(KeyEvent.VK_Z);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_Z);
                break;
            }
            case '0': {
                robot.keyPress(KeyEvent.VK_0);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_0);
                break;
            }
            case '1': {
                robot.keyPress(KeyEvent.VK_1);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_1);
                break;
            }
            case '2': {
                robot.keyPress(KeyEvent.VK_2);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_2);
                break;
            }
            case '3': {
                robot.keyPress(KeyEvent.VK_3);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_3);
                break;
            }
            case '4': {
                robot.keyPress(KeyEvent.VK_4);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_4);
                break;
            }
            case '5': {
                robot.keyPress(KeyEvent.VK_5);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_5);
                break;
            }
            case '6': {
                robot.keyPress(KeyEvent.VK_6);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_6);
                break;
            }
            case '7': {
                robot.keyPress(KeyEvent.VK_7);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_7);
                break;
            }
            case '8': {
                robot.keyPress(KeyEvent.VK_8);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_8);
                break;
            }
            case '9': {
                robot.keyPress(KeyEvent.VK_9);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_9);
                break;
            }
            // ... and so on for the rest of the digits
            case ':': {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                break;
            }
          case ';': {
            robot.keyPress(KeyEvent.VK_SEMICOLON);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_SEMICOLON);
            break;
          }
          case ',': {
              robot.keyPress(KeyEvent.VK_COMMA);
            //   robot.delay(20);
              robot.keyRelease(KeyEvent.VK_COMMA);
              break;
          }
          case '.': {
              robot.keyPress(KeyEvent.VK_PERIOD);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_PERIOD);
            break;
        }
            case '\'': {
                robot.keyPress(KeyEvent.VK_QUOTE);
                // robot.delay(20);
                robot.keyRelease(KeyEvent.VK_QUOTE);
                break;
            }
            case '"': {
                robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_QUOTE);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_QUOTE);
            break;
        }
        case '-': {
            robot.keyPress(KeyEvent.VK_MINUS);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_MINUS);
            break;
        }
        case '&': {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_7);
            // robot.delay(20);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_7);
            break;
          }
          
          default: return;
        };
    }
    }