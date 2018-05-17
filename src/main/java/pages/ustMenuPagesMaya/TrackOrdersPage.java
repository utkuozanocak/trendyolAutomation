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
    private ElementsCollection TBL_SIPARIS_SEC_CSS = $$("tbody[id='orderForm:orderDataTable_data'] tr[data-ri]");
    private SelenideElement TBL_SIPARIS_SEC1_CSS = $("tbody[id='orderForm:orderDataTable_data'] tr[data-ri] td[role] a");
    private SelenideElement BTN_YENILE_XPATH = $(By.xpath("//div[@class='col-md-12 text-right']//button[@type='submit']"));
    private SelenideElement BTN_SIPARISGECMISI_XPATH = $(By.xpath("//div[@id='orderDetailForm:orderDetailFormTabView']//ul//li[2]//a[text()='Sipariş Geçmişi']"));
    private SelenideElement BTN_PROJELER_XPATH = $(By.xpath("//div[@id='orderDetailForm:orderDetailFormTabView']//ul//li[3]//a[text()='Projeler']"));
    private SelenideElement BTN_SIPARISSATIRLARI_XPATH = $(By.xpath("//div[@id='orderDetailForm:orderDetailFormTabView']//ul//li[1]//a[text()='Sipariş Satırları']"));
    private SelenideElement BTN_OZELLIK_XPATH = $(By.xpath("//td[@role='gridcell']//button[@title='Özellik']"));
    private SelenideElement BTN_OZELLIKKAPAT_XPATH = $(By.xpath("//div[@class='ui-datatable-footer ui-widget-header ui-corner-bottom']//div//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']"));
    private SelenideElement BTN_SIPARISDETAY_XPATH = $(By.xpath("//span[contains(@class,'treetable')]"));
    private SelenideElement BTN_URUNEGIT_XPATH = $(By.xpath("//a[text()='Ürüne git']"));

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
        TBL_SIPARIS_SEC1_CSS.click();
        return this;
    }

    @Step("Yenile Butonuna Tıklanır.")
    public TrackOrdersPage yenileButtonTıkla() {
        sleep(1000);
        BTN_YENILE_XPATH.click();
        return this;
    }

    @Step("Sipariş Geçişine Tıklanır")
    public TrackOrdersPage siparisGecmisTıkla() {
        sleep(1000);
        BTN_SIPARISGECMISI_XPATH.click();
        return this;
    }

    @Step("Projelere Tıklanır")
    public TrackOrdersPage projelerTıkla() {
        sleep(1000);
        BTN_PROJELER_XPATH.click();
        return this;
    }

    @Step("Projelere Tıklanır")
    public TrackOrdersPage siparisSatirlariTıkla() {
        sleep(1000);
        BTN_SIPARISSATIRLARI_XPATH.click();
        return this;
    }

    @Step("Özellik Butonuna Tıklanır.")
    public TrackOrdersPage siparisOzelliklerTikla() {
        BTN_OZELLIK_XPATH.click();
        return this;
    }

    @Step("Özellik Popup Kapatılır.")
    public TrackOrdersPage siparisOzelliklerKapat() {
        BTN_OZELLIKKAPAT_XPATH.click();
        return this;
    }

    @Step("Siparis Detayları Açılır.")
    public TrackOrdersPage siparisDetayGoruntule() {
        BTN_SIPARISDETAY_XPATH.click();
        return this;
    }

    @Step("Ürüne git Buttonuna Tıklanır.")
    public TrackOrdersPage uruneGit() {
        BTN_URUNEGIT_XPATH.click();
        return this;
    }



    public TrackOrdersPage sablonTipi(String tip)
    {
        return this;
    }
}
