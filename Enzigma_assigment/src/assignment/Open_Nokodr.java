package assignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_Nokodr {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\seleniumData\\to\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://app-staging.nokodr.com/");
        Thread.sleep(1000); // Adjust the sleep time if needed

        // Get and print the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);

        // Keep the browser open for observation
        System.out.println("Press Enter in the console to close the browser...");
        System.in.read();

        // Close the browser
        driver.quit();
        System.out.println("Browser closed.");
    }
}
