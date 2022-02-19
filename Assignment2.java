package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
		List<String> nameList = new ArrayList<String>();
		List<String> nameList2 = new ArrayList<String>();

		for (int i = 1; i < listRows.size(); i++) {
			WebElement currentRow1 = listRows.get(i);
			List<WebElement> listColumns1 = currentRow1.findElements(By.tagName("td"));
			String name1 = listColumns1.get(1).getText();
			System.out.println(name1);
			nameList.add(name1);
			Collections.sort(nameList);
		}
		File source = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File destination = new File("./src/main/resources/snap/Img002.jpg");
		FileUtils.copyFile(source, destination);
		System.out.println("NameList1:" + nameList);

		driver.findElement(By.xpath("//th[text()='Name']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File source1 = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File destination1 = new File("./src/main/resources/snap/Img003.jpg");
		FileUtils.copyFile(source1, destination1);
		for (int j = 1; j < listRows.size(); j++) {
			WebElement currentRow1 = listRows.get(j);
			List<WebElement> listColumns2 = currentRow1.findElements(By.tagName("td"));
			String name2 = listColumns2.get(1).getText();
			System.out.println(name2);
			nameList2.add(name2);
			Collections.sort(nameList2);
		}
		System.out.println("NameList2:" + nameList2);
		if (nameList.equals(nameList2)) {
			System.out.println("Both the list are equal");
		} else {
			System.out.println("Both the list are not equal");

		}
	}

}
