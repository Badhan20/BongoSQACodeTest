/*
 * Author: Md. Mahfuz-Ul-Alam Baadhan
 * Date: 27/07/2020
 */
package content;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplementSolution {

	static WebDriver driver;
	static String browser;
	static WebDriverWait wait;
	static WebElement contentPlayButton;

	public static void main(String [] args) throws InterruptedException {

		setBrowser();
		SetBrowserConfiguration();
		clickContent();
		loadContent();
		playContent();

	}

	public static void setBrowser() {
		browser="Chrome";
	}

	public static void SetBrowserConfiguration() {

		if(browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Java\\Java Projects\\SeleniumWithJava\\lib\\chromeDriver\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Java\\Java Projects\\SeleniumWithJava\\lib\\geckoDriver\\geckodriver.exe");

			driver = new FirefoxDriver(); 
		}

	}

	public static void clickContent() throws InterruptedException {


		//Get the URL
		driver.get("https://www.udemy.com/course/robot-framework-2/");

		//Maximize the Window Size
		driver.manage().window().maximize();

		//Set Waiting Time for the Visibility
		wait = new WebDriverWait(driver, 20);

		//Waiting for the Visibility of the Dismiss Button
		WebElement dismissButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md alert-banner--button--21v33']")));

		//Wait 2 Seconds
		Thread.sleep(2000);

		//Click on the Dismiss Button
		dismissButton.click();

		//Wait 2 seconds
		Thread.sleep(2000);

		//Click on the Content
		driver.findElement(By.xpath("//div[text()='Preview this course']")).click();
	}

	public static void loadContent() {

		//Waiting to load the Content Play Button				
		contentPlayButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='video-player--center-button--aPLkI']//a")));

	} 

	public static void playContent() throws InterruptedException {


		//Wait 2 seconds to Click
		Thread.sleep(2000);

		//Click to Play
		contentPlayButton.click();

		//Wait 20 seconds to close the video Content
		Thread.sleep(20000);

		//Click to Close the Video Content
		driver.findElement(By.xpath("//label[@class='udlite-btn udlite-btn-small udlite-btn-ghost udlite-heading-sm udlite-btn-icon udlite-btn-icon-small udlite-modal-close modal--close-button--28QM_']//*[local-name()='svg']")).click();
		
		//Wait 2 seconds to close the browser
		Thread.sleep(2000);
		
		//Close the Browser
		driver.quit();
	}

}
