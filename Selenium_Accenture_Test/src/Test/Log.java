package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Log {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
	SimpleDateFormat dateFormatFile = new SimpleDateFormat("'Date'_d-MM-yyyy_'Time'_HH.mm.ss");
	SimpleDateFormat dateFormatFileLog = new SimpleDateFormat("'Date'_d-MM-yyyy");
	Charset charset = Charset.forName("UTF-8");
	File file;
	
	public Log() {
		file = new File("/Users/periclesfeltrin/Desktop/Accenture/Accenture_Academy_Test_Selenium/Log/" + dateFormatFileLog.format(Calendar.getInstance().getTime())  + ".log");
	}
	
	public void setNewLog(String c, String desciption){
		String logMenssage = dateFormat.format(Calendar.getInstance().getTime()) + " - [" + c + "]: " + desciption;
		System.out.println(logMenssage);
		try {

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(logMenssage+"\n");
			bw.close();

		} catch (Exception e) {
			
		}
		
	}

	public void screenshot(WebDriver driver){
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String nameFile = dateFormatFile.format(Calendar.getInstance().getTime());
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("/Users/periclesfeltrin/Desktop/Accenture/Accenture_Academy_Test_Selenium/Log/"+ nameFile +".png"));
			setNewLog("Log.screenshot", "Sucess screenshot");
		} catch (IOException e) {
			setNewLog("Log.screenshot", "Error screenshot");
		}
	
	}
	
}
