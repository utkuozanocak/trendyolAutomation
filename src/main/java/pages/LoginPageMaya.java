package pages;

import com.codeborne.selenide.*;
import data.TestDataMaya;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPageMaya extends MainPageMaya {

    private SelenideElement LOGIN_PAGE_ID = $(By.id(GetObject("MAYA","LOGIN_PAGE_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement TXT_USERNAME_ID = $(By.id(GetObject("MAYA","TXT_USERNAME_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement TXT_PASSWWORD_ID = $(By.id(GetObject("MAYA","TXT_PASSWWORD_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement SELECT_MAINORG_XPATH = $(By.xpath(GetObject("MAYA","SELECT_MAINORG_XPATH","XPATH","MayaLoginPage","PRP")));
    private SelenideElement LBL_AFTER_USERPASS_ID = $(By.id(GetObject("MAYA","LBL_AFTER_USERPASS_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement BTN_SUBORG_ID = $(By.id(GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement BTN_LOGIN_ID = $(By.id(GetObject("MAYA","BTN_LOGIN_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement SELECT_SUBORG_XPATH = $(By.xpath(GetObject("MAYA","SELECT_SUBORG_XPATH","XPATH","MayaLoginPage","PRP")));

    // Fox Login Elements
    private SelenideElement BTN_LOGIN = $(By.id(GetObject("FOX","BTN_LOGIN","ID","FoxLoginPage","PRP")));
    private SelenideElement TXT_PASSWORDFOX = $(By.xpath(GetObject("FOX","TXT_PASSWORDFOX","XPATH","FoxLoginPage","PRP")));
    private SelenideElement TXT_USERNAMEFOX = $(By.xpath(GetObject("FOX","TXT_USERNAMEFOX","XPATH","FoxLoginPage","PRP")));
    private SelenideElement BTN_FOX_INBOX = $(By.id(GetObject("FOX","BTN_FOX_INBOX","ID","FoxMainPage","PRP")));

    private LoginPageMaya open(String url) {
//        clearCookies();
        WebDriverRunner.clearBrowserCache();
        Selenide.open(url);
        maximazeBrowser();
        return this;
    }

    @Step("Giriş yap")
    public LoginPageMaya login(String username, String password, String MainOrg, String SubOrg) {
        open(TestDataMaya.mayaURL);
        TXT_USERNAME_ID.sendKeys(username);
        TXT_PASSWWORD_ID.sendKeys(password);
        SELECT_MAINORG_XPATH.click();
        SELECT_MAINORG_XPATH.click();
        $(By.xpath(MainOrg)).click();
        BTN_SUBORG_ID.click();

        SelenideElement p = $(By.id("loginForm:subDealerDialogId"));
        ElementsCollection tblAltOrganizasyon =$$("tbody[id='loginForm:subDealerTable_data'] tr[data-ri]")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        //Selenide.sleep(5000);
        tblAltOrganizasyon
                .filterBy(Condition.text(SubOrg))
                .first().click();
//        $(By.xpath(SubOrg)).click();
        BTN_LOGIN_ID.click();
        return this;
    }

    @Step("\"{username}\" kullanıcısı ile giriş yap")
    public LoginPageMaya loginFox(String username, String password) {
        open(TestDataMaya.mayaURL);
        TXT_USERNAMEFOX.sendKeys(username);
        TXT_PASSWORDFOX.sendKeys(password);
        BTN_LOGIN.click();
        BTN_FOX_INBOX.waitUntil(Condition.visible,10000);
        return this;
    }
}