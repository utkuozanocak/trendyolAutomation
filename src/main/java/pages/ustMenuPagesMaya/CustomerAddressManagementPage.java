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
public class CustomerAddressManagementPage extends MainPageMaya {
    private SelenideElement LBL_KAYITLIADRESLER = $(By.xpath(GetObject("MAYA","LBL_KAYITLIADRESLER","XPATH","CustomerAddressManagementPage","PRP")));
    @Step("Müşteri Adres Bilgileri sayfası açılır.")
    public CustomerAddressManagementPage musteriAdresBilgileriTikla() {
        ustMenu(MayaUstMenuData.Islemler.AdresBilgileri);
        return this;
    }
    @Step("Müşteri Adres Bilgileri sayfasının geldiği görülür.")
    public CustomerAddressManagementPage musteriAdresBilgileriSayfaKontrolu() {
        Assert.assertEquals(LBL_KAYITLIADRESLER.isDisplayed(),true,"Müşteri Adres Bilgileri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }
}
