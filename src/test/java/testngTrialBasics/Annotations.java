package testngTrialBasics;

import org.testng.annotations.*;

public class Annotations {

    @BeforeTest
    public void beforetest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("After Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After MEthod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("After class");
    }
    @Test()
    public void test1(){

        System.out.println("test 1 executions");
        System.out.println("---------");

    }
    @Test(groups = {"Smoke"})
    public void test2(){
        System.out.println("---------");
        System.out.println("test 2 executions");
        System.out.println("---------");

    }
    @Test(groups = {"Smoke"})
    public void test3(){
        System.out.println("test3");
    }
}
