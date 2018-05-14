package pages.ustMenuPagesFox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageFox;

import static com.codeborne.selenide.Selenide.*;

public class StepDetayPage extends MainPageFox {

    private TeknikForm teknikForm = new TeknikForm();

    private SelenideElement BTN_UZERINEAL_XPATH = $(By.xpath(GetObject("FOX", "BTN_UZERINEAL_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
    private SelenideElement CMB_PAZARLAMASEGMENTI_XPATH = $(By.xpath(GetObject("FOX", "CMB_PAZARLAMASEGMENTI_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
    private SelenideElement RADIO_AKISDURUMU_XPATH = $(By.xpath(GetObject("FOX", "RADIO_AKISDURUMU_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
    private SelenideElement BTN_BAYIOTOMASYONUNDANCIKAR_XPATH = $(By.xpath(GetObject("FOX", "BTN_BAYIOTOMASYONUNDANCIKAR_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
//    SolCrmElement CMB_PAZARLAMASEGMENTI_XPATH = comboBox(By.xpath(GetObject("FOX","CMB_PAZARLAMASEGMENTI_XPATH","XPATH","FoxStepDetayPage","PRP")));

    private SelenideElement TXT_ACIKLAMA_XPATH = $(By.xpath(GetObject("FOX", "TXT_ACIKLAMA_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
    private SelenideElement BTN_ACIKLAMAEKLE_XPATH = $(By.xpath(GetObject("FOX", "BTN_ACIKLAMAEKLE_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));

    @Step("Üzerine Al butonu tıklanır.")
    public StepDetayPage uzerineAl() {
        BTN_UZERINEAL_XPATH.click();
        return this;
    }

    @Step("Pazarlama Segmenti varsa seçilir. ")
    public StepDetayPage pazarlamaSegmentiSec(String segment) {
        if (CMB_PAZARLAMASEGMENTI_XPATH.isDisplayed()) {
            CMB_PAZARLAMASEGMENTI_XPATH.selectOption(segment);
        }
//        CMB_PAZARLAMASEGMENTI_XPATH.pressTab();
        return this;
    }

    @Step("Üzerine Al butonu tıklanır.")
    public StepDetayPage akisDurumuSec(String text) {
        SelenideElement radio = $(By.xpath("//input[@value='" + text + "']"));
        Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", radio);
        radio.click();
//        RADIO_AKISDURUMU_XPATH.click();
        return this;
    }

    @Step("Bayi Otomasyondan Çıkar varsa tıklanır")
    public StepDetayPage bayiOtomasyondanCikar() {
        if (BTN_BAYIOTOMASYONUNDANCIKAR_XPATH.isDisplayed()) {
            BTN_BAYIOTOMASYONUNDANCIKAR_XPATH.click();
            int i = 0;
            while (BTN_BAYIOTOMASYONUNDANCIKAR_XPATH.isDisplayed() && i < 10) ;
            i++;
            sleep(1000);
        }
        return this;
    }

    @Step("Açıklama alanı doldurulur.")
    public StepDetayPage aciklamaDoldur(String aciklama) {
        TXT_ACIKLAMA_XPATH.sendKeys(aciklama);
        return this;
    }

    @Step("Açıklama Ekle butonu tıklanır.")
    public StepDetayPage aciklamaEkle() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", BTN_ACIKLAMAEKLE_XPATH);
        BTN_ACIKLAMAEKLE_XPATH.click();
        return this;
    }


    public TeknikForm teknikFormTabAc() {
        return teknikForm.openPage();
    }

    public class TeknikForm extends MainPageFox {

        private SelenideElement TAB_TEKNIKFORM_XPATH = $(By.xpath(GetObject("FOX", "TAB_TEKNIKFORM_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement CMB_KURULUMSTATU_XPATH = $(By.xpath(GetObject("FOX", "CMB_KURULUMSTATU_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement CMB_KURULUMALTSTATU_XPATH = $(By.xpath(GetObject("FOX", "CMB_KURULUMALTSTATU_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement CMB_SOZLESMESTATU_XPATH = $(By.xpath(GetObject("FOX", "CMB_SOZLESMESTATU_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement CMB_SOZLESMESUBSTATU_XPATH = $(By.xpath(GetObject("FOX", "CMB_SOZLESMESUBSTATU_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement TXT_ALTYAPI_ID = $(By.id(GetObject("FOX", "TXT_ALTYAPI_ID", "ID", "FoxStepDetayPage", "PRP")));
        ElementsCollection TBL_SERINOCIHAZLISTE_CSS = $$(GetObject("FOX", "TBL_SERINOCIHAZLISTE_CSS", "CSS_SELECTOR", "FoxStepDetayPage", "PRP"));
        private SelenideElement TXT_YENICIHAZSERINO_XPATH = $(By.xpath(GetObject("FOX", "TXT_YENICIHAZSERINO_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement BTN_GUNCELLE_ID = $(By.id(GetObject("FOX", "BTN_GUNCELLE_ID", "ID", "FoxStepDetayPage", "PRP")));
        private SelenideElement BTN_SERINOKONTROL_XPATH = $(By.xpath(GetObject("FOX", "BTN_SERINOKONTROL_XPATH", "XPATH", "FoxStepDetayPage", "PRP")));
        private SelenideElement MSJ_SERINOGIRIS_XPATH = $(By.xpath(GetObject("FOX","MSJ_SERINOGIRIS_XPATH","XPATH","FoxStepDetayPage","PRP")));
        private SelenideElement BTN_SERINOGIRISKAPAT_ID = $(By.id(GetObject("FOX","BTN_SERINOGIRISKAPAT_ID","ID","FoxStepDetayPage","PRP")));
        private SelenideElement BTN_MESAJTAMAM_ID = $(By.id(GetObject("FOX","BTN_MESAJTAMAM_ID","ID","FoxStepDetayPage","PRP")));
        private SelenideElement LBL_MESAJDETAY_ID = $(By.id(GetObject("FOX","LBL_MESAJDETAY_ID","ID","FoxStepDetayPage","PRP")));
        private SelenideElement BTN_GONDER_XPATH = $(By.xpath(GetObject("FOX","BTN_GONDER_XPATH","XPATH","FoxStepDetayPage","PRP")));

        @Step("Teknik Form açılır.")
        public TeknikForm openPage() {
//            Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", TAB_TEKNIKFORM_XPATH);
            TAB_TEKNIKFORM_XPATH.click();
            return this;
        }

        @Step("Teknik Form açılır.")
        public TeknikForm teknik() {
            return this;
        }

        @Step("Kurulum statü \"{kurulumStatu}\" seçilir.")
        public TeknikForm kurulumStatuSec(String kurulumStatu) {
            CMB_KURULUMSTATU_XPATH.selectOption(kurulumStatu);
            return this;
        }

        @Step("Kurulum Alt statü \"{kurulumAltStatu}\" seçilir.")
        public TeknikForm kurulumAltStatuSec(String kurulumAltStatu) {
            CMB_KURULUMALTSTATU_XPATH.selectOption(kurulumAltStatu);
            return this;
        }

        @Step("Sözleşme statü \"{sozlesmeStatu}\" seçilir.")
        public TeknikForm sozlesmeStatuSec(String sozlesmeStatu) {
            Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", CMB_SOZLESMESTATU_XPATH);
            CMB_SOZLESMESTATU_XPATH.selectOption(sozlesmeStatu);
            return this;
        }

        @Step("Sözleşme Sub statü \"{sozlesmeSubStatu}\" seçilir.")
        public TeknikForm sozlesmeSubStatuSec(String sozlesmeSubStatu) {
            CMB_SOZLESMESUBSTATU_XPATH.selectOption(sozlesmeSubStatu);
            return this;
        }

        @Step("Alt Yapı bilgisi alınır.")
        public String altYapiBilgisiAl() {
            Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", TXT_ALTYAPI_ID);
            String altYapi = TXT_ALTYAPI_ID.getValue();
            return altYapi;
        }


        @Step("Tabloda Alytapı \"{text}\" için kalem ikonuna tıklanır.")
        public TeknikForm tabloSeriNoGiris(String text) {
            Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", $(By.id("FRM_FIELDSET_DEVICEINFORMATIONFORM")));
            TBL_SERINOCIHAZLISTE_CSS
                    .filterBy(Condition.text(text))
                    .first()
                    .$("a")
                    .click();
            return this;
        }


        @Step("Yeni Cihaz Seri No alanına \"{seriNo}\" yazılır.")
        public TeknikForm yeniCihazSeriNoDoldur(String seriNo) {
            switchTo().frame(1);
            TXT_YENICIHAZSERINO_XPATH.sendKeys(seriNo);
            return this;
        }

        @Step("Güncelle butonuna tıklanır.")
        public TeknikForm guncelle() {
            BTN_GUNCELLE_ID.click();
            return this;
        }

        @Step("Mesaj kontrolü.")
        public TeknikForm mesajKontrolu(String mesaj) {
            Assert.assertEquals(MSJ_SERINOGIRIS_XPATH.text().equals(mesaj),true);
            takeScreenshot();
            return this;
        }

        @Step("Seri No Giriş ekranı kapatılır.")
        public TeknikForm seriNoGirisEkraniKapat() {
            switchTo().parentFrame();
            BTN_SERINOGIRISKAPAT_ID.click();
            return this;
        }
        @Step("Seri No Kontrol butonuna tıklanır.")
        public TeknikForm seriNoKontrol() {
            Selenide.executeJavaScript("arguments[0].scrollIntoView(true);",BTN_SERINOKONTROL_XPATH);
            BTN_SERINOKONTROL_XPATH.click();
            return this;
        }

        @Step("EAM mesaj kontrolu")
        public TeknikForm EAMmesajKontrol(String mesaj) {
            LBL_MESAJDETAY_ID.shouldHave(Condition.visible);
            String msj= LBL_MESAJDETAY_ID.getText();
            boolean sonuc = msj.equals(mesaj);
            Assert.assertEquals(sonuc,true,"Mesaj aynı olmalı");
            return this;
        }

        @Step("EAM mesajda Tamam butonuna tıklanır.")
        public TeknikForm EAMmesajKontrolTamam() {
            BTN_MESAJTAMAM_ID.click();
            return this;
        }

        @Step("Gönder butonuna tıklanır.")
        public TeknikForm gonder() {
            BTN_GONDER_XPATH.click();
            return this;
        }
    }


}
