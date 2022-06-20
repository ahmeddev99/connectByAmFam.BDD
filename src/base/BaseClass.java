package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import commons.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DriverDetailsPage;
import pages.GetAQuotePage;
import pages.LandingPage;
import pages.PolicyHolderDetailsPage;
import pages.VehicleDetailsPages;
import pages.ZipCodePage1;
import pages.ZipCodePage2;
import utils.ReadConfigFile;

public class BaseClass {

	public static WebDriver driver;
	
	protected LandingPage landingPage;
	protected CommonActions commonActions;
	protected ZipCodePage1 zipCodePage1;
	protected GetAQuotePage getAQuotePage;
	protected ZipCodePage2 zipCodePage2;
	protected PolicyHolderDetailsPage policyHolderDetailsPage;
	protected VehicleDetailsPages vehicleDetailsPages;
	protected DriverDetailsPage driverDetailsPage;

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ReadConfigFile.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadConfigFile.getInstance().getPageLoadTime()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigFile.getInstance().getImplicitlyWaitTime()));
	}
	
	public void initClasses(WebDriver driver) {
		commonActions = new CommonActions();
		landingPage = new LandingPage(driver);
		zipCodePage1 = new ZipCodePage1(driver);
		getAQuotePage = new GetAQuotePage(driver);
		zipCodePage2 = new ZipCodePage2(driver);
		policyHolderDetailsPage = new PolicyHolderDetailsPage(driver);
		vehicleDetailsPages = new VehicleDetailsPages(driver);
		driverDetailsPage = new DriverDetailsPage(driver);	
	}
	
	public void closingBrowser() {
		driver.quit();
	}
}
