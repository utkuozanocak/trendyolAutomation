package pages.ustMenuPagesMaya;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.pageComponents.SolCrmFramework.comboBox;
import static pages.pageComponents.SolCrmFramework.comboText;
/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Zehra Yıldız
 ****************************************************/
public class bindingListPage extends MainPageMaya{

    private SelenideElement LBL_ESLESTIRMELER = $(By.xpath(GetObject("MAYA","LBL_ESLESTIRMELER","XPATH","bindingListPage","PRP")));
    private SelenideElement BTN_BINDINGEKLE = $(By.id(GetObject("MAYA","BTN_BINDINGEKLE","ID","bindingListPage","PRP")));

    @Step("Yeni toptan müşterisi oluşturma sayfası açılır.")
    public bindingListPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.Eslestirmeler);
        return this;
    }
    @Step("Yeni Toptan Müşteri Oluşturma sayfasının geldiği görülür.")
    public bindingListPage sayfaKontrolu() {
        Assert.assertEquals(LBL_ESLESTIRMELER.isDisplayed(),true, "Sayfa Açıldı.");
        takeScreenshot();
        return this;
    }
}
