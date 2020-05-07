package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposeEmailDialog;
import pages.DraftsFolderPage;
import pages.LoginPage;
import utils.InputData;
import utils.Utils;

public class EmailInDraftsAfterSentTest extends BaseTest{

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String emailSubject = Utils.getRandomString(9);
        String emailBody = Utils.getRandomString(50);

        @Test
        public void verifyEmailInDrafts(){
        new LoginPage(driver)
                .login(InputData.LOGINNAME.getPersonalData(), InputData.PASSWORD.getPersonalData());

        new ComposeEmailDialog(driver).clickCompose()
                .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                .closeEmail();

        DraftsFolderPage draftsFolder = new DraftsFolderPage(driver).draftsOpenFolder();
        draftsFolder.findEmail(emailSubject);
        draftsFolder.verifyEmails(sendToAddress, emailBody);
        draftsFolder.sendEmail();
        draftsFolder.closeAlertWindow();

        Assert.assertFalse(draftsFolder.draftsOpenFolder().findEmail(emailSubject), "Email is NOT sent!");
    }
}
