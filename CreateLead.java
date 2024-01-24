package Module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

public class CreateLead {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;

	PropertyFileUtils putils = new  PropertyFileUtils();
	ExcelUtils	eutils = new ExcelUtils();
	WebDriverUtils wutils = new WebDriverUtils();
	
	//To read data from property file
	String BROWSER = putils.getdatafromProprtyFile("browser");
	String URL = putils.getdatafromProprtyFile("url");
	String USERNAME = putils.getdatafromProprtyFile("username");
	String PASSWORD = putils.getdatafromProprtyFile("password");
	
	//To read data from Excel
	String FIRSTNAME = eutils.getdatafromExcel("Lead", 0, 1);
	String LASTNAME = eutils.getdatafromExcel("Lead", 1, 1);
	String COMPANYNAME = eutils.getdatafromExcel("Lead", 2, 1);
	String GROUP = eutils.getdatafromExcel("Lead", 3, 1);
	
	//To Launch browser 	
			if(BROWSER.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
			}else {
			driver = new FirefoxDriver();	
			System.out.println("Default browser");
			}
			
			
			//Maximize window
			wutils.maximizewindow(driver);
			//To apply implicit wait
			wutils.WaitWebelementToLoad(driver);

			
			//Step5:Load the url
			driver.get(URL);
			
			//Step6:Login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();	
			
			
			
			//Step7:Click on Leads
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			
		//Step8:Click on +(Create Leads..) icon
			driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
			
		//Step9:Enter the First name
			driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
			
		//Step10:Enter the Last name
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
			//Step11:Enter the Company name
			driver.findElement(By.name("company")).sendKeys(COMPANYNAME);
			
		//Step12:Click on Group radio button
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//Step13:Select Support Group in groupdropdown
		WebElement Groupdropdown = driver.findElement(By.name("assigned_group_id"));	
		wutils.handledropdown(Groupdropdown, GROUP);	
		
		//Step14:Click on Save btn
		driver.findElement(By.name("button")).click();	
		
		//Step15:Mouse hover on Administrator icon
				WebElement adminicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutils.mousehover(driver, adminicon);
				
				Thread.sleep(2000);
				
				//Step16:Click on Signout 
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
	
	
	
	
	
	
}
}
