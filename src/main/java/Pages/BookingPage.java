package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	
	//This is my web driver constructor
	WebDriver driver;
	
	public BookingPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//object repository
	
	@FindBy(xpath = "(//span[@class=\"headerIconTextAlignment chNavText darkGreyText\"])[2]")
	protected WebElement hotels;
	
	@FindBy(id = "city")
	protected WebElement city;
	
	@FindBy(id = "checkin")
	protected WebElement checkin;
	
	@FindBy(id = "checkout")
	protected WebElement checkout;


}
