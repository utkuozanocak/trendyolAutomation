package pages.ustMenuPagesMaya;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageComponents.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.pageComponents.SolCrmFramework.comboBox;
import static pages.pageComponents.SolCrmFramework.comboText;

public class AdresBilgileriPage extends MainPageMaya
{
    private SelenideElement BTN_YENIKAYIT_XPATH = $(By.xpath(GetObject("MAYA","BTN_YENIKAYIT_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
    SolCrmElement  CMB_SEHIR_ID = comboBox(By.id(GetObject("MAYA","CMB_SEHIR_ID","ID","MayaCustomerAddressManagementPage","PRP")));
    SolCrmElement CMB_ILCE_ID = comboBox(By.id(GetObject("MAYA","CMB_ILCE_ID","ID","MayaCustomerAddressManagementPage","PRP")));
    SolCrmElement CMB_MAHALLE_ID = comboBox(By.id(GetObject("MAYA","CMB_MAHALLE_ID","ID","MayaCustomerAddressManagementPage","PRP")));
    SolCrmElement CMB_SOKAK_ID = comboBox(By.id(GetObject("MAYA","CMB_SOKAK_ID","ID","MayaCustomerAddressManagementPage","PRP")));
    SolCrmElement CMB_BINANO_ID = comboBox(By.id(GetObject("MAYA","CMB_BINANO_ID","ID","MayaCustomerAddressManagementPage","PRP")));
    private SelenideElement TXT_BLOK_XPATH = $(By.xpath(GetObject("MAYA","TXT_BLOK_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
    private SelenideElement BTN_ADRESKAYDET_XPATH = $(By.xpath(GetObject("MAYA","BTN_ADRESKAYDET_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
    private SelenideElement POP_ONAY_XPATH = $(By.xpath(GetObject("FOX","POP_ONAY_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
    private SelenideElement BTN_EVET_XPATH = $(By.xpath(GetObject("MAYA","BTN_EVET_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
    @Step("Adres Bilgileri sayfası açılır.")
    public AdresBilgileriPage openPage()
    {
        ustMenu(MayaUstMenuData.Islemler.AdresBilgileri);
        return this;
    }

    @Step("yeni kayıt butonuna tıklanır.")
    public AdresBilgileriPage yeniAdresEkle() {
        BTN_YENIKAYIT_XPATH.click();
        return this;
    }
    @Step("Şehir tıklanır.")
    public AdresBilgileriPage sehirSec(String sehir) {
        CMB_SEHIR_ID.selectComboBox(sehir);
        return this;
    }
    @Step("İlçe seçilir.")
    public AdresBilgileriPage ilceSec(String ilce) {
        CMB_ILCE_ID.selectComboBox(ilce);
        return this;
    }

    @Step("Mahalle seçilir.")
    public AdresBilgileriPage mahalleSec(String mahalle) {
        CMB_MAHALLE_ID.selectComboBox("Altayçeşme");
        return this;
    }

    @Step("Sokak seçilir.")
    public AdresBilgileriPage sokakSec(String sokak) {

        CMB_SOKAK_ID.selectComboBox(sokak);

        return this;
    }

    @Step("bina No seçilir.")
    public AdresBilgileriPage binaNoIlkKayitSec() {

        CMB_BINANO_ID.getComboBoxValues().get(1).click();
        return this;
    }
    @Step("bina No seçilir.")
    public AdresBilgileriPage blokEkle(String blok) {
        TXT_BLOK_XPATH.setValue(blok);
        return this;
    }

    @Step("Adres detayları kaydedilir.")
    public AdresBilgileriPage adresKaydet() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView(true);",BTN_ADRESKAYDET_XPATH);
        //BTN_ADRESKAYDET_XPATH.shouldHave(Condition.appear);
        clickJs(BTN_ADRESKAYDET_XPATH);
        return this;
    }

    @Step("Adres detayları kaydedilir.")
    public AdresBilgileriPage adresOnay() {
        POP_ONAY_XPATH.shouldHave(Condition.visible);
        return this;
    }

    @Step("Adres detayları kaydedilir.")
    public AdresBilgileriPage adresEvetButonSec() {

        //clickJs(BTN_EVET_XPATH);
        clickJs($x("//body[@onload='closeMessagesDialog()']//div[69]//span[text()='Evet']//..//..//button[2]"));
        return this;
    }
    @Step("Adres bilgileri sayfası açılır.")
    public AdresBilgileriPage siparisAdresEkle() {
        ustMenu(MayaUstMenuData.Islemler.AdresBilgileri);
        return this;
    }


    public AdresBilgileriPage sablonTipi(String tip)
    {
        return this;
    }
}
