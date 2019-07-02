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


public class BoutiqueDetailPage extends BaseLibrary {
    SelenideElement OBJ_BUTIKDETAIL_ID = $(By.id("boutiqueDetailContainer"));
    ElementsCollection IMG_BUTIK_XPATH_LST = $$(By.xpath("//div[@class='component-list component-big-list']//article[@class='component-item']//img"));
    ElementsCollection IMG_BUTIKDETAIL_LST = $$(By.xpath("//li[@class='product-box']//div//img"));
    @Step("Rastgele butik içeriği imaj kontrolu")
    public BoutiqueDetailPage randomButikEntranceImageControl() {
        Random r = new Random();
        int rndButikNo = r.nextInt(IMG_BUTIK_XPATH_LST.size());
        IMG_BUTIK_XPATH_LST.get(rndButikNo).click();
        Assert.assertTrue(OBJ_BUTIKDETAIL_ID.shouldBe(Condition.visible).isDisplayed(),"Butik Detay Sayfası Yüklenemedi");
        for (int i=0; i<IMG_BUTIKDETAIL_LST.size(); i++) {
            if (IMG_BUTIKDETAIL_LST.get(i).shouldBe(Condition.visible).isDisplayed()) {
                IMG_BUTIKDETAIL_LST.get(i).scrollTo();
                log.info(  i+". Sıradaki butik detay ürün imajı başarılı yüklendi");
            } else {
                log.info(  i+". Sıradaki butik detay ürün imajı yüklenemedi");
            }
        }
        return this;
    }
}
