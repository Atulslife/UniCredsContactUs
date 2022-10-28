package testngpackge;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UniCredsContactUs {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void contactUsFrom() {
		driver.get("https://unicreds.com/contact-us");
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div")));
		driver.findElement(By.xpath("//html/body/div[4]/div/div/div[1]/button/span[1]")).click();
		driver.findElement(By.id("fullname")).sendKeys("atul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mishraatul65@gmail.com");
		Select s1 = new Select(driver
				.findElement(By.xpath("//*[@id=\'__next\']/div[2]/section/div/div[2]/div[2]/div[2]/div/form/select")));
		s1.selectByValue("91");
		driver.findElement(By.id("phone")).sendKeys("9039817558");
		driver.findElement(By.id("message")).sendKeys("Hello");
		driver.findElement(By.id("contactButton")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
