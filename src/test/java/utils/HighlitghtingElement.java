package utils;

import org.openqa.selenium.*;

public class HighlitghtingElement {

    public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException
    {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        Thread.sleep(3000);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

}
