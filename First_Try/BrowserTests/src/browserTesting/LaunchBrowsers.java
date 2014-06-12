/**
 * 
 */
package browserTesting;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Shawn
 *
 */
public class LaunchBrowsers {

	private static WebDriver driver;

	public static void main(String[] args) {
		launchChrome();
		launchFirefox();
		launchIE();
		   
	}
	public static void launchChrome() {
		   // Optional, if not specified, WebDriver will search your path for chromedriver.
		   System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		   try {
		   driver = new ChromeDriver();
		   driver.get("http://www.google.com/xhtml");
		   Thread.sleep(5000);  // Let the user actually see something!
		   WebElement searchBox = driver.findElement(By.name("q"));
		   searchBox.sendKeys("ChromeDriver");
		   searchBox.submit();
		   Thread.sleep(5000);  // Let the user actually see something!
		   driver.quit();
		   } catch (Exception EX) {
		   } finally {}	
	}
	
	public static void launchFirefox() {
        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();
        
        // Go to the Google Suggest home page
        driver.get("http://www.google.com/webhp?complete=1&hl=en");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }

        driver.quit();
	}
	
	public static void launchIE() {
		// IE 11 is not currently supported due to an issue with Protected Mode
		System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
        // Go to the Google Suggest home page
        driver.get("http://www.google.com/webhp?complete=1&hl=en");
        
        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
        }

        driver.quit();
	}
}
