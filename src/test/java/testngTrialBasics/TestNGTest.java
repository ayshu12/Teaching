package testngTrialBasics;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest {
    @Test(priority =0)
    public void loginPagetest1(){
        System.out.println("Open the login page");
        String actual="ayswarya";
        String expected="ayswarya";
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 1,enabled = true)
    @Parameters({"username","password"})
    public void enterCredentialstest2(String username, String password){
        System.out.println("Enter username and password");
        System.out.println("UserName : "+username);
        System.out.println("Password : "+password);
    }
    @Test(priority = 2,dataProvider = "Login",dataProviderClass =TestNGParam.class)
    public void verifyLogintest3(String user,String pwd){
        System.out.println("Verify if login is successfull");
        System.out.println("user: "+user);
        System.out.println("pwd :"+pwd);
    }

}
