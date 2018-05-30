package pages.mayaFrames;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Utku Ozan OCAK
 ****************************************************/
public class EtkilesimlerFrame extends MainPageMaya {
    private SelenideElement LBL_ETKILESIMLER = $(By.xpath(GetObject("MAYA","LBL_ETKILESIMLER","XPATH","MayaTrackOrdersPage","PRP")));
    @Step("Müşteri etkileşimler sayfası açılır.")
    public EtkilesimlerFrame openMusteriEtkilesimleriPage() {
        ustMenu(MayaUstMenuData.Islemler.MusteriEtkilesimleri);
        return this;
    }
    @Step("\"{buttonText}\" tıklanır")
    public EtkilesimlerFrame btnForEtkilesim(String buttonText) {
        $(By.xpath("//span[text()='"+buttonText+"']//..//..//button")).shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Müşteri Etkileşimleri sayfasının geldiği görülür.")
    public EtkilesimlerFrame musteriEtkilesimleriSayfaKontrolu() {
        LBL_ETKILESIMLER.shouldBe(Condition.visible);
        Assert.assertEquals(LBL_ETKILESIMLER.isDisplayed(),true,"Müşteri Etkileşimleri Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }
}
