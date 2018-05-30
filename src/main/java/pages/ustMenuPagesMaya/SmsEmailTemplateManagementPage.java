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
public class SmsEmailTemplateManagementPage extends MainPageMaya {

    private SelenideElement LBL_SABLONBILGI = $(By.xpath(GetObject("MAYA","LBL_SABLONBILGI","XPATH","smsEmailTemplateManagementPage","PRP")));
    private SelenideElement LBL_SABLONICERIK = $(By.xpath(GetObject("FOX","LBL_SABLONICERIK","XPATH","smsEmailTemplateManagementPage","PRP")));

    @Step("SMS / E-posta Şablonları sayfası açılır.")
    public SmsEmailTemplateManagementPage openPage() {
        ustMenu(MayaUstMenuData.Yonetim.SMSEPostaSablonlari);
        return this;
    }

    @Step("SMS / E-posta Şablonları sayfasının açıldığı görülür.")
    public SmsEmailTemplateManagementPage sayfaKontrolu() {
        Assert.assertEquals(LBL_SABLONBILGI.isDisplayed(),true,"Sayfa açıldı.");
        Assert.assertEquals(LBL_SABLONICERIK.isDisplayed(),true,"");
        return this;
    }
}
