package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ComposeEmail;
import pages.DraftsFolder;
import pages.LoginPage;
import utils.InputData;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class MailRuComposeEmailTest {
    public static void main(String[] args) {

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String loginName = InputData.LOGINNAME.getPersonalData();
        String password = InputData.PASSWORD.getPersonalData();
        String emailSubject = Utils.getRandomString(9);
        String emailBody = Utils.getRandomString(50);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        new LoginPage(driver)
                .openPage()
                .login(loginName, password);

        new ComposeEmail(driver).clickCompose()
                .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                .closeEmail();

        DraftsFolder draftsFolder = new DraftsFolder(driver).draftsOpenFolder();
        Assert.assertTrue(draftsFolder.findEmail(emailSubject), "Email is not found in Drafts-folder!");

        driver.quit();
    }
}
