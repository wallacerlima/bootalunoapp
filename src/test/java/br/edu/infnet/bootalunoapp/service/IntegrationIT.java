package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegrationIT {

	
	
	@Test
	public void deveriaCadastrarUmNovoAluno() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\veloso\\workspaces\\selenium\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8484/bootaluno");
		driver.findElement(  By.linkText("Cadastrar novo aluno")).click();
		
		driver.findElement( By.id("nome") ).sendKeys("Antonio");
		driver.findElement( By.id("email") ).sendKeys("antonio@gmail.com");
		
		driver.findElement( By.cssSelector(".btn-primary") ).click();
		
		assertTrue( driver.getPageSource().contains("severino@gmail.com")  );
		
		driver.close();
		
		
	}

}
