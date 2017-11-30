package Demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBookingTestMyOwn {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("OneWay")).click();
        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
        Date d=new Date();
        String s=d.toString();
        String[] str=s.split(" ");
        String today=str[2];
        
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.linkText(today)).click();

        //all fields filled in. Now click on search
        driver.findElement(By.id("SearchBtn")).click();
      //verify that result appears for the provided journey search

        //close the browser
        driver.quit();
	}
}
