package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public LoginPage(WebDriver driver){super (driver);}


    public LoginPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
               .until(ExpectedConditions.visibilityOf(login));
        return this;
    }

    public LoginPage login(String loginName, String password){

        login.sendKeys(loginName);
        saveAuthCheckBox.click();
        addPassBtn.click();
        passwordInput.sendKeys(password);
        addPassBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));

        return this;
    }

    public String getLoggedUserName(){
        return userName.getText();
    }

}
