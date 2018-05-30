package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPropertiesPage extends MainPageMaya {

    @Step("Ürün/Özellikler sayfası açılır.")
    public ProductPropertiesPage openPage() {
        ustMenu(MayaUstMenuData.Urun.Ozellikler);
        return this;
    }

    @Step("Ürün/Özellikler sayfasının geldiği görülür.")
    public ProductPropertiesPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Yeni Özellik']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
