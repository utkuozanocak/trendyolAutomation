package pages.ustMenuPages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.pageData.UrunEklemeData;
import pages.pageData.UstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class OrderCapturePage extends MainPage {

    private Fiber fiber = new Fiber();
    private ADSL adsl = new ADSL();
    private SelenideElement BTN_SIPARISEURUNEKLE_ID = $(By.id(GetObject("MAYA", "BTN_SIPARISEURUNEKLE_ID", "ID", "MayaOrderCapturePage", "PRP")));


    @Step("Siparis Oluştur sayfası açılır.")
    public OrderCapturePage siparisOlusturTikla() {
        ustMenu(UstMenuData.Islemler.SiparisOlustur);
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

    public class Fiber extends MainPage {

        private SelenideElement TXT_KAMPANYAARA = $(By.id(GetObject("MAYA", "TXT_SEARCHPRODUCT_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_DEGISTIR = $(By.xpath(GetObject("MAYA", "BTN_DEGISTIRFORLOC_ID", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement TXT_BINALOKASYON = $(By.id(GetObject("MAYA", "TXT_LOCATION_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA", "BTN_SEARCHLOCATION", "XPATH", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_LOKASYONSEC = $(By.id(GetObject("MAYA", "BTN_LOCATIONRESULT", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement TXT_DAIRE_ID = $(By.id(GetObject("MAYA", "TXT_DAIRE_ID", "ID", "MayaOrderCapturePage", "PRP")));
        private SelenideElement BTN_NEXTDAIRE_XPATH = $(By.xpath(GetObject("MAYA","BTN_NEXTDAIRE_XPATH","XPATH","MayaOrderCapturePage","PRP")));
        private SelenideElement BTN_LOCATIONKAYDET_ID = $(By.id(GetObject("MAYA","BTN_LOCATIONKAYDET_ID","ID","MayaOrderCapturePage","PRP")));

        ElementsCollection TBL_KAMPANYA = $$("tbody[id='productSelectionWizardForm:fiberOfferDataTable_data'] tr[data-ri]");
        ElementsCollection TBL_LOKASYON = $$("tbody[id='productSelectionWizardForm:fiberAddressManagementForm:fiberAddressTableLazy_data'] tr[data-ri]");


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
            BTN_LOKASYONSEC.click();
            return this;
        }

        @Step("Lokasyon tablosundan lokasyon seçilir.")
        public Fiber tablodanLokasyonSec() {
            TBL_LOKASYON
                    .first()
                    .$("td:nth-child(1)")
                    .click();

            return this;
        }

        @Step("Lokasyon id alanına \"{lokasyonId}\" yazılır.")
        public Fiber lokasyonIDDoldur(String lokasyonId) {
            TXT_BINALOKASYON.sendKeys(lokasyonId);
            sleep(1000);
            return this;
        }

        @Step("Daire no alanına \"{daireNo}\" yazılır.")
        public Fiber daireNoDoldur(String daireNo) {
            TXT_DAIRE_ID.sendKeys(daireNo);
            return this;
        }

        @Step("Daire no seçilir. \"{daireNo}\" ")
        public Fiber daireNoSec(String daireNo) {
            while (!WebDriverRunner.getWebDriver().findElement(By.xpath("//span[text()='" + daireNo + "']")).isDisplayed()) {
                BTN_NEXTDAIRE_XPATH.click();
            }
            WebDriverRunner.getWebDriver().findElement(By.xpath("//span[text()='" + daireNo + "']")).click();
            return this;
        }

        @Step("Kaydet butonuna tıklanır.")
        public Fiber kaydet() {
            BTN_LOKASYONSEC.click();
            return this;
        }

        @Step("Kampanya Ara alanına \"{kampanya}\" yazılır.")
        public Fiber kampanyaAra(String kampanya) {
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

    }

    public class ADSL extends MainPage {

        @Step("ADSL menu açılır.")
        public ADSL openPage() {
            urunSecimMenu(UrunEklemeData.Internet.ADSL);
            return this;
        }
    }

}
