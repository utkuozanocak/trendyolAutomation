package pages.ustMenuPagesFox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPageFox;
import pages.pageData.FoxUstMenuData;
import pages.ustMenuPagesMaya.SozlesmelerimPage;

import static com.codeborne.selenide.Selenide.$$;

public class AkisListesiPage extends MainPageFox {

    ElementsCollection TBL_AKISLISTESI = $$("table[id='workflowbox-grid'] tbody tr[role='row']");

    @Step("Akis Listesi sayfası açılır.")
    public AkisListesiPage openPage() {
        ustMenuFox(FoxUstMenuData.UstMenuGroupFox.AkisListesi);
        return this;
    }

    @Step("Akış Detayı açılır.")
    public AkisListesiPage akisDetay(String akisNo) {
        TBL_AKISLISTESI
                .filterBy(Condition.text(akisNo))
                .first()
                .$("img")
                .click();
        return this;

    }


}
