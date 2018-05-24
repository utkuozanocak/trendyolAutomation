package pages;

import com.codeborne.selenide.Selenide;
import common.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TestToolPage extends BaseLibrary {

    @Step("Test Tool sayfası açılır.")

    public void testToolAc(String url) throws InterruptedException {
        Selenide.open(url);
    }

    @Step("Test Tool'dan seri numarası sorgulanır.")
    public String GetSerialNumber(String ortam, String depo, String cihaz) throws AWTException {
        String seriNo = null;
        int i = 0;
        $(By.id("ctl00_MainContent_DrpOrtamList")).selectOption(ortam);
        $(By.id("ctl00_MainContent_DrpDepoList")).selectOption(depo);
        $(By.id("ctl00_MainContent_DrpProductList")).selectOption(cihaz);
        $(By.id("ctl00_MainContent_lnkSearch")).click();
        while (!$(By.id("ctl00_MainContent_lblSuccess")).getText().equals("Sorgulama Tamamlandı") && i < 10) {
            sleep(1000);
            i++;
        }
        seriNo = $(By.id("ctl00_MainContent_txtSeriNo")).getValue();
        System.out.println(seriNo);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_W);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_W);
        return seriNo;
    }

    @Step("Test Tool'dan Telefon numarası sorgulanır.")
    public String GetPhoneNumber(String city, String env, String churnType) {
        String phoneNumber = null;
        int i = 0;
        $(By.id("ctl00_MainContent_CityList")).selectOption(city);
        $(By.xpath("//label[text()='" + env + "']//..//input")).click();
        $(By.id("ctl00_MainContent_ChurnList")).selectOption(churnType);
        $(By.id("ctl00_MainContent_lnkErisimNoGetir")).click();
        while (!$(By.id("ctl00_MainContent_lblSuccess")).getText().equals("Sorgulama Tamamlandı") && i < 10) {
            sleep(1000);
            i++;
        }
        phoneNumber = $(By.id("ctl00_MainContent_txtTelno")).getValue();
        System.out.println(phoneNumber);
//        closeNewWindow();
        return phoneNumber;
    }
}
