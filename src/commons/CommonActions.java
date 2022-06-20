package commons;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import reporting.Loggers;
import base.BaseClass;

/*
 * Purpose of common actions class is to reuse all events (Click, SendKeys, GetText) again for all test steps
 */


public class CommonActions {
	
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
	JavascriptExecutor jsExecutor = (JavascriptExecutor)BaseClass.driver;

	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Loggers.log("Element is clicking : " + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace(); // <--same thing as System.out.println():
			Loggers.log("Element is unable to click: " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();  
		}
	}
	
	public String getUrl() {
		String currentUrl = BaseClass.driver.getCurrentUrl();
		//Reporter.log("Element is Cliking : " + element );
		Loggers.log("Current URL is : " + currentUrl );
		return currentUrl;
	}
	
	
	public void sleep(double sec) {
		try {
			Thread.sleep((long) (sec*1000));
		} catch (Exception e) {
			
		}
	}
	
	
	public void click(String element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
			BaseClass.driver.findElement(By.xpath(element)).click();
			Loggers.log("Element is Clicking : " + element + "<br>");
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
			BaseClass.driver.findElement(By.xpath(element)).click();
			Loggers.log("Element is Clicking : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Element is unable to click: " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}
	
	
	public void inputText(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
			Loggers.log(text + " : value passed to element : " + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}		
	


	
	public void inputText(WebElement element, char text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(String.valueOf(text));
			Loggers.log(text +" : value passed to element : " + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log("Element is not found : " + element+"\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}
	
	
	public void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			Loggers.log(value + " : value has been selected from the element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Locator doesn't match for : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}
	
	
	public String getTextRun(WebElement element, String expected) {
		try {
			Loggers.log("Actual value : " + element.getText() + " >>><<< Expected value : " + expected);
			Assert.assertEquals(element.getText(), expected);
			return element.getText();
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log(element + " Element Not Found \n" + e.getLocalizedMessage());
			return element + " : Element Not Found";
		}
	}
	
	
	public void scrollUp() {
		try {
			Loggers.log("Scrolling up to 250 to 0 pixels");
		} catch (JavascriptException e) {
			Loggers.log("Exception while scrolling up");
		}
	}
	
	
	public boolean isSelected(WebElement element) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isSelected();
			if(status) {
				Loggers.log(element +" : is selected" );
			}else {
				Loggers.log(element +" : is Not selected" );
			}
		}catch (TimeoutException e) {
			e.printStackTrace();
			Loggers.log("Element Not Found : " + element+"\n" + e.getMessage() );
			Assert.fail();
		}
		return status;
	}

	
	public String getText(WebElement element) {
		String textString = element.getText();
		Loggers.log(element+" has text : " +textString );
		return textString;
	}
	
	
	public void textVerification(String actual, String expected) {
		Loggers.log("Actual : "+actual+"<<<>>>"+"Expeted : " + expected);
		Assert.assertEquals(actual, expected);
	}
	
	
	public void logEvent(String eventMsg) {
		Loggers.log(eventMsg);
	}
	
	
	public void logEventAndFail(String eventMsg) {
		Loggers.log(eventMsg);
		Assert.fail();
	}
	

	// when another window pops Up and to get control over current windows
	public void getCurrentWindow() { 
		Set<String> window = BaseClass.driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(window);
		int windowsCount = listOfWindows.size();
		Loggers.log("Window Count is : " + windowsCount);
		BaseClass.driver.switchTo().window(listOfWindows.get(windowsCount - 1));
	}
	
	
	// any error accord it take screen shots
	public String getScreenShot() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String suffix = dateFormat.format(date);
		File file = new File("screenShots/error_"+suffix+".png");
		String fileLocation = file.getAbsolutePath();
		TakesScreenshot ss = ((TakesScreenshot) BaseClass.driver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(srcFile, file.getAbsoluteFile());
			Loggers.log("Test Failed & Sceenshot taken in location : " + fileLocation);
		} catch (IOException e) {
			Loggers.log("Error while taking screen shot");
		}
		return fileLocation;
	}
	

}








































/*
to write this in pages class
Public void inputZipCode(CommonsActions commonsActions, String Value) {
System.out.println(BaseClass.driver.getWindowHandles().size());
System.out.println(BaseClass.driver.switchTo().alert());
Baseclass.driver.switchTo().frame(0);
CommonsAction.inputText(enterZipCodeElement, value)

once you run the code (TestNG)
you get error --> NO AlertPresentException: no such alert
and syso --> will give how many window (2)

you could delete those two lines 
System.out.println(BaseClass.driver.getWindowHandles().size()); // is not a window
System.out.println(BaseClass.driver.switchTo().alert()); // is not a alert

if those error message is true than it become iframe

Public void inputZipCode(CommonsActions commonsActions, String Value) {
Baseclass.driver.switchTo().frame(0);
CommonsAction.inputText(enterZipCodeElement, value)


*/
