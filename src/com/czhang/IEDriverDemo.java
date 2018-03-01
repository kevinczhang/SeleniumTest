package com.czhang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.ie.driver",path of executable file
		// "IEDriverServer.exe")
		System.setProperty("webdriver.ie.driver", "D:\\\\Javaworkspace\\\\SeleniumTest\\IEDriverServer.exe");
		// Initialize InternetExplorerDriver Instance.
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.google.com/xhtml");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("ChromeDriver");
			searchBox.submit();
			Thread.sleep(5000); // Let the user actually see something!
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
