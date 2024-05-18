package trial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TRyTest {
    @Test
    public void trytestingtrail(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //webdriver commands
        driver.get("https://trytestingthis.netlify.app/");

        String title = driver.getTitle();
        System.out.println("Title : "+title);
        Assert.assertEquals(title,"Try Testing This");
//
//        String pageSource =driver.getPageSource();
//        System.out.println("Page source: "+pageSource);

        String currentUrl= driver.getCurrentUrl();
        System.out.println("current url: "+currentUrl);

//        driver.close();
        //Locators:
        //4. xpath
        //5. partialLinkText
        //6. Linktext
        //7. cssSelector
        //8. tagname

        //1.id
        WebElement fname=driver.findElement(By.id("fname"));
        fname.click();
        fname.sendKeys("ayswarya");

        //2. class
//       WebElement heading= driver.findElement(By.className("main"));
//       String headingTitle = heading.getText();
//        System.out.println(headingTitle);

        //3. name
       WebElement lname= driver.findElement(By.name("lname"));
       lname.sendKeys("CM");

        //4. Linktext
       WebElement contactLink=driver.findElement(By.linkText("Contact"));
       if (contactLink.isEnabled()){
           contactLink.click();
       }

       //5. partialLinktext
        WebElement homeLink= driver.findElement(By.partialLinkText("Home"));
        homeLink.click();

        //6.tagname
        List<WebElement> tags=driver.findElements(By.tagName("a"));
//       String tagName= tags.getText();
//        System.out.println("tagneme :" +tagName);
        for (WebElement tag:tags){
            System.out.println(tag.getText());
        }

        //7.cssSelector
        WebElement radioMale=driver.findElement(By.cssSelector("body > div.row > div.main > form > fieldset > label:nth-child(14)"));
        radioMale.click();

        //8.xpath
        WebElement radioOther=driver.findElement(By.xpath("//*[@id=\"other\"]"));
        radioOther.click();
    }
    @Test
    public void dropdownTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trytestingthis.netlify.app/");
        //dropdown
        Select select=new Select(driver.findElement(By.id("option")));

        select.selectByIndex(2);
        select.selectByValue("option 3");
        select.selectByVisibleText("Option 1");
        String dropdownValue =select.getFirstSelectedOption().getText();
        System.out.println(dropdownValue);
    }

    @Test
    public void selectMultipleTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trytestingthis.netlify.app/");
        Select select=new Select(driver.findElement(By.id("owc")));
        select.selectByIndex(0);
        select.selectByIndex(2);
//        List<WebElement> options=select.getOptions();
//        for(WebElement e:options){
//            System.out.println(e.getText());
//        }
        List<WebElement> optionSelect=select.getAllSelectedOptions();
        for(WebElement e:optionSelect){
            System.out.println(e.getText());
        }
    }

}
