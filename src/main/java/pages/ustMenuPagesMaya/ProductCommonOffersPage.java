package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCommonOffersPage extends MainPageMaya {

    @Step("Ürün/Ürünler sayfası açılır.")
    public ProductCommonOffersPage openPage() {
        ustMenu(MayaUstMenuData.Urun.Urunler);
        return this;
    }

    @Step("Ürün/Ürünler sayfasının geldiği görülür.")
    public ProductCommonOffersPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Ürün Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
