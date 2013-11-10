/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author Teemu
 */
public class BooklibrarySelenium {
    private String port;
    private WebDriver driver;
    private String baseUrl;
    
    @Before
    public void setUp() throws Exception {
        this.driver = new HtmlUnitDriver();
        this.baseUrl = "http://localhost:8084/WepaHT/";
    }

    @Test
    public void loginPageWorks(){
        driver.get(baseUrl);
        System.out.println(driver.getPageSource());
        assertTrue("löytyi", driver.getPageSource().contains("Log in to use everything"));
        assertTrue("löytyi2", driver.getPageSource().contains("Username"));
    }
    
    @Test
    public void addingNewUserWorks(){
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("Register here!"));
        element.click();
        
        assertEquals(true, driver.getPageSource().contains("Register to book library!"));
        
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        
        username.sendKeys("unama");
        password.sendKeys("pasa");
        
        username.submit();
        
        assertEquals(true, driver.getPageSource().contains("New user registered!"));
       
    }
    @Test
    public void loggedInUserCanAddNewBook(){
        driver.get(baseUrl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        
        // Testaamista varten luotu valmiiksi käyttäjä jonka username ja salasana ovat testi.
        username.sendKeys("testi");
        password.sendKeys("testi");
        
        username.submit();
        
        assertEquals(true, driver.getPageSource().contains("List of the books"));
        assertEquals(true, driver.getPageSource().contains("Add new book"));
        assertEquals(true, driver.getPageSource().contains("Kirjaudu ulos"));
        
        WebElement element = driver.findElement(By.linkText("Add new book"));
        element.click();
        
        WebElement name = driver.findElement(By.name("name"));
        WebElement isbn = driver.findElement(By.name("isbn"));
        WebElement year = driver.findElement(By.name("publishingYear"));
        WebElement authors = driver.findElement(By.name("authors"));
        WebElement publishers = driver.findElement(By.name("publishers"));
        
        name.sendKeys("bane");
        isbn.sendKeys("1024");
        year.sendKeys("1999");
        authors.sendKeys("authors");
        publishers.sendKeys("publishers");
        
        name.submit();
        
        assertEquals(true, driver.getPageSource().contains("New book created!"));
        
    }
}
