package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	@Test
	public void init() {
	System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.get("https://techfios.com/billing/?ng=login/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	
	}
	public void screenshotTake() throws IOException, InterruptedException {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		
		TakesScreenshot ts = (TakesScreenshot)driver;//type casting
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/screenshot/" + label + ".png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(4000);
	}	
	
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
