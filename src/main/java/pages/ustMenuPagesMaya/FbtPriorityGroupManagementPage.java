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


    @Step("Kurumsal İletişim Bilgileri sayfası açılır.")
    public FbtPriorityGroupManagementPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.FBTOncelik);
        return this;
    }

    @Step("İletişim bilgisi seçilir.")
    public FbtPriorityGroupManagementPage sayfaKontrolu() {
        Assert.assertEquals(BTN_ONCELIKELE,true,"Sayfa açıldı.");
        return this;
    }


}
