package pages.ustMenuPagesFox;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import drivers.Chrome;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.MainPageFox;
import pages.pageComponents.solcrmElements.SolCrmElement;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static pages.pageComponents.solcrmElements.SolCrm.comboBox;

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

        private SelenideElement TAB_TEKNIKFORM_XPATH = $(By.xpath(GetObject("FOX","TAB_TEKNIKFORM_XPATH","XPATH","FoxStepDetayPage","PRP")));
        private SelenideElement CMB_KURULUMSTATU_XPATH = $(By.xpath(GetObject("FOX","CMB_KURULUMSTATU_XPATH","XPATH","FoxStepDetayPage","PRP")));
        private SelenideElement CMB_KURULUMALTSTATU_XPATH = $(By.xpath(GetObject("FOX","CMB_KURULUMALTSTATU_XPATH","XPATH","FoxStepDetayPage","PRP")));
        private SelenideElement CMB_SOZLESMESTATU_XPATH = $(By.xpath(GetObject("FOX","CMB_SOZLESMESTATU_XPATH","XPATH","FoxStepDetayPage","PRP")));
        private SelenideElement CMB_SOZLESMESUBSTATU_XPATH = $(By.xpath(GetObject("FOX","CMB_SOZLESMESUBSTATU_XPATH","XPATH","FoxStepDetayPage","PRP")));

        @Step("Teknik Form açılır.")
        public TeknikForm openPage() {
            TAB_TEKNIKFORM_XPATH.click();
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


    }


}
