package pages;
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
 * Tarih: 2018-05-31
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Zehra Yıldız
 ****************************************************/
public class CustomerAssetPropPage extends MainPageMaya
{
    private SelenideElement LBL_OZELLIKLER = $(By.xpath(GetObject("MAYA","LBL_OZELLIKLER","XPATH","CustomerAssetPropPage","PRP")));
    private SelenideElement BTN_KAPATOZELLILER = $(By.xpath(GetObject("MAYA","BTN_KAPATOZELLILER","XPATH","CustomerAssetPropPage","PRP")));


    @Step("Özellikler sayfasının açıldığı görülür..")
    public CustomerAssetPropPage SayfaKontrolu() {
        Assert.assertEquals(LBL_OZELLIKLER.isDisplayed(),true,"Sayfa açıldı.");
        Assert.assertEquals(BTN_KAPATOZELLILER.isDisplayed(),true,"Sayfa açıldı.");

        return this;
    }

}
