package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.TestData.passwordOPTIIM;
import static data.TestData.usernameOPTIIM;

public class LoginPage extends MainPage  {

/*
    DBConnection dbConnection = new DBConnection();
    private String LOGIN_PAGE_ID = dbConnection.GetObject("MAYA","LOGIN_PAGE_ID","ID","MayaLoginPage","PRP");
    private String TXT_USERNAME_ID = dbConnection.GetObject("MAYA","TXT_USERNAME_ID","ID","MayaLoginPage","PRP");
    private String TXT_PASSWWORD_ID = dbConnection.GetObject("MAYA","TXT_PASSWWORD_ID","ID","MayaLoginPage","PRP");
    private String SELECT_MAINORG_XPATH = dbConnection.GetObject("MAYA","SELECT_MAINORG_XPATH","XPATH","MayaLoginPage","PRP");
    private String LBL_AFTER_USERPASS_ID = dbConnection.GetObject("MAYA","LBL_AFTER_USERPASS_ID","ID","MayaLoginPage","PRP");
    private String BTN_SUBORG_ID = dbConnection.GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage","PRP");
    private String SELECT_SUBORG_XPATH = dbConnection.GetObject("MAYA","SELECT_SUBORG_XPATH","XPATH","MayaLoginPage","PRP");
    private String BTN_LOGIN_ID = dbConnection.GetObject("MAYA","BTN_LOGIN_ID","ID","MayaLoginPage","PRP");
*/

    private String LOGIN_PAGE_ID = GetObject("MAYA","LOGIN_PAGE_ID","ID","MayaLoginPage","PRP");
    private String TXT_USERNAME_ID = GetObject("MAYA","TXT_USERNAME_ID","ID","MayaLoginPage","PRP");
    private String TXT_PASSWWORD_ID = GetObject("MAYA","TXT_PASSWWORD_ID","ID","MayaLoginPage","PRP");
    private String SELECT_MAINORG_XPATH = GetObject("MAYA","SELECT_MAINORG_XPATH","XPATH","MayaLoginPage","PRP");
    private String LBL_AFTER_USERPASS_ID =GetObject("MAYA","LBL_AFTER_USERPASS_ID","ID","MayaLoginPage","PRP");
    private String BTN_SUBORG_ID = GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage","PRP");
    private String SELECT_SUBORG_XPATH = GetObject("MAYA","SELECT_SUBORG_XPATH","XPATH","MayaLoginPage","PRP");
    private String BTN_LOGIN_ID = GetObject("MAYA","BTN_LOGIN_ID","ID","MayaLoginPage","PRP");


    private SelenideElement txtUsername = $(By.id(TXT_USERNAME_ID));
    private SelenideElement txtPassword = $(By.id(TXT_PASSWWORD_ID));
    private SelenideElement cmbOrganisation = $x(SELECT_MAINORG_XPATH);
    private SelenideElement txtSubOrganisation = $x(SELECT_SUBORG_XPATH);

    private SelenideElement btnSubOrganisation = $(By.id(BTN_SUBORG_ID));



    private SelenideElement btnLogin = $(By.id("eForm:egirisYapButton"));
    //private SelenideElement btnUsermenu = $(By.id("topMenuForm:userMenuButton_button"));
    private SelenideElement btnUsermenu = $("button#topMenuForm\\:userMenuButton_button");



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
    public LoginPage login() {
        open();
        txtUsername.sendKeys(usernameOPTIIM);
        txtPassword.sendKeys(passwordOPTIIM);

        btnLogin.shouldBe(Condition.visible).click();
        btnUsermenu.waitUntil(Condition.visible, 40000);
        return this;
    }

    @Step("\"{username}\" kullanıcısı ile giriş yap")
    public LoginPage login(String username, String password) {
//        System.out.println("LOGIN_PAGE_ID:" + LOGIN_PAGE_ID + " " + TXT_USERNAME_ID + " " + TXT_PASSWWORD_ID + " " + SELECT_MAINORG_XPATH + " " + LBL_AFTER_USERPASS_ID + " " + BTN_SUBORG_ID + " " + SELECT_SUBORG_XPATH + " " + BTN_LOGIN_ID);
        open();

        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        cmbOrganisation.click();

        cmbOrganisation.selectOption("ADANA BACK OFIS");
//        btnLogin.click();
//        btnUsermenu.waitUntil(Condition.visible, 40000);
        return this;
    }

    @Step("\"{username}\" kullanıcısı ile giriş yapmaya çalış. Bakımdan dolayı giriş yapamaz.")
    public LoginPage loginBakim(String username, String password) {
        open();

        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        btnUsermenu.waitUntil(Condition.visible, 40000);
        return this;
    }

    @Step("Login")
    public void login(User user) {
        login(user.getUsername(), user.getPassword());
        if (!user.getBirimAdi().isEmpty() && user.getBirimAdi() != null)
            birimSec(Condition.text(user.getBirimAdi()));
    }
}