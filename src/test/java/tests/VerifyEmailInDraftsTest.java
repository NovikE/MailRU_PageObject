package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposeEmail;
import pages.DraftsFolder;
import pages.LoginPage;
import utils.InputData;
import utils.Utils;

public class VerifyEmailInDraftsTest extends BaseTest{

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String emailSubject = Utils.getRandomString(9);
        String emailBody = Utils.getRandomString(50);

        @Test
        public void createEmailAsDraft(){
        new LoginPage(driver)
                .openPage()
                .login(InputData.LOGINNAME.getPersonalData(), InputData.PASSWORD.getPersonalData());

        new ComposeEmail(driver).clickCompose()
                .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                .closeEmail();

        DraftsFolder draftsFolder = new DraftsFolder(driver).draftsOpenFolder();
        draftsFolder.findEmail(emailSubject);
        Assert.assertTrue(draftsFolder.verifyEmails(sendToAddress, emailBody), "Wrong email!");
        draftsFolder.sendEmail();
        draftsFolder.closeAlertWindow();

    }
}
