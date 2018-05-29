package pages.ustMenuPagesMaya;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.pageComponents.SolCrmFramework.comboBox;

public class SearchCustomerCorparatePage extends MainPageMaya {

    private SelenideElement TXT_UNVAN_ID = $(By.id(GetObject("MAYA", "TXT_UNVAN_ID", "ID", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement BTN_SEARCH = $(By.id(GetObject("MAYA", "BTN_SEARCH", "ID", "MayaSearchCustomerCorporate", "PRP")));
    //private SelenideElement BTN_STATU = $(By.id(GetObject("MAYA","BTN_STATU","ID","MayaSearchCustomerCorporate","PRP")));
//  //private SelenideElement BTN_SEGMENT = $(By.id(GetObject("MAYA","BTN_SEGMENT","ID","MayaSearchCustomerCorporate","PRP")));
    private SelenideElement TXT_SEARCHRESULT_ID = $(By.id(GetObject("MAYA", "TXT_SEARCHRESULT_ID", "ID", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement BTN_ISLEMLER_XPATH = $(By.xpath(GetObject("MAYA", "BTN_ISLEMLER_XPATH", "XPATH", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement BTN_SIPARISOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISOLUSTUR_XPATH", "XPATH", "MayaSearchCustomerCorporate", "PRP")));
    ElementsCollection TBL_MUSTERILISTESI = $$(GetObject("MAYA", "TBL_MUSTERILISTESI", "CSS_SELECTOR", "MayaSearchCustomerCorporate", "PRP"));
    ElementsCollection tblCustomerList = $$(GetObject("MAYA", "TBL_SEARCH_CUSTOMER", "CSS_SELECTOR", "MayaSearchCustomerCorporate", "PRP"));
    SolCrmElement cmbStatu = comboBox(By.id(GetObject("MAYA", "BTN_STATU", "ID", "MayaSearchCustomerCorporate", "PRP")));
    SolCrmElement cmbSegment = comboBox(By.id(GetObject("MAYA", "BTN_SEGMENT", "ID", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement TXT_MUSTERINO_XPATH = $(By.xpath(GetObject("MAYA", "TXT_MUSTERINO_XPATH", "XPATH", "MayaSearchCustomerCorporate", "PRP")));

    @Step("Ünvan alanına \"{unvan}\" yazılır.")
    public SearchCustomerCorparatePage unvanDoldur(String unvan) {
        TXT_UNVAN_ID.sendKeys(unvan);
        return this;
    }

    @Step("Müşteri no alanına \"{musteriNo}\" yazılır.")
    public SearchCustomerCorparatePage musteriNoDoldur(String musetriNo) {
        TXT_MUSTERINO_XPATH.sendKeys(musetriNo);
        return this;
    }

    @Step("Statü alanında \"{statu}\" seçilir.")
    public SearchCustomerCorparatePage statuSec(String statu) {
        cmbStatu.selectComboBox(statu);
        return this;
    }

    @Step("Statü alanında \"{segment}\" seçilir.")
    public SearchCustomerCorparatePage segmentSec(String segment) {
        cmbSegment.selectComboBox(segment);
        return this;
    }

    @Step("Ara butonu tıklanır.")
    public SearchCustomerCorparatePage ara() {
        BTN_SEARCH.click();
        return this;
    }

    @Step("Tablodan ilk kayıt tıklanır.")
    public SearchCustomerCorparatePage tablodanIlkKayitTikla() {
        tblCustomerList.first().click();
//        tblCustomerList.get(2).click();
        return this;
    }

    @Step("Tablodan müşterinoya göre kayıt seçilir.")
    public SearchCustomerCorparatePage tablodanMusteriNoyaGoreKayitTikla(String customerNo) {
        tblCustomerList.filterBy(text(customerNo)).first().click();
        return this;
    }

    @Step("Tablodan ilk sıradaki müştesri no alınır.")
    public String tabloIlkMusteriNoAl() {
        return TBL_MUSTERILISTESI.first().$("td:nth-child(2)").getText();
    }

    @Step("Tablodan ilk sıradaki müştesri no alınır.")
    public String tabloRandomMusteriNoSecVeAl() {
        Random rand = new Random();
//        sleep(2000);
        TBL_MUSTERILISTESI.shouldBe(CollectionCondition.sizeGreaterThan(0));
        int sayi = TBL_MUSTERILISTESI.size() - 1;
        sayi = rand.nextInt(sayi) + 1;
        SelenideElement tabloElement = TBL_MUSTERILISTESI.get(sayi);
        tabloElement.click();
        return tabloElement.$("td:nth-child(2)").getText();

    }


}
