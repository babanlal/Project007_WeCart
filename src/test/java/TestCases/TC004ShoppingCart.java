package TestCases;

import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC004ShoppingCart extends BaseClass{
	
	@Test(groups={"Sanity"})
	public void verifyShoppingCart() throws InterruptedException
	{
		logger.info("*****navigate to shopping cart starts******");
		HomePage hp = new HomePage(driver);
		hp.setMyShopCart();
		Thread.sleep(3000);
		
		CartPage cp = new CartPage(driver);
		cp.verifyShopPage();
		cp.setPayCart();
		
		logger.info("*******TC004Shopping cart page tested sucessfuly*******");
	}

}
