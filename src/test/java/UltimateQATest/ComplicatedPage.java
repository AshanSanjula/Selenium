package UltimateQATest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static UltimateQATest.HomePage.GreenTXT;
import static UltimateQATest.HomePage.ResetTXT;

public class ComplicatedPage {

    @Test
    public void NavigationTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().fullscreen();


            driver.get("https://www.google.com/");


            driver.navigate().to("https://ultimateqa.com/complicated-page");
            Thread.sleep(2000);


            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://ultimateqa.com/complicated-page";

            if (currentUrl.equals(expectedUrl)) {
                System.out.println(GreenTXT + "Test Passed: Navigated to the correct URL." + expectedUrl + ResetTXT);
            } else {
                System.out.println("Test Failed: Incorrect URL. Current URL is: " + currentUrl);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }

    }

}
