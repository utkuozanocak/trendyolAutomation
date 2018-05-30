package pages.ustMenuPagesMaya;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static pages.pageComponents.SolCrmFramework.comboBox;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Zehra Yıldız
 ****************************************************/
public class xdgProfileManagementPage extends MainPageMaya {

    private SelenideElement TXT_XDGKODU = $(By.xpath(GetObject("MAYA","TXT_XDGKODU","XPATH","xdgProfileManagementPage","PRP")));
    private SelenideElement BTN_XDGYENIEKLE = $(By.xpath(GetObject("MAYA","BTN_XDGYENIEKLE","XPATH","xdgProfileManagementPage","PRP")));
    private SelenideElement TXT_XDGACIKLAMA = $(By.xpath(GetObject("MAYA","TXT_XDGACIKLAMA","XPATH","xdgProfileManagementPage","PRP")));

    @Step("Yeni toptan müşterisi oluşturma sayfası açılır.")
    public xdgProfileManagementPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.XDGProfilYonetimi);
        return this;
    }
    @Step("Yeni Toptan Müşteri Oluşturma sayfasının geldiği görülür.")
    public xdgProfileManagementPage sayfaKontrolu() {
        Assert.assertEquals(TXT_XDGKODU.isDisplayed(),true, "Sayfa Açıldı.");
        takeScreenshot();
        return this;
    }
}
