package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;
import dataProvider.AutoData;

public class ZipCodePage2 {
	
	public ZipCodePage2 (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "uid_34")WebElement inputZipCodElement1;
	@FindBy (id = "uid_37")WebElement autoElement;
	@FindBy (xpath = "(//button[@type='submit'])[1]")WebElement clickonQuoteElement;
	
	private void inputZipcode2(CommonActions commonActions, String zipCode2) {
		commonActions.inputText(inputZipCodElement1, zipCode2);
	}	
	private void autoIinsurance(CommonActions commonActions, String typeInsurance) {
		commonActions.selectByValue(autoElement, typeInsurance);
	}
	private void clickonQuote(CommonActions commonActions) {
		commonActions.click(clickonQuoteElement);
	}
	
	
	public void zipCodePage2Steps(CommonActions commonActions, String zipCode2, String typeInsurance) {
		inputZipcode2(commonActions, zipCode2);
		autoIinsurance(commonActions, typeInsurance);
		clickonQuote(commonActions);
	}
	
	public void zipCodePage2Steps(CommonActions commonActions, AutoData autoData) {
		inputZipcode2(commonActions, autoData.getZipCode2());
		autoIinsurance(commonActions, autoData.getTypeInsurance());
		clickonQuote(commonActions);
	}

}
