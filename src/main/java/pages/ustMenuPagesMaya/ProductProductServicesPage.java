package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductProductServicesPage extends MainPageMaya {

    @Step("Ürün-CFS/PR sayfası açılır.")
    public ProductProductServicesPage openPage() {
        ustMenu(MayaUstMenuData.Urun.CFSPR);
        return this;
    }

    @Step("Ürün-CFS/PR sayfasının geldiği görülür.")
    public ProductProductServicesPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='CFS/PR Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}