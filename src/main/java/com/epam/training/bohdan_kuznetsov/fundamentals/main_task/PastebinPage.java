package com.epam.training.bohdan_kuznetsov.fundamentals.main_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By codeInput = By.id("postform-text");
    private By expirationDropdown = By.id("postform-expiration");
    private By titleInput = By.id("postform-name");
    private By createNewPasteButton = By.xpath("//button[text()='Create New Paste']");

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCode(String code) {
        WebElement codeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(codeInput));
        codeElement.sendKeys(code);
    }
    public void selectExpiration(String expiration) {
        WebElement expirationElement = wait.until(ExpectedConditions.elementToBeClickable(expirationDropdown));
        Select expirationSelect = new Select(expirationElement);
        expirationSelect.selectByVisibleText(expiration);
    }
    public void enterTitle(String title) {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleInput));
        titleElement.sendKeys(title);
    }
    public void createNewPaste() {
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(createNewPasteButton));
        createButton.click();
    }
}
