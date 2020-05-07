package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposeEmailDialog;
import pages.DraftsFolderPage;
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
               .login(InputData.LOGINNAME.getPersonalData(), InputData.PASSWORD.getPersonalData());

        new ComposeEmailDialog(driver).clickCompose()
                .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                .closeEmail();

        DraftsFolderPage draftsFolder = new DraftsFolderPage(driver).draftsOpenFolder();
        draftsFolder.findEmail(emailSubject);
        Assert.assertTrue(draftsFolder.verifyEmails(sendToAddress, emailBody), "Wrong email!");
        draftsFolder.sendEmail();
        draftsFolder.closeAlertWindow();

    }
}
