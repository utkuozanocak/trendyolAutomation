package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductActivationCodeDefinitionsPage extends MainPageMaya {

    @Step("Ürün/Promocode sayfası açılır.")
    public ProductActivationCodeDefinitionsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.Promocode);
        return this;
    }

    @Step("Ürün/Promocode sayfasının geldiği görülür.")
    public ProductActivationCodeDefinitionsPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Promocode Havuz Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
