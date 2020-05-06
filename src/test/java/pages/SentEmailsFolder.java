package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.InputData;
import utils.Utils;

import java.util.List;

public class SentEmailsFolder extends AbstractPage {

    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(xpath = "//*[@title='Отправленные']")
    private WebElement sentFolderBtn;

    @FindBy(xpath = "//*[@class='ll-sj__normal']")
    private List<WebElement> sentEmails;

    @FindBy(id = "PH_logoutLink")
    private WebElement exitBtn;

    @FindBy(xpath = "//div[contains(@style, 'display: table;')]")
    private WebElement sentTable;

    public SentEmailsFolder openSentEmailsFolder() throws InterruptedException {
        sentFolderBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(sentTable));
        Thread.sleep(2000);
        return this;
    }

    public boolean isEmailSent(String subject){
        return  Utils.equalText(sentEmails, subject);
    }

    public void logout(){exitBtn.click();}

    protected AbstractPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS).
                until(ExpectedConditions.visibilityOf(sentFolderBtn));
        return this;
    }

    public SentEmailsFolder(WebDriver driver){super(driver);}

}
