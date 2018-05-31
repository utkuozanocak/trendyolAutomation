package pages.ustMenuPagesMaya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static pages.pageComponents.SolCrmFramework.comboBox;

public class CustomerAssetsPage extends MainPageMaya {
    private SelenideElement BTN_ARAMA = $(By.id(GetObject("MAYA", "BTN_ARAMA", "ID", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_STATU = comboBox(By.id(GetObject("MAYA", "CMB_STATU", "ID", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_URUN = comboBox(By.id(GetObject("MAYA", "CMB_URUN", "ID", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA", "BTN_ARA", "XPATH", "CustomerAssetsPage", "PRP")));
    ElementsCollection TBL_PRODUCTLIST = $$(GetObject("MAYA", "TBL_PRODUCTLIST", "CSS_SELECTOR", "CustomerAssetsPage", "PRP"));
    private SelenideElement BTN_ETKILESIMLER = $(By.xpath(GetObject("MAYA", "BTN_ETKILESIMLER", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_PARTNERORANGIRISI = $(By.xpath(GetObject("MAYA", "BTN_PARTNERORANGIRISI", "XPATH", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_PARTNER = comboBox(By.id(GetObject("MAYA", "CMB_PARTNER", "ID", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_KAYDET = $(By.xpath(GetObject("MAYA", "BTN_KAYDET", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement LBL_MSG = $(By.xpath(GetObject("MAYA", "LBL_MSG", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement LBL_MUSTERIURUNLERI = $(By.xpath(GetObject("MAYA", "LBL_MUSTERIURUNLERI", "XPATH", "CustomerAssetsPage", "PRP")));

    @Step("Müşteri Ürünleri sayfasının geldiği görülür.")
    public CustomerAssetsPage musteriUrunleriSayfaKontrolu() {
        Assert.assertEquals(LBL_MUSTERIURUNLERI.isDisplayed(), true, "Müşteri Ürünleri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }

    @Step("Müşteri ürünleri sayfası açılır.")
    public CustomerAssetsPage musteriUrunleriSayfasiAc() {
        ustMenu(MayaUstMenuData.Islemler.MusteriUrunleri);
        return this;
    }

    @Step("Arama Butonu Tıklanır")
    public CustomerAssetsPage btnAramaTikla() {
        BTN_ARAMA.click();
        return this;
    }

    @Step("Statü alanında \"{statu}\" seçilir.")
    public CustomerAssetsPage statuSec(String statu) {
        CMB_STATU.selectComboBox(statu);

        return this;
    }

    @Step("Ürün alanında \"{urun}\" seçilir.")
    public CustomerAssetsPage urunSec(String urun) {
        CMB_URUN.selectComboBox(urun);
        return this;
    }

    @Step("Ara Butonu Tıklanır")
    public CustomerAssetsPage btnAraTikla() {
        BTN_ARA.click();
        return this;
    }

    @Step("Ürün tablosundan ilk ürünün işlemler butonu tıklanır.")
    public CustomerAssetsPage tablodanIlkUrunIslemlerTikla() {
        TBL_PRODUCTLIST.first().$("button").click();
        return this;
    }

    @Step("Ürün tablosundan ilk kontrat detayı açılır.")
    public CustomerAssetsPage tablodanIlkUrunKontratDetayAc() {
        TBL_PRODUCTLIST.first().$("span").click();
        return this;
    }


    @Step("Ürün tablosundan aktif olan ilk kontrat ürün detayı işlemler açılır.")
    public CustomerAssetsPage tablodanKontratDetayHizIslemlerAc(String statu, String urun, String secim) {
        tabloComboBoxSec(TBL_PRODUCTLIST, statu, urun, secim);
        return this;
    }

    @Step("Ürün tablosundan aktif olan ilk kontrat ürün detayı özellikler açılır.")
    public CustomerAssetsPage tablodanKontratDetayHizOzelliklerAc(String statu, String urun, String secim) {
        tabloComboBoxSec(TBL_PRODUCTLIST, statu, urun, secim);
        return this;
    }

    @Step("Etkileşimler Butonu Tıklanır")
    public CustomerAssetsPage btnEtkilesimlerTikla() {
        BTN_ETKILESIMLER.click();
        return this;
    }

    @Step("Partner Oran Girişi Butonu Tıklanır")
    public CustomerAssetsPage btnPartnerOranGirisiTikla() {
        BTN_PARTNERORANGIRISI.click();
        return this;
    }

    @Step("Partner alanında \"{partner}\" seçilir.")
    public CustomerAssetsPage cmbPartnerSec(String partner) {
        CMB_PARTNER.selectComboBox(partner);
        return this;
    }

    @Step("Partner Oran Kaydet Butonu Tıklanır")
    public CustomerAssetsPage btnPartnerKaydetTikla() {
        BTN_KAYDET.click();
        return this;
    }

    @Step("Mesaj kontrolü yapılır.")
    public CustomerAssetsPage mesajKontrol(String mesaj) {
        Assert.assertEquals(LBL_MSG.text().contains(mesaj), true);
        takeScreenshot();
        return this;
    }


}
