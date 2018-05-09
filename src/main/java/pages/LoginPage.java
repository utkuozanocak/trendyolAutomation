package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage extends MainPage  {

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

    private LoginPage open() {
//        clearCookies();
        WebDriverRunner.clearBrowserCache();
        Selenide.open("");

        System.out.println("================================");
        System.out.println("Driver: " + getCapabilities().toString());
        System.out.println("================================");
        maximazeBrowser();
        return this;
    }

    @Step("Giriş yap")
    public LoginPage login(String username, String password,String MainOrg,String SubOrg) {
        open();
        TXT_USERNAME_ID.sendKeys(username);
        TXT_PASSWWORD_ID.sendKeys(password);
        SELECT_MAINORG_XPATH.click();
//        Assert.assertEquals(LBL_AFTER_USERPASS_ID.shouldBe(Condition.visible),true);
        SELECT_MAINORG_XPATH.click();
        $(By.xpath(MainOrg)).click();
//        Assert.assertEquals(BTN_SUBORG_ID.shouldBe(Condition.visible),true);
        BTN_SUBORG_ID.click();
//        Assert.assertEquals(SELECT_SUBORG_XPATH.shouldBe(Condition.visible),true);

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
    public LoginPage loginFox(String username, String password) {
        open();
        TXT_USERNAMEFOX.sendKeys(username);
        TXT_PASSWORDFOX.sendKeys(password);
        BTN_LOGIN.click();
        BTN_FOX_INBOX.waitUntil(Condition.visible,10000);
        return this;
    }

    @Step("Fox Giriş Başarılımı Kontrolü Yapılır.")
    public LoginPage isLoginFox(){
        Assert.assertEquals(BTN_FOX_INBOX.isDisplayed(),true,"Inbox Gelmeli");
        return this;
    }

    @Step("\"{username}\" kullanıcısı ile giriş yapmaya çalış. Bakımdan dolayı giriş yapamaz.")
    public LoginPage loginBakim(String username, String password) {
        open();

//        txtUsername.sendKeys(username);
//        txtPassword.sendKeys(password);
//        btnLogin.click();
//        btnUsermenu.waitUntil(Condition.visible, 40000);
        return this;
    }
}