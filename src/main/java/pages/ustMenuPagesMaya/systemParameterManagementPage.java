package pages.ustMenuPagesMaya;
import com.codeborne.selenide.SelenideElement;
import common.BaseTest;
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
 * Yazan: Zehra Yıldız
 ****************************************************/
public class systemParameterManagementPage extends MainPageMaya{
    private SelenideElement LBL_PARAMETREYONETIM = $(By.xpath(GetObject("MAYA","LBL_PARAMETREYONETIM","XPATH","systemParameterManagementPage","PRP")));
    private SelenideElement BTN_YENIEKLE = $(By.xpath(GetObject("MAYA","BTN_YENIEKLE","XPATH","systemParameterManagementPage","PRP")));

    @Step("Sistem Parametreleri Yönetimi sayfası açılır.")
    public systemParameterManagementPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.SistemParametreleriYonetim);
        return this;
    }

    @Step("Sistem Parametreleri Yönetimi sayfasının açıldığı görülür.")
    public systemParameterManagementPage sayfaKontrolu() {
        Assert.assertEquals(LBL_PARAMETREYONETIM.isDisplayed(),true,"Sayfa açıldı.");
        Assert.assertEquals(BTN_YENIEKLE.isDisplayed(),true,"");
        return this;
    }
}
