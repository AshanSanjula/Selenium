package UltimateQATest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class QATest {
    public static final String GreenTXT = "\u001B[32m";
    public static final String ResetTXT = "\u001B[0m";

//    @Test
//    public void TestQA() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().fullscreen();
//        driver.get("https://www.google.com/");
//        driver.navigate().to("https://ultimateqa.com/automation");
//        driver.quit();
//    }

    @Test
    public void NavigationTest() {

        // Set up the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the window
            driver.manage().window().fullscreen();

            // Navigate to the first URL
            driver.get("https://www.google.com/");

            // Navigate to the second URL
            driver.navigate().to("https://ultimateqa.com/automation");
            Thread.sleep(2000);

            // Get the current URL after navigation
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://ultimateqa.com/automation";

            // Check if the current URL matches the expected URL
            if (currentUrl.equals(expectedUrl)) {
                System.out.println(GreenTXT + "Test Passed: Navigated to the correct URL." + expectedUrl + ResetTXT);
            } else {
                System.out.println("Test Failed: Incorrect URL. Current URL is: " + currentUrl);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }

    }

    @Test(dependsOnMethods = "NavigationTest")
    public void TestComplicatedPage() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.navigate().to("https://ultimateqa.com/automation");
            driver.findElement(By.linkText("Big page with many elements")).click();

            Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ultimateqa.com/complicated-page";

        if(currentUrl.equals(expectedUrl)){
            System.out.println(GreenTXT + "Test Passed Navigated to " +ResetTXT + expectedUrl);
        }else{
            System.out.println("Test Failed: Incorrect URL. Current URL is: " + currentUrl);
        }

        }catch(Exception e)
        {
            System.out.println("An error occurred: " +e.getMessage());
        }
        driver.quit();
    }
}



