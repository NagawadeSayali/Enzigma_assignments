package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPasswordValidation {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\seleniumData\\to\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Open the Forgot Password Page
        driver.get("https://app-staging.nokodr.com/forgot-password"); // Replace with actual forgot password URL
        Thread.sleep(2000); // Wait for the page to load

        // Step 2: Validate the Email Input Field
        WebElement emailField = driver.findElement(By.xpath("//input[@name=\"username\"][1]")); // Replace with actual ID of email field
        if (emailField != null) {
            System.out.println("Email field is present.");
        } else {
            System.out.println("Email field is missing.");
            driver.quit();
            return;
        }

        // Step 3: Test valid email input (Registered Email)
        emailField.sendKeys("nagawadesayali1@gmail.com"); // Replace with a valid email
        WebElement submitButton = driver.findElement(By.id("submitBtn")); // Replace with actual ID of submit button
        submitButton.click();
        Thread.sleep(3000); // Wait for the result

        // Verify success message (e.g., "Reset link sent to your email")
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'Reset link sent to your email')]"));
        if (successMessage.isDisplayed()) {
            System.out.println("Success: Reset link sent to your email.");
        } else {
            System.out.println("Failed: Success message not displayed.");
        }

        // Clear the email field for the next test
        emailField.clear();

        // Step 4: Test invalid email input (Non-registered Email)
        emailField.sendKeys("demo#123.com"); // Replace with an email that is not registered
        submitButton.click();
        Thread.sleep(3000); // Wait for error message

        // Verify error message for non-registered email
        WebElement errorMessageNonRegistered = driver.findElement(By.xpath("//div[contains(text(),'Email not registered')]"));
        if (errorMessageNonRegistered.isDisplayed()) {
            System.out.println("Error: Email not registered.");
        } else {
            System.out.println("Failed: Error message for non-registered email not displayed.");
        }

        // Step 5: Test invalid email format
        emailField.clear();
        emailField.sendKeys("demo#123.com"); // Invalid email format (no '@' symbol)
        submitButton.click();
        Thread.sleep(3000); // Wait for error message

        // Verify error message for invalid email format
        WebElement errorMessageInvalidEmail = driver.findElement(By.xpath("//div[contains(text(),'Invalid email format')]"));
        if (errorMessageInvalidEmail.isDisplayed()) {
            System.out.println("Error: Invalid email format.");
        } else {
            System.out.println("Failed: Error message for invalid email format not displayed.");
        }

        // Step 6: Test blank email field
        emailField.clear();
        submitButton.click(); // Submit with blank email
        Thread.sleep(3000); // Wait for error message

        // Verify error message for blank email
        WebElement errorMessageBlankEmail = driver.findElement(By.xpath("//div[contains(text(),'Email is required')]"));
        if (errorMessageBlankEmail.isDisplayed()) {
            System.out.println("Error: Email is required.");
        } else {
            System.out.println("Failed: Error message for blank email not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}

