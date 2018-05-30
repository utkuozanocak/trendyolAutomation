package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCommitmentsPage extends MainPageMaya {

    @Step("Ürün/Taahhütler sayfası açılır.")
    public ProductCommitmentsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.Taahhutler);
        return this;
    }

    @Step("Ürün/Taahhütler sayfasının geldiği görülür.")
    public ProductCommitmentsPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Taahhüt Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}

