package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.InputData;


import java.util.concurrent.TimeUnit;

public class MailRuLoginPageTest {

    public static void main(String[] args) {

        String loginName = InputData.LOGINNAME.getPersonalData();
        String password = InputData.PASSWORD.getPersonalData();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assert.assertTrue(new LoginPage(driver)
                .openPage()
                .login(loginName,password)
                .getLoggedUserName().contains(loginName),"Wrong user login name!");

        driver.quit();
    }



}
