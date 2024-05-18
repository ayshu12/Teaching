package testngTrialBasics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParam {
//    @Test
// //  @Parameters({"username","password"})
//    public void loginwithCredentials(String username,String password){
//        System.out.println("Username :" +username );
//        System.out.println("Password :" +password);
//    }

    @Test(dataProvider = "Login")
    public void testLoginUsingDataProvider(String user,String password){
        System.out.println(user);
        System.out.println(password);
    }
    @DataProvider(name ="Login")
    public Object[][] getLoginCredentials()
    {
        return new Object[][]{
                {"admin", "admin123"},
                {"admin12", "admin234"}
        };
    }
}
