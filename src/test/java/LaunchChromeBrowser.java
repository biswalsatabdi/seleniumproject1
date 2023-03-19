import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LaunchChromeBrowser {
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\seleniumjarandwebdriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			// browser type and chromedrover.exe path as parameters

			String url = "https://nextv3.elemetrik.net/elemetrik-registration/signup/registration";
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://nextv3.elemetrik.net/elemetrik-registration/signup/registration");
			System.out.println(driver.getTitle());
			System.out.println(driver.getPageSource());
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='firstName']"))))
					.sendKeys("Satabdi");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='lastName']"))))
					.sendKeys("Biswal");

			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Satabdi.Biswal@gmail.com");
			driver.findElement(By.xpath("//label[text()='Account Title*']//following-sibling::input"))
					.sendKeys("DemoXYZ.co.in");

			driver.findElement(By.xpath("//input[@name='siteDomain']")).sendKeys("Demo");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(@class,'next_select__indicator')])[1]"))))
			.click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Assessments']"))))
			.click();
			driver.findElement(By.xpath("(//div[contains(@class,'next_select__indicator')])[1]")).click();

			driver.findElement(By.xpath("//span[text()='Next']")).click();

			Thread.sleep(6000);
			Assert.assertEquals(
					driver.findElement(By.xpath("//h3[text()='Verify your Email to Complete Setup']")).getText(),
					"Verify your Email to Complete Setup");
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}