package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage 
{
	@FindBy(name = "btnreset")
	WebElement ObjResetBtn;
	@FindBy(xpath = "//input[@id='username']")
	WebElement ObjUser;
	@FindBy(id = "password")
	WebElement ObjPass;
	@FindBy(id = "btnsubmit")
	WebElement ObjLogin;
	public void adminLogin(String user,String pass)
	{
		ObjResetBtn.click();
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		ObjLogin.click();
	}
	

}
