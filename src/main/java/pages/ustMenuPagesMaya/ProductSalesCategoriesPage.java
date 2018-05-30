package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductSalesCategoriesPage extends MainPageMaya {

    @Step("Ürün/Satış Kategorileri sayfası açılır.")
    public ProductSalesCategoriesPage openPage() {
        ustMenu(MayaUstMenuData.Urun.SatisKategorileri);
        return this;
    }

    @Step("Ürün/Satış Kategorileri sayfasının geldiği görülür.")
    public ProductSalesCategoriesPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Yeni Kategori']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}