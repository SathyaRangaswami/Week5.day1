package week5.day1.assignment;

import org.openqa.selenium.By;

import org.testng.annotations.Test;


public class DuplicateLead extends BaseLead {
	@Test
	public void runDuplicateLead() throws InterruptedException {
	
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("testleaf@gmail.com");
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(5000);
		 //String text = driver.findElement(By.xpath("//div[@class='x-grid3-hd-inner x-grid3-hd-firstName']/following::tr[1]/td[3]/div/a[1]")).getText();
		//driver.findElement(By.xpath("//div[@class='x-grid3-hd-inner x-grid3-hd-firstName']/following::tr[1]/td[3]/div/a[1]")).click();
		 
		 String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
			System.out.println("name: "+text);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
			
	driver.findElement(By.linkText("Duplicate Lead")).click();
	 String duplicate = driver.findElement(By.xpath("//div[text()='Duplicate Lead']")).getText();
	 if(duplicate.equals("Duplicate Lead"))
	 {
		 System.out.println("Duplicate Lead is verified");
	 }
	 else
	 {
		 System.out.println("Title not verified");
	 }
	 driver.findElement(By.className("smallSubmit")).click();
	 String text2 = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();	
	 System.out.println("duplicate name: "+text2);
	 if(text.equals(text2))
	 {
		 System.out.println("the duplicated lead name is same as captured name");
	 }
	 else
	 {
		 System.out.println("Lead name are different");
	 }
	 Thread.sleep(5000);
	 
	}

}
