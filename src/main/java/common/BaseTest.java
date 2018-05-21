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
import pages.LoginPageFox;
import pages.LoginPageMaya;
import pages.MainPageFox;
import pages.pageComponents.solcrmElements.SolCrmFramework;

import java.nio.charset.Charset;
import java.util.Locale;
//import static data.TestDataMaya.mayaURL;


public class BaseTest extends BaseLibrary {

    //Seconds
    static final int timeout = 20;
    static final int loadingTimeout = 40;

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


        SolCrmFramework.setUp();
        WebDriverRunner.addListener(new DriverEventListener());

        System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver\\chromedriver.exe");

        Configuration.browser="chrome";

        Configuration.driverManagerEnabled = false;
        Configuration.reportsFolder = "test-result/reports";
        Configuration.screenshots = Configuration.remote == null;
        Configuration.savePageSource = false;
        Configuration.collectionsTimeout = timeout * 1000;
        Configuration.holdBrowserOpen = true;
        Configuration.holdBrowserOpen = Configuration.remote== null;
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
//    public void beforeMethod(ITestContext context, Method test) {
//        String testResults = "";
//        String testName = firstNonEmpty(
//                test.getDeclaredAnnotation(org.testng.annotations.Test.class).description(),
//                test.getName())
//                .orElse("Unknown");
//
//        final String desc = test.getDeclaredAnnotation(org.testng.annotations.Test.class).toString();
//        Allure.addAttachment("Annotations", desc);
//        testResults += "\n///////////////////////////////////////////////////////" + "\n";
//        testResults += "\nTotal Tests: " + context.getAllTestMethods().length;
//        testResults += "\nPassed Tests: " + context.getPassedTests().size();
//        testResults += "\nFailed Tests: " + context.getFailedTests().size();
//        testResults += "\nSkipped Tests: " + context.getSkippedTests().size();
//        testResults += "\nLeft Tests: " + Integer.valueOf(context.getAllTestMethods().length - (context.getPassedTests().size() + context.getFailedTests().size() + context.getSkippedTests().size())).toString() + "\n";
//        testResults += "\n///////////////////////////////////////////////////////";
//        testResults += "\nTEST CLASS: " + test.getDeclaringClass().getSimpleName() + "\n";
//        testResults += "\nTEST: " + testName + "\n";
//        testResults += "\nSTATUS: Started: " + "\n";
//        testResults += "\nTEST ANNOTATIONS: " + test.getDeclaredAnnotation(org.testng.annotations.Test.class).toString();
//        testResults += "\n///////////////////////////////////////////////////////";
//        testResults += "\n///////////////////////////////////////////////////////";
//        log.info(testResults);
//
//    }

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

        //Parallelde hatası vermemesi WebDriverRunner.closeWebDriver() eklendi.
        //login da WebDriverRunner.clearBrowserCache(); eklendi
        //Selenide.close();
        //WebDriverRunner.getAndCheckWebDriver().quit();
        log.info(testResults);

        try {
            Selenide.close();
            //WebDriverRunner.getWebDriver().quit();
            //WebDriverRunner.closeWebDriver();
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
    public void loginFox(String username, String password) {
        new LoginPageFox().loginFox(username, password);
    }

    @Step("Login")
    public void loginMaya(String username, String password,String mainOrg,String subOrg) {
        new LoginPageMaya().login(username, password,mainOrg,subOrg);
    }

    @Step("Logout")
    public void logout() {
        new MainPageFox().logout();
    }


}
