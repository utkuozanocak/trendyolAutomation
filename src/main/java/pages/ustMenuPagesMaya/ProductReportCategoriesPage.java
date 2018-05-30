package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductReportCategoriesPage extends MainPageMaya {

    @Step("Ürün/Rapor Kategorileri sayfası açılır.")
    public ProductReportCategoriesPage openPage() {
        ustMenu(MayaUstMenuData.Urun.RaporKategorileri);
        return this;
    }

    @Step("Ürün/Rapor Kategorileri sayfasının geldiği görülür.")
    public ProductReportCategoriesPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Yeni Kategori']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
