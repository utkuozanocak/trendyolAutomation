package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import listeners.DriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

import java.nio.charset.Charset;
import java.util.Locale;
public class BaseTest extends BaseLibrary {
    static final int timeout = 5;
    static final int loadingTimeout = 10;
    public Locale turkishLocal;
    @BeforeSuite(alwaysRun = true)
    public void driverSetUp() {
        String sysProperties = "";
        sysProperties += "Setup started";
        sysProperties += "\nfile.encoding: " + String.format("file.encoding: %s", System.getProperty("file.encoding"));
        sysProperties += "\ndefault charset=" + Charset.defaultCharset();
        sysProperties += "\njava.specification.version" + System.getProperty("java.specification.version");
        sysProperties += "\njava.runtime.version" + System.getProperty("java.runtime.version");
        sysProperties += "\nlocale default:" + Locale.getDefault();
        turkishLocal = new Locale("tr", "TR");
        if (!Locale.getDefault().equals(turkishLocal)) Locale.setDefault(turkishLocal);
        sysProperties += "\nlocale: " + Locale.getDefault();
        WebDriverRunner.addListener(new DriverEventListener());
        System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
        Configuration.browser="chrome";
        Configuration.driverManagerEnabled = false;
        Configuration.reportsFolder = "test-result/reports";
        Configuration.screenshots = Configuration.remote == null;
        Configuration.savePageSource = false;
        Configuration.collectionsTimeout = timeout * 1000;
        Configuration.holdBrowserOpen = Configuration.remote==null;
        Configuration.timeout = timeout * 1000;
        Configuration.startMaximized = true;
        Configuration.pollingInterval = 100;
        Configuration.collectionsPollingInterval = 100;
        Configuration.headless = false;
        setWaitForLoading(loadingTimeout);
        sysProperties += "\nremote: " + Configuration.remote;
        sysProperties += "\nbrowser: " + Configuration.browser;
        sysProperties += "\nbrowser.version: " + Configuration.browserVersion;
        sysProperties += "\nurl: " + Configuration.baseUrl;
        log.info(sysProperties);
    }
    @BeforeMethod(alwaysRun = true, enabled = true)
    @AfterMethod(alwaysRun = true, enabled = true)
    public void afterMethod(ITestResult testResult) {
        String testResults = "";
        int SUCCESS = 1;
        int FAILURE = 2;
        int SKIP = 3;
        int SUCCESS_PERCENTAGE_FAILURE = 4;
        int STARTED = 16;
        String result = "unknown";
        switch (testResult.getStatus()) {
            case 1:
                result = "SUCCESS";
                break;
            case 2:
                result = "FAILURE";
                break;
            case 3:
                result = "SKIP";
                break;
            case 4:
                result = "SUCCESS_PERCENTAGE_FAILURE";
                break;
            case 16:
                result = "STARTED";
                break;
        }
        if (testResult.getStatus() == ITestResult.FAILURE)
            takeScreenshot();
        testResults += "///////////////////////////////////////////////////////";
        testResults += "///////////////////////////////////////////////////////";
        testResults += "\nTEST: " + testResult.getMethod().getMethodName() + "\n";
        testResults += "\nSTATUS: " + result + "\n";
        testResults += "\nDESCRIPTION: " + testResult.getMethod().getDescription() + "\n";
        if (testResult.getThrowable() != null) {
            testResults += "\nERROR: " + testResult.getThrowable().getMessage() + "\n";
        }
        //        System.out.println("Test Annotations: " + testResult.getMethod().getMethod().getDeclaredAnnotation(org.testng.annotations.Test.class).toString());
        testResults += "///////////////////////////////////////////////////////";
        testResults += "///////////////////////////////////////////////////////";
        log.info(testResults);
        try {
            Selenide.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        Selenide.close();
        log.info("Browser has been closed.");
    }
    @Step("Test Numarası : {testid} {status} ")
    public void testStatus(String testid, String status) { }
    @Step("{name} : {description}")
    public void step(String name, String description) { }
    @Step("Login")
    public void loginTrendyol(String username, String password) {
        new LoginPage().login(username, password);
    }
}
