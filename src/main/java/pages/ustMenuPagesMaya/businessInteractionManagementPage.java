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
public class businessInteractionManagementPage extends  MainPageMaya{

    private SelenideElement LBL_BILIST = $(By.xpath(GetObject("MAYA","LBL_BILIST","XPATH","businessInteractionManagementPage","PRP")));
    private SelenideElement TXT_ETKILESIMADI = $(By.xpath(GetObject("MAYA","TXT_ETKILESIMADI","XPATH","businessInteractionManagementPage","PRP")));


    @Step("Sistem Parametreleri Yönetimi sayfası açılır.")
    public businessInteractionManagementPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.BIYonetim);
        return this;
    }

    @Step("Sistem Parametreleri Yönetimi sayfasının açıldığı görülür.")
    public businessInteractionManagementPage sayfaKontrolu() {
        Assert.assertEquals(LBL_BILIST.isDisplayed(),true,"Sayfa açıldı.");
        Assert.assertEquals(TXT_ETKILESIMADI.isDisplayed(),true,"");
        return this;
    }
}
