package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HighlitghtingElement;
import utils.InputData;

public class LoginPage extends AbstractPage{

    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(id = "mailbox:login")
    private WebElement login;

    @FindBy(id = "mailbox:saveauth")
    private  WebElement saveAuthCheckBox;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private  WebElement addPassBtn;

    @FindBy(id = "mailbox:password")
    private  WebElement passwordInput;

    @FindBy(id = "PH_user-email")
    private WebElement userName;

    public LoginPage(WebDriver driver){
        super (driver);
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(login));
    }

    public LoginPage login(String loginName, String password){

        new Actions(driver).sendKeys(login, loginName).build().perform();
       //login.sendKeys(loginName);
        new Actions(driver).click(saveAuthCheckBox).build().perform();
       // saveAuthCheckBox.click();
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("document.getElementById('mailbox:submit').click()");
      //addPassBtn.click();
        passwordInput.sendKeys(password);
        addPassBtn.click();


        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));

        return this;
    }

    public String getLoggedUserName() throws InterruptedException{
        HighlitghtingElement.highlightElement(driver, userName);
        return userName.getText();
    }

}
