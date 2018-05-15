package pages.ustMenuPagesFox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageFox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class KullaniciDegistirPage extends MainPageFox {

    private SelenideElement BTN_ORGANIZASYON_ID = $(By.id(GetObject("FOX", "BTN_ORGANIZASYON_ID", "ID", "FoxChangeUserPage", "PRP")));
    private SelenideElement TXT_ORGANIZASYON_XPATH = $(By.xpath(GetObject("FOX", "TXT_ORGANIZASYON_XPATH", "XPATH", "FoxChangeUserPage", "PRP")));
    ElementsCollection LST_ORGANIZASYON_CSS = $$(GetObject("FOX", "LST_ORGANIZASYON_CSS", "CSS_SELECTOR", "FoxChangeUserPage", "PRP"));

    private SelenideElement BTN_POZISYON_ID = $(By.id(GetObject("FOX", "BTN_POZISYON_ID", "ID", "FoxChangeUserPage", "PRP")));
    private SelenideElement TXT_POZISYON_XPATH = $(By.xpath(GetObject("FOX", "TXT_POZISYON_XPATH", "XPATH", "FoxChangeUserPage", "PRP")));
    ElementsCollection LST_POZISYON_CSS = $$(GetObject("FOX", "LST_POZISYON_CSS", "CSS_SELECTOR", "FoxChangeUserPage", "PRP"));

    private SelenideElement BTN_ARA_ID = $(By.id(GetObject("FOX", "BTN_ARA_ID", "ID", "FoxChangeUserPage", "PRP")));

    ElementsCollection TBL_USERS_CSS = $$(GetObject("FOX", "TBL_USERS_CSS", "CSS_SELECTOR", "FoxChangeUserPage", "PRP"));

    @Step("Organizasyon seçilir. \"{organizasyon}\" ")
    public KullaniciDegistirPage organizasyonSec(String organizasyon) {

        BTN_ORGANIZASYON_ID.click();
        TXT_ORGANIZASYON_XPATH.sendKeys(organizasyon);
        LST_ORGANIZASYON_CSS.filterBy(Condition.text(organizasyon)).first().click();
        return this;
    }

    @Step("Pozisyon seçilir. \"{pozisyon}\" ")
    public KullaniciDegistirPage pozisyonSec(String pozisyon) {

        BTN_POZISYON_ID.click();
        TXT_POZISYON_XPATH.sendKeys(pozisyon);
        LST_POZISYON_CSS.filterBy(Condition.text(pozisyon)).first().click();
        return this;
    }

    @Step("Ara butonu tıklanır.")
    public KullaniciDegistirPage ara() {
        BTN_ARA_ID.click();
        return this;
    }

    @Step("Tablodan ilk kayıt seçilir.")
    public KullaniciDegistirPage tablodanIlkKayitSec() {
        String assignType = null;
        String userCode = null;
        int i = 0;
        do {
            userCode = TBL_USERS_CSS.get(i).$("td:nth-child(2)").text();
            assignType = GetFoxUserAssignType(userCode)[0];
            System.out.println(assignType);
            i++;
        } while (assignType.equals("O"));
        i--;
        TBL_USERS_CSS.get(i).$("a").click();
        return this;
    }

}
