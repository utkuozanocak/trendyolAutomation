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
public class FbtPriorityGroupManagementPage extends MainPageMaya{
    private SelenideElement BTN_ONCELIKELE = $(By.xpath(GetObject("MAYA","BTN_ONCELIKELE","XPATH","FbtPriorityGroupManagement","PRP")));
    private SelenideElement BTN_URUNCIKAR = $(By.xpath(GetObject("MAYA","BTN_URUNCIKAR","XPATH","FbtPriorityGroupManagement","PRP")));
    private SelenideElement BTN_URUNEKLE = $(By.xpath(GetObject("MAYA","BTN_URUNEKLE","XPATH","FbtPriorityGroupManagement","PRP")));

    @Step("FBT  öncelik sayfası açılır.")
    public FbtPriorityGroupManagementPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.FBTOncelik);
        return this;
    }

    @Step("FBT  öncelik sayfası'nın geldiği görülür.")
    public FbtPriorityGroupManagementPage sayfaKontrolu() {
        Assert.assertEquals(BTN_ONCELIKELE.isDisplayed(),true,"Sayfa açıldı.");
        Assert.assertEquals(BTN_URUNCIKAR.isDisplayed(),true,"");
        return this;
    }


}
