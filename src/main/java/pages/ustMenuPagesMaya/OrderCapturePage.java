package pages.ustMenuPagesMaya;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageComponents.solcrmElements.SolCrmElement;
import pages.pageData.UrunEklemeData;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.pageComponents.solcrmElements.SolCrm.comboBox;

public class OrderCapturePage extends MainPageMaya {

    private Fiber fiber = new Fiber();
    private ADSL adsl = new ADSL();
    private SelenideElement BTN_SIPARISEURUNEKLE_ID = $(By.id(GetObject("MAYA", "BTN_SIPARISEURUNEKLE_ID", "ID", "MayaOrderCapturePage", "PRP")));
    private SelenideElement BTN_YENIKAYIT_XPATH = $(By.xpath(GetObject("MAYA","BTN_YENIKAYIT_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));

    @Step("Siparis Oluştur sayfası açılır.")
    public OrderCapturePage siparisOlusturTikla() {
        ustMenu(MayaUstMenuData.Islemler.SiparisOlustur);
        return this;
    }
    @Step("Adres bilgileri sayfası açılır.")
    public OrderCapturePage siparisAdresEkle() {
        ustMenu(MayaUstMenuData.Islemler.AdresBilgileri);
        return this;
    }

    @Step("Siparise ürün ekle butonu tıklanır.")
    public OrderCapturePage siparseUrunEkleTikla() {
        BTN_SIPARISEURUNEKLE_ID.click();
        return this;
    }

    public Fiber fiberAc() {
        return fiber.openPage();
    }

    public ADSL adslAc() {
        return adsl.openPage();
    }

    public class Fiber extends MainPageMaya {

        private SelenideElement TXT_KAMPANYAARA = $(By.xpath(GetObject("MAYA", "TXT_SEARCHPRODUCT_XPATH", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_DEGISTIR = $(By.xpath(GetObject("MAYA","BTN_DEGISTIRFORLOC_ID","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement TXT_LOCATION_XPATH = $(By.xpath(GetObject("MAYA","TXT_LOCATION_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA","BTN_SEARCHLOCATION","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_LOCATIONRESULT = $(By.id(GetObject("MAYA","BTN_LOCATIONRESULT","ID","MayaOrderCapturePage","PRP")));
        private SelenideElement TXT_DAIRE_ID = $(By.id(GetObject("MAYA", "TXT_DAIRE_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_NEXTDAIRE_XPATH = $(By.xpath(GetObject("MAYA","BTN_NEXTDAIRE_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_LOCATIONKAYDET_ID = $(By.id(GetObject("MAYA","BTN_LOCATIONKAYDET_ID","ID","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_SELECT_XPATH = $(By.xpath(GetObject("MAYA","BTN_SELECT_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        ElementsCollection TBL_KAMPANYA = $$(GetObject("MAYA","TBL_KAMPANYA","CSS_SELECTOR","MayaOrderCapturePage","PRP"));
        ElementsCollection TBL_LOKASYON = $$(GetObject("MAYA","TBL_LOKASYON","CSS_SELECTOR","MayaOrderCapturePage","PRP"));
        //private SolCrmElement CMB_HIZSEC_ID = comboBox(By.id(GetObject("MAYA","CMB_HIZSEC_ID","ID","MayaOrderCapturePage","PRP")));
        private SolCrmElement CMB_HIZSEC_XPATH = comboBox(By.xpath(GetObject("MAYA","CMB_HIZSEC_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_HIZEKLE_XPATH = $(By.xpath(GetObject("MAYA","BTN_HIZEKLE_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_SIPARISEKLE_XPATH = $(By.xpath(GetObject("MAYA","BTN_SIPARISEKLE_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_SIPARISIOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA","BTN_SIPARISIOLUSTUR_XPATH","XPATH","MayaOrderCapturePage","PRP")));

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

        @Step("Sipariş oluştur tıklanır.")
        public Fiber siparişOluştur() {
            BTN_SIPARISIOLUSTUR_XPATH.click();
            return this;
        }
    }



    public class ADSL extends MainPageMaya
    {
        @Step("ADSL menu açılır.")
        public ADSL openPage() {
            urunSecimMenu(UrunEklemeData.Internet.ADSL);
            return this;
        }
    }

}
