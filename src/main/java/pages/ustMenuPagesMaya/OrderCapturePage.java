package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;
import pages.pageData.UrunEklemeData;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.*;
import static pages.pageComponents.SolCrmFramework.comboBox;

public class OrderCapturePage extends MainPageMaya {

    private Fiber fiber = new Fiber();
    private ADSL adsl = new ADSL();
    private VDSL vdsl = new VDSL();
    private SelenideElement BTN_SIPARISEURUNEKLE_ID = $(By.id(GetObject("MAYA", "BTN_SIPARISEURUNEKLE_ID", "ID", "MayaOrderCapturePage", "PRP")));
    private SelenideElement BTN_YENIKAYIT_XPATH = $(By.xpath(GetObject("MAYA", "BTN_YENIKAYIT_XPATH", "XPATH", "MayaCustomerAddressManagementPage", "PRP")));
    private SelenideElement BTN_SIPARISIOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISIOLUSTUR_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));

    @Step("Siparis Oluştur sayfası açılır.")
    public OrderCapturePage siparisOlusturSayfaAc() {
        ustMenu(MayaUstMenuData.Islemler.SiparisOlustur);
        return this;
    }

    @Step("Siparise ürün ekle butonu tıklanır.")
    public OrderCapturePage siparseUrunEkleTikla() {
        BTN_SIPARISEURUNEKLE_ID.click();
        return this;
    }

    @Step("Siparis Oluştur Tıkla")
    public OrderCapturePage siparisOlusturTikla() {
        BTN_SIPARISIOLUSTUR_XPATH.click();
        return this;
    }

    public Fiber fiberAc() {
        return fiber;
    }

    public ADSL adslAc() {
        // if($x("//a[text()='DSL Konfigrasyonu']").isDisplayed())
        return adsl;
        //return adsl.openPage();
    }

    public VDSL vdslAc() {
        // if($x("//a[text()='DSL Konfigrasyonu']").isDisplayed())
        return vdsl;
        //return adsl.openPage();
    }

    public class Fiber extends MainPageMaya {

        private SelenideElement TXT_KAMPANYAARA = $(By.xpath(GetObject("MAYA", "TXT_SEARCHPRODUCT_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_DEGISTIR = $(By.xpath(GetObject("MAYA", "BTN_DEGISTIRFORLOC_ID", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement TXT_LOCATION_XPATH = $(By.xpath(GetObject("MAYA", "TXT_LOCATION_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA", "BTN_SEARCHLOCATION", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_LOCATIONRESULT = $(By.id(GetObject("MAYA", "BTN_LOCATIONRESULT", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement TXT_DAIRE_ID = $(By.id(GetObject("MAYA", "TXT_DAIRE_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_NEXTDAIRE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_NEXTDAIRE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_LOCATIONKAYDET_ID = $(By.id(GetObject("MAYA", "BTN_LOCATIONKAYDET_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SELECT_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SELECT_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        ElementsCollection TBL_KAMPANYA = $$(GetObject("MAYA", "TBL_KAMPANYA", "CSS_SELECTOR", "MayaOrderCapturePage", "PRP"));
        ElementsCollection TBL_LOKASYON = $$(GetObject("MAYA", "TBL_LOKASYON", "CSS_SELECTOR", "MayaOrderCapturePage", "PRP"));
        //private SolCrmElement CMB_HIZSEC_ID = comboBox(By.id(GetObject("MAYA","CMB_HIZSEC_ID","ID","MayaOrderCapturePage","PRP")));
        private SolCrmElement CMB_HIZSEC_XPATH = comboBox(By.xpath(GetObject("MAYA", "CMB_HIZSEC_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_HIZEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_HIZEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SIPARISEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SIPARISIOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISIOLUSTUR_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SolCrmElement CMB_IKINCIDONANIM_XPATH = comboBox(By.xpath(GetObject("MAYA", "CMB_IKINCIDONANIM_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_DONANIMEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_DONANIMEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));


        @Step("Fiber menu açılır.")
        public Fiber openPage() {
            urunSecimMenu(UrunEklemeData.Internet.Fiber);
            return this;
        }

        @Step("Değiştir butonu tıklanır.")
        public Fiber degistirTikla() {
            BTN_DEGISTIR.click();
            return this;
        }

        @Step("Ara butonu tıklanır.")
        public Fiber Ara() {
            BTN_ARA.click();
            return this;
        }

        @Step("Seç butonu tıklanır.")
        public Fiber lokasyonSec() {
            BTN_LOCATIONRESULT.click();
            return this;
        }

        @Step("Lokasyon tablosundan lokasyon seçilir.")
        public Fiber tablodanLokasyonSec() {
            TBL_LOKASYON
                    .first()
                    .$("span")
                    .click();
            return this;
        }

        @Step("Lokasyon id alanına \"{lokasyonId}\" yazılır.")
        public Fiber lokasyonIDDoldur(String lokasyonId) {
            TXT_LOCATION_XPATH.setValue(lokasyonId);
            return this;
        }

        @Step("Daire no alanına \"{daireNo}\" yazılır.")
        public Fiber daireNoDoldur(String daireNo) {
            TXT_DAIRE_ID.sendKeys(daireNo);
            return this;
        }

        @Step("Daire no seçilir. \"{daireNo}\" ")
        public Fiber daireNoSec(String daireNo) {
            while (!$(By.xpath("//span[text()='" + daireNo + "']")).isDisplayed()) {
                BTN_NEXTDAIRE_XPATH.click();
            }
            $(By.xpath("//a[@title='" + daireNo + "']//span")).click();
            return this;
        }

        @Step("Kaydet butonuna tıklanır.")
        public Fiber kaydet() {
            BTN_LOCATIONKAYDET_ID.click();
            return this;
        }

        @Step("Kampanya Ara alanına \"{kampanya}\" yazılır.")
        public Fiber kampanyaAra(String kampanya) {
            sleep(2000);
            TXT_KAMPANYAARA.sendKeys(kampanya);
            return this;
        }

        @Step("Kamapnya tablosundan \"{kampanya}\" seçilir.")
        public Fiber tablodanKampanyaSec(String kampanya) {
            TBL_KAMPANYA
                    .filterBy(Condition.text(kampanya))
                    .first()
                    .click();
            return this;
        }

        @Step("Seç butonu tıklanır.")
        public Fiber kampanyaSec() {
            BTN_SELECT_XPATH.click();
            return this;
        }

        @Step("Hız Seçilir ve Eklenir.")
        public Fiber hizSec(String hiz) {
            CMB_HIZSEC_XPATH.selectComboBox(hiz);
            BTN_HIZEKLE_XPATH.click();
            return this;
        }

        @Step("Sipariş Eklenir.")
        public Fiber siparisEkle() {
            clickJs(BTN_SIPARISEKLE_XPATH);
            return this;
        }

        @Step("2. donanım ürünü siparişe eklenir.")
        public Fiber donanimEkle(String donanim) {


            Selenide.executeJavaScript("arguments[0].scrollIntoView(true);",CMB_IKINCIDONANIM_XPATH);

//            SelenideElement lbl = $x("//label[normalize-space(text())='Dect Telefon Seçim Grubu Fiber']");
//            BTN_DONANIMEKLE_XPATH.scrollIntoView(true);

            CMB_IKINCIDONANIM_XPATH.selectComboBox(donanim);
            BTN_DONANIMEKLE_XPATH.click();
            return this;
        }

        @Step("Sipariş oluştur tıklanır.")
        public Fiber siparişOluştur() {
            BTN_SIPARISIOLUSTUR_XPATH.click();
            return this;
        }
    }


    public class ADSL extends MainPageMaya {
        private SelenideElement CMB_DSLHIZ_ID = $(By.id(GetObject("FOX", "CMB_DSLHIZ_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement CMB_HIZADSL_XPATH = $(By.xpath(GetObject("MAYA", "CMB_HIZADSL_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement CMB_DSLTIPI_XPATH = $(By.xpath(GetObject("MAYA", "CMB_DSLTIPI_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement LBL_STANDARTDSL_XPATH = $(By.xpath(GetObject("MAYA", "LBL_STANDARTDSL_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_TTHIZMETSORGULA_XPATH = $(By.xpath(GetObject("MAYA", "BTN_TTHIZMETSORGULA_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement DSL_ERISIM_NO = $(By.id(GetObject("MAYA", "DSL_ERISIM_NO", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SUNUSEC_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SUNUSEC_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement TXT_SEARCHCAMPAIGN_XPATH = $(By.xpath(GetObject("MAYA", "TXT_SEARCHCAMPAIGN_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        ElementsCollection TBL_DSLKAMPANYA = $$(GetObject("MAYA", "TBL_DSLKAMPANYA", "CSS_SELECTOR", "MayaOrderCapturePage", "PRP"));
        private SolCrmElement CMB_ADSLHIZSEC_XPATH = comboBox(By.xpath(GetObject("MAYA", "CMB_ADSLHIZSEC_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_ADSLHIZEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_ADSLHIZEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SIPARISEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SIPARISIOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISIOLUSTUR_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));


        @Step("ADSL menu açılır.")
        public ADSL openPage() {
            urunSecimMenu(UrunEklemeData.Internet.ADSL);
            return this;
        }

        @Step("DSL hızı seçilir.")
        public ADSL dslHizSec() {
            CMB_DSLHIZ_ID.click();
            CMB_HIZADSL_XPATH.click();
            return this;
        }

        @Step("DSL Tipi Seçilir.")
        public ADSL dslTipiSec(String tip) {
            CMB_DSLTIPI_XPATH.click();
            LBL_STANDARTDSL_XPATH.click();
            return this;
        }

        @Step("TT'den gelen erisim no girilir.")
        public ADSL erisimNoGir(String erisimno) {
            DSL_ERISIM_NO.sendKeys(erisimno);
            return this;
        }

        @Step("TT hizmet sorgulama butonuna tıklanır.")
        public ADSL ttHizmetSorgulama() {
            BTN_TTHIZMETSORGULA_XPATH.click();
            return this;
        }

        @Step("Sunu seç butonuna tıklanır.")
        public ADSL dslSunuSec() {
            BTN_SUNUSEC_XPATH.click();
            return this;
        }

        @Step("Kampanya Ara alanına \"{kampanya}\" yazılır.")
        public ADSL kampanyaAraDsl(String kampanya) {
            TXT_SEARCHCAMPAIGN_XPATH.sendKeys(kampanya);
            return this;
        }

        @Step("Kamapnya tablosundan \"{kampanya}\" seçilir.")
        public ADSL tablodanKampanyaSecDsl(String kampanya) {
            TBL_DSLKAMPANYA
                    .filterBy(Condition.text(kampanya))
                    .first()
                    .click();
            return this;
        }

        @Step("Hız Seçilir ve Eklenir.")
        public ADSL hizSecAdsl(String hiz) {
            CMB_ADSLHIZSEC_XPATH.selectComboBox(hiz);
            BTN_ADSLHIZEKLE_XPATH.click();
            return this;
        }

        @Step("Sipariş Eklenir.")
        public ADSL siparisEkle() {
            clickJs(BTN_SIPARISEKLE_XPATH);
            return this;
        }

        @Step("Sipariş oluştur tıklanır.")
        public ADSL siparişOluştur() {
            BTN_SIPARISIOLUSTUR_XPATH.click();
            return this;
        }

    }

    public class VDSL extends MainPageMaya {
        private SelenideElement CMB_DSLHIZ_ID = $(By.id(GetObject("FOX", "CMB_DSLHIZ_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement CMB_HIZVDSL_XPATH = $(By.xpath(GetObject("MAYA", "CMB_HIZVDSL_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement CMB_DSLTIPI_XPATH = $(By.xpath(GetObject("MAYA", "CMB_DSLTIPI_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement LBL_STANDARTDSL_XPATH = $(By.xpath(GetObject("MAYA", "LBL_STANDARTDSL_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_TTHIZMETSORGULA_XPATH = $(By.xpath(GetObject("MAYA", "BTN_TTHIZMETSORGULA_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement DSL_ERISIM_NO = $(By.id(GetObject("MAYA", "DSL_ERISIM_NO", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SUNUSEC_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SUNUSEC_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement TXT_SEARCHCAMPAIGN_XPATH = $(By.xpath(GetObject("MAYA", "TXT_SEARCHCAMPAIGN_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        ElementsCollection TBL_DSLKAMPANYA = $$(GetObject("MAYA", "TBL_DSLKAMPANYA", "CSS_SELECTOR", "MayaOrderCapturePage", "PRP"));
        private SolCrmElement CMB_ADSLHIZSEC_XPATH = comboBox(By.xpath(GetObject("MAYA", "CMB_ADSLHIZSEC_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_ADSLHIZEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_ADSLHIZEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SIPARISEKLE_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISEKLE_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_SIPARISIOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISIOLUSTUR_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));


        @Step("ADSL menu açılır.")
        public VDSL openPage() {
            urunSecimMenu(UrunEklemeData.Internet.ADSL);
            return this;
        }

        @Step("DSL hızı seçilir.")
        public VDSL dslHizSec() {
            CMB_DSLHIZ_ID.click();
            CMB_HIZVDSL_XPATH.click();
            return this;
        }

        public VDSL dslTipiSec(String tip) {
            CMB_DSLTIPI_XPATH.click();
            LBL_STANDARTDSL_XPATH.click();
            return this;
        }

        @Step("TT'den gelen erisim no girilir.")
        public VDSL erisimNoGir(String erisimno) {
            DSL_ERISIM_NO.sendKeys(erisimno);
            return this;
        }

        @Step("TT hizmet sorgulama butonuna tıklanır.")
        public VDSL ttHizmetSorgulama() {
            BTN_TTHIZMETSORGULA_XPATH.click();
            return this;
        }

        @Step("Sunu seç butonuna tıklanır.")
        public VDSL vdsldslSunuSec() {
            BTN_SUNUSEC_XPATH.click();
            return this;
        }

        @Step("Kampanya Ara alanına \"{kampanya}\" yazılır.")
        public VDSL kampanyaAraDsl(String kampanya) {
            sleep(2000);
            TXT_SEARCHCAMPAIGN_XPATH.sendKeys(kampanya);
            return this;
        }
    }
}
