package hrmsjenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginlogout {
	public WebDriver  driver;
		
@Test
public void Tc001()
{
driver=new EdgeDriver();
System.setProperty("webdriver.edgedriver.driver", "D:\\Edgedrivers\\edgedriver.exe");

driver.get("http://183.82.103.245/nareshit/login.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
driver.findElement(By.name("Submit")).click();
System.out.println("login completed");
	driver.findElement(By.linkText("Logout")).click();

	driver.close();
}
/*public static void main(String[]args) throws InterruptedException
{
	loginlogout obj=new loginlogout();
	obj.startup();
	obj.openapplication();
	obj.login();
	obj.logout();
	obj.closeapplication();
}*/

}
