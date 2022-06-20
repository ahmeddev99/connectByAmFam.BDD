package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import reporting.Loggers;

public class ReadConfigFile {
	
	private static ReadConfigFile ReadConfigFile;
	private String path = "./configuration/configure.properties";
	
	
	private String url;
	private int pageLoadTime;
	private int implicitlyWaitTime;
	private static String excelPath;
	private static String sheetName;
	private static String titleFilePath;
	
	
	private ReadConfigFile() {
		
	}
	
	// singleton Class
	public static ReadConfigFile getInstance() {
		if (ReadConfigFile == null) {
			ReadConfigFile = new ReadConfigFile();
		}
		ReadConfigFile.loadProperties();
		return ReadConfigFile;
	}
	
	
	private void loadProperties() {
		try {
			FileReader reader = new FileReader(path);
			Properties properties = new Properties();
			properties.load(reader);
			// ^^ top 3 lines are reading the configure.properties file
			url = properties.getProperty("url");
			implicitlyWaitTime = Integer.parseInt(properties.getProperty("implicitlyWaitTime"));
			pageLoadTime = Integer.parseInt(properties.getProperty("pageLoadWait"));
			excelPath = properties.getProperty("excelPath");
			sheetName = properties.getProperty("sheetName");
			titleFilePath = properties.getProperty("titleFilePath");
		} catch (IOException e) {
			Loggers.log("File Not Found \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		} catch(NumberFormatException e) {
			Loggers.log("Number format in properties not correct \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public int getPageLoadTime() {
		return pageLoadTime;
	}

	public int getImplicitlyWaitTime() {
		return implicitlyWaitTime;
	}

	public String getExcelPath() {
		return excelPath;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	
	public String getTitleFilePath() {
		return titleFilePath;
	}

	
}
