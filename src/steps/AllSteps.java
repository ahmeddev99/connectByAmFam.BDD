package steps;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllSteps extends BaseClass {
	
	public AllSteps() {
		initClasses(driver);
	}
	
	@Given("user select auto")
	public void user_select_auto() {
		landingPage.landingpageSteps(commonActions);
	}
	
	@When("user input in zipcode")
	public void user_input_in_zipcode() {
		zipCodePage1.zipCodePage1Steps(commonActions, "07522");
	}
	
	
	@When("user select get a Quote")
	public void user_select_get_a_Quote() {
		getAQuotePage.getAQuotePageSteps(commonActions);
	}
	
	@Then("user will navigate to zipCodePage2 Steps")
	public void user_will_navigate_to_getAQuote_page() {
		commonActions.sleep(4);
		commonActions.getUrl();
	}
	
	@When("user input zipcode page2")
	public void user_input_zipcode_page2() {
		zipCodePage2.zipCodePage2Steps(commonActions, "07457", "A");
	}
	
	@Then("user will navigate policy Holder Details Page")
	public void user_will_navigate_policy_Holder_Details_Page() {
		commonActions.sleep(4);
		commonActions.getUrl();
	}
	
	@When("user input policy details")
	public void user_input_policy_details() {
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, "Pippen", 'Z', "Jordan", "01231982", "youcanemail@gmail.com", "Riverdale", 
				"1 S Corporate Dr", "NJ", "07457", "2003");
	}
	
	@Then("user will navigate vehicle details page")
	public void user_will_navigate_vehicle_detailss_Page() {
		commonActions.sleep(4);
		commonActions.getUrl();
	}
	
	@When("user input vehicle details")
	public void user_input_vehicle_details() {
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, "2021", "TYTA", "CAMRY LE AWD", "SEDAN 4D, V4, 2.5L, 4WD", "002", "3", "3", "2", "3", "1");
	}
	
	
	
	

	
}
