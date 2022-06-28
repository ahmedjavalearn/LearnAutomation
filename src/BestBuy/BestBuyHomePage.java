package BestBuy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BestBuyHomePage {

    static WebDriver driver;

    public static void setUp(String browserName, String url) {
//        driver location
        String driverPath = "C:\\Users\\ahmed\\IdeaProjects\\LearnSelenium\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

//        open Chrome Browser
        WebDriver driver = new ChromeDriver();
//        Navigate to eBay.com
        driver.get("https://www.eBay.com/");
        driver.manage().window().maximize();

    }
    @Test
    public static void testSearchBox() throws InterruptedException {

        String driverPath = "C:\\Users\\ahmed\\IdeaProjects\\LearnSelenium\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

//        open Chrome Browser
        WebDriver driver = new ChromeDriver();
//        Navigate to eBay.com
        driver.get("https://www.eBay.com/");
        driver.manage().window().maximize();

//     test case 1/valid product name
//       Enter Keyword in the searchBox
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("LG TV ");

//        click in the search button
        driver.findElement(By.id("gh-btn")).click();


//        Verify the searched product
        String ActualText = driver.findElement(By.className("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1")).getText();

        String expectedText = "lg tv";
        System.out.println("expected text:" + expectedText);
        System.out.println("actual text:" + ActualText);

        if (ActualText.equals(expectedText)) {
            System.out.println("test pass");
        } else {
            System.out.println("test fail");

            Thread.sleep(10000);

            driver.close();
        }
    }

    @Test
    public static void testSearchBoxWithCaracters() throws InterruptedException {
        setUp("chrome","https: //www.eBay.com/");
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));

//        enter random Characters
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("#@&*^%<> hh");

//        click in the search button
        driver.findElement(By.id("gh-btn")).click();

//        Verify the searched results
        String ActualText = driver.findElement(By.className("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[2]")).getText();

        String expectedText = "#@&*^%<> hh";
        System.out.println("expected text:" + expectedText);
        System.out.println("actual text:" + ActualText);

        if (ActualText.equals(expectedText)) {
            System.out.println("test pass");
        } else {
            System.out.println("test fail");

            Thread.sleep(10000);

            driver.close();


            Thread.sleep(10000);

            driver.close();
        }
    }
@Test
    public static void testSearchBoxWithBlankField() throws InterruptedException {

        setUp("chrome","https: //www.eBay.com/");
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));

//        enter random Characters
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(" ");

//        click in the search button
        driver.findElement(By.id("gh-btn")).click();

//        Verify the searched results
        String ActualText = driver.findElement(By.xpath("//*[@id=\"ebay-motors\"]/a/h2")).getText();

        String expectedText = "eBay Motors";
        System.out.println("expected text:" + expectedText);
        System.out.println("actual text:" + ActualText);

        if (ActualText.equals(expectedText)) {
            System.out.println("test pass");
        } else {
            System.out.println("test fail");

            Thread.sleep(10000);

            driver.close();

        }
    }


    @Test
    public static void testSignIn() throws InterruptedException{
        String driverPath = "C:\\Users\\ahmed\\IdeaProjects\\LearnSelenium\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

//        open Chrome Browser
        WebDriver driver = new ChromeDriver();
//        Navigate to eBay.com
        driver.get("https://www.eBay.com/");
        driver.manage().window().maximize();

//        click in the sign-in link
        driver.findElement(By.linkText("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F"));

        driver.findElement(By.linkText("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F")).click();

//        enter email or userName
        driver.findElement(By.id("userid"));

            Thread.sleep(10000);

            driver.close();

    }

}
