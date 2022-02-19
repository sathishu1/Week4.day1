package week4.day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Appear {
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/appear.html");
	driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver,10);
    long time = System.currentTimeMillis();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flex']//button)[3]")));
    System.out.println(String.format("The message appeared after %d miliseconds", System.currentTimeMillis() - time));
    System.out.println(driver.findElement(By.xpath("(//div[@class='flex']//button)[3]")).getText());
}
}