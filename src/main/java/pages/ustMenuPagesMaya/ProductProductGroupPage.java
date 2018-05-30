package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductProductGroupPage extends MainPageMaya {

    @Step("Ürün/Ürün Grupları sayfası açılır.")
    public ProductProductGroupPage openPage() {
        ustMenu(MayaUstMenuData.Urun.UrunGruplari);
        return this;
    }

    @Step("Ürün/Ürün Grupları sayfasının geldiği görülür.")
    public ProductProductGroupPage sayfaKontrolu() {
        //$x("//span[text()='Promocode Havuz Listesi']").shouldBe(Condition.visible);
        Assert.assertEquals($x("//td[text()='AYRINTILI FATURA']").isDisplayed(),true);
        takeScreenshot();
        return this;
    }
}
