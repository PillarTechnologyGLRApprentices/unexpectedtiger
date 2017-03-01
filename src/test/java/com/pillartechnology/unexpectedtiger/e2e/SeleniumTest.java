package com.pillartechnology.unexpectedtiger.e2e;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    private static WebDriver driver;


    @BeforeClass
    public static void setUp() throws Exception {
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
    public void todoIsAddedToListAndPersisted() throws InterruptedException {
        WebElement input = driver.findElement(By.id("todoInput"));
        input.sendKeys("test Todo");
        WebElement add = driver.findElement(By.id("add"));
        add.click();
        driver.navigate().refresh();
        WebElement todos = driver.findElement(By.id("todos"));
        Assert.assertTrue("testTodo should be added to todos",
                todos.getText().contains("test Todo"));
    }

    @Test
    public void todoIsRemovedFromListAndPersisted() throws InterruptedException {
        WebElement input = driver.findElement(By.id("todoInput"));
        input.sendKeys("test Todo");
        WebElement add = driver.findElement(By.id("add"));
        add.click();
        driver.navigate().refresh();
        final WebElement firstTodoRemove = driver.findElements(By.className("remove")).get(0);
        firstTodoRemove.click();

        final List<WebElement> todos = driver.findElements(By.className("todo"));

        Assert.assertEquals(0, todos.size());

    }

    @Test
    public void todoIsRemovedFromListWhenMultipleItemsAdded() throws InterruptedException {
        WebElement input = driver.findElement(By.id("todoInput"));
        input.sendKeys("test Todo1");
        WebElement add = driver.findElement(By.id("add"));
        add.click();

        WebElement input2 = driver.findElement(By.id("todoInput"));

        input2.sendKeys("test Todo2");
        WebElement add2 = driver.findElement(By.id("add"));
        add2.click();

        final WebElement firstTodoRemove = driver.findElements(By.className("remove")).get(0);

        firstTodoRemove.click();

        final List<WebElement> todos = driver.findElements(By.className("todo"));

        Assert.assertEquals(1, todos.size());
        Assert.assertTrue(todos.get(0).getText().contains("test Todo2"));

    }

    @AfterClass
    public static void tearDownDriver() throws Exception {
        driver.close();
        driver.quit();
    }

    @After
    public void tearDown() throws Exception {
        final List<WebElement> removeLinks = driver.findElements(By.linkText("remove"));
        for (WebElement remove : removeLinks) {
            remove.click();
        }

    }
}
