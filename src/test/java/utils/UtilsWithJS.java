package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class UtilsWithJS {

    public static void highlightElement(WebDriver driver, WebElement element) throws IOException {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        makeScreenshots(driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public static void makeScreenshots(WebDriver driver) throws IOException {
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(screenShotFile, new File("src/test/test-output"));
    }

}
