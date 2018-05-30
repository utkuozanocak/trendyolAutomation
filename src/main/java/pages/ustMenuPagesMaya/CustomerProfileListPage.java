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
public class CustomerProfileListPage extends MainPageMaya {
    private SelenideElement LBL_MUSTERIPROFILLISTESI = $(By.xpath(GetObject("MAYA","LBL_MUSTERIPROFILLISTESI","XPATH","CustomerProfileListPage","PRP")));
    @Step("Müşteri Profil Bilgileri sayfası açılır.")
    public CustomerProfileListPage musteriProfilBilgileriTikla() {
        ustMenu(MayaUstMenuData.Islemler.MusteriProfilBilgileri);
        return this;
    }
    @Step("Müşteri Profil Bilgileri sayfasının geldiği görülür.")
    public CustomerProfileListPage musteriProfilBilgileriSayfaKontrolu() {
        Assert.assertEquals(LBL_MUSTERIPROFILLISTESI.isDisplayed(),true,"Müşteri Profil Bilgileri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }
}
