package ass2RelativeXPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromWebDriver {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeTest
	public void setUp() {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to a WebSite
		driver.navigate().to("https://learnenglish.britishcouncil.org/");

		// Maximize current window
		driver.manage().window().maximize();
	}

	/**
	 * Test to check click on button functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {

		// wait until the pop-up modal window appears.
		// references :
		// https://stackoverflow.com/questions/17465136/selenium-webdriver-how-to-close-the-first-pop-up-window-and-go-to-the-actual-p
		// https://stackoverflow.com/questions/45183797/element-not-interactable-exception-in-selenium-web-automation
		// https://stackoverflow.com/questions/71761074/the-constructor-webdriverwaitchromedriver-int-is-undefined
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='custom-page-popup-modal-close spb_close']")));

		// Delay execution for 3 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(3000);

		// close the pop-up modal window
		driver.findElement(By.xpath("//span[@class='custom-page-popup-modal-close spb_close']")).click();

		// Delay execution for 3 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(3000);

		// to scroll down on a web page
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Define the web element to find it,
		// using Relative XPath to locate and click on the ‘Discover your level’ link
		WebElement relativeXPathMethod = driver.findElement(By.xpath(
				"//div[@class='field field--name-body field--type-text-with-summary field--label-hidden field--item']/child::p[2]/a"));

		// scroll horizontally on a web page to a specific web element using Selenium
		js.executeScript("arguments[0].scrollIntoView();", relativeXPathMethod);

		// click on web element
		relativeXPathMethod.click();

		// Delay execution for 5 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(5000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.quit();
	}
}
