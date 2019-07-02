package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BaseLibrary extends ElementsContainer {


    protected static final Logger log = Logger.getLogger(BaseLibrary.class.getName());
    protected static String winHandleBefore = null;
    protected static String uploadPath = null;
    protected static String downloadPath = null;
    private static String browserName = null;
    private long waitForLoading = 60;
    private int doWaitLoading = 0;
    private boolean doNotWaitLoading = false;
    //public WebDriverWait wait;

    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    private String ssEnvironment = "";

    public static void killProcess() {

        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("taskkill /f /im " + "chrome.exe");
            rt.exec("taskkill /f /im " + "chromedriver.exe");
            rt.exec("taskkill /f /im " + "conhost.exe");
            rt.exec("taskkill /f /im " + "firefox.exe");
            rt.exec("taskkill /f /im " + "geckodriver.exe");
            rt.exec("taskkill /f /im " + "iexplore.exe");
            rt.exec("taskkill /f /im " + "iedriver.server");
            rt.exec("taskkill /f /im " + "iedriver.server64");
            //rt.exec("taskkill /f /im " + "WerFault");
            //rt.exec("taskkill /f /im " + "AcroRd32");
            //rt.exec("taskkill /f /im " + "Excel");
        } catch (IOException e) {
            System.out.println("Processler Kill Edilememdi!!!");
        }
    }


    public static String clearTurkishChars(String str) {
        String ret = str;
        char[] turkishChars = new char[]{0x131, 0x130, 0xFC, 0xDC, 0xF6, 0xD6, 0x15F, 0x15E, 0xE7, 0xC7, 0x11F, 0x11E};
        char[] englishChars = new char[]{'i', 'I', 'u', 'U', 'o', 'O', 's', 'S', 'c', 'C', 'g', 'G'};
        for (int i = 0; i < turkishChars.length; i++) {
            ret = ret.replaceAll(new String(new char[]{turkishChars[i]}), new String(new char[]{englishChars[i]}));
        }
        return ret;
    }

    //<editor-fold desc="Allure screenshooter">
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        byte[] bytes = new byte[]{};
        try {
            //System.out.println("Screenshot will be taken");
            bytes = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            //System.out.println("Screenshot has been taken");
        } catch (WebDriverException e) {
            log.warning("Take screenshot error:" + e.getMessage());
        }
        return bytes;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        byte[] bytes = new byte[]{};
        try {
            bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            log.warning("Error takeScreenshot:" + e.getMessage());
        }
        return bytes;
    }



    private void waitForLoadingToDisappear(WebDriver driver) {
        try {
            new WebDriverWait(driver, 10, 50).
                    until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(
                            By.className("loading"))));
        } catch (Exception e) {
        }
    }


    private long getWaitForLoading() {
        return waitForLoading;
    }

    public void setWaitForLoading(long seconds) {
        this.waitForLoading = waitForLoading;
    }

    public void waitForLoadingJS(WebDriver driver, long timeoutSec) {
        new WebDriverWait(driver, timeoutSec, 10).until(driver1 ->
        {
            JavascriptExecutor js = (JavascriptExecutor) driver1;
            boolean isJsFinished = false;
            try {
                isJsFinished = (boolean) js.executeScript("return (document.readyState == \"complete\" || document.readyState == \"interactive\")");
            } catch (Exception e) {
                isJsFinished = true;
            }

            boolean isAjaxFinished = false;
            try {
                isAjaxFinished = (boolean) js.executeScript("var result = true; try { result = (typeof jQuery != 'undefined') ? jQuery.active == 0 : true } catch (e) {}; return result;");
            } catch (Exception e) {
                isAjaxFinished = true;
            }

            boolean isLoaderHidden = false;
            try {
                isLoaderHidden = (boolean) js.executeScript("return document.querySelectorAll('div[style*='visibility: visible'] img[alt='loading']').length == 0");
            } catch (Exception e) {
                isLoaderHidden = true;
                System.out.println("Load: isLoaderHidden error: " + e.getMessage());
            }

            return isJsFinished && isLoaderHidden && isAjaxFinished;
        });
    }

    public void waitForLoadingJS(WebDriver driver) {
        long timeout = getWaitForLoading();
        waitForLoadingJS(driver, timeout);
    }



    public void maximazeBrowser() {
        try {
            if (Configuration.browserSize != null) {
                try {
                    String[] size = Configuration.browserSize.split("x");
                    int width = Integer.parseInt(size[0]);
                    int height = Integer.parseInt(size[1]);
                    Dimension browserSize = new Dimension(width, height);
                    WebDriverRunner.getWebDriver().manage().window().setSize(browserSize);
                } catch (NumberFormatException e) {
                    WebDriverRunner.getWebDriver().manage().window().maximize();
                }
            } else {
                try {
                    WebDriverRunner.getWebDriver().manage().window().maximize();
                    System.out.println("manage().window().maximize()");
                } catch (Exception e) {
                    System.out.println("maximize:" + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("maximize:" + e.getMessage());
        }
    }


    @Step("{stepDescription}")
    public void clickJs(SelenideElement element, String stepDescription) {
        executeJavaScript("arguments[0].click();", element);
    }

    /**
     * JavaSctipt ile click yapılır
     *
     * @param
     */
}
