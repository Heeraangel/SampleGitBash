package com.ajio.productTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyProductTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.ajio.com/?gclid=EAIaIQobChMIqZ6-uqzS9wIVSwwrCh11NwA4EAAYASAAEgL7z_D_BwE");
		driver.findElement(By.xpath("//a[@title='KIDS']")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000);");
		driver.findElement(By.xpath("//a[@href='/s/starting-at-rs-199-4691-77081']")).click();
		Thread.sleep(2000);
		Set<String> allid=driver.getWindowHandles();
		for(String id:allid)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains("starting"))
			{
				break;
			}
		}
		WebElement sortDropdown=driver.findElement(By.xpath("//div[@class='sort ']/div/select"));
		Select s=new Select(sortDropdown);
		s.selectByValue("prce-desc");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500);");
		driver.findElement(By.xpath("//span[text()='brands']")).click();
		driver.findElement(By.xpath("//label[@for='3pin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='612 League']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='AARIKA GIRLS ETHNIC']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='https://assets.ajio.com/medias/sys_master/root/h68/h43/12259017293854/612_league_white_%26_maroon_shirt_with_printed_vest.jpg']")).click();
		Set<String> all=driver.getWindowHandles();
		for(String id:all)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains("maroonburg"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//span[text()='4-5Y']")).click();
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500);");
		driver.findElement(By.xpath("//div[@class='ic-cart ']")).click();
		//String item=driver.findElement(By.xpath("//span[text()='612 League']")).getText();
		driver.findElement(By.xpath("//div[text()='Delete']")).click();
		driver.findElement(By.xpath("//div[text()='DELETE']")).click();
		driver.quit();
	}
}
