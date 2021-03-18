package test.sweta;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    public static final String URL_TO_TEST = "https://account.dojo.tech/";
    public static final String PATH_TO_CHROME_DRIVER = "/usr/local/Caskroom/chromedriver/89.0.4389.23/chromedriver";
    public static final String XPATH_TO_USERNAME = "/html/body/app-root/div/div/div[2]/app-login/div[1]/form/mdc-form-field[1]/mdc-text-field/input";
    public static final String XPATH_TO_PASS = "/html/body/app-root/div/div/div[2]/app-login/div[1]/form/mdc-form-field[2]/mdc-text-field/input";
    public static final String XPATH_TO_LOGIN = "/html/body/app-root/div/div/div[2]/app-login/div[1]/form/button";
    WebDriver driver;


    @Given("^Open the Chrome and launch the application$")
    public void open_the_Chrome_and_launch_the_application() throws Throwable
    {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL_TO_TEST);
        System.out.println("Login page of the application is opened.");
    }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable
    {

        WebElement eleUsername = driver.findElement(By.xpath(XPATH_TO_USERNAME));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", eleUsername);
        eleUsername.sendKeys("test@test.com");

        WebElement elePassword = driver.findElement(By.xpath(XPATH_TO_PASS));
        executor.executeScript("arguments[0].click();", elePassword);
        elePassword.sendKeys("password");


        System.out.println("This step enter the Username and Password on the login page.");
    }

    @Then("^Press Login$")
    public void Press_Login() throws Throwable
    {
        WebElement elePassword = driver.findElement(By.xpath(XPATH_TO_LOGIN));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", elePassword);
        System.out.println("This step click on the Reset button.");
    }
}