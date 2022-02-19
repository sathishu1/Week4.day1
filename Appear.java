package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		long time = System.currentTimeMillis();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flex']//button)[3]")));
		System.out
				.println(String.format("The message appeared after %d miliseconds", System.currentTimeMillis() - time));
		System.out.println(driver.findElement(By.xpath("(//div[@class='flex']//button)[3]")).getText());
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File destination = new File("./src/main/resources/snap/Img004.jpg");
		FileUtils.copyFile(source, destination);
	}
}