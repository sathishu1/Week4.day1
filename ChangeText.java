package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeText {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/TextChange.html");
	driver.manage().window().maximize();
	System.out.println("Before text change"+driver.findElement(By.xpath("//div[@class='todo']//button[1]")).getText());
	WebDriverWait wait=new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='todo']//button[1]"),"Click ME!"));
	System.out.println("After text change:"+driver.findElement(By.xpath("//div[@class='todo']//button[1]")).getText());
	driver.findElement(By.xpath("//div[@class='todo']//button[1]")).click();
	Alert alert =driver.switchTo().alert();
	String altext =  alert.getText();
	alert.accept();
	System.out.println("Text in Alert Box is - "+altext);
}
}








