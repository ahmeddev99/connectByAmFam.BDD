package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import reporting.Loggers;

public class ReadTxtFile {

	FileReader reader;
	BufferedReader bufferedReader;

	public ReadTxtFile(String filePath) {
		try {
			reader = new FileReader(filePath);
			bufferedReader = new BufferedReader(reader);
		} catch (IOException e) {
			Loggers.log("FileNot Found in location :" + filePath);
		}
	}

	public List<String> getListData() {
		List<String> list = new ArrayList<String>();
		String line = "";
		try {
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			Loggers.log("Cannot read the file");
		}
		return list;
	}
}
