package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPageMaya;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChangeBundleOfferSelectionPage extends MainPageMaya {
    ElementsCollection TBL_MEVCUTPRODUCTLIST = $$(GetObject("MAYA","TBL_MEVCUTPRODUCTLIST","CSS_SELECTOR","CustomerAssetsPage","PRP"));
    ElementsCollection TBL_HIZLISTE = $$(GetObject("MAYA","TBL_HIZLISTE","CSS_SELECTOR","ChangeBundleOfferSelectionPage","PRP"));
    private SelenideElement BTN_ILERI = $(By.xpath(GetObject("MAYA","BTN_ILERI","XPATH","ChangeBundleOfferSelectionPage","PRP")));
    @Step("Mevcut Ürün tablosundan \"{urunAilesiAdi}\" ürünün değiştir butonu tıklanır.")
    public ChangeBundleOfferSelectionPage tablodanDegistirButonuTikla(String urunAilesiAdi) {
        TBL_MEVCUTPRODUCTLIST
                .filterBy(Condition.text(urunAilesiAdi))
                .first()
                .$("button:nth-child(2)")
                .click();
        return this;
    }
    @Step("Hız tablosundan ilk hız seçilir")
    public ChangeBundleOfferSelectionPage tablodanIlkHiziSec() {
        TBL_HIZLISTE
                .first()
                .$("button")
                .click();
        return this;
    }
    @Step("İleri Butonu Tıklanır")
    public ChangeBundleOfferSelectionPage btnIleriTikla() {
        BTN_ILERI.click();
        return this;
    }
}
