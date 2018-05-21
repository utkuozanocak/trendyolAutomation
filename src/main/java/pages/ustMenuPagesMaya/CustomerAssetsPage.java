package pages.ustMenuPagesMaya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageComponents.solcrmElements.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static pages.pageComponents.solcrmElements.SolCrmFramework.comboBox;

public class CustomerAssetsPage extends MainPageMaya {
    private SelenideElement BTN_ARAMA = $(By.id(GetObject("MAYA", "BTN_ARAMA", "ID", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_STATU = comboBox(By.id(GetObject("MAYA", "CMB_STATU", "ID", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_URUN = comboBox(By.id(GetObject("MAYA", "CMB_URUN", "ID", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA", "BTN_ARA", "XPATH", "CustomerAssetsPage", "PRP")));
    ElementsCollection TBL_PRODUCTLIST = $$(GetObject("MAYA", "TBL_PRODUCTLIST", "CSS_SELECTOR", "CustomerAssetsPage", "PRP"));
    private SelenideElement BTN_ETKILESIMLER = $(By.xpath(GetObject("MAYA", "BTN_ETKILESIMLER", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_KAMPANYAICIURUNDEGISIKLIGI = $(By.xpath(GetObject("MAYA", "BTN_KAMPANYAICIURUNDEGISIKLIGI", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_ABONELIKISLEMLERIIPTAL_XPATH = $(By.xpath(GetObject("MAYA", "BTN_ABONELIKISLEMLERIIPTAL_XPATH", "XPATH", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_IPTALMAINREASON_ID = comboBox(By.xpath(GetObject("MAYA", "CMB_IPTALMAINREASON_ID", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_IPTALSIPARISTAMAMLA_XPATH = $(By.xpath(GetObject("MAYA", "BTN_IPTALSIPARISTAMAMLA_XPATH", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_PARTNERORANGIRISI = $(By.xpath(GetObject("MAYA", "BTN_PARTNERORANGIRISI", "XPATH", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_PARTNER = comboBox(By.id(GetObject("MAYA", "CMB_PARTNER", "ID", "CustomerAssetsPage", "PRP")));
    SolCrmElement CMB_INTERNETPROFIL = comboBox(GetObject("MAYA","CMB_INTERNETPROFIL","CSS_SELECTOR","CustomerAssetsPage","PRP"));
    private SelenideElement BTN_KAYDET = $(By.xpath(GetObject("MAYA", "BTN_KAYDET", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement LBL_MSG = $(By.xpath(GetObject("MAYA", "LBL_MSG", "XPATH", "CustomerAssetsPage", "PRP")));
    private SelenideElement BTN_FIBERDATASIFREDEGISIKLIGI = $(By.xpath(GetObject("MAYA","BTN_FIBERDATASIFREDEGISIKLIGI","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_DATASIFREDEGISTIR = $(By.xpath(GetObject("MAYA","BTN_DATASIFREDEGISTIR","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_EVET = $(By.xpath(GetObject("MAYA","BTN_EVET","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_GUVENLIINTERNETPROFILDEGISIKLIGI = $(By.xpath(GetObject("MAYA","BTN_GUVENLIINTERNETPROFILDEGISIKLIGI","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_DEGISIKLIGI_KAYDET = $(By.xpath(GetObject("MAYA","BTN_DEGISIKLIGI_KAYDET","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_POPUP_EVET = $(By.xpath(GetObject("MAYA","BTN_POPUP_EVET","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_KAMPANYA_DEGISIKLIGI = $(By.xpath(GetObject("MAYA","BTN_KAMPANYA_DEGISIKLIGI","XPATH","CustomerAssetsPage","PRP")));
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
    @Step("Kampanya Değişikliği Butonu Tıklanır")
    public CustomerAssetsPage btnKampanyaDegisikligiTikla() {
        BTN_KAMPANYA_DEGISIKLIGI.click();
        return this;
    }
    @Step("Değişikliği Kaydet Butonu Tıklanır")
    public CustomerAssetsPage btnDegisikligiKaydet() {
        BTN_DEGISIKLIGI_KAYDET.click();
        return this;
    }
    @Step("PopUp Evet Butonu Tıklanır")
    public CustomerAssetsPage btnPopUpEvet() {
        BTN_POPUP_EVET.click();
        return this;
    }
    @Step("Güvenli İnternet Profil Değişikliği Butonu Tıklanır")
    public CustomerAssetsPage btnGuvenliInternetProfilDegisikligiTikla() {
        BTN_GUVENLIINTERNETPROFILDEGISIKLIGI.click();
        return this;
    }
    @Step("İnternet Profil alanında \"{internetProfil}\" seçilir.")
    public CustomerAssetsPage cmbInternetProfilSec(String internetProfil) {
        CMB_INTERNETPROFIL.selectComboBox(internetProfil);
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
    public CustomerAssetsPage tablodanKontratDetayHizIslemlerAc(String statu,String urun,String secim) {
        tabloComboBoxSec(TBL_PRODUCTLIST,statu,urun,secim);
        return this;
    }

    @Step("Fiber Data Şifre Değişikliği Butonu Tıklanır")
    public CustomerAssetsPage btnFiberDataSifreDegisikligi() {
        BTN_FIBERDATASIFREDEGISIKLIGI.click();
        return this;
    }

    @Step("Data Şifre Değiştir Butonu Tıklanır")
    public CustomerAssetsPage btnDataSifreDegistirTikla() {
        BTN_DATASIFREDEGISTIR.click();
        return this;
    }
    @Step("Data Şifre Değiştir Onay (Evet) Tıklanır")
    public CustomerAssetsPage btnDataSifreDegisikligiEvetTikla() {
        BTN_EVET.click();
        return this;
    }

    @Step("Etkileşimler Butonu Tıklanır")
    public CustomerAssetsPage btnEtkilesimlerTikla() {
        BTN_ETKILESIMLER.click();
        return this;
    }


    @Step("Kampanya İçi Ürün Değişikliği Butonu Tıklanır")
    public CustomerAssetsPage btnKampanyaIciUrunDegisikligiTikla() {
        BTN_KAMPANYAICIURUNDEGISIKLIGI.click();
        return this;
    }

    @Step("Abonelik işlemleri/İptal butonuna tıklanır.")
    public CustomerAssetsPage btnIptalSiparisiTikla() {
        BTN_ABONELIKISLEMLERIIPTAL_XPATH.click();
        return this;
    }

    @Step("İptal ana sebebi seçilir.")
    public CustomerAssetsPage cmbIptalAnaNedeniSec(String iptalananedeni) {
        comboBox("div[id^='deactivationForm'][id$='mainReasons']").selectComboBox(iptalananedeni);
        return this;
    }

    @Step("İptal ana sebebi seçilir.")
    public CustomerAssetsPage altNedenSec(String iptalaltnedeni) {
        comboBox("div[id^='deactivationForm'][id$='detailReasons']").selectComboBox(iptalaltnedeni);
//        $("div[id^='deactivationForm'][id$='detailReasons'] span[class='ui-icon ui-icon-triangle-1-s ui-c']").click();
//        $$("div[id^='deactivationForm'][id$='detailReasons_panel'] li")
//                .filterBy(Condition.text(iptalaltnedeni))
//                .first()
//                .click();
        return this;
    }

    @Step("İptal siparişi tamamlanır.")
    public CustomerAssetsPage iptalSiparişiTamamla() {
        BTN_IPTALSIPARISTAMAMLA_XPATH.click();
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
    public void mesajKontrol(String mesaj) {
        Assert.assertEquals(LBL_MSG.text().contains(mesaj), true);
        takeScreenshot();
    }

}
