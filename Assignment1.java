package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
		System.out.println("Total no of rows:" + listRows.size());
		WebElement currentRow = listRows.get(2);
		List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
		System.out.println("Total no of columns:" + listColumns.size());
		System.out.println("Progress value of Learn to interact with Elements:" + listColumns.get(1).getText());
		WebElement currentRow2 = listRows.get(4);
		List<WebElement> listColumns1 = currentRow2.findElements(By.tagName("td"));
		listColumns1.get(2).click();
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File destination = new File("./src/main/resources/snap/Img001.jpg");
		FileUtils.copyFile(source, destination);
	}
}
