package com.czhang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserLaunchDemo {
	public static void main(String[] args) {
		// Setting webdriver.gecko.driver property
		System.setProperty("webdriver.gecko.driver", "D:\\Javaworkspace\\SeleniumTest\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
		// Instantiating driver object and launching browser
		WebDriver driver = new FirefoxDriver();

		// Using get() method to open a webpage
		driver.get("http://google.com");

		// Initializing webelement searchBox
		WebElement searchBox = driver.findElement(By.name("q"));

		// Writing a text "ArtOfTesting" in the search box
		searchBox.sendKeys("ArtOfTesting");

		// Closing the browser
		driver.quit();

	}
}
