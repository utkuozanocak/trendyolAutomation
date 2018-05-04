package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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


    //private String TXT_USERNAME_ID = GetObject("MAYA","TXT_USERNAME_ID","ID","MayaLoginPage","PRP");
    //private String TXT_PASSWWORD_ID = GetObject("MAYA","TXT_PASSWWORD_ID","ID","MayaLoginPage","PRP");
    //private String SELECT_MAINORG_XPATH = GetObject("MAYA","SELECT_MAINORG_XPATH","XPATH","MayaLoginPage","PRP");
    //private String LBL_AFTER_USERPASS_ID =GetObject("MAYA","LBL_AFTER_USERPASS_ID","ID","MayaLoginPage","PRP");
    //private String BTN_SUBORG_ID = GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage","PRP");
    //private String SELECT_SUBORG_XPATH = GetObject("MAYA","SELECT_SUBORG_XPATH","XPATH","MayaLoginPage");
    //private String BTN_LOGIN_ID = GetObject("MAYA","BTN_LOGIN_ID","ID","MayaLoginPage","PRP");


//    private SelenideElement txtUsername = $(By.id(TXT_USERNAME_ID));
//    private SelenideElement txtPassword = $(By.id(TXT_PASSWWORD_ID));
//    private SelenideElement cmbOrganisation = $(By.id("loginForm:i3_input"));
    //private SelenideElement txtSubOrganisation = $x(SELECT_SUBORG_XPATH);
   // private SelenideElement btnSubOrganisatioid(n = $(By.BTN_SUBORG_ID));


//    private SelenideElement BTN_SUBORG_XPATH = $(By.xpath(GetObject("MAYA","BTN_SUBORG_XPATH","XPATH","MayaLoginPage","PRP")));
//    private SelenideElement BTN_LOGIN_ID = $(By.id(GetObject("MAYA","BTN_LOGIN_ID","ID","MayaLoginPage","PRP")));
   // private String BTN_SUBORG_ID = GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage");
//    private String SELECT_SUBORG_XPATH = GetObject("MAYA","SELECT_SUBORG_XPATH","XPATH","MayaLoginPage", "PRP");
//
//    private SelenideElement btnLogin = $(By.id("eForm:egirisYapButton"));
    //private SelenideElement btnUsermenu = $(By.id("topMenuForm:userMenuButton_button"));
//    private SelenideElement btnUsermenu = $("button#topMenuForm\\:userMenuButton_button");
//    private SelenideElement formAltOrganizasyon = $x("//*[@id='loginForm:subDealerDialogId_title']");
//    private SelenideElement btnKod1 = $(By.xpath("//span[text()='00001.00001']"));
//    private SelenideElement BTN_SUBORG_ID = $(By.id(GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage", "PRP")));
//    private SelenideElement btnKod2 = $(By.xpath("//*[@id='loginForm:subDealerTable_data']/tr[1]"));



    private SelenideElement LOGIN_PAGE_ID = $(By.id(GetObject("MAYA","LOGIN_PAGE_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement TXT_USERNAME_ID = $(By.id(GetObject("MAYA","TXT_USERNAME_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement TXT_PASSWWORD_ID = $(By.id(GetObject("MAYA","TXT_PASSWWORD_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement SELECT_MAINORG_XPATH = $(By.xpath(GetObject("MAYA","SELECT_MAINORG_XPATH","XPATH","MayaLoginPage","PRP")));
    private SelenideElement LBL_AFTER_USERPASS_ID = $(By.id(GetObject("MAYA","LBL_AFTER_USERPASS_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement BTN_SUBORG_ID = $(By.id(GetObject("MAYA","BTN_SUBORG_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement BTN_LOGIN_ID = $(By.id(GetObject("MAYA","BTN_LOGIN_ID","ID","MayaLoginPage","PRP")));
    private SelenideElement SELECT_SUBORG_XPATH = $(By.xpath(GetObject("MAYA","SELECT_SUBORG_XPATH","XPATH","MayaLoginPage","PRP")));



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
        TXT_USERNAME_ID.sendKeys(GetTestParameter("MayaLoginTest","Username")[0]);
        TXT_PASSWWORD_ID.sendKeys(GetTestParameter("MayaLoginTest","Password")[0]);
        SELECT_MAINORG_XPATH.click();
        Assert.assertEquals(LBL_AFTER_USERPASS_ID.shouldBe(Condition.visible),true);
        SELECT_MAINORG_XPATH.click();
        $(By.xpath(GetTestParameter("MayaLoginTest","MainOrg")[0])).click();
        Assert.assertEquals(BTN_SUBORG_ID.shouldBe(Condition.visible),true);
        BTN_SUBORG_ID.click();
        Assert.assertEquals(SELECT_SUBORG_XPATH.shouldBe(Condition.visible),true);
        $(By.xpath(GetTestParameter("MayaLoginTest","SubOrg")[0])).click();
        BTN_LOGIN_ID.click();
        return this;
    }

    @Step("\"{username}\" kullanıcısı ile giriş yap")
    public LoginPage login(String username, String password) {
        open();



//        txtUsername.sendKeys(username);
//        txtPassword.sendKeys(password);
//        txtPassword.sendKeys(Keys.ENTER);
        //cmbOrganisation.selectOptionByValue("TTB01.00002");
       // cmbOrganisation.selectOption("ADANA BACK OFIS");

//        SELECT_MAINORG_XPATH.click();

        //driver.findElement(By.xpath(text)).click();
//        WebDriverRunner.getWebDriver().findElement(By.xpath("//li[text()='ADANA BACK OFIS']")).click();

        // driver.findElement(By.id(BTN_SUBORG_ID)).click();
//        BTN_SUBORG_ID.click();
//
//        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(),60);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_SUBORG_XPATH)));

       // formAltOrganizasyon.shouldBe(Condition.visible);

        //sorun burda
        //driver.findElement(By.xpath(text)).click();
      //  WebDriverRunner.getWebDriver().findElement(By.xpath("//span[text()='00001.00001']")).click();
//        btnKod1.click();



        //loginPage.clickSubOrg();
        //loginPage.isValidSubOrgList();
        //loginPage.selectSubOrg(loginPage.GetTestParameter("MayaLoginTest","SubOrg")[0]);

        //  driver.findElement(By.id(BTN_LOGIN_ID)).click();
        //BTN_LOGIN_ID.click();
//        btnUsermenu.waitUntil(Condition.visible, 40000);
        TXT_USERNAME_ID.sendKeys(GetTestParameter("MayaLoginTest","Username")[0]);
        TXT_PASSWWORD_ID.sendKeys(GetTestParameter("MayaLoginTest","Password")[0]);
        SELECT_MAINORG_XPATH.click();
        Assert.assertEquals(LBL_AFTER_USERPASS_ID.shouldBe(Condition.visible),true);
        SELECT_MAINORG_XPATH.click();
        $(By.xpath(GetTestParameter("MayaLoginTest","MainOrg")[0])).click();
        Assert.assertEquals(BTN_SUBORG_ID.shouldBe(Condition.visible),true);
        BTN_SUBORG_ID.click();
        Assert.assertEquals(SELECT_SUBORG_XPATH.shouldBe(Condition.visible),true);
        $(By.xpath(GetTestParameter("MayaLoginTest","SubOrg")[0])).click();
        BTN_LOGIN_ID.click();
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