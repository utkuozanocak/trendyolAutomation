package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductDetailPage extends BaseLibrary {
    ElementsCollection IMG_BUTIKDETAIL_LST = $$(By.xpath("//li[@class='product-box']//div//img"));
    SelenideElement OBJ_PRODUCTDETAIL_ID = $(By.id("product-detail-app"));
    SelenideElement BTN_ADDBASKET_XPATH = $(By.xpath("//div[text()='Sepete Ekle']"));

    @Step("Rastgele ürün detayı giriş")
    public ProductDetailPage randomProductDetailEntrance() {
        Random r = new Random();
        int rndProduct = r.nextInt(IMG_BUTIKDETAIL_LST.size());
        IMG_BUTIKDETAIL_LST.get(rndProduct).click();
        Assert.assertTrue(OBJ_PRODUCTDETAIL_ID.shouldBe(Condition.visible).isDisplayed(),"Ürün Detay Sayfası Yüklenemedi");
        return this;
    }

    @Step("Sepete ekle")
    public ProductDetailPage addBasket() {
        BTN_ADDBASKET_XPATH.click();
        return this;
    }
}
