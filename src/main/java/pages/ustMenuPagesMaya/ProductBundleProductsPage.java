package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductBundleProductsPage extends MainPageMaya {

    @Step("Ürün/Çoklu Ürün Aileleri sayfası açılır.")
    public ProductBundleProductsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.CokluUrunAileleri);
        return this;
    }

    @Step("Ürün/Çoklu Ürün Aileleri sayfasının geldiği görülür.")
    public ProductBundleProductsPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Çoklu Ürün Ailesi Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
