package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseHRMClass {
		
		public static Properties prop = new Properties();
		public static WebDriver driver;
		
		public BaseHRMClass()  {
			
			try {
				
			FileInputStream file = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\HRManagement\\src\\test\\java\\enviornmentsetup\\config.properties");
			prop.load(file);
			
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException io) {
				io.printStackTrace();
			}
		}
		public static void initiate() throws InterruptedException {
			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			Thread.sleep(3000);
		}
		public static void screenshots(String Filename) {
			File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file,new File("C:\\Users\\User\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshot\\screenshots" +Filename+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
