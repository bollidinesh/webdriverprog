package hrmsjenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Addemployee {
	public WebDriver  driver;
	
	@BeforeClass
	public void startup() throws InterruptedException
	{
	driver=new FirefoxDriver();
	System.setProperty("webdriver.edgedriver.driver", "D:\\firefox driver\\geckodriver.exe");
	}
	@Test(priority=1)
	public void openapp()
	{
	driver.get("http://183.82.103.245/nareshit/login.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=2)
	public void login() throws InterruptedException
	{
	driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
	driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
	driver.findElement(By.name("Submit")).click();
	System.out.println("login completed");
	Thread.sleep(3000);
	}
	@Test(priority=3)
	public void addemployee()
	{
	driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//*[@id=\"standardView\"]/div[3]/div[1]/input[1]")).click();
	driver.findElement(By.name("txtEmpFirstName")).sendKeys("hfdtrdyu");
	driver.findElement(By.name("txtEmpLastName")).sendKeys("cgdkjfhsjk");
	driver.findElement(By.id("btnEdit")).click();
	System.out.println("employee addded successfully");
	driver.switchTo().defaultContent();
	}
	@Test(priority=4)
	public void logout()
	{
	driver.findElement(By.linkText("Logout")).click();
	}
	@AfterClass
	public void closeapp()
	{
	driver.close();
	}
}


