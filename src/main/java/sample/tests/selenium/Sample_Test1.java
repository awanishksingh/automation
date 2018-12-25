package sample.tests.selenium;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sample_Test1 {

	public static void main(String[] args) throws InterruptedException, AWTException{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//============ create the driver object, add implicit wait, maximize the window =======//
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   //============================ load the web page ======================================//
		driver.get("https://www.seleniumhq.org/");
		//========================   Working : opening a link in a new tab ===================//
		String selectLinkNewWindow = Keys.chord(Keys.SHIFT, Keys.ENTER);
		driver.findElement(By.linkText("Documentation")).sendKeys(selectLinkNewWindow);
		// ======================= moving focus to newly created tab ========================//
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		//===================================================================================//
		Thread.sleep(2000);
		driver.quit();
	}
}
