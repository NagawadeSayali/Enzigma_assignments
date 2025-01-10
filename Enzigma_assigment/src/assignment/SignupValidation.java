package assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignupValidation {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\seleniumData\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://app.nokodr.com/super/apps/user-profile/v1/index.html#/");
        Thread.sleep(7000);

        // Click on the "Sign up" button
        driver.findElement(By.xpath("//a[text()='Sign up']")).click();

        // Enter the email address
        //driver.findElement(By.xpath("//input[@class=\"slds-input ng-pristine ng-valid ng-touched\"]"))
         driver.findElement(By.id("id_17365061979351619\"]")).sendKeys("nagawadesayali1@gmail.com");
        //driver.findElement(By.xpath("//span[@title='Phone'][1]"))
       // .click();
        Thread.sleep(2000);
       //driver.findElement(By.id("id_17365058966076748\"]")).sendKeys("9637343370");

        // Click on the "Proceed" button
       // driver.findElement(By.xpath("//div[text()=\"Proceed\"]//ancestor::button")).click();
        driver.findElement(By.xpath("//div[text()='Proceed']")).click();

        // Check for the error message
        String errorMessage = driver.findElement(By.xpath("//h1[text()=\"Error\"]")).getText();
        Thread.sleep(2000);
        if (errorMessage.equalsIgnoreCase("Error")) {
            System.out.println("Error Message Appears");
        }

        // Select the checkbox
        driver.findElement(By.xpath("//span[@class=\"slds-checkbox_faux\"]")).click();
        Thread.sleep(2000);

        // Click on the "Proceed" button again
        driver.findElement(By.xpath("//div[text()=\"Proceed\"]//ancestor::button")).click();
        Thread.sleep(2000);

        // Check for the success message
        String successMessage = driver.findElement(By.xpath("//h1[text()=\"Success\"]")).getText();
        if (successMessage.equalsIgnoreCase("Success")) {
            System.out.println("Success Message Appears");
        }

        // Enter the verification code
        Thread.sleep(10000);

        // Click on "Verify Code"
        driver.findElement(By.xpath("//div[@title=\"Verify Code\"]")).click();
        Thread.sleep(2000);

        // Fill out the registration form
        driver.findElement(By.xpath("//input[@id=\"id_17364449985393153\"]")).sendKeys("Ashish");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id=\"id_17364449985421262\"]")).sendKeys("Bhosale");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id=\"id_17364449985459091\"]")).sendKeys("Enter your pwd here");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id=\"id_17364449985459091-confirmpassword\"]"))
                .sendKeys("ENTER YOUR pwd HERE");
        Thread.sleep(2000);

        // Click on the "Register" button
        driver.findElement(By.xpath("//div[text()=\"Register\"]")).click();
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}


