package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {
	private static Helper Helper;    
	private static WebDriver driver ;
	public final static int TIMEOUT = 2;

	private Helper(String browser) {
		System.out.println("in helper if else");
		if (browser.equalsIgnoreCase("firefox")) { 
			System.out.println("Testing on firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} 
		else if (browser.equalsIgnoreCase("chrome")) { 
			System.out.println("Testing on chrome");
			//			Loggerload.info("Testing on chrome"); 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 

		else if (browser.equalsIgnoreCase("edge")) { 
			System.out.println("Testing on Edge");
			//			Loggerload.info("Testing on Edge");
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
		}


		//		WebDriverManager.chromedriver().setup();
		//		driver = new ChromeDriver();
		new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();
	}
	//public static void openPage(String url) {
	public static void openPage() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static void NavBack() {
		driver.navigate().back();
	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static void ValidLogin() {
		WebElement uname = driver.findElement(By.name("username"));
		uname.sendKeys("NinjaCoders");
		WebElement pword = driver.findElement(By.name("password"));
		pword.sendKeys("SDET135batch");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
	}
	public static void GetStartedbttn() {
		driver.findElement(By.xpath("//a[text()='Get Started']")).click();
	}
	public static void Tryherebttn() {

		driver.findElement(By.xpath("//a[text()='Try here>>>']")).click();
	}

	public static void RunBtn() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='answer_form']/button")).click();
		Thread.sleep(1000);
	}

	public static void SignOutBtn() {

		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

	}
	public static void setUpDriver(String browser) {
		if (Helper==null)
		{
			Helper = new Helper(browser);
		}
	}
	public static void tearDown() {
		//		if(driver!=null) {
		driver.close();
		//			driver.quit();
		//		}
		Helper = null;
	}

}

/*	private Helper() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
driver.manage().window().maximize();
}
//public static void openPage(String url) {
public static void openPage() {
driver.get("https://dsportalapp.herokuapp.com/login");
}
public static String getTitle() {
return driver.getTitle();
}
public static void NavBack() {
driver.navigate().back();
}
public static WebDriver getDriver() {
return driver;
}

public static void ValidLogin() {
WebElement uname = driver.findElement(By.name("username"));
uname.sendKeys("NinjaCoders");
WebElement pword = driver.findElement(By.name("password"));
pword.sendKeys("SDET135batch");
driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
}
public static void GetStartedbttn() {
driver.findElement(By.xpath("//a[text()='Get Started']")).click();
}
public static void Tryherebttn() {

driver.findElement(By.xpath("//a[text()='Try here>>>']")).click();
}

public static void RunBtn() throws InterruptedException {

driver.findElement(By.xpath("//*[@id='answer_form']/button")).click();
Thread.sleep(1000);
}

public static void SignOutBtn() {

driver.findElement(By.xpath("//a[text()='Sign out']")).click();

}
public static void setUpDriver() {
if (Helper==null)
{
	Helper = new Helper(browser);
}
}
public static void tearDown() {
//if(driver!=null) {
	driver.close();
//	driver.quit();
//}
Helper = null;
}*/