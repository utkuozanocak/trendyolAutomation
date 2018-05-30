package pages.mayaFrames;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;

import static com.codeborne.selenide.Selenide.$;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Utku Ozan OCAK
 ****************************************************/
public class EtkilesimDetayDevirFrame extends MainPageMaya {
    private SelenideElement CHK_DEVIRTURU = $(GetObject("MAYA","CHK_DEVIRTURU","CSS_SELECTOR","CustomerAssetsPage","PRP"));
    private SelenideElement TXT_DEVIRCUSTOMERNO_ID = $(By.id(GetObject("MAYA","TXT_DEVIRCUSTOMERNO_ID","ID","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_DEVIRARA_XPATH = $(By.xpath(GetObject("MAYA","BTN_DEVIRARA_XPATH","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_MUSTERISEC_XPATH = $(By.xpath(GetObject("MAYA","BTN_MUSTERISEC_XPATH","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_DEVIRBASLAT_XPATH = $(By.xpath(GetObject("MAYA","BTN_DEVIRBASLAT_XPATH","XPATH","CustomerAssetsPage","PRP")));

    @Step("Devir türü seçilir.")
    public EtkilesimDetayDevirFrame devirTuruIsaretle(boolean select) {
        CHK_DEVIRTURU.click();
        return this;
    }
    @Step("Devir yapılacak müşteri no girilir.")
    public EtkilesimDetayDevirFrame musteriNoGir() {
        TXT_DEVIRCUSTOMERNO_ID.setValue("23484706");
        return this;
    }
    @Step("Devir yapılacak müşteri aranır.")
    public EtkilesimDetayDevirFrame musteriAra() {
        BTN_DEVIRARA_XPATH.click();
        return this;
    }
    @Step("Müşteri seçilir.")
    public EtkilesimDetayDevirFrame musteriSec() {
        BTN_MUSTERISEC_XPATH.click();
        return this;
    }
    @Step("Müşteri seçilir.")
    public EtkilesimDetayDevirFrame devirBaslat() {
        BTN_DEVIRBASLAT_XPATH.click();
        return this;
    }
}
