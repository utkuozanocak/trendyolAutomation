package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCrossSaleRelationsPage extends MainPageMaya {

    @Step("Ürün/Çapraz Satış İlişkileri sayfası açılır.")
    public ProductCrossSaleRelationsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.CaprazSatisIliskileri);
        return this;
    }

    @Step("Ürün/Çapraz Satış İlişkileri sayfasının geldiği görülür.")
    public ProductCrossSaleRelationsPage sayfaKontrolu() {
        //$x("//span[text()='Çapraz Satış İlişki Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Çapraz Satış İlişki Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
