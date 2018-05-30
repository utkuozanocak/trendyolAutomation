package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsProductsPage extends MainPageMaya {

    @Step("Ürün/Ürün Aileleri sayfası açılır.")
    public ProductsProductsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.UrunAileleri);
        return this;
    }

    @Step("Ürün/Ürün Aileleri sayfasının geldiği görülür.")
    public ProductsProductsPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Ürün Ailesi Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
