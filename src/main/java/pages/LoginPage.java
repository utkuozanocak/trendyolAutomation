package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.TestDataTrendyol;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends MainPage {
    private SelenideElement BTN_GIRISYAP_HOVER_ID = $(By.id("not-logged-in-container"));
    private SelenideElement BTN_GIRISYAP_CLICK_XPATH = $(By.xpath("//div[@class='account-button login']"));
    private SelenideElement TXT_EMAIL_ID = $(By.id("email"));
    private SelenideElement TXT_PASSWORD_ID = $(By.id("password"));
    private SelenideElement BTN_LOGINOL_ID = $(By.id("loginSubmit"));

    private LoginPage open() {
        WebDriverRunner.clearBrowserCache();
        Selenide.open("");
        maximazeBrowser();
        return this;
    }
    private LoginPage open(String url) {
        WebDriverRunner.clearBrowserCache();
        Selenide.open(url);
        maximazeBrowser();
        return this;
    }
    @Step("Giriş yap")
    public LoginPage login(String username, String password) {
        Configuration.baseUrl = (System.getProperty("URLTRENDYOL") == null) ? TestDataTrendyol.trendyolUrl : System.getProperty("URLTRENDYOL");
        open();
        frameClose();
        BTN_GIRISYAP_HOVER_ID.hover();
        BTN_GIRISYAP_CLICK_XPATH.click();
        TXT_EMAIL_ID.sendKeys(username);
        TXT_PASSWORD_ID.sendKeys(password);
        BTN_LOGINOL_ID.click();
        return this;
    }
}
