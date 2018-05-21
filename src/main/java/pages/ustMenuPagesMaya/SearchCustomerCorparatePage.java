package pages.ustMenuPagesMaya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static pages.pageComponents.SolCrmFramework.comboBox;

public class SearchCustomerCorparatePage extends MainPageMaya {

    private SelenideElement TXT_UNVAN_ID = $(By.id(GetObject("MAYA", "TXT_UNVAN_ID", "ID", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement BTN_SEARCH = $(By.id(GetObject("MAYA", "BTN_SEARCH", "ID", "MayaSearchCustomerCorporate", "PRP")));
    //private SelenideElement BTN_STATU = $(By.id(GetObject("MAYA","BTN_STATU","ID","MayaSearchCustomerCorporate","PRP")));
//  //private SelenideElement BTN_SEGMENT = $(By.id(GetObject("MAYA","BTN_SEGMENT","ID","MayaSearchCustomerCorporate","PRP")));
    private SelenideElement TXT_SEARCHRESULT_ID = $(By.id(GetObject("MAYA", "TXT_SEARCHRESULT_ID", "ID", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement BTN_ISLEMLER_XPATH = $(By.xpath(GetObject("MAYA", "BTN_ISLEMLER_XPATH", "XPATH", "MayaSearchCustomerCorporate", "PRP")));
    private SelenideElement BTN_SIPARISOLUSTUR_XPATH = $(By.xpath(GetObject("MAYA", "BTN_SIPARISOLUSTUR_XPATH", "XPATH", "MayaSearchCustomerCorporate", "PRP")));

    ElementsCollection tblCustomerList = $$(GetObject("MAYA","TBL_SEARCH_CUSTOMER","CSS_SELECTOR","MayaSearchCustomerCorporate","PRP"));
    SolCrmElement cmbStatu = comboBox(By.id(GetObject("MAYA","BTN_STATU","ID","MayaSearchCustomerCorporate","PRP")));
    SolCrmElement cmbSegment = comboBox(By.id(GetObject("MAYA", "BTN_SEGMENT", "ID", "MayaSearchCustomerCorporate", "PRP")));

    @Step("Ünvan alanına \"{unvan}\" yazılır.")
    public SearchCustomerCorparatePage unvanDoldur(String unvan) {
        TXT_UNVAN_ID.sendKeys(unvan);
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
        return this;
    }

}
