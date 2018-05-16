package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPageMaya;
import pages.pageComponents.solcrmElements.SolCrmElement;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.*;
import static pages.pageComponents.solcrmElements.SolCrmFramework.comboBox;

public class TrackOrdersPage extends MainPageMaya {

//    private SelenideElement BTN_YENIKAYIT_XPATH = $(By.xpath(GetObject("MAYA","BTN_YENIKAYIT_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
//    SolCrmElement CMB_SEHIR_ID = comboBox(By.id(GetObject("MAYA","CMB_SEHIR_ID","ID","MayaCustomerAddressManagementPage","PRP")));
//    SolCrmElement CMB_ILCE_ID = comboBox(By.id(GetObject("MAYA","CMB_ILCE_ID","ID","MayaCustomerAddressManagementPage","PRP")));
//    SolCrmElement CMB_MAHALLE_ID = comboBox(By.id(GetObject("MAYA","CMB_MAHALLE_ID","ID","MayaCustomerAddressManagementPage","PRP")));
//    SolCrmElement CMB_SOKAK_ID = comboBox(By.id(GetObject("MAYA","CMB_SOKAK_ID","ID","MayaCustomerAddressManagementPage","PRP")));
//    SolCrmElement CMB_BINANO_ID = comboBox(By.id(GetObject("MAYA","CMB_BINANO_ID","ID","MayaCustomerAddressManagementPage","PRP")));
//    private SelenideElement TXT_BLOK_XPATH = $(By.xpath(GetObject("MAYA","TXT_BLOK_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
//    private SelenideElement BTN_ADRESKAYDET_XPATH = $(By.xpath(GetObject("MAYA","BTN_ADRESKAYDET_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
//    private SelenideElement POP_ONAY_XPATH = $(By.xpath(GetObject("FOX","POP_ONAY_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
//    private SelenideElement BTN_EVET_XPATH = $(By.xpath(GetObject("MAYA","BTN_EVET_XPATH","XPATH","MayaCustomerAddressManagementPage","PRP")));
//    Select select = new Select($(By.id("orderForm:orderDataTable:orderTypeId_input")));
//    private  SelenideElement TXT_SIPARISNO_XPATH = $(By.xpath("//input[@id='orderForm:orderDataTable:siparisNoHeader:filter']"));
//    private SelenideElement CMB_ISLEMTIPI_XPATH = $(By.xpath("//div[@id='orderForm:orderDataTable:orderTypeId']//label[@id='orderForm:orderDataTable:orderTypeId_label']"));

    private SelenideElement TXT_SIPARISNO_ID = $(By.id("orderForm:orderDataTable:siparisNoHeader:filter"));
    private SolCrmElement CMB_ISLEMTIPI_XPATH = comboBox(By.xpath("//div[@id='orderForm:orderDataTable:orderTypeId']//label[@id='orderForm:orderDataTable:orderTypeId_label']"));
    private SolCrmElement CMB_STATU_XPATH = comboBox(By.xpath("//div[@id='orderForm:orderDataTable:orderStatusId']//label[@id='orderForm:orderDataTable:orderStatusId_label']"));
    private SelenideElement TXT_BASLAGICTARIHI_ID = $(By.id("orderForm:orderDataTable:baslangicTarihiHeader:filter"));
    private SelenideElement TXT_TAMAMLANMATARIHI_ID = $(By.id("orderForm:orderDataTable:tamamlanmaTarihiHeader:filter"));
    private SelenideElement TXT_YARATANORGANIZASYON_ID = $(By.id("orderForm:orderDataTable:yaratanOrganizasyonHeader:filter"));
    private ElementsCollection TBL_SIPARIS_SEC = $$("tbody[id='orderForm:orderDataTable_data'] tr[data-ri]']");


     @Step("Adres Bilgileri sayfası açılır.")
    public TrackOrdersPage openPage()
    {
        ustMenu(MayaUstMenuData.Islemler.MusteriSiparisleri);
        return this;
    }

    @Step("Sipariş No girilir.")
    public TrackOrdersPage siparisNoGir(String siparisno) {
        TXT_SIPARISNO_ID.sendKeys(siparisno);
        return this;
    }
    @Step("İşlem Tipi Seçilir.")
    public TrackOrdersPage islemTipiSec(String tip) {

         sleep(1000);
        CMB_ISLEMTIPI_XPATH.selectComboBox(tip);
        return this;
    }
    @Step("Statü Seçilir.")
    public TrackOrdersPage statuSec(String status) {
        sleep(1000);
        CMB_STATU_XPATH.selectComboBox(status);
        return this;
    }

    @Step("Başlangıç Tarihi Girilir.")
    public TrackOrdersPage baslangicTarihiSec(String baslangicTarih) {
        sleep(1000);
        TXT_BASLAGICTARIHI_ID.sendKeys(baslangicTarih);
        return this;
    }

    @Step("Tamamlanma Tarihi Girilir.")
    public TrackOrdersPage tamamlanmaTarihiSec(String tamamlanmaTarih) {
        sleep(1000);
        TXT_TAMAMLANMATARIHI_ID.sendKeys(tamamlanmaTarih);
        return this;
    }

    @Step("Yaratan Organizasyon Tarihi Girilir.")
    public TrackOrdersPage yaratanOrganizasyonSec(String yaratanOrganizasyon) {
        sleep(1000);
        TXT_YARATANORGANIZASYON_ID.sendKeys(yaratanOrganizasyon);
        return this;
    }

    @Step("Tablodan ilk Sipariş Seçilir.")
    public TrackOrdersPage siparisSec() {
        sleep(1000);
        TBL_SIPARIS_SEC.first()
                .$("a")
                .click();
        return this;
    }

//    @Step("Sokak seçilir.")
//    public TrackOrdersPage sokakSec(String sokak) {
//        CMB_SOKAK_ID.selectComboBox(sokak);
//        return this;
//    }
//
//    @Step("bina No seçilir.")
//    public TrackOrdersPage binaNoIlkKayitSec() {
//        CMB_BINANO_ID.getComboBoxValues().get(1).click();
//        return this;
//    }
//    @Step("bina No seçilir.")
//    public TrackOrdersPage blokEkle(String blok) {
//        TXT_BLOK_XPATH.setValue(blok);
//        return this;
//    }
//
//    @Step("Adres detayları kaydedilir.")
//    public TrackOrdersPage adresKaydet() {
//        Selenide.executeJavaScript("arguments[0].scrollIntoView(true);",BTN_ADRESKAYDET_XPATH);
//        //BTN_ADRESKAYDET_XPATH.shouldHave(Condition.appear);
//        clickJs(BTN_ADRESKAYDET_XPATH);
//        return this;
//    }
//
//    @Step("Adres detayları kaydedilir.")
//    public TrackOrdersPage adresOnay() {
//        POP_ONAY_XPATH.shouldHave(Condition.visible);
//        return this;
//    }
//
//    @Step("Adres detayları kaydedilir.")
//    public TrackOrdersPage adresEvetButonSec() {
//
//        //clickJs(BTN_EVET_XPATH);
//        clickJs($x("//body[@onload='closeMessagesDialog()']//div[69]//span[text()='Evet']//..//..//button[2]"));
//        return this;
//    }



    public TrackOrdersPage sablonTipi(String tip)
    {
        return this;
    }
}
