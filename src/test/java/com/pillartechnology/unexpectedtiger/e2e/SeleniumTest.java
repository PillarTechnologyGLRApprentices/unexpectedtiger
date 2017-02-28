package com.pillartechnology.unexpectedtiger.e2e;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
        driver.close();
        driver.quit();
    }
}
