package hrmsjenkins;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeleteCompanyLocation {
	WebDriver driver;
	@Test
	public void Tc001()
	{
	//driver=new EdgeDriver();
	//System.setProperty("webdriver.edgedriver.driver", "D:\\Edgeedriver\\edgedriver.exe");
		driver=new FirefoxDriver();
		System.setProperty("webdriver.edgedriver.driver", "D:\\firefox driver\\geckodriver.exe");
	driver.get("http://183.82.103.245/nareshit/login.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("application opened");
	driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
	driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
	driver.findElement(By.name("Submit")).click();
	System.out.println("login completed");
	Actions ac= new Actions(driver);
	ac.moveToElement(driver.findElement(By.linkText("Admin"))).perform();
	ac.moveToElement(driver.findElement(By.linkText("Company Info"))).perform();
	driver.findElement(By.linkText("Locations")).click();
	driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//input[@name='chkLocID[]'][@value='LOC013']")).click();
	driver.findElement(By.xpath("//input[@onclick='returnDelete();']")).click();
	Alert a= driver.switchTo().alert();
	a.accept();
	System.out.println("company location deleted successfully");
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("Logout")).click();
    System.out.println("logout completed");
	driver.close();
	}

}
