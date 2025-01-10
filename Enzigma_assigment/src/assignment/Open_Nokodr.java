package assignment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

		public class Open_Nokodr {
		    public static void main(String[] args) {
		        // Path to your ChromeDriver executable
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\seleniumData\\to\\chromedriver.exe"); // Replace with your ChromeDriver path

		        // Step 1: Open a browser (Chrome)
		        WebDriver driver = new ChromeDriver();
		        System.out.println("Opening browser...");

		        try {
		            // Step 2: Navigate to the noKodr platform
		            String url = "https://app-staging.nokodr.com/";
		            System.out.println("Navigating to " + url + "...");
		            driver.get(url);
		            // Optionally, wait for the page to load 
		            String pageTitle = driver.getTitle();
		            System.out.println("Page title: " + pageTitle);
		            Thread.sleep(1000);

		            // Keep the browser open for observation
		            System.out.println("Press Enter in the console to close the browser...");
		            System.in.read();

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Step 3: Close the browser
		            driver.quit();
		            System.out.println("Browser closed.");
		        }
		    }
		

	}


