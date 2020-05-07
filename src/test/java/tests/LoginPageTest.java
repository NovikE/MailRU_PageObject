package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.InputData;

public class LoginPageTest extends BaseTest{

        @Test
        public void loginUser(){
            Assert.assertTrue(new LoginPage(driver)
            .openPage()
            .login(InputData.LOGINNAME.getPersonalData(),InputData.PASSWORD.getPersonalData())
            .getLoggedUserName().contains(InputData.LOGINNAME.getPersonalData()),"Wrong user login name!");
        }

    }

