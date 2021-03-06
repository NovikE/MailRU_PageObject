package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.InputData;

import java.io.IOException;

public class LoginPageTest extends BaseTest{

        @Test
        public void loginUser() throws IOException {
            Assert.assertTrue(new LoginPage(driver)
            .login(InputData.LOGINNAME.getPersonalData(),InputData.PASSWORD.getPersonalData())
            .getLoggedUserName().contains(InputData.LOGINNAME.getPersonalData()),"Wrong user login name!");
        }

    }

