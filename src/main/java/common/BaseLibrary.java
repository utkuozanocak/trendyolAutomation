package common;

import com.codeborne.selenide.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.apache.commons.io.FileUtils.deleteDirectory;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

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

    /**
     * Türkçe harfleri inglizce harflere dönüştürüyor
     *
     * @param str
     * @return
     */
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

    /**
     * Waiting to JS and jQuery ready state and object with class "loading" to disappear.
     * Used in DriverInvokeListener beforeFindBy method
     *
     * @param
     */
    private void waitForJS() {
        try {
            new WebDriverWait(WebDriverRunner.getWebDriver(), Configuration.timeout / 1000, 50).
                    until((ExpectedCondition<Boolean>) driver -> {
                        String readyState = executeJavaScript("return document.readyState");
//                        System.out.println("Internal ready state:" + readyState);
//                        return readyState.equals("complete") || readyState.equals("interactive");
                        return !readyState.equals("loading");

                    });
//            System.out.println("Loading: Ok");
        } catch (Exception e) {
            System.out.println("Loading window error: " + e.getMessage());
        }
        /*try {
            Wait().until(ExpectedConditions.and(
                    (ExpectedCondition<Boolean>) driver -> {
                        try {
                            return (Boolean) executeJavaScript("return document.readyState").equals("complete");
                        } catch (Exception e) {
                            return true;
                        }
                    },
                    (ExpectedCondition<Boolean>) driver -> {
                        try {
                            return (Boolean) executeJavaScript("return jQuery.active == 0");
                        } catch (Exception e) {
                            return true;
                        }
                    }
            ));
        } catch (Exception e) {
            System.out.println("WaitForJS error: " + e.getMessage());
        }*/
    }

    private void waitForJSreadyState() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@NotNull WebDriver driver) {
                return executeJavaScript("return document.readyState").equals("complete");
            }
        });
    }

    private void waitForLoadingToDisappear(WebDriver driver) {
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        //Thread.sleep(3000);
        try {

            /*List<WebElement> loading = driver.findElements(By.className("loading"));
            System.out.println("Count:" + loading.size());
            int i = 0;
            for (WebElement e:loading) {
                System.out.println(i + ": innerHtml-" + executeJavaScript("return arguments[0].outerHTML", e));
                System.out.println(i + ": isDisplayed-" + e.isDisplayed() + "   isEnabled-" + e.isEnabled());
            }*/

//            System.out.println("Count:" + driver.findElements(By.className("loading")).size());
            //System.out.println("Count:" + driver.findElements(By.cssSelector("div[style*='display: block;'] .loading")).size());
            new WebDriverWait(driver, 10, 50).
                    until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(
                            By.className("loading"))));
//            System.out.println("Loading: Ok");
        } catch (Exception e) {
//            System.out.println("Loading window error: " + e.getMessage());
        }
//        driver.manage().timeouts().implicitlyWait(Configuration.timeout, TimeUnit.MILLISECONDS);
    }

    private void waitForLoadingToDisappear1(WebDriver driver) {
        try {

            //div[starts-with(@id,"bekleyiniz") and contains(@style, "display")]
            //div[id*='bekleyiniz'][style*='visibility: visible']
            new WebDriverWait(driver, Configuration.timeout / 1000, 50).
                    until(invisibilityOfElementLocated(By.cssSelector("div[id*='bekleyiniz'][style*='visibility: visible']")));

//            new WebDriverWait(driver, Configuration.timeout / 1000, 50).
//                    until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.className("loading"))));
            //      new WebDriverWait(driver, Configuration.timeout / 1000, 50).
            //            until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.className("loading"))));
            //
            //                 new WebDriverWait(driver, Configuration.timeout / 1000, 50).
//                        until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.className("loading"))));

//            System.out.println("Loading: Ok");
        } catch (Exception e) {
//            System.out.println("Loading window error: " + e.getMessage());
        }
    }

    private void setDoNotWaitLoading(boolean doNotWaitLoading) {
        this.doNotWaitLoading = doNotWaitLoading;
    }

    private void waitForLoading(WebDriver driver) throws InterruptedException {
        if (doNotWaitLoading)
            return;
        //waitForJS();
        waitForLoadingToDisappear(driver);
    }
    //</editor-fold>

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
                //System.out.println("Load: isJsFinished error: " + e.getMessage());
            }

            //            boolean isAjaxFinished = (boolean) ((JavascriptExecutor) driver1).
//                    executeScript("return jQuery.active == 0");

            boolean isAjaxFinished = false;
            try {
                isAjaxFinished = (boolean) js.executeScript("var result = true; try { result = (typeof jQuery != 'undefined') ? jQuery.active == 0 : true } catch (e) {}; return result;");
            } catch (Exception e) {
                isAjaxFinished = true;
                //System.out.println("Load: isAjaxFinished error: " + e.getMessage());
            }

            boolean isLoaderHidden = false;
            try {
                isLoaderHidden = (boolean) js.executeScript("return document.querySelectorAll('div[style*='visibility: visible'] img[alt='loading']').length == 0");
//                                                          return document.querySelectorAll('div[id*="bekleyiniz"][style*="visibility: visible"]').length == 0
// executeScript("return $('.loading').is(':visible') == false");
                //   System.out.println("Loading bekleniyor");
            } catch (Exception e) {
                isLoaderHidden = true;
                System.out.println("Load: isLoaderHidden error: " + e.getMessage());
            }

            return isJsFinished && isLoaderHidden && isAjaxFinished;
        });
    }

    public void waitForLoadingJS(WebDriver driver) {
//        long timeout = Configuration.timeout / 1000;
        long timeout = getWaitForLoading();
        waitForLoadingJS(driver, timeout);
    }

    public void waitForLoadingJS() {
//        long timeout = Configuration.timeout / 1000;
        long timeout = getWaitForLoading();
        waitForLoadingJS(WebDriverRunner.getWebDriver(), Configuration.timeout);
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
//                    System.out.println("custom maximize()");
                } catch (NumberFormatException e) {
                    WebDriverRunner.getWebDriver().manage().window().maximize();
//                    System.out.println("manage().window().maximize()");
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

    /**
     * Alan setValue, sendKeys doğru çalışmıyor ise bu metodu kullanılır.
     *
     * @param element
     * @param value
     */
    public void setValueJS(SelenideElement element, String value) {
        sleep(2000);
        executeJavaScript("arguments[0].value = arguments[1]", element, value);
    }

    /**
     * get date from text in format 31.12.2017
     *
     * @param text
     * @return
     */
    public String getDateFromText(String text) {
        String result = "";
        String regex = "[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
            result = matcher.group();

        return result;
    }

    /**
     * get time from text in format 18:59:01
     *
     * @param text
     * @return
     */
    public String getTimeFromText(String text) {
        String result = "";
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
            result = matcher.group();

        return result;
    }

    /**
     * JavaSctipt ile click yapılır
     *
     * @param element
     */
    public void clickJs(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
        waitForLoadingJS(WebDriverRunner.getWebDriver());
    }

    /**
     * JavaSctipt ile click yapılır
     *
     * @param element
     */
    @Step("{stepDescription}")
    public void clickJs(SelenideElement element, String stepDescription) {
        executeJavaScript("arguments[0].click();", element);
    }

    /**
     * JavaSctipt ile click yapılır
     *
     * @param element
     */
    public void clickJs(WebElement element) {
        executeJavaScript("arguments[0].click();", element);
    }

    //Dosya ekler
    public void uploadFile(SelenideElement element, String pathToFile) {
        try {
            element.toWebElement().sendKeys(pathToFile);
            log.info("Dosya yüklemeye başlandı.");
        } catch (Exception e) {
            log.info("Dosya yükleme başarısız. : " + e);
            throw new RuntimeException(e);
        }
    }

    //Random numara üretir.
    public String createRandomNumber(int length) {
        Random r = new Random();
        List<Integer> digits = new ArrayList<>();
        String number = "";

        for (int i = 0; i < length - 1; i++) {
            digits.add(i);
        }

        for (int i = length - 1; i > 0; i--) {
            int randomDigit = r.nextInt(i);
            number += digits.get(randomDigit);
            digits.remove(randomDigit);
        }

        number = "1" + number;

        return number;
    }

    //Random text üretir.
    public String createRandomText(int textSize) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < textSize; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

    //Random text üretir.
    public String createRandomTextWithLineBreaks(int textSize) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int lineBreakEveryChar = 10;
        int i = 0;
        while (sb.length() < textSize) {
            if (i != 0 && i % lineBreakEveryChar == 0)
                sb.append(' ');
            sb.append(chars[random.nextInt(chars.length)]);
            i++;
        }
        return sb.toString();
    }

    //yyyyMMddHHmmss formatına göre sysdate alır.
    public String getSysDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now)); // 2016/11/16 12:08:43

        return dtf.format(now);
    }

    //dd.MM.yyyy HH:mm:ss formatına göre sysdate alır.
    public String getDateTime() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(LocalDateTime.now());
    }

    //dd.MM.yyyy formatına göre sysdate alır.
    public String getSysDateForKis() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now)); // 2016/11/16 12:08:43

        return dtf.format(now);
    }


    //dd.MM.yyyy HH formatına göre sysdate alır.
    public String getSysDateForTarihSaat() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now)); // 2016/11/16 12:08:43

        return dtf.format(now);
    }

    //dd.MM.yyyy formatına göre / koyarak sysdate alır.
    public String getSysDateForKis2() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now)); // 2016/11/16 12:08:43

        return dtf.format(now);
    }

    //Bugün tarihinden sonraki bir yıl sonrayı alır.
    public String getAfterSysYear() {
        String untildate = getSysDateForKis();// can take any date in current
        // format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        return dateFormat.format(cal.getTime());

    }


    //Günün tarihinden sonraki bir tarihi alır.
    public String getAfterSysDate(int i) throws ParseException {
        String untildate = getSysDateForKis();// can take any date in current
        // format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(untildate));
        cal.add(Calendar.DATE, i);
        String convertedDate = dateFormat.format(cal.getTime());
//        System.out.println("Gunun tarihinden 10 gun sonrasi: " + convertedDate);

        return convertedDate;

    }

    // sistem yılını alır
    public String getSysYear() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));

        return dtf.format(now);
    }

    // sistem ayını alır
    public String getSysMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));

        return dtf.format(now);
    }

    //Dosyanın bilgisayara inip inmediğini kontrol eder.
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }

        return flag;
    }

    //Bilgisayara indirilen dosyaları siler.
    public boolean deleteFile(String pathToFile) {
        try {
            File file = new File(pathToFile);

            if (file.delete()) {
//                System.out.println(file.getName() + " dosyasi silindi.");
//                LogPASS(file.getName() + " dosyasi silindi.");
            } else {
//                System.out.println("Dosya silme islemi basarisiz.");
                //logger.error("Error : Dosya silme islemi basarisiz.");
//                LogFAIL("Error : Dosya silme islemi basarisiz. ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Random tc yaratır mernis sorgusundan geçecek şekilde.
    public String createMernisTCKN() {
        Vector<Integer> array = new Vector<>();
        Random randomGenerator = new Random();
        array.add(new Integer(1 + randomGenerator.nextInt(9)));

        for (int i = 1; i < 9; i++) array.add(randomGenerator.nextInt(10));

        int t1 = 0;
        for (int i = 0; i < 9; i += 2) t1 += array.elementAt(i);

        int t2 = 0;
        for (int i = 1; i < 8; i += 2) t2 += array.elementAt(i);

        int x = ((t1 * 7) - t2) % 10;
        array.add(new Integer(x));

        x = 0;
        for (int i = 0; i < 10; i++) x += array.elementAt(i);

        x = x % 10;
        array.add(new Integer(x));

        String res = "";
        for (int i = 0; i < 11; i++) res = res + Integer.toString(array.elementAt(i));

//        System.out.println("Olusturulan TC Kimlik No:" + res);

        return res;
    }

    //Textin ilk harfini büyük yapar.
    public String toUpperCaseFirst(String text) {
        char ilkHarf = Character.toUpperCase(text.charAt(0));
        text = ilkHarf + text.substring(1);
        return text;
    }

    //Texti split edip : 'dan sonrasını alır.
    public String splitString(String str) {
        String[] parts = str.split(": ");// "004: 034556"
        String part1 = parts[0]; // 004

        return parts[1];
    }

    /* columnInput ile gönderilen değer, columnIndex ile belirtilen sütunda
       aratılır. columnInput olan satırın elementini döndürür. columnInput araması tüm sayfalarda yapılır.*/
    protected WebElement findElementOnTableByColumnInputInAllPages(SelenideElement byTable, int columnIndex, String columnInput) {
        SelenideElement next = $(("[class='ui-paginator-next ui-state-default ui-corner-all']"));
        // SelenideElement nextDisable = $(("[class*='ui-state-disabled']"));

        SelenideElement element = null;
        while (element == null) {
            element = findElementOnTableByColumnInput(byTable, columnIndex, columnInput);
            if (element == null) {
                if (next.isDisplayed() == false) {
//                    System.out.println("Element tablodaki hiç bir sayfada bulunamadı.");
                    return null; // Element hiç bir sayfada bulunamazsa null döner.
                }
                next.click();
            }
        }
//        System.out.println("Tabloda element bulundu.");
        return element;
    }

    /*  columnInput ile gönderilen değer, columnIndex ile belirtilen sütunda
       aratılır. columnInput olan satırın elementini döndürür. */
    protected WebElement findElementOnTableByColumnInputO(SelenideElement byTable, int columnIndex, String columnInput) {
        WebElement table = $(byTable).$(By.tagName("tbody"));
        int rowCount = 0;

        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        rowCount = allRows.size();
        WebElement elem = null;
        for (WebElement row : allRows) {
            elem = row.findElements(By.tagName("td")).get(columnIndex - 1);
            if (elem.getText().equals(columnInput)) {
                return elem;
            }
        }
        return null;
    }

    protected SelenideElement findElementOnTableByColumnInput(SelenideElement byTable, int columnIndex, String columnInput) {
        int rowCount = 0;

        ElementsCollection allRows = $(byTable).$(By.tagName("tbody")).$$(By.tagName("tr"));
        rowCount = allRows.size();
        if (rowCount == 0)
            return null;

        SelenideElement elem = null;
        for (SelenideElement row : allRows) {
            elem = row.$$(By.tagName("td")).get(columnIndex - 1).shouldBe(visible);
            if (elem.text().equals(columnInput)) {
                return elem;
            }
        }
        return null;
    }

    public String getNumberFromText(By by) {
        String x = WebDriverRunner.getWebDriver().findElement(by).getText();
        Pattern y = Pattern.compile("\\d+");
        Matcher m = y.matcher(x);
        m.find();
        String number = m.group();
//        System.out.println(number);

        return number;
    }

    public String getNumberFromText(String text) {
        Pattern y = Pattern.compile("\\d+");
        Matcher m = y.matcher(text);
        m.find();
        //        System.out.println("Get number from text: \"" + text + "\" number: " + number);
        return m.group();
    }

    // Store the current window handle
    public String windowHandleBefore() {
        winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        return winHandleBefore;
    }

    // Perform the click operation that opens new window
    // Switch to new window opened
    public void switchToNewWindow() throws InterruptedException {
        Thread.sleep(6000);
        for (String winHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            WebDriverRunner.getWebDriver().switchTo().window(winHandle);
        }
    }

    // Switch to default window
    public void switchToDefaultWindow() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverRunner.getWebDriver().close();
        // driver.switchTo().defaultContent();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    public void closeNewWindow() {
        WebDriverRunner.getWebDriver().close();
    }

    public boolean findElementOnTableAllPages(String form, SelenideElement element) {

        SelenideElement next = $(("[id='" + form + "'] [class='ui-paginator-next ui-state-default ui-corner-all']"));

        boolean status = false;
        while (status == false) {
            status = element.isDisplayed();
            if (status == false) {
                if (next.isDisplayed() == false) {
                    //System.out.println("Element hiç bir sayfada bulunamadı.");
                    return status;
                }
                next.click();
            }
        }
        //System.out.println("Element bulundu.");
        return status;
    }

    //Bilgisayarda uzantısını verdiğiniz klasordeki dosyalardan gönderdiğiniz ismi içinde içeriyorsa o dosyayı siler.
    @Step("Gönderilen klasöreki dosyayı siler. Path : \"{path}\" \n Filename : \"{fileName}\" ")
    public boolean deleteFile(String path, String fileName) throws IOException {

        boolean flag = false;
        File directory = new File(path);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                        flag = true;
                    } else {
                        if (files[i].getName().toString().contains(fileName)) {
                            files[i].delete();
                            //System.out.println("dosya silindi");
                            flag = true;
                        } else
                            System.out.println("Klasörde istenilen isimde dosya bulunamadı.");
                    }
                }
            } else
                System.out.println("Klasör boş.");
        }
        return flag;
    }

    // İşlem penceresi kapatma onay - popup
    @Step("Popup : İşlem penceresi kapatma onayi: \"{secim}\" ")
    public void islemPenceresiKapatmaOnayiPopup(String secim) {

        SelenideElement btnKapat = $(By.id("kapatButton"));
        SelenideElement btnIptal = $(By.id("kapatButton"));
        SelenideElement islemPenceresiKapatmaPopup = $(By.id("closeWindowConfirm"));

        if (islemPenceresiKapatmaPopup.isDisplayed()) {
            switch (secim) {
                case "Kapat":
                    btnKapat.click();
                    break;
                case "İptal":
                    btnIptal.click();
                    break;
            }
        }

    }

    @Step("Silme Onayı: Kaydı silmek istediğinize emin misiniz?: {secim}")
    public void silmeOnayiEvrakSilPopup(String secim) {

        SelenideElement btnEvet = $(By.id("mainPreviewForm:evrakSilEvetButton"));
        SelenideElement btnHayir = $(By.id("mainPreviewForm:evrakSilHayirButton"));

        switch (secim) {
            case "Evet":
                btnEvet.click();
                break;
            case "Hayır":
                btnHayir.click();
                break;
        }
    }

    // İşlem penceresi kapatma onay - popup
    @Step("Popup : İşlem penceresi kaydet: {secim}")
    public void islemPenceresiKaydetPopup(String secim) {

        SelenideElement islemKaydetPopup = $(By.id("saveOnCloseWindowConfirm"));
        SelenideElement btnEvet = $(By.id("kapatKaydetEvetButton"));
        SelenideElement btnHayir = $(By.id("kapatKaydetHayirButton"));
        SelenideElement btnIptal = $(By.id("kapatKaydetIptalButton"));

        switch (secim) {
            case "Evet":
                btnEvet.pressEnter();
                break;
            case "Hayır":
                btnHayir.pressEnter();
                break;
            case "İptal":
                btnIptal.click();
                break;
        }
    }

    //endregion

    @Step("\"{fileName}\" isimli dosya silindi")
    public BaseLibrary deleteSpecificFile(String fileName) {

        File folder = new File("C://users//" + System.getProperty("user.name") + "//Downloads//");
        final File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File dir,
                                  final String name) {
                return name.matches("Rapor_.*\\.");
            }
        });
        for (File file1 : files) {
            if (!file1.delete()) {
                System.err.println("Dosya silinemedi: " + file1.getAbsolutePath());
            }
        }

        return this;
    }

    //Dosyanın bilgisayara inip inmediğini kontrol eder.
    @Step("Gönderilen klaörede verilen dosyayı arama : Path :  \"{downloadPath}\" \n Filename : \"{fileName}\"  ")
    public boolean searchDownloadedFileWithName(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();
        Pattern y = Pattern.compile("[^0-9]");
        String s = null;
        SoftAssert sa = new SoftAssert();

        for (int i = 0; i < dir_contents.length; i++) {
            String file = dir_contents[i].getName().toString();
            s = "";
            Matcher m = y.matcher(file);
            while (m.find()) {
                s = s + m.group();
            }
//            sa.assertEquals(s,fileName,"Klasör "+ dir_contents[i].getName().toString() +"indirilmiştir.");
//            sa.assertNotEquals(s,fileName,"İstenilen dosya indirilmemiştir.");
//            assert s.equals(fileName) : "Klasör "+ dir_contents[i].getName().toString() + "indirilmiştir.";
//            assert s.equalsIgnoreCase(fileName) : "İstenilen dosya indirilmemiştir.";

            if (s.contains(fileName)) {
                //System.out.println("dosya indirilmiştir.");
                Allure.addAttachment(dir_contents[i].getName().toString(), "raporu indirilmiştir");
                flag = true;
                break;
            } else
                Allure.addAttachment("Rapor Sonucu", "İstenilen dosya indirilememiştir.");
        }
        return flag;
    }

    public int getRandomNumber(int startIndex, int endIndex) {
        return (new Random().nextInt((endIndex - startIndex) + 1) + startIndex);
    }

    public String myip() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.get("http://www.whatismyip.com/");
        String myIP = driver.findElement(By.cssSelector("ul[class='list-group text-center'] h3")).getText();
        String[] ipString = myIP.split(":");
        myIP = ipString[1].trim();
        //System.out.println(myIP);
        return myIP;
    }


    public String URL_VALUE;
    public String OBJECT_VALUE;
    private String sEnvironment = "";

    public static String GetUrl(String strapp, String strenv,boolean isUse) {

        Connection connection;
        Statement statement;
        ResultSet rs;
        String[] dataSet = new String[1];
        try {
            connection = new DBConnection().connect();
            statement = connection.createStatement();
            rs = statement.executeQuery("select Url from TBL_App where App='" + strapp + "' and Environment='" + strenv + "' and IsUse='" + isUse + "' ");

            while (rs.next()) {

                dataSet[0] = rs.getNString("Url");
            }
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet[0];
    }



    public String GetObject(String strApp, String strObjectName, String strObjectType, String strPageName) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        try {
            connection = new DBConnection().connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select ObjectValue from TBL_PageObjects tpo " +
                    "join TBL_ObjectTypes tot on tpo.ObjectTypeID=tot.ObjectTypeID " +
                    "join TBL_Pages tp on tp.PageID=tpo.PageID " +
                    "join TBL_App ta on ta.AppID=tpo.AppID " +
                    "where ta.App='" + strApp + "' and ta.Environment='" + ssEnvironment + "' " +
                    "and tpo.ObjectName='" + strObjectName + "' " +
                    "and tot.ObjectType='" + strObjectType + "' and tp.PageName='" + strPageName + "'");

            while (rs.next()) {

                OBJECT_VALUE = rs.getNString("ObjectValue");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return OBJECT_VALUE;
    }

    public String GetObject(String strApp, String strObjectName, String strObjectType, String strPageName, String strEnv) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        try {

            connection = new DBConnection().connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select ObjectValue from TBL_PageObjects tpo " +
                    "join TBL_ObjectTypes tot on tpo.ObjectTypeID=tot.ObjectTypeID " +
                    "join TBL_Pages tp on tp.PageID=tpo.PageID " +
                    "join TBL_App ta on ta.AppID=tpo.AppID " +
                    "where ta.App='" + strApp + "' and ta.Environment='" + strEnv + "' " +
                    "and tpo.ObjectName='" + strObjectName + "' " +
                    "and tot.ObjectType='" + strObjectType + "' and tp.PageName='" + strPageName + "'");

            while (rs.next()) {

                OBJECT_VALUE = rs.getNString("ObjectValue");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return OBJECT_VALUE;
    }


    public static String[] GetTestParameter(String strTestName, String strParameterName) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        String[] dataSet = new String[4];
        try {
            connection = new DBConnection().connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select tp.TestParameterValue from TBL_TestParamMove tpa " +
                    "join TBL_TestParameters tp on tpa.TestParameterID=tp.TestParameterID " +
                    "join TBL_Tests t on t.TestID=tpa.TestID where t.TestName = '" + strTestName + "' and tp.TestParameterName = '" + strParameterName + "'");
            int i = 0;
            while (rs.next()) {
                dataSet[i] = rs.getNString("TestParameterValue");
                i = i + 1;
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public static String[] GetLocationData(String LocationType) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        String[] dataSet = new String[1];
        try {
            connection = new DBConnection().connectPrp();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT top 1 pqlu.LocationId FROM PQuiknetAddress pqa " +
                    "JOIN PQuiknetLocationUnit pqlu (nolock) on pqa.LocationID = pqlu.LocationId " +
                    "JOIN TAddress ta (nolock) on pqlu.ID = ta.PLocationUnitId " +
                    "JOIN PSiteLocation psl (nolock) on pqa.LocationID=psl.LocationId where " +
                    "pqa.LocationInfrastructure = '" + LocationType + "' AND pqlu.LocationId like '00%' " +
                    "AND pqa.StatusDescription = 'AKTIF (Satisa Hazir)' AND " +
                    "pqa.IntegratorCode IS NOT NULL AND pqa.GcRecordId is null and " +
                    "psl.GcRecordId is null and pqlu.ProductInstanceBaseId is null and " +
                    "ta.PLocationUnitId IS NOT NULL AND pqa.EmptorSiteId IS NOT NULL ORDER BY NEWID()");
            while (rs.next()) {
                dataSet[0] = rs.getNString("LocationId");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public static String[] GetLocationDaireData(String LocationType, String LocationId) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        String[] dataSet = new String[1];
        try {
            connection = new DBConnection().connectPrp();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT top 1 pqlu.LocationUnitName FROM PQuiknetAddress pqa " +
                    "JOIN PQuiknetLocationUnit pqlu (nolock) on pqa.LocationID = pqlu.LocationId " +
                    "JOIN TAddress ta (nolock) on pqlu.ID = ta.PLocationUnitId " +
                    "JOIN PSiteLocation psl (nolock) on pqa.LocationID=psl.LocationId where " +
                    "pqa.LocationInfrastructure = '" + LocationType + "' AND " +
                    "pqa.StatusDescription = 'AKTIF (Satisa Hazir)' AND " +
                    "pqa.IntegratorCode IS NOT NULL AND pqa.GcRecordId is null and " +
                    "psl.GcRecordId is null and pqlu.ProductInstanceBaseId is null and " +
                    "ta.PLocationUnitId IS NOT NULL AND pqa.EmptorSiteId IS NOT NULL " +
                    "and pqlu.LocationId = '" + LocationId + "' ORDER BY NEWID()");
            while (rs.next()) {
                dataSet[0] = rs.getNString("LocationUnitName");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public Integer[] FoxSearchFlowNo(String TaskId, String FlowStatus,String... CustomerNo) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        Integer[] dataSet = new Integer[1];
        try {
            connection = new DBConnection().connectFoxPrp();
            statement = connection.createStatement();
                rs = statement.executeQuery("SELECT top 1 w.ID" + " FROM  NFWDTT_WORKFLOWINSTANCE (NOLOCK) w" +
                        " INNER JOIN NFWDFT_WORKFLOWVERSION (NOLOCK) v" +
                        " ON  v.ID = w.WORKFLOWVERSION" + " INNER JOIN NFWDTT_WORKFLOWSEARCHKEY (NOLOCK) s" +
                        " ON  s.WORKFLOWINSTANCE = w.ID" + " AND s.SEARCHKEY = 'MUSTERINOKEY'" +
                        " LEFT JOIN NFWDTV_POOLRECORDS  R ON R.STEP =  " +
                        " (SELECT TOP 1 ID FROM nfwdtt_step WHERE WORKFLOWINSTANCE = W.ID  ORDER BY 1 DESC)" +
                        " LEFT JOIN NFWDTT_WORKFLOWSEARCHKEY s2 (NOLOCK)" + " ON  s2.WORKFLOWINSTANCE = w.ID" +
                        " AND s2.SEARCHKEY = 'TASKIDCODE'" + " WHERE s.[VALUE] = '"+CustomerNo[0]+"' and s2.[VALUE]='" + TaskId + "'" +
                        " and  w.WORKFLOWSTATUS ='" + FlowStatus + "'" + " " +
                        " AND (R.ORGANIZATION='NOVATECH' OR R.ORGANIZATION='FIBERTEKNOLOJI') ORDER BY  v.STARTDATE DESC");
            while (rs.next()) {
                dataSet[0] = rs.getInt("ID");
            }
            if (dataSet[0] == null)
            {
                rs = statement.executeQuery("SELECT top 1 w.ID" + " FROM  NFWDTT_WORKFLOWINSTANCE (NOLOCK) w" +
                        " INNER JOIN NFWDFT_WORKFLOWVERSION (NOLOCK) v" +
                        " ON  v.ID = w.WORKFLOWVERSION" + " INNER JOIN NFWDTT_WORKFLOWSEARCHKEY (NOLOCK) s" +
                        " ON  s.WORKFLOWINSTANCE = w.ID" + " AND s.SEARCHKEY = 'MUSTERINOKEY'" +
                        " LEFT JOIN NFWDTV_POOLRECORDS  R ON R.STEP =  " +
                        " (SELECT TOP 1 ID FROM nfwdtt_step WHERE WORKFLOWINSTANCE = W.ID  ORDER BY 1 DESC)" +
                        " LEFT JOIN NFWDTT_WORKFLOWSEARCHKEY s2 (NOLOCK)" + " ON  s2.WORKFLOWINSTANCE = w.ID" +
                        " AND s2.SEARCHKEY = 'TASKIDCODE'" + " WHERE s.[VALUE] like '2%' and s2.[VALUE]='" + TaskId + "'" +
                        " and  w.WORKFLOWSTATUS ='" + FlowStatus + "'" + " " +
                        " AND (R.ORGANIZATION='NOVATECH' OR R.ORGANIZATION='FIBERTEKNOLOJI') ORDER BY  v.STARTDATE DESC");
                while (rs.next()) {
                    dataSet[0] = rs.getInt("ID");
                }
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public String[] FoxGetUserForChange(String AkisNo) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        String[] dataSet = new String[2];
        try {
            connection = new DBConnection().connectFoxPrp();
            statement = connection.createStatement();

            rs = statement.executeQuery("select top 1 o.NAME,CAST(po.DESCRIPTIONS AS XML).value('(/Descriptions//Descriptions/Description/@Description)[1]', 'nvarchar(max)') as POSITIONNAME from NFWDTT_STEP s" +
                    " JOIN NFWDTT_POOL p ON s.ID=p.STEP" +
                    " JOIN NFWDFT_POSITION po on p.POSITION = po.CODE" +
                    " JOIN NFWDFT_ORGANIZATION o on p.ORGANIZATION=o.CODE" +
                    " JOIN NFWDTV_ACTIVEUSERPOSITION PP ON PP.POSITION = P.POSITION AND PP.ORGANIZATION = P.ORGANIZATION" +
                    " where s.WORKFLOWINSTANCE='" + AkisNo + "' and p.TYPE='I' AND PP.ISACTIVE = 1 and po.DESCRIPTIONS not like '%WebService%' order by STARTTIME desc");

            while (rs.next()) {
                dataSet[0] = rs.getString("NAME");
                dataSet[1] = rs.getString("POSITIONNAME");

            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public String[] GetFoxUserAssignType(String userCode) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        String[] dataSet = new String[1];
        try {
            connection = new DBConnection().connectFoxPrp();
            statement = connection.createStatement();

            rs = statement.executeQuery("select ASSIGNTYPE from nfwdft_user where CODE='" + userCode + "'");

            while (rs.next()) {
                dataSet[0] = rs.getString("ASSIGNTYPE");

            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public void tabloComboBoxSec(ElementsCollection element,String statu,String urun,String secim){

        ElementsCollection tbl = element.filterBy(Condition.matchesText(statu));

        String id = tbl.filterBy(Condition.text(urun)).first().$("button").parent().getAttribute("id");

        By btnTriger = By.cssSelector("*[id='" + id + "'] button");
        String menu = "//*[@id='" + id + "_menu']";
        By liLocator = By.cssSelector("[id='" + id + "_menu'] li");
        By ulLocator = By.cssSelector("[id='" + id + "_menu'] ul");

        if($x(menu).is(Condition.not(Condition.visible)))
            $(btnTriger).click();
        $$(liLocator).filterBy(Condition.text(secim)).first().click();
    }
    public Integer[] getTestId(String testName) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        Integer[] dataSet = new Integer[1];
        try {
            connection = new DBConnection().connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select TestID from TBL_Tests where TestName='" + testName + "'");

            while (rs.next()) {
                dataSet[0] = rs.getInt("TestID");

            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
    public static void insertCustomer (int customerNo,boolean isUsable,int testId,String CreateDateTime,String OrderNumber) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        try {
            connection = new DBConnection().connect();
            statement = connection.createStatement();

            int executeUpdate = statement.executeUpdate("INSERT INTO TBL_Customers (CustomerNo,IsUsable,TestID,CreateDateTime,OrderNumber) VALUES ('"+customerNo+"','"+isUsable+"','"+testId+"','"+CreateDateTime+"','"+OrderNumber+"')");

            if (executeUpdate > 0) {
                System.out.println("Insert Success");
            }
            connection.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    public Integer[] GetCustomer(String TestName,boolean IsUsable) {
        Connection connection;
        Statement statement;
        ResultSet rs;
        Integer[] dataSet = new Integer[1];
        try {
            connection = new DBConnection().connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select top 1 c.CustomerNo from TBL_Tests t" +
                    " join TBL_Customers c on t.TestID=c.TestID where" +
                    " t.TestName='"+ TestName +"' and c.IsUsable='"+IsUsable+"' order by CreateDateTime desc");

            while (rs.next()) {
                dataSet[0] = rs.getInt("CustomerNo");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
}
