package pages.ustMenuPagesMaya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageComponents.solcrmElements.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static pages.pageComponents.solcrmElements.SolCrmFramework.comboBox;

public class CustomerAssetsPage extends MainPageMaya {
    private SelenideElement BTN_ARAMA = $(By.id(GetObject("MAYA","BTN_ARAMA","ID","CustomerAssetsPage","PRP")));
    SolCrmElement CMB_STATU = comboBox(By.id(GetObject("MAYA","CMB_STATU","ID","CustomerAssetsPage","PRP")));
    SolCrmElement CMB_URUN = comboBox(By.id(GetObject("MAYA","CMB_URUN","ID","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_ARA = $(By.xpath(GetObject("MAYA","BTN_ARA","XPATH","CustomerAssetsPage","PRP")));
    ElementsCollection TBL_PRODUCTLIST = $$(GetObject("MAYA","TBL_PRODUCTLIST","CSS_SELECTOR","CustomerAssetsPage","PRP"));
    private SelenideElement BTN_ETKILESIMLER = $(By.xpath(GetObject("MAYA","BTN_ETKILESIMLER","XPATH","CustomerAssetsPage","PRP")));
    private SelenideElement BTN_KAMPANYAICIURUNDEGISIKLIGI = $(By.xpath(GetObject("MAYA","BTN_KAMPANYAICIURUNDEGISIKLIGI","XPATH","CustomerAssetsPage","PRP")));
    @Step("Müşteri ürünleri sayfası açılır.")
    public CustomerAssetsPage musteriUrunleriSayfasiAc() {
        ustMenu(MayaUstMenuData.Islemler.MusteriUrunleri);
        return this;
    }
    @Step("Arama Butonu Tıklanır")
    public CustomerAssetsPage btnAramaTikla() {
        BTN_ARAMA.click();
        return this;
    }
    @Step("Statü alanında \"{statu}\" seçilir.")
    public CustomerAssetsPage statuSec(String statu) {
        CMB_STATU.selectComboBox(statu);
        return this;
    }
    @Step("Ürün alanında \"{urun}\" seçilir.")
    public CustomerAssetsPage urunSec(String urun) {
        CMB_URUN.selectComboBox(urun);
        return this;
    }
    @Step("Ara Butonu Tıklanır")
    public CustomerAssetsPage btnAraTikla() {
        BTN_ARA.click();
        return this;
    }
    @Step("Ürün tablosundan ilk ürünün işlemler butonu tıklanır.")
    public CustomerAssetsPage tablodanIlkUrunIslemlerTikla() {
        TBL_PRODUCTLIST
                .first()
                .$("button")
                .click();
        return this;
    }
    @Step("Etkileşimler Butonu Tıklanır")
    public CustomerAssetsPage btnEtkilesimlerTikla() {
        BTN_ETKILESIMLER.click();
        return this;
    }
    @Step("Kampanya İçi Ürün Değişikliği Butonu Tıklanır")
    public CustomerAssetsPage btnKampanyaIciUrunDegisikligiTikla() {
        BTN_KAMPANYAICIURUNDEGISIKLIGI.click();
        return this;
    }

}
