package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.*;
import static pages.pageComponents.SolCrmFramework.comboBox;

public class TrackOrdersPage extends MainPageMaya {

    private SelenideElement TXT_SIPARISNO_ID = $(By.id(GetObject("MAYA", "TXT_SIPARISNO_ID", "ID", "MayaTrackOrdersPage", "PRP")));
    private SolCrmElement CMB_ISLEMTIPI_XPATH = comboBox(By.xpath(GetObject("MAYA", "CMB_ISLEMTIPI_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SolCrmElement CMB_STATU_XPATH = comboBox(By.xpath(GetObject("MAYA", "CMB_STATU_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement TXT_BASLAGICTARIHI_ID = $(By.id(GetObject("MAYA", "TXT_BASLAGICTARIHI_ID", "ID", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement TXT_TAMAMLANMATARIHI_ID = $(By.id(GetObject("MAYA", "TXT_TAMAMLANMATARIHI_ID", "ID", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement TXT_YARATANORGANIZASYON_ID = $(By.id(GetObject("MAYA", "TXT_YARATANORGANIZASYON_ID", "ID", "MayaTrackOrdersPage", "PRP")));
    ElementsCollection TBL_SIPARIS = $$(GetObject("MAYA","TBL_SIPARIS","CSS_SELECTOR","MayaTrackOrdersPage","PRP"));    private SelenideElement BTN_YENILE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_YENILE_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_SIPARISGECMISI_XPATH = $(By.xpath(GetObject("FOX", "BTN_SIPARISGECMISI_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_PROJELER_XPATH = $(By.xpath(GetObject("MAYA", "BTN_PROJELER_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_SIPARISSATIRLARI_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISSATIRLARI_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_OZELLIK_XPATH = $(By.xpath(GetObject("MAYA", "BTN_OZELLIK_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_OZELLIKKAPAT_XPATH = $(By.xpath(GetObject("MAYA", "BTN_OZELLIKKAPAT_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_SIPARISDETAY_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISDETAY_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement BTN_URUNEGIT_XPATH = $(By.xpath(GetObject("MAYA", "BTN_URUNEGIT_XPATH", "XPATH", "MayaTrackOrdersPage", "PRP")));
    private SelenideElement LBL_HIZMETNOSIPARISLERI = $(By.xpath(GetObject("MAYA","LBL_HIZMETNOSIPARISLERI","XPATH","MayaTrackOrdersPage","PRP")));
    private SelenideElement LBL_MUSTERISIPARISLERI = $(By.xpath(GetObject("MAYA","LBL_MUSTERISIPARISLERI","XPATH","MayaTrackOrdersPage","PRP")));
    private SelenideElement LBL_ETKILESIMLER = $(By.xpath(GetObject("MAYA","LBL_ETKILESIMLER","XPATH","MayaTrackOrdersPage","PRP")));

    @Step("Müşteri Sipraişleri sayfası açılır.")
    public TrackOrdersPage openMusteriSiparisleriPage() {
        ustMenu(MayaUstMenuData.Islemler.MusteriSiparisleri);
        return this;
    }

    @Step("Hizmet No Siparişleri sayfası açılır.")
    public TrackOrdersPage openPageHizmetNoIleSiparis() {
        ustMenu(MayaUstMenuData.Satis.HizmetNoIleSiparis);
        return this;
    }

    @Step("Müşteri Sipraişleri sayfasını geldiği görülür.")
    public TrackOrdersPage hizmetNoIleSiparisSayfaKontrolu() {
        Assert.assertEquals(LBL_HIZMETNOSIPARISLERI.isDisplayed(), true, "Sayfa açıldı");
        takeScreenshot();
        return this;
    }

    @Step("Müşteri etkileşimler sayfası açılır.")
    public TrackOrdersPage openMusteriEtkilesimleriPage() {
        ustMenu(MayaUstMenuData.Islemler.MusteriEtkilesimleri);
        return this;
    }

    @Step("Müşteri Sipraişleri sayfasını geldiği görülür.")
    public TrackOrdersPage musteriSiparisleriSayfaKontrolu() {
        LBL_MUSTERISIPARISLERI.shouldBe(Condition.visible);
        takeScreenshot();
        return this;
    }
    @Step("Müşteri Etkileşimleri sayfasının geldiği görülür.")
    public TrackOrdersPage musteriEtkilesimleriSayfaKontrolu() {
        LBL_ETKILESIMLER.shouldBe(Condition.visible);
        Assert.assertEquals(LBL_ETKILESIMLER.isDisplayed(),true,"Müşteri Etkileşimleri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }

    @Step("Sipariş No girilir.")
    public TrackOrdersPage siparisNoGir(String siparisno) {
        TXT_SIPARISNO_ID.sendKeys(siparisno);
        return this;
    }

    @Step("İşlem Tipi Seçilir.")
    public TrackOrdersPage islemTipiSec(String tip) {
        CMB_ISLEMTIPI_XPATH.selectComboBox(tip);
        return this;
    }

    @Step("Statü Seçilir.")
    public TrackOrdersPage statuSec(String status) {
        CMB_STATU_XPATH.selectComboBox(status);
        return this;
    }

    @Step("Başlangıç Tarihi Girilir.")
    public TrackOrdersPage baslangicTarihiSec(String baslangicTarih) {
        TXT_BASLAGICTARIHI_ID.sendKeys(baslangicTarih);
        return this;
    }

    @Step("Tamamlanma Tarihi Girilir.")
    public TrackOrdersPage tamamlanmaTarihiSec(String tamamlanmaTarih) {
        TXT_TAMAMLANMATARIHI_ID.sendKeys(tamamlanmaTarih);
        return this;
    }

    @Step("Yaratan Organizasyon Tarihi Girilir.")
    public TrackOrdersPage yaratanOrganizasyonSec(String yaratanOrganizasyon) {
        TXT_YARATANORGANIZASYON_ID.sendKeys(yaratanOrganizasyon);
        return this;
    }

    @Step("Tablodan ilk Sipariş Seçilir.")
    public TrackOrdersPage siparisSec() {
        TBL_SIPARIS.first().$("a").click();
        return this;
    }

    @Step("Tablodan ilk Sipariş no alınır.")
    public String tablodanIlkSiparisNoAl() {
        return TBL_SIPARIS.first().$("a").getText();
    }

    @Step("Yenile Butonuna Tıklanır.")
    public TrackOrdersPage yenileButtonTıkla() {
        BTN_YENILE_XPATH.click();
        return this;
    }

    @Step("Sipariş Geçişine Tıklanır")
    public TrackOrdersPage siparisGecmisTıkla() {
        BTN_SIPARISGECMISI_XPATH.click();
        return this;
    }

    @Step("Projelere Tıklanır")
    public TrackOrdersPage projelerTıkla() {
        BTN_PROJELER_XPATH.click();
        return this;
    }

    @Step("Projelere Tıklanır")
    public TrackOrdersPage siparisSatirlariTıkla() {
        BTN_SIPARISSATIRLARI_XPATH.click();
        return this;
    }

    @Step("Özellik Butonuna Tıklanır.")
    public TrackOrdersPage siparisOzelliklerTikla() {
        BTN_OZELLIK_XPATH.click();
        return this;
    }

    @Step("Özellik Popup Kapatılır.")
    public TrackOrdersPage siparisOzelliklerKapat() {
        BTN_OZELLIKKAPAT_XPATH.click();
        return this;
    }

    @Step("Siparis Detayları Açılır.")
    public TrackOrdersPage siparisDetayGoruntule() {
        BTN_SIPARISDETAY_XPATH.click();
        return this;
    }

    @Step("Ürüne git Buttonuna Tıklanır.")
    public TrackOrdersPage uruneGit() {
        BTN_URUNEGIT_XPATH.click();
        return this;
    }
}
