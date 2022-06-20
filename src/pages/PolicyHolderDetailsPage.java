package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;
import dataProvider.AutoData;


public class PolicyHolderDetailsPage {
	
	public PolicyHolderDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "F_PH_FirstName_0") WebElement firstNameElement;
	@FindBy (id = "F_PH_MiddleInitial_0") WebElement middleInitElement;
	@FindBy (id = "F_PH_LastName_0") WebElement lastNameElement;
	@FindBy (id = "F_PH_DOB_0") WebElement dobElement;
	@FindBy(id = "F_PH_email_0")WebElement emailElement;
	@FindBy (id = "F_street_0") WebElement streetAddressElement;
	@FindBy (id = "F_city_0") WebElement cityElement;
	@FindBy (id = "F_state_0") WebElement stateElement;
	@FindBy (id = "F_zipCode_0") WebElement zipCodeElement;
	@FindBy (id = "F_livingYear_0") WebElement livingyearsElement;
	@FindBy (xpath = "//span[text()='Continue ']") WebElement continueElement;
	@FindBy(xpath = "//span[@class='addressD']") WebElement checkBoxElement;
	

	private void inputFirstName(CommonActions commonActions, String firstName) {
		commonActions.inputText(firstNameElement, firstName);
	}
	private void inputMiddleName(CommonActions commonActions, char middleName) {
		commonActions.inputText(middleInitElement, middleName);
	}
	private void inputLastName(CommonActions commonActions, String lastName) {
		commonActions.inputText(lastNameElement, lastName);
	}
	private void dateOfBirth(CommonActions commonActions, String dob) {
		commonActions.inputText(dobElement, dob);
	}
	private void emailAddress(CommonActions commonActions, String email) {
		commonActions.inputText(emailElement, email);
	}
	private void streetAddress(CommonActions commonActions, String streetAddress) {
		commonActions.inputText(streetAddressElement, streetAddress);
	}
	private void city(CommonActions commonActions, String city) {
		commonActions.inputText(cityElement, city);
	}
	private void pickState(CommonActions commonActions, String State) {
		commonActions.selectByValue(stateElement, State);
	}
	private void zipCode(CommonActions commonActions, String zipcode) {
		commonActions.inputText(zipCodeElement, zipcode);
	}
	private void livingAtTheAddress(CommonActions commonActions, String atTheAddress) {
		commonActions.inputText(livingyearsElement, atTheAddress);
	}
	private void continueNext(CommonActions commonActions) {
		commonActions.click(continueElement);
	}
	
	public void policyHolderDetailsPageSteps(CommonActions commonActions, String firstName, char middleName, String lastName, String dob, String email, 
			String city, String streetAddress, String State, String zipcode, String atTheAddress) {
		inputFirstName(commonActions, firstName);
		inputMiddleName(commonActions, middleName);
		inputLastName(commonActions, lastName);
		dateOfBirth(commonActions, dob);
		emailAddress(commonActions, email);
		city(commonActions, city);
		streetAddress(commonActions, streetAddress);
		pickState(commonActions, State);
		zipCode(commonActions, zipcode);
		livingAtTheAddress(commonActions, atTheAddress);
		continueNext(commonActions);
	}
	
	public void policyHolderDetailsPageSteps(CommonActions commonActions, AutoData autoData) {
		inputFirstName(commonActions, autoData.getFirstName());
		inputMiddleName(commonActions, autoData.getMiddleName());
		inputLastName(commonActions, autoData.getLastName());
		dateOfBirth(commonActions, autoData.getDob());
		emailAddress(commonActions, autoData.getEmail());
		city(commonActions, autoData.getCity());
		streetAddress(commonActions, autoData.getStreetAddress());
		pickState(commonActions, autoData.getState());
		zipCode(commonActions, autoData.getZipCode());
		livingAtTheAddress(commonActions, autoData.getAtTheAddress());
		continueNext(commonActions);
	}

}
