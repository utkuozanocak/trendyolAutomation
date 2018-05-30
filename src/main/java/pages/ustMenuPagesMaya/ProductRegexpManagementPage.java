package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductRegexpManagementPage extends MainPageMaya {

    @Step("Ürün/Regexp sayfası açılır.")
    public ProductRegexpManagementPage openPage() {
        ustMenu(MayaUstMenuData.Urun.Regexp);
        return this;
    }

    @Step("Ürün/Regexp sayfasının geldiği görülür.")
    public ProductRegexpManagementPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Regular Expression']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
