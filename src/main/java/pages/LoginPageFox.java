package pages;

import com.codeborne.selenide.*;
import data.TestDataMaya;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageFox extends MainPageFox {

    // Fox Login Elements
    private SelenideElement BTN_LOGIN = $(By.id(GetObject("FOX","BTN_LOGIN","ID","FoxLoginPage","PRP")));
    private SelenideElement TXT_PASSWORDFOX = $(By.xpath(GetObject("FOX","TXT_PASSWORDFOX","XPATH","FoxLoginPage","PRP")));
    private SelenideElement TXT_USERNAMEFOX = $(By.xpath(GetObject("FOX","TXT_USERNAMEFOX","XPATH","FoxLoginPage","PRP")));
    private SelenideElement BTN_FOX_INBOX = $(By.id(GetObject("FOX","BTN_FOX_INBOX","ID","FoxMainPage","PRP")));

    private LoginPageFox open() {
//        clearCookies();
        WebDriverRunner.clearBrowserCache();
        Selenide.open("");
        maximazeBrowser();
        return this;
    }

    private LoginPageFox open(String url) {
//        clearCookies();
        WebDriverRunner.clearBrowserCache();
        Selenide.open(url);
        maximazeBrowser();
        return this;
    }

    @Step("\"{username}\" kullanıcısı ile giriş yap")
    public LoginPageFox loginFox(String username, String password) {
        //Configuration.baseUrl = (System.getProperty("URL") == null) ? TestDataMaya.foxURL : System.getProperty("URL");
        open(TestDataMaya.foxURL);
        TXT_USERNAMEFOX.sendKeys(username);
        TXT_PASSWORDFOX.sendKeys(password);
        BTN_LOGIN.click();
        BTN_FOX_INBOX.waitUntil(Condition.visible,10000);
        return this;
    }
}
