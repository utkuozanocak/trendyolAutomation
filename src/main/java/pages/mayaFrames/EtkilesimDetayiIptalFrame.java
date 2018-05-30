package pages.mayaFrames;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;

import static com.codeborne.selenide.Selenide.$;
import static pages.pageComponents.SolCrmFramework.comboBox;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Utku Ozan OCAK
 ****************************************************/
public class EtkilesimDetayiIptalFrame extends MainPageMaya {
    private SelenideElement BTN_IPTALSIPARISTAMAMLA_XPATH = $(By.xpath(GetObject("MAYA", "BTN_IPTALSIPARISTAMAMLA_XPATH", "XPATH", "CustomerAssetsPage", "PRP")));
    @Step("İptal ana sebebi seçilir.")
    public EtkilesimDetayiIptalFrame cmbIptalAnaNedeniSec(String iptalananedeni) {
        comboBox("div[id^='deactivationForm'][id$='mainReasons']").selectComboBox(iptalananedeni);
        return this;
    }

    @Step("İptal ana sebebi seçilir.")
    public EtkilesimDetayiIptalFrame altNedenSec(String iptalaltnedeni) {
        comboBox("div[id^='deactivationForm'][id$='detailReasons']").selectComboBox(iptalaltnedeni);
        return this;
    }
    @Step("İptal siparişi tamamlanır.")
    public EtkilesimDetayiIptalFrame iptalSiparişiTamamla() {
        BTN_IPTALSIPARISTAMAMLA_XPATH.click();
        return this;
    }
}
