package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addNewCustomerPAge {
	public WebDriver ldriver;
public addNewCustomerPAge(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(ldriver,this);
}
@FindBy(xpath = "//a[@href=\"#\"]/p[contains(text(),'Customers')]")
WebElement customerMenu;

@FindBy(xpath = "//a[@href=\"/Admin/Customer/List\"]/p[contains(text(),'Customers')]")
WebElement customerList;

@FindBy(xpath = "//a[@class=\"btn btn-primary\"]")
WebElement addNewButton;

@FindBy(className ="float-left")
WebElement customersTitle;

@FindBy(id ="Email")
WebElement emailTF;

@FindBy(id ="Password")
WebElement passwordTF;

@FindBy(id ="FirstName")
WebElement fNameTF;

@FindBy(id ="LastName")
WebElement lNameTF;

@FindBy(id ="Gender_Male")
WebElement genderRB;

@FindBy(id ="DateOfBirth")
WebElement DOB;

@FindBy(id ="Company")
WebElement CompanyTF;

@FindBy(xpath = "//select[@id=\"SelectedNewsletterSubscriptionStoreIds\"]")
WebElement newsletterSelectList;

@FindBy(id ="VendorId")
WebElement manageVendorSelectList;

@FindBy(xpath = "//button[@name=\"save\"]")
WebElement saveBT;

@FindBy(xpath = "//div[@class=\"content-header\"]")
WebElement dashboardTitle;

@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissable\"]/button")
WebElement confirmationMSG;

public String confirmationMsg() {
	return confirmationMSG.getText();
}
public String getPAgeTitle() {
	return ldriver.getTitle();
}
public void customerMenu() {
	customerMenu.click();
}
public void customerSubMenu() {
	customerList.click();
}
public void addNewCustomer() {
	addNewButton.click();
}
public String customerTitle() {
	return customersTitle.getText();
}
public void emailTF(String email) {
	emailTF.sendKeys(email);
}
public void passwordTf(String password) {
	passwordTF.sendKeys(password);
}
public void fname(String fNAme) {
	fNameTF.sendKeys(fNAme);
}
public void lname(String lNAme) {
	lNameTF.sendKeys(lNAme);
}
public void selectGEnderMale() {
	genderRB.click();
}
public void dobCalender(String ddmmyyyy) {
	DOB.sendKeys(ddmmyyyy);
}
public void companyTF(String cNAme) {
	CompanyTF.sendKeys(cNAme);
}
public void newsLetterTF(String text) {
	Select s=new Select(newsletterSelectList);
	s.selectByVisibleText(text);
}
public void vendorSelectList(String vendorText) {
	Select s=new Select(manageVendorSelectList);
	s.selectByVisibleText(vendorText);
}
public void saveButton() {
	saveBT.click();
}
}
