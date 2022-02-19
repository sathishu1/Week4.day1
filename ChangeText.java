package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeText {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		System.out.println(
				"Before text change" + driver.findElement(By.xpath("//div[@class='todo']//button[1]")).getText());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='todo']//button[1]"),
				"Click ME!"));
		System.out.println(
				"After text change:" + driver.findElement(By.xpath("//div[@class='todo']//button[1]")).getText());
		driver.findElement(By.xpath("//div[@class='todo']//button[1]")).click();
		Alert alert = driver.switchTo().alert();
		String altext = alert.getText();
		alert.accept();
		System.out.println("Text in Alert Box is - " + altext);
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File destination = new File("./src/main/resources/snap/Img005.jpg");
		FileUtils.copyFile(source, destination);
	}
}
