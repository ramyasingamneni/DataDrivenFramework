package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.CustomerPage;
import config.AppUtil1;
import utilities.ExcelFileUtil;

public class DriverFactory extends AppUtil1
{
	String inputpath="./FileInput/CustomerData.xlsx";
	String outputpath="./FileOutput/CustomerResults.xlsx";
	ExtentReports report;
	ExtentTest logger;
	@Test
	public void startTest() throws Throwable
	{
		CustomerPage cus=PageFactory.initElements(driver, CustomerPage.class);
		report=new ExtentReports("./taget/Reports/CustomerReports.html");
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int rc=xl.rowCount("Customer");
		Reporter.log("No. of rows::"+rc, true);
		for(int i=1;i<=rc;i++)
		{
			logger=report.startTest("Customer Reports");
			logger.assignAuthor("Ramya");
			String customername=xl.getCellData("Customer", i, 0);
			String address=xl.getCellData("Customer", i, 1);
			String city=xl.getCellData("Customer", i, 2);
			String country=xl.getCellData("Customer", i, 3);
			String contactperson=xl.getCellData("Customer", i, 4);
			String phnumber=xl.getCellData("Customer", i, 5);
			String email=xl.getCellData("Customer", i, 6);
			String mobile_number=xl.getCellData("Customer", i, 7);
			String notes=xl.getCellData("Customer", i, 8);
			logger.log(LogStatus.INFO, customername+"---"+address+"---"+city+"---"+country+"---"+contactperson+"---"+phnumber+"---"+email
					+"---"+mobile_number+"---"+notes);
			boolean res=cus.AddCustomer(customername, address, city, country, contactperson, phnumber, email, mobile_number, notes);
			if(res)
			{
				xl.setCellData("Customer", i, 9, "Pass", outputpath);
				logger.log(LogStatus.PASS, "Customer added successfully");
			}
			else
			{
				xl.setCellData("Customer", i, 9, "Fail", outputpath);
				logger.log(LogStatus.FAIL, "Customer not added successfully");
			}
			report.endTest(logger);
			report.flush();
		}
	}

}
