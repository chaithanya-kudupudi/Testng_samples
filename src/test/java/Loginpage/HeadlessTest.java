package Loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTest {
	
	public static String URL ="https://web-int.stg.voyaah.com/#/";
	public static WebDriver driver;
	public static String title = "Vooyah";
	@BeforeTest
	public static void browserInvoke() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt= new ChromeOptions();
//		opt.addArguments("--headless");
		opt.addArguments("--incognito");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public static void Home() throws Exception {
		driver.get(URL);
		Reporter.log("Entered URL success-Fully "+URL);
		Thread.sleep(7000);
		String Extractedtitle = driver.getTitle();
		if (title.equalsIgnoreCase(Extractedtitle)) {
			System.out.println("Title validated Successfully : " + title);
			Reporter.log("Title validated Successfully : " + title);
			
		} else {
			System.out.println("Error in title extraction : " + title);
			Reporter.log("Error in title extraction :" + title);
		}	
		WebElement staycations = driver.findElement(By.xpath("(//*[@href=\"#/\"])[2]"));
		if (staycations.isDisplayed()) {
			Thread.sleep(1000);
			staycations.click();
			System.out.println("Successfully Validated Home :" + driver.getTitle());
		} else {
			System.out.println("Home is not on the expected screen....");

		}
	}

	@Test(priority = 1)
	public static void Staycations() throws Exception {

		WebElement staycations = driver.findElement(By.xpath("(//*[@href=\"#/staycation\"])[2]"));
		if (staycations.isDisplayed()) {
			Thread.sleep(1000);
			staycations.click();
			System.out.println("Successfully clicked on Staycations:" + driver.getTitle());
		} else {
			System.out.println("Staycations is not on the expected screen....");

		}

	}

//	@AfterTest
	public static void teardown() {
		driver.quit();
	}

}