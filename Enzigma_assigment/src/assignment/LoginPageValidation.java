package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageValidation {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\seleniumData\\to\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the URL (Login Page)
        driver.get("https://app-staging.nokodr.com/");
        Thread.sleep(2000); // Wait for the page to load

        // Validate mandatory fields (Username and Password)
        WebElement usernameField = driver.findElement(By.xpath("[name=\"username\"]")); // Replace with actual ID
        WebElement passwordField = driver.findElement(By.xpath("[id=\"id_17365055204977539\"]")); // Replace with actual ID
        WebElement loginButton = driver.findElement(By.id("loginBtn")); // Replace with actual ID
        
        if (usernameField != null && passwordField != null) {
            System.out.println("Mandatory fields (username and password) are present.");
        } else {
            System.out.println("Mandatory fields are missing.");
            driver.quit();
            return;
        }

        // Test valid credentials (Correct username and password)
        usernameField.sendKeys("sayalinagawade@gmail.com");
        passwordField.sendKeys("Sayali@123");
        loginButton.click();
        Thread.sleep(3000); // Wait for login action to complete

        // Verify successful login (Check if redirected to dashboard or success message)
        if (driver.getTitle().contains("Dashboard") || driver.getCurrentUrl().contains("/dashboard")) {
            System.out.println("Login successful with valid credentials.");
        } else {
            System.out.println("Login failed with valid credentials.");
        }

        // Clear the fields for invalid tests
        usernameField.clear();
        passwordField.clear();

        // Test invalid credentials (Incorrect username or password)
        usernameField.sendKeys("Sayaligmail@.co");
        passwordField.sendKeys("@123");
        loginButton.click();
        Thread.sleep(2000); // Wait for the error message to appear

        // Verify error message for invalid credentials
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Error message displayed for invalid credentials.");
        } else {
            System.out.println("Error message not displayed for invalid credentials.");
        }

        // Test blank fields (Empty username and password)
        usernameField.clear();
        passwordField.clear();
        loginButton.click();
        Thread.sleep(2000); // Wait for error message

        // Verify error message for blank fields
        WebElement blankFieldErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter email')]"));
        if (blankFieldErrorMessage.isDisplayed()) {
            System.out.println("Error message displayed for blank fields.");
        } else {
            System.out.println("Error message not displayed for blank fields.");
        }

        // Test special characters in fields (Invalid input format)
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("!@#$%^&*()");
        passwordField.sendKeys("!@#$%^&*()");
        loginButton.click();
        Thread.sleep(2000); // Wait for error message

        // Verify error message for special characters
        WebElement specialCharErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid characters')]"));
        if (specialCharErrorMessage.isDisplayed()) {
            System.out.println("Error message displayed for special characters.");
        } else {
            System.out.println("Error message not displayed for special characters.");
        }

        // Close the browser
        driver.quit();
    }
}
