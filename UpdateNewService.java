package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class UpdateNewService extends ServiceNow {
  @Test
  public void updateService() {
	  driver.switchTo().frame("gsft_main");
	  String incidentNo = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("incidient No :"+incidentNo);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		driver.findElement(By.id("incident.urgency")).sendKeys("1 - High");				
		driver.findElement(By.id("incident.state")).sendKeys("In Progress");	
				driver.findElement(By.id("sysverb_update")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo+Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']/option")).getText();
		System.out.println("urgency :"+urgency);  
        if(urgency.contains("High"))
        {
        	System.out.println("urgency is updated :" +urgency);
        }
        String state = driver.findElement(By.xpath("//option[text()='In Progress']")).getText();
        System.out.println("State: "+state);
        if(state.contains("In Progress"))
        {
        	System.out.println("State is updated :"+state);
        }
	  
  }
}
