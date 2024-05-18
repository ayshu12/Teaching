package trial;

import org.testng.annotations.Test;

public class TEstTrail {
    @Test(groups = {"Smoke"})
    public void test1(){
        System.out.println("test 1");
    }
    @Test
    public void test2(){
        System.out.println("test 2");
    }
    @Test
    public void test3(){
        System.out.println("test 3");
    }
}
