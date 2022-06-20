package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;


public class GetAQuotePage {
	
	public GetAQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[text()='Get a Quote']")WebElement getQuotElement;
	
	private void clickOnQuote(CommonActions commonActions) {
		commonActions.click(getQuotElement);
	}
	
	
	public void getAQuotePageSteps(CommonActions commonActions) {
		clickOnQuote(commonActions);
	}

}
