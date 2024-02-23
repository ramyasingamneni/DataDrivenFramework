package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogoutPage;

public class AppUtil1 
{
	public static Properties conpro;
	public static WebDriver driver;
	@BeforeTest
	public static void setUp() throws Throwable
	{
		conpro=new Properties();
		driver=new ChromeDriver();
		conpro.load(new FileInputStream("./PropertyFiles/login.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(conpro.getProperty("Url"));
			AdminLoginPage login=PageFactory.initElements(driver, AdminLoginPage.class);
			login.adminLogin("admin", "master");
		}
		else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			
		}
		else
		{
			Reporter.log("Browser value is not matching", true);
		}
	}
	@AfterTest
	public static void tearDown() 
	{
		AdminLogoutPage logout=PageFactory.initElements(driver, AdminLogoutPage.class);
		logout.logout();
		driver.quit();
	}

}
