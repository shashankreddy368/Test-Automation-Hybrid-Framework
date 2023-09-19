package testCaseBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;	//for logging
	
	public ResourceBundle rb;	// java.utils package

	@Parameters("browserName")
	@BeforeClass(groups= {"Sanity","Master"})
	public void setup(String br) {
		
		logger = LogManager.getLogger(this.getClass());
		
		rb = ResourceBundle.getBundle("config");	// load config.properties file
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		
//		WebDriverManager.chromedriver().setup();	// from selenium 4.6 version this is not required
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.demo.guru99.com/V4/");
		driver.get(rb.getString("baseUrl"));	// Reading url value from config.properties file
	}

	@AfterClass(groups= {"sanity","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	public String captureScreenShot(String testName) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String timeStamp = df.format(date);
		
		
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		
		File source = takesScreenShot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destination;
	}

}
