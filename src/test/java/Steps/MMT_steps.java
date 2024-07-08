package Steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MMT_steps {
	
	WebDriver driver;
	@Given("User on the MakeMyTrip homepage")
	public void user_on_the_make_my_trip_homepage() {
		    driver = new ChromeDriver();
		    driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
	}

	@When("User performs certain test steps")
	public void user_performs_certain_test_steps() throws InterruptedException {
			
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(By.xpath("(//span[@class=\"headerIconTextAlignment chNavText darkGreyText\"])[2]")).click();
	   
	   WebElement search1 = driver.findElement(By.id("city"));
	   search1.sendKeys(Keys.CONTROL + "a");
	   search1.sendKeys(Keys.BACK_SPACE);
	   driver.findElement(By.cssSelector("[title=\"Where do you want to stay?\"]")).sendKeys("Munnar");
	   driver.findElement(By.xpath("(//p[@class=\"hw__nearbyTextWrapper font16\"])[1]")).click();
	   driver.findElement(By.id("checkin")).click();
	   driver.findElement(By.xpath("(//div[@role=\"gridcell\" and text()=\"28\"])[1]")).click();
	   driver.findElement(By.xpath("(//div[@role=\"gridcell\" and text()=\"31\"])[1]")).click();
	   driver.findElement(By.cssSelector("[data-cy=\"RoomsGuestsNew_327\"]")).click();
	   driver.findElement(By.xpath("//span[@class=\"lbl_input appendBottom5\" and text()=\"Price per Night\"]")).click();
	   driver.findElement(By.xpath("//li[@data-cy=\"PricePerNight_325\" and text()=\"₹2500-₹5000\"]")).click();
	   driver.findElement(By.id("hsw_search_button")).click();
	   driver.findElement(By.xpath("(//span[text()=\"Breakfast Included\"])[1]")).click();
	   driver.findElement(By.xpath("(//span[text()=\"Very Good: 3.5+\"])[1]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//a[@href=\"javascript:void(0)\" and text()=\"Clear\"]")).click();	
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("[class=\"react-autosuggest__input\"]")).sendKeys("Blanket Hotel & Spa");
	   driver.findElement(By.xpath("//span[text()=\"Blanket Hotel & Spa Munnar, Munnar, Kerala\"]")).click();	   
	   driver.findElement(By.xpath("//span[text()=\"Blanket Hotel & Spa Munnar\"]")).click();
	   
	   Set<String> wh = driver.getWindowHandles();

	   List<String> h = new ArrayList<>(wh);
	   String s1 = h.get(1); 
	   driver.switchTo().window(s1);
	 	   
	}

	@Then("Payment should be visible")
	public void payment_should_be_visible() {
		 driver.findElement(By.cssSelector("[class=\"appBtn filled large bkngOption__cta  \"]")).click();
		   String exp = driver.findElement(By.cssSelector("[class=\"font22 latoBlack blackText\"]")).getText();
		   String act ="Blanket Hotel & Spa Munnar";
		   Assert.assertEquals(exp, act);
	}

	@Then("Booking deatils should be visible")
	public void booking_deatils_should_be_visible() {
		String x = driver.findElement(By.cssSelector("p[class=\"latoBold blackText\"]")).getText();
		   String a ="1 Room x 3 Nights";
		   Assert.assertEquals(x, a);
	}

}
