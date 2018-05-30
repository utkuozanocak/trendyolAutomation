package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPropertyListsPage extends MainPageMaya {

    @Step("Ürün/Değer Listeleri sayfası açılır.")
    public ProductPropertyListsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.DegerListeleri);
        return this;
    }

    @Step("Ürün/Değer Listeleri sayfasının geldiği görülür.")
    public ProductPropertyListsPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Yeni Değer Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}