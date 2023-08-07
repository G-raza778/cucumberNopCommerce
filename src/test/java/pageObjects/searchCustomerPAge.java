package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchCustomerPAge {
WebDriver ldriver;

public searchCustomerPAge(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
}
@FindBy(id = "SearchEmail")
WebElement searchEmailTF;

@FindBy(id = "search-customers")
WebElement searchBT;

@FindBy(xpath="//table[@id=\"customers-grid\"]/descendant::td")
List<WebElement> tableList;

public void searchEmailTF(String email) {
	searchEmailTF.sendKeys(email);
}
public void searchBT() {
	searchBT.click();
}
public boolean verifyByEmailFromTable(String actualEmail) {
	boolean found=false; 
	int size=tableList.size();
	for(WebElement e:tableList) {
	String ExpectedEmail=e.getText();
	if(ExpectedEmail.contains(actualEmail)) {
		found=true;
	}
}
	return found;
}
}
