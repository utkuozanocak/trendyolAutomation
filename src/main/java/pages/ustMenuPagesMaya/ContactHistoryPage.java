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
public class ContactHistoryPage extends MainPageMaya {
    private SelenideElement LBL_MUSTERIGECMISI = $(By.xpath(GetObject("MAYA","LBL_MUSTERIGECMISI","XPATH","ContactHistoryPage","PRP")));
    @Step("Müşteri Geçmişi sayfası açılır.")
    public ContactHistoryPage musteriGecmisiTikla() {
        ustMenu(MayaUstMenuData.Islemler.MusteriGecmisi);
        return this;
    }
    @Step("Müşteri Profil Bilgileri sayfasının geldiği görülür.")
    public ContactHistoryPage musteriGecmisiSayfaKontrolu() {
        Assert.assertEquals(LBL_MUSTERIGECMISI.isDisplayed(),true,"Müşteri Profil Bilgileri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }
}
