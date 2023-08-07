package stepDefinitions;

import java.awt.AWTException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.addNewCustomerPAge;
import pageObjects.loginPAge;
import pageObjects.searchCustomerPAge;

public class stepDef {
	public WebDriver driver;
	public loginPAge lp;
	public addNewCustomerPAge anc;
	public searchCustomerPAge scp;

	@Given("when user launches chrome browser")
	public void when_user_launches_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new loginPAge(driver);
		anc=new addNewCustomerPAge(driver);
		scp=new searchCustomerPAge(driver);
	}

	@When("user navigates to URL {string}")
	public void user_navigates_to_url(String url) {
	  driver.get(url);
	}

	@When("enters email as {string} and password as {string}")
	public void enters_email_as_and_password_as(String email, String password) {
		lp.enterEmail(email);
		lp.enterPassword(password);
	}

	@When("click on signin button")
	public void click_on_signin_button() {
		lp.loginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() {
		lp.logoutButton();;
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}
//////////////////////////////////////Add new customers//////////////////////////////////////////
@Then("user can see dashboard")
public void user_can_see_dashboard() {
   String actual=anc.getPAgeTitle();
   String expected="Dashboard / nopCommerce administration";
   if(actual.equalsIgnoreCase(expected)) {
	   Assert.assertTrue(true);
   }
   else {
	   Assert.assertTrue(false);
   }
}

@When("user clicks on customer menu")
public void user_clicks_on_customer_menu() {
anc.customerMenu();
}

@When("user clicks on customer")
public void user_clicks_on_customer() {
anc.customerSubMenu();
}

@Then("customer menu is visible")
public void customer_menu_is_visible() {
  String actual=anc.getPAgeTitle();
  String expected="Add a new customer / nopCommerce administration";
  if(actual.equalsIgnoreCase(expected)) {
	  Assert.assertTrue(false);
  }
  else {
	  Assert.assertTrue(true);
  }
}

@When("user clicks on add new customer button")
public void user_clicks_on_add_new_customer_button() {
anc.addNewCustomer();
}

@Then("user can see add new customer option")
public void user_can_see_add_new_customer_option() {
  String actual=anc.customerTitle();
  String expected="Customers";
  if(actual.equalsIgnoreCase(expected)) {
	  Assert.assertTrue(false);
  }
  else {
	  Assert.assertTrue(true);
  }
}

@When("user enters all info")
public void user_enters_all_info() throws AWTException {
anc.emailTF("azxefc1a@gmail.com");
anc.passwordTf("kisiKoBatanaNahi");
anc.fname("gulam");
anc.lname("raza");
anc.selectGEnderMale();
anc.dobCalender("02/21/1995");
anc.companyTF("raza enterprises");
//anc.newsLetterTF("Your store name");
anc.newsLetterTF();
anc.vendorSelectList("Vendor 1");

}

@When("clicks on save button")
public void clicks_on_save_button() {
anc.saveButton();
}

@Then("user can see confirmation message {string}")
public void user_can_see_confirmation_message(String actual) {
  String expected=anc.confirmationMsg();
  if(actual.equalsIgnoreCase(expected)) {
	  Assert.assertTrue(false);
  }
  else {
	  Assert.assertTrue(true);
  }
}
/////////////////////////////////////////////Search by email and validating by table data//////////////////////////
@When("user enters email in search BY email text field")
public void user_enters_email_in_search_by_email_text_field() {
scp.searchEmailTF("victoria_victoria@nopCommerce.com");
}

@When("clicks on search button")
public void clicks_on_search_button() {
scp.searchBT();
}

@Then("customer details is vissible")
public void customer_details_is_vissible() {
String expectedEmail="victoria_victoria@nopCommerce.com";
Assert.assertTrue(scp.verifyByEmailFromTable(expectedEmail));
}

}
