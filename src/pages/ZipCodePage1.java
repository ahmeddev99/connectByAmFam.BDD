package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;
import dataProvider.AutoData;

public class ZipCodePage1 {
	
	public ZipCodePage1 (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='h1']" )
	public	WebElement displayTextElement;
	
	@FindBy (id = "uid_54")
	WebElement inputZipCodElement;
	
	@FindBy (xpath = "(//span[@class='LoadingButton__content'])[1]")
	WebElement clickonStartQuotingElement;
	
	
	public void displayText () {
	String display = displayTextElement.getText();
		System.out.println(display);
	}
	
	private void inputZipCode(CommonActions commonActions, String zipCode1) {
		commonActions.inputText(inputZipCodElement, zipCode1);
	}
	private void clickOnStartQuoting(CommonActions commonActions) {
		commonActions.click(clickonStartQuotingElement);
	}
	
	
	public void zipCodePage1Steps(CommonActions commonActions, String zipCode1) {
		inputZipCode(commonActions, zipCode1);
		clickOnStartQuoting(commonActions);
	}
	
	public void zipCodePage1Steps(CommonActions commonActions, AutoData autoData) {
		inputZipCode(commonActions, autoData.getZipCode1());
		clickOnStartQuoting(commonActions);
	}

}



