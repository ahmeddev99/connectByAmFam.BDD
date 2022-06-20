package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;
import dataProvider.AutoData;

public class VehicleDetailsPages {
	
	public VehicleDetailsPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "F_year_0") WebElement vehicleYear;
	@FindBy(id = "F_make_0") WebElement vehicleMake;
	@FindBy(id = "F_model_0") WebElement vehicleModel;
	@FindBy(id = "F_subModel_0") WebElement vehicleTrime;
	@FindBy(id = "F_coverage_0") WebElement vehicleCoverage;
	@FindBy(id = "F_ownerTitle_0") WebElement vehicleTitleHolder;
	@FindBy(id = "F_airbags_0") WebElement vehicleAirBags;
	@FindBy(id = "F_alarm_0") WebElement vehicleAntiTheft;
	@FindBy(id = "F_residentialParking_0") WebElement vehicleParked;
	@FindBy(xpath = "//select[@id='F_usage_0']") WebElement vehiclePrimarilyUsed;
	@FindBy(xpath = "//input[@id='F_anotherVehicle_id_0_1']") WebElement AdditionalVehicles;
	@FindBy(id = "F_continue_0") WebElement detailsPagesContinue;
	
	public void vehicleYear(CommonActions commonActions, String vYear) {
		commonActions.inputText(vehicleYear, vYear);
	}
	public void vehicleMake(CommonActions commonActions, String vMake) {
		commonActions.selectByValue(vehicleMake, vMake);
	}
	public void vehicleModel(CommonActions commonActions, String vModel) {
		commonActions.selectByValue(vehicleModel, vModel);
	}

	public void vehicleTrime(CommonActions commonActions, String vTrim) {
		commonActions.selectByValue(vehicleTrime, vTrim); 
	}
	
//	public void vehicleTrime(CommonActions commonActions, String trim) {
//		if (trim != null && trim.length()>1) {
//			commonActions.selectByValue(vehicleTrime, trim);
//		} 
//	}
	 
	private void vehicleCoverage(CommonActions commonActions, String vCoverage) {
		commonActions.selectByValue(vehicleCoverage, vCoverage);
	}
	private void vehicleTitleHolder(CommonActions commonActions, String titleHolder) {
		commonActions.selectByValue(vehicleTitleHolder, titleHolder);
	}
	private void vehicleAirBags(CommonActions commonActions, String airBag) {
		commonActions.selectByValue(vehicleAirBags, airBag);
	}
	private void vehicleAntiTheft(CommonActions commonActions, String antiTheft) {
		commonActions.selectByValue(vehicleAntiTheft, antiTheft);
	}
	private void vehicleParked(CommonActions commonActions, String parked) {
		commonActions.selectByValue(vehicleParked, parked);
	}
	private void vehiclePrimarilyUsed(CommonActions commonActions, String primarilyUsed) {
		commonActions.selectByValue(vehiclePrimarilyUsed, primarilyUsed);
	}
	private void additionalVehicles(CommonActions commonActions) {
		commonActions.click(AdditionalVehicles);
	}
	private void detailsPagesContinue(CommonActions commonActions) {
		commonActions.click(detailsPagesContinue);
	}
	
	public void vehicleDetailsPagesSteps(CommonActions commonActions, String vYear, String vMake, String vModel, String vTrim, String vCoverage, String titleHolder, 
			String airBag, String antiTheft, String parked, String primarilyUsed) {
		vehicleYear(commonActions, vYear);
		vehicleMake(commonActions, vMake);
		vehicleModel(commonActions, vModel);
		vehicleTrime(commonActions, vTrim);
		vehicleCoverage(commonActions, vCoverage);
		vehicleTitleHolder(commonActions, titleHolder);
		vehicleAirBags(commonActions, airBag);
		vehicleAntiTheft(commonActions, antiTheft);
		vehicleParked(commonActions, parked);
		vehiclePrimarilyUsed(commonActions, primarilyUsed);
		additionalVehicles(commonActions);
		detailsPagesContinue(commonActions);	
	}
	
	public void vehicleDetailsPagesSteps(CommonActions commonActions, AutoData autoData) {
		vehicleYear(commonActions, autoData.getvYear());
		vehicleMake(commonActions, autoData.getvMake());
		vehicleModel(commonActions, autoData.getvModel());
		vehicleTrime(commonActions, autoData.getvTrim());
		vehicleCoverage(commonActions, autoData.getvCoverage());
		vehicleTitleHolder(commonActions, autoData.getTitleHolder());
		vehicleAirBags(commonActions, autoData.getAirBag());
		vehicleAntiTheft(commonActions, autoData.getAntiTheft());
		vehicleParked(commonActions, autoData.getParked());
		vehiclePrimarilyUsed(commonActions, autoData.getPrimarilyUsed());
		additionalVehicles(commonActions);
		detailsPagesContinue(commonActions);	
	}

}
