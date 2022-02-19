package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/disapper.html");
	driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver,10);
    long time = System.currentTimeMillis();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='btn']//b[1]")));
    System.out.println(String.format("The message dissapeared after %d miliseconds", System.currentTimeMillis() - time));
}
}



