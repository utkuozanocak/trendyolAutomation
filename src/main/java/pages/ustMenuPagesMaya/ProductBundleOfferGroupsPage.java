package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductBundleOfferGroupsPage extends MainPageMaya {

    @Step("Ürün/Kampanya Grupları sayfası açılır.")
    public ProductBundleOfferGroupsPage openPage() {
        ustMenu(MayaUstMenuData.Urun.KapanyaGruplari);
        return this;
    }

    @Step("Ürün/Kampanya Grupları sayfasının geldiği görülür.")
    public ProductBundleOfferGroupsPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//span[text()='Kampanya Grupları Listesi']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}