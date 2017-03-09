package com.pillartechnology.unexpectedtiger.e2e;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    private static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        removeAllTodos();

    }

    @BeforeClass
    public static void setUpDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/jenniferkron/dev/practice/javascript/node_modules/chromedriver/lib/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8090");
    }

    @Test
    public void todoIsAddedToListAndPersisted() throws InterruptedException {
        addTodoWithContent("test Todo");
        driver.navigate().refresh();
        WebElement todos = driver.findElement(By.id("todos"));
        Assert.assertTrue("testTodo should be added to todos",
                todos.getText().contains("test Todo"));
    }

    @Test
    public void todoIsRemovedFromListAndPersisted() throws InterruptedException {
        addTodoWithContent("test Todo");
        driver.navigate().refresh();
        final WebElement firstTodoRemove = driver.findElements(By.className("remove")).get(0);
        firstTodoRemove.click();

        final List<WebElement> todos = driver.findElements(By.className("todo"));

        Assert.assertEquals(0, todos.size());

    }

    @Test
    public void todoIsRemovedFromListWhenMultipleItemsAdded() throws InterruptedException {
        addTodoWithContent("test Todo1");
        addTodoWithContent("test Todo2");

        final WebElement firstTodoRemoveButton = driver.findElements(By.className("remove")).get(0);
        firstTodoRemoveButton.click();
        final List<WebElement> todos = driver.findElements(By.className("todo"));

        Assert.assertEquals(1, todos.size());
        Assert.assertTrue(todos.get(0).getText().contains("test Todo2"));

    }

    private void addTodoWithContent(String content) {
        WebElement input = driver.findElement(By.id("todoInput"));
        input.sendKeys(content);
        WebElement add = driver.findElement(By.id("add"));
        add.click();
    }

    private void removeAllTodos() {
        final List<WebElement> removeLinks = driver.findElements(By.linkText("remove"));
        for (WebElement remove : removeLinks) {
            remove.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        removeAllTodos();

    }

    @AfterClass
    public static void tearDownDriver() throws Exception {
        driver.close();
        driver.quit();
    }
}
