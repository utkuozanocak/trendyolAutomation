package pages.mayaFrames;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;

import static com.codeborne.selenide.Selenide.$;
import static pages.pageComponents.SolCrmFramework.comboBox;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Utku Ozan OCAK
 ****************************************************/
public class EtkilesimDetayInternetProfilDegisikligiFrame extends MainPageMaya {
    SolCrmElement CMB_INTERNETPROFIL = comboBox(GetObject("MAYA","CMB_INTERNETPROFIL","CSS_SELECTOR","CustomerAssetsPage","PRP"));
    private SelenideElement BTN_DEGISIKLIGI_KAYDET = $(By.xpath(GetObject("MAYA","BTN_DEGISIKLIGI_KAYDET","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement LBL_MSG = $(By.xpath(GetObject("MAYA", "LBL_MSG", "XPATH", "CustomerAssetsPage", "PRP")));
    @Step("İnternet Profil alanında \"{internetProfil}\" seçilir.")
    public EtkilesimDetayInternetProfilDegisikligiFrame cmbInternetProfilSec(String internetProfil) {
        CMB_INTERNETPROFIL.selectComboBox(internetProfil);
        return this;
    }
    @Step("Değişikliği Kaydet Butonu Tıklanır")
    public EtkilesimDetayInternetProfilDegisikligiFrame btnDegisikligiKaydet() {
        BTN_DEGISIKLIGI_KAYDET.click();
        return this;
    }
    @Step("Mesaj kontrolü yapılır.")
    public EtkilesimDetayInternetProfilDegisikligiFrame mesajKontrol(String mesaj) {
        Assert.assertEquals(LBL_MSG.text().contains(mesaj), true);
        takeScreenshot();
        return this;
    }
}
