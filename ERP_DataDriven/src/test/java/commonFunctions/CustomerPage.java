package commonFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage
{
	@FindBy(xpath = "(//a[starts-with(text(),'Customers')])[2]")
	WebElement ObjCustomer;
	@FindBy(xpath = "(//a[contains(@data-caption,'Add')])[1]")
	WebElement ObjAdd;
	@FindBy(id = "x_Customer_Number")
	WebElement ObjCustomerNumber;
	@FindBy(id = "x_Customer_Name")
	WebElement ObjCustomerName;
	@FindBy(id = "x_Address")
	WebElement ObjAddress;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement ObjCity;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement ObjCountry;
	@FindBy(id = "x_Contact_Person")
	WebElement ObjContactPerson;
	@FindBy(id = "x_Phone_Number")
	WebElement ObjPhoneNumber;
	@FindBy(id = "x__Email")
	WebElement ObjEmail;
	@FindBy(id = "x_Mobile_Number")
	WebElement ObjMobileNumber;
	@FindBy(id = "x_Notes")
	WebElement ObjNotes;
	@FindBy(id = "btnAction")
	WebElement ObjClickAddBtn;
	@FindBy(xpath="(//button[contains(text(),'OK')])[6]")
	WebElement ObjConfirmok;
	@FindBy(xpath="(//button[contains(.,'OK')])[6]")
	WebElement ObjAlertok;
	@FindBy(xpath="//button[@data-caption='Search Panel']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchtextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchBtn;	
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
	
	public boolean AddCustomer(String CustName,String Address,String City,
			String Country,String ContactPerson,String PhoneNo,String Email,String MobileNo,String Notes) throws Throwable
	{
		ObjCustomer.click();
		ObjAdd.click();
		String Exp_Num= ObjCustomerNumber.getAttribute("value");
		ObjCustomerName.sendKeys(CustName);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(City);
		ObjCountry.sendKeys(Country);
		ObjContactPerson.sendKeys(ContactPerson);
		ObjPhoneNumber.sendKeys(PhoneNo);
		ObjEmail.sendKeys(Email);
		ObjMobileNumber.sendKeys(MobileNo);
		ObjNotes.sendKeys(Notes);
		ObjClickAddBtn.sendKeys(Keys.ENTER);
		ObjConfirmok.click();
		Thread.sleep(2000);
		ObjAlertok.click();
		Thread.sleep(2000);
		if(!ObjSearchtextbox.isDisplayed())
			ObjSearchPanel.click();
		ObjSearchtextbox.clear();
		ObjSearchtextbox.sendKeys(Exp_Num);
		ObjSearchBtn.click();
		String Act_Num=webtable.getText();
		if(Exp_Num.equals(Act_Num))
		{
			Reporter.log("Customer number matching"+Exp_Num+"   "+Act_Num, true);
			return true;
		}
		else
		{
			Reporter.log("Customer number not matching"+Exp_Num+"   "+Act_Num, true);
			return false;
		}
	}

}
