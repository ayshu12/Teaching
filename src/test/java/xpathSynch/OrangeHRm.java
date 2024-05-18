package xpathSynch;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OrangeHRm {
    WebDriver driver;
    @BeforeTest
    public void initialSetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test
    public void loginPage() throws InterruptedException {
        //1. implicit wait
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        //2. Explicit wait
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement password =wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        password.sendKeys("admin123");

        WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submit.click();

        //1. Basic xpath
        //Fields: username and password
        //input[@name='username']
        //input[@name='password']

        //2.Contains
        //Fields: submit,username,OrangeHRM, Inc
        //button[contains(@type,'submit')]
        //input[contains(@name,'username')]
        //*[contains(@name,'username')]
        //*[contains(text(),'Username')]
        //*[contains(text(),'OrangeHRM, Inc')]

        //3.OR and AND
        //fields: username and password
        //input[@name='username' and @placeholder='Username'] (matches)
        //input[@name='username' and @placeholder='Password'] (no match)

        //4.starts-with
        //fields: usernmae and submit
        //input[starts-with(@name,'user')]
        //label[starts-with(text(),'Username')]
        //button[starts-with(@type,'submit')]

        //5.text()
        //fields = left side -Dashboard,admin,Time at work
        //span[text()='Dashboard']
        //span[text()='Admin']
        //p[text()='Time at Work']

        //6.xpath axes (main topic for interviews)
        //fields: time
        //6.1. preceding
        //span[text()='Time']//preceding::span (result = 3)
        //span[text()='Time']//preceding::span[3]  (result=1)

        //6.2 Following
        //fields - Time
        //span[text()='Time']//following::span (result= 35)
        //span[text()='Time']//following::span[3]

        // 6.3 Ancestor
        //fields -dashboard =>  Employee Distribution by Sub Unit , Performance

        //p[text()='Employee Distribution by Sub Unit']//ancestor::div [result=9]
        //p[text()='Employee Distribution by Sub Unit']//ancestor::div[4] [result=1]

        //span[text()='Performance']//ancestor::div  {result=4}
        //span[text()='Performance']//ancestor::div[1] {result=1}

        //6.3 Descendant
        //table in  admin
        //div[@class="oxd-table-card-cell-checkbox"]//descendant::div
        //nav[@class='oxd-topbar-body-nav']/ul//descendant::li
        //nav[@class='oxd-topbar-body-nav']/ul//ancestor::div(Result =5)

        //6.4 Child
        //fields: navigation bar => jobs sub category
        //nav[@class='oxd-topbar-body-nav']/ul/li//child::li (result=5)
        //nav[@class='oxd-topbar-body-nav']/ul/li//child::li[2] (result=1)

        //6.5 Parent
        //field - parent of navigation bar admin
        //nav[@class='oxd-topbar-body-nav']/ul//parent::div

        //6.6 following--sibling
        //fields: navigation bar  after user management
        //nav[@class='oxd-topbar-body-nav']/ul/li/following-sibling::li
        //fields: left side
        //ul[@class='oxd-main-menu']/li/a//following-sibling::span




    }

}
