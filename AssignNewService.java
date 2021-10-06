package week5.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignNewService extends ServiceNow 
{
@Test
public void assignIncident()
{
	driver.switchTo().frame("gsft_main");
	String incidentNo = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
	System.out.println("incidient No :" + incidentNo);
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	driver.findElement(By.id("lookup.incident.assignment_group")).click();
	Set<String> winHandle = driver.getWindowHandles();
	List<String> winList=new ArrayList<String>(winHandle);
	driver.switchTo().window(winList.get(1));
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("software",Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Software']")).click();
	driver.switchTo().window(winList.get(0));
	driver.switchTo().frame("gsft_main");
	String group = driver.findElement(By.id("sys_display.incident.assignment_group")).getText();
	System.out.println("Assigned to group"+group);
	driver.findElement(By.id("activity-stream-textarea")).sendKeys("Worknotes for the incident- testleaf");
	driver.findElement(By.id("sysverb_update_bottom")).click();
	
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo+Keys.ENTER);
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	String assignGroup =driver.findElement(By.id("sys_display.incident.assignment_group")).getText();
	System.out.println("Assigned to group"+assignGroup);
	if(assignGroup.equals(group))
	{
		System.out.println("Assigngroup is same");
		
	}
	
		
}
}
