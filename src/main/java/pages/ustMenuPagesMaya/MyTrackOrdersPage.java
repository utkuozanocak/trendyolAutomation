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
public class MyTrackOrdersPage extends MainPageMaya {

    private SelenideElement LBL_BENIMSIPARISLERIM = $(By.xpath(GetObject("MAYA","LBL_BENIMSIPARISLERIM","XPATH","MyTrackOrdersPage","PRP")));
    private SelenideElement TXT_BASLANGICTARIHI = $(By.id(GetObject("MAYA","TXT_BASLANGICTARIHI","ID","MyTrackOrdersPage","PRP")));
    private SelenideElement TXT_BITISTARIHI = $(By.id(GetObject("MAYA","TXT_BITISTARIHI","ID","MyTrackOrdersPage","PRP")));
    private SelenideElement BTN_LISTELE = $(By.xpath(GetObject("MAYA","BTN_LISTELE","XPATH","MyTrackOrdersPage","PRP")));
    ElementsCollection TBL_BENIMSIPARISLERIM = $$(GetObject("MAYA","TBL_BENIMSIPARISLERIM","CSS_SELECTOR","MyTrackOrdersPage","PRP"));

    @Step("Taslak Siparişlerim sayfası açılır.")
    public MyTrackOrdersPage openPage() {
        ustMenu(MayaUstMenuData.Satis.TaslakSiparislerim);
        return this;
    }

    @Step("Taslak Siparişlerim sayfasının açıldığı görülür.")
    public MyTrackOrdersPage sayfaKontrolu() {
        Assert.assertEquals(LBL_BENIMSIPARISLERIM.isDisplayed(), true, "Sayfa açıldı");
        return this;
    }
}
