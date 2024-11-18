package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[normalize-space()='Shopping Cart']")
	WebElement verifyCartPage;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement cartCont;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement payCart;
	
	public void verifyShopPage() {
		if(verifyCartPage.getText().equals("Shopping Cart"))
		{
			System.out.println("Shopping Cart Page...");
		}
		else
		{
			System.out.println("Failed to show cart page...");
		}
	}
	
	public void setCartCont() {
		cartCont.click();
	}
	
	public void setPayCart() {
		payCart.click();
	}
}
