package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BaseLibrary {
    SelenideElement FRM_OBJECT_XPATH = $(By.xpath("//div[@class='homepage-popup']"));
    SelenideElement BTN_FRAMECLOSE_XPATH = $(By.xpath("//a[@title='Close']"));
    SelenideElement LBL_LOGIN_ID = $(By.id("logged-in-container"));
    ElementsCollection BTN_TABLINK_XPATH_LST = $$(By.xpath("//div[@id='navigation-wrapper']//ul[@class='main-nav']//li[contains(@class,'tab-link')]//a[@class='category-header']"));
    ElementsCollection IMG_BUTIK_XPATH_LST = $$(By.xpath("//div[@class='component-list component-big-list']//article[@class='component-item']//img"));
    SelenideElement OBJ_TABMENUDETAIL_ID = $(By.id("browsing-gw-homepage"));

    @Step("Frame Varsa Kapat")
    public MainPage frameClose() {
        FRM_OBJECT_XPATH.shouldBe(Condition.visible);
        BTN_FRAMECLOSE_XPATH.click();
        return this;
    }

    @Step("Login Oldumu")
    public MainPage loginKontrol() {
        Assert.assertTrue(LBL_LOGIN_ID.shouldBe(Condition.visible).isDisplayed(),"Login Başarısız");
        return this;
    }

    @Step("Tab Link Butik İmaj Kontrol")
    public MainPage tabLinkButikImageControl() {
        for (int i=0; i<BTN_TABLINK_XPATH_LST.size(); i++) {
            BTN_TABLINK_XPATH_LST.get(i).click();
            Assert.assertTrue(OBJ_TABMENUDETAIL_ID.shouldBe(Condition.visible).isDisplayed(),"Tab menü detay yüklenemedi");
            for (int j=0; j<IMG_BUTIK_XPATH_LST.size(); j++) {
                if (IMG_BUTIK_XPATH_LST.get(j).shouldBe(Condition.visible).isDisplayed()) {
                    IMG_BUTIK_XPATH_LST.get(j).scrollTo();
                    log.info(  "Sol'dan "+i+". menünün altında bulunan " + j + ". Butik Resmi Başarılı Görüntülendi");
                } else {
                    log.info(  "Sol'dan "+i+". menünün altında bulunan " + j + ". Butik Resmi Görüntülenemedi");
                }
            }
        }
        return this;
    }
}
