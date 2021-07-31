package br.edu.infnet.bootalunoapp.service;


import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InsertIT {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\veloso\\workspaces\\selenium\\geckodriver.exe");

		driver = new FirefoxDriver();
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void insert() {
		driver.get("http://localhost:8484/bootaluno");
		driver.findElement(By.linkText("Cadastrar novo aluno")).click();
		driver.findElement(By.id("nome")).click();

		driver.findElement(By.id("nome")).sendKeys("godofredo");
		driver.findElement(By.id("email")).sendKeys("godofredo@bol.com");

		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		assertTrue(driver.getPageSource().contains("godofredo"));
		
		
	}
}
