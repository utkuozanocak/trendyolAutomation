package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPaymentPlanTemplatesPage extends MainPageMaya {

    @Step("Ürün/Ödeme Şablonları sayfası açılır.")
    public ProductPaymentPlanTemplatesPage openPage() {
        ustMenu(MayaUstMenuData.Urun.OdemeSablonlari);
        return this;
    }

    @Step("Ürün/Ödeme Şablonları sayfasının geldiği görülür.")
    public ProductPaymentPlanTemplatesPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Ödeme Şablon Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
