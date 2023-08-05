package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPAge {
WebDriver ldriver;
public loginPAge(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
}
@FindBy(id="Email")
WebElement EmailTf;

@FindBy(id="Password")
WebElement passwordTF;

@FindBy(xpath = "//button[.=\"Log in\"]")
WebElement loginBT;

@FindBy(xpath = "//a[.=\"Logout\"]")
WebElement logoutBT;

public void enterEmail(String email) {
	EmailTf.clear();
	EmailTf.sendKeys(email);
}
public void enterPassword(String password) {
	passwordTF.clear();
	passwordTF.sendKeys(password);
}
public void loginButton() {
	loginBT.click();
}
public void logoutButton() {
	logoutBT.click();
}
}
