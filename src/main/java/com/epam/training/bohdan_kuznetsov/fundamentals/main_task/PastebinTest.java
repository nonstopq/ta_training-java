package com.epam.training.bohdan_kuznetsov.fundamentals.main_task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        // Define the paste content, expiration, and title
        String code = "Hello from WebDriver";
        String expiration = "10 Minutes";
        String title = "helloweb";

        // Use the Page Object to perform actions
        pastebinPage.enterCode(code);
        pastebinPage.selectExpiration(expiration);
        pastebinPage.enterTitle(title);
        pastebinPage.createNewPaste();

        // Verify the title to ensure the paste was created with the correct title
        assertTrue(driver.getTitle().contains(title), "The paste title does not contain the expected text.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
