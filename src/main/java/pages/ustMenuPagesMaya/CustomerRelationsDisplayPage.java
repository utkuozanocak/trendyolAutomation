package pages.ustMenuPagesMaya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Utku Ozan OCAK
 ****************************************************/
public class CustomerRelationsDisplayPage extends MainPageMaya {
    private SelenideElement LBL_MUSTERIILISKILERI = $(By.xpath(GetObject("MAYA","LBL_MUSTERIILISKILERI","XPATH","CustomerRelationsDisplayPage","PRP")));
    @Step("Müşteri İlişkileri sayfası açılır.")
    public CustomerRelationsDisplayPage musteriIliskileriTikla() {
        ustMenu(MayaUstMenuData.Islemler.MusteriIliskileri);
        return this;
    }
    @Step("Müşteri İlişkileri sayfasının geldiği görülür.")
    public CustomerRelationsDisplayPage musteriIliskileriSayfaKontrolu() {
        Assert.assertEquals(LBL_MUSTERIILISKILERI.isDisplayed(),true,"Müşteri İlişkileri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }
}
