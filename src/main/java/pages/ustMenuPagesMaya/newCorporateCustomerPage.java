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

public class newCorporateCustomerPage extends MainPageMaya
{
    private SelenideElement LBL_TC_XPATH = $(By.xpath(GetObject("MAYA","LBL_TC_XPATH","XPATH","newCorporateCustomerPage","PRP")));
    private SelenideElement TXT_TCGIR_XPATH = $(By.xpath(GetObject("MAYA","TXT_TCGIR_XPATH","XPATH","newCorporateCustomerPage","PRP")));
    private SelenideElement BTN_TCSORGULA = $(By.xpath(GetObject("MAYA","BTN_TCSORGULA","XPATH","newCorporateCustomerPage","PRP")));
    private SelenideElement BTN_TEMIZLE = $(By.xpath(GetObject("MAYA","BTN_TEMIZLE","XPATH","newCorporateCustomerPage","PRP")));

    @Step("Kurumsal yeni müşteri oluşturma sayfası açılır.")
    public newCorporateCustomerPage openPage() {
        ustMenu(MayaUstMenuData.Musteri.MusteriOlusturma);
        return this;
    }
    @Step("Yeni Kurumsal Müşteri Oluşturma sayfasının gelidiği görülür.")
    public newCorporateCustomerPage sayfaKontrolu() {
        Assert.assertEquals(LBL_TC_XPATH.isDisplayed(),true, "Sayfa Açıldı.");
        takeScreenshot();
        return this;
    }


}
