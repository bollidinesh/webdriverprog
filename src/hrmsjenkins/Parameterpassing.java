package hrmsjenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterpassing {
public WebDriver  driver;
	@Parameters("browser")
	@BeforeTest
	public void startup(String browser) throws InterruptedException
	{
		if(browser.equalsIgnoreCase("edge"))
		{
	driver=new EdgeDriver();
	System.setProperty("webdriver.edgedriver.driver", "D:\\Edgedrivers\\edgedriver.exe");
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\FirefoxDrivers\\geckodriver.exe");
	}
	}
	@Test(priority=1)
	public void openapp()
	{
	driver.get("http://183.82.103.245/nareshit/login.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Parameters({"username","password"})
	@Test(priority=2)
	public void login(String username, String password) throws InterruptedException
	{
	driver.findElement(By.name("txtUserName")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	System.out.println("login completed");
	Thread.sleep(3000);
	}
	@Parameters({"firstname","lastname"})
	@Test(priority=3)
	public void addemployee(String firstname,String lastname)
	{
	driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//*[@id=\"standardView\"]/div[3]/div[1]/input[1]")).click();
	driver.findElement(By.name("txtEmpFirstName")).sendKeys(firstname);
	driver.findElement(By.name("txtEmpLastName")).sendKeys(lastname);
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
