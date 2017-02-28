package com.pillartechnology.unexpectedtiger.e2e;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/jenniferkron/dev/practice/javascript/node_modules/chromedriver/lib/chromedriver/chromedriver");
        driver = new ChromeDriver();

        driver.navigate().to("http://localhost:8080");
    }

    @Test
    public void titleIsTodoList() throws InterruptedException {
        Assert.assertTrue("title should start with Todo",
                driver.getTitle().startsWith("Todo List"));
    }

    @Test
    public void todoIsAddedToList() throws InterruptedException {
        WebElement input = driver.findElement(By.id("todoInput"));
        input.sendKeys("test Todo");
        WebElement add = driver.findElement(By.id("add"));
        add.click();
        WebElement todos = driver.findElement(By.id("todos"));
        Assert.assertTrue("testTodo should be added to todos",
                todos.getText().contains("test Todo"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
