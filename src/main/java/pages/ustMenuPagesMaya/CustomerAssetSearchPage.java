package pages.ustMenuPagesMaya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Emre Sencan
 ****************************************************/
public class CustomerAssetSearchPage extends MainPageMaya {

    private SelenideElement TXT_KONTRATDETAYNO = $(By.xpath(GetObject("MAYA","TXT_KONTRATDETAYNO","XPATH","CustomerAssetSearchPage","PRP")));
    private SelenideElement LBL_KONTRATDETAYNO = $(By.xpath(GetObject("MAYA","LBL_KONTRATDETAYNO","XPATH","CustomerAssetSearchPage","PRP")));
    private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA","BTN_ARA","XPATH","CustomerAssetSearchPage","PRP")));
    ElementsCollection TBL_URUNLER = $$(GetObject("MAYA","TBL_URUNLER","CSS_SELECTOR","CustomerAssetSearchPage","PRP"));

    @Step("Müşteri Ürün Ara sayfası açılır.")
    public CustomerAssetSearchPage openPage() {
        ustMenu(MayaUstMenuData.Satis.MusteriUrunAra);
        return this;
    }

    @Step("Müşteri Ürünü Arama sayfasının açıldığı görülür.")
    public CustomerAssetSearchPage sayfaKontrolu() {
        Assert.assertEquals(LBL_KONTRATDETAYNO.isDisplayed(), true, "Sayfa açıldı");
        return this;
    }
}
