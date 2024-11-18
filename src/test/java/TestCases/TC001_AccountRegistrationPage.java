package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationPage extends BaseClass {
	
	@Test(groups={"Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		Thread.sleep(2000);
		hp.clickRegister();
		
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString(6).toUpperCase());
		regpage.setLastName(randomeString(6).toUpperCase());
		
		Thread.sleep(2000);
		String email = randomeAlphaNum(4,4)+("@gmail.com");
		regpage.setEmail(email);// randomly generated the email
		System.out.println(email);
		
		regpage.setTelephone(randomeNumeric(10));
		
		Thread.sleep(2000);
		String password=randomeAlphaNum(4,4);
		System.out.println(password);
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		Thread.sleep(2000);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message..");
		
		Thread.sleep(2000);
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		logger.info("Test passed");
		
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
	}

}
