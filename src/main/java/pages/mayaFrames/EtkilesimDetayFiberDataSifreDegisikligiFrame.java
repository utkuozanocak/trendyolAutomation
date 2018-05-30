package pages.mayaFrames;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;

import static com.codeborne.selenide.Selenide.$;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Utku Ozan OCAK
 ****************************************************/
public class EtkilesimDetayFiberDataSifreDegisikligiFrame extends MainPageMaya {
    private SelenideElement BTN_DATASIFREDEGISTIR = $(By.xpath(GetObject("MAYA","BTN_DATASIFREDEGISTIR","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_EVET = $(By.xpath(GetObject("MAYA","BTN_EVET","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement LBL_MSG = $(By.xpath(GetObject("MAYA", "LBL_MSG", "XPATH", "CustomerAssetsPage", "PRP")));
    @Step("Data Şifre Değiştir Butonu Tıklanır")
    public EtkilesimDetayFiberDataSifreDegisikligiFrame btnDataSifreDegistirTikla() {
        BTN_DATASIFREDEGISTIR.click();
        return this;
    }
    @Step("Data Şifre Değiştir Onay (Evet) Tıklanır")
    public EtkilesimDetayFiberDataSifreDegisikligiFrame btnDataSifreDegisikligiEvetTikla() {
        BTN_EVET.click();
        return this;
    }
    @Step("Mesaj kontrolü yapılır.")
    public EtkilesimDetayFiberDataSifreDegisikligiFrame mesajKontrol(String mesaj) {
        Assert.assertEquals(LBL_MSG.text().contains(mesaj), true);
        takeScreenshot();
        return this;
    }
}
