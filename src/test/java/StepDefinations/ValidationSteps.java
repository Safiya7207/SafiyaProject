package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ValidationSteps {

	WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Given("Open URL")
	public void open_url() {
		System.out.println("Given URL is opened");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :" + projectPath);

		System.getProperty("webdriver.chrome.drive", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("Enter Username")
	public void enter_username() {
		System.out.println("Entered Username");
		driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
				.sendKeys("Admin");
	}

	@Then("Enter Password")
	public void enter_password() {
		System.out.println("Entered Password");
		driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
				.sendKeys("admin123");
	}

	@And("Click on login")
	public void click_on_login() {
		System.out.println("Clicked on login Button");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("verify the title")
	public void verify_the_title() {
		System.out.println("Verified the title of dashboard page");

		String act_label = "";
		try {
			act_label = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
					.getText();
		} catch (Exception e) {
		}

		String exp_label = "Dashboard";

		if (act_label.equals(exp_label)) {
			System.out.println("test passed");
		} else {
			System.out.println("test failed");
		}
	}
	
	@Then("close browser")
	public void close_browser() {
	  System.out.println("Browser closed");
	  driver.quit();
	}

}
