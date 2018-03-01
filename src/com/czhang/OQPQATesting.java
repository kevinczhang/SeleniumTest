package com.czhang;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class OQPQATesting {
	public static void main(String[] args) {
		// Setting webdriver.gecko.driver property
		System.setProperty("webdriver.gecko.driver", "D:\\Javaworkspace\\SeleniumTest\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
		// Instantiating driver object and launching browser
		WebDriver driver = new FirefoxDriver();

		// Set implicit wait of 10 seconds
		// This is required for managing waits in selenium webdriver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(30, TimeUnit.SECONDS)
		        .pollingEvery(200, TimeUnit.MILLISECONDS)
		        .ignoring(NoSuchElementException.class);

		// Launch sampleSiteForSelenium
		driver.get("https://qa-smallbizquote.thehartford.com/app/index.html");
		
		try {
			Thread.sleep(5000);			
			WebElement keyWordWE = driver.findElement(By.name("SearchKeyword"));
			// Finding textbox using id locator and then using send keys to write in it
			fluentWait.until(ExpectedConditions.visibilityOf(keyWordWE));			
			driver.findElement(By.name("SearchKeyword")).sendKeys("Public Speaker");			
			driver.findElement(By.name("SearchKeyword")).click();
			Thread.sleep(3000);
			WebElement dropDownWE = driver.findElement(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']//li[1]"));
			dropDownWE.click();
			
			driver.findElement(By.xpath("//div[@id='options']/label[2]")).click();
			driver.findElement(By.id("businessLocation")).sendKeys("1");
			driver.findElement(By.id("noOfEmployee")).sendKeys("1");
			driver.findElement(By.id("estdYearId")).sendKeys("2001");
			driver.findElement(By.id("businessZIPCode")).sendKeys("12309");
			Thread.sleep(3000);
			driver.findElement(By.id("btnNext")).click();
			Thread.sleep(5000);
			
			// Product Page
			driver.findElement(By.id("propertyProduct")).click();
			driver.findElement(By.id("liabilityProduct")).click();
			driver.findElement(By.id("workersCompProduct")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("propertyProduct")).click();			
			driver.findElement(By.id("liabilityProduct")).click();
			driver.findElement(By.id("workersCompProduct")).click();
			driver.findElement(By.id("btnNext")).click();
			Thread.sleep(5000);
			
			// Operations page
			driver.findElement(By.xpath("//div[@class='btn-group']/label[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("btnNext")).click();
			Thread.sleep(5000);
			
			// Contact Page
			driver.findElement(By.id("regBizNameId")).sendKeys("Chao testing in QA");
			driver.findElement(By.id("bizStrtAddId")).sendKeys("1 Union St");
			driver.findElement(By.id("firstNameId")).sendKeys("Chao");
			driver.findElement(By.id("lastNameId")).sendKeys("Zhang");
			driver.findElement(By.id("phoneId")).sendKeys("5555555555");
			driver.findElement(By.id("emailAddressId")).sendKeys("chao.zhang@thehartford.com");
			driver.findElement(By.id("btnNext")).click();
			Thread.sleep(5000);
			
			// Business Page
			Select legalEntitySelect = new Select(driver.findElement(By.id("legalEntity")));
			legalEntitySelect.selectByVisibleText("Association");
			driver.findElement(By.id("businessDescription")).sendKeys("Test");
			Select workplaceSelect = new Select(driver.findElement(By.id("workplace")));
			workplaceSelect.selectByVisibleText("Home Office");
			driver.findElement(By.xpath("//div[@id='ownRentWorkplace']/label[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("annualSalesId")).sendKeys("50000");
			driver.findElement(By.id("internetSalesId")).sendKeys("5");
			driver.findElement(By.id("btnNext")).click();
			Thread.sleep(5000);
			
			// Coverage Page
			driver.findElement(By.id("numberOfPropertyLossesId")).sendKeys("1");
			driver.findElement(By.id("bppLimitId")).sendKeys("15000");
			driver.findElement(By.id("numberOfLiabilityLossesId")).sendKeys("1");
			driver.findElement(By.xpath("//div[@id='benefitsPlanQuestionId']/label[2]")).click();
			driver.findElement(By.id("principalAvgYearProfExperienceId")).sendKeys("1");
			Thread.sleep(3000);
			driver.findElement(By.id("btnNext")).click();
			Thread.sleep(5000);
			
			// Location Page
			driver.findElement(By.id("yearBuiltId")).sendKeys("2001");
			driver.findElement(By.xpath("//div[@id='woodFramedExteriorWallsOptions']/label[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='masonryVeneerOptionsID']/label[2]")).click();
			driver.findElement(By.id("numberOfStoriesId")).sendKeys("1");
			driver.findElement(By.name("areaOccupiedId")).sendKeys("1");
			Thread.sleep(1000);
			driver.findElement(By.id("btnNextId")).click();
			Thread.sleep(5000);
			
			// Payroll Page
			Select prioIncSelect = new Select(driver.findElement(By.id("priorIncId")));
			prioIncSelect.selectByVisibleText("No Prior Insurance");
			driver.findElement(By.xpath("//div[@id='corpIndicatorId']/label[2]")).click();			
			driver.findElement(By.xpath("//div[@id='nonProfitIndicatorId']/label[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("estimatedAnnualpayrollId")).sendKeys("15000");
			driver.findElement(By.id("question1")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("btnNextId")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Close the browser
		//driver.close();
	}
}
