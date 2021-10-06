package week5.day1.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ServiceNow {

  public ChromeDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://dev81850.service-now.com/");
		WebElement frameser = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frameser);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Alliswell@123");
		driver.findElement(By.id("sysverb_login")).click();
        driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
        
        driver.findElement(By.xpath("//div[text()='Incidents']")).click();
			
  }

  @AfterMethod
  public void afterMethod() {
	  driver.switchTo().defaultContent();
	  driver.close();
  }

}
