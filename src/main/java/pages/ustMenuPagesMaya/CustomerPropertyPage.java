package pages.ustMenuPagesMaya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;

public class CustomerPropertyPage extends MainPageMaya {
    private SelenideElement BTN_YENIOZELLIK = $(By.xpath(GetObject("MAYA","BTN_YENIOZELLIK","XPATH","CustomerPropertyPage","PRP")));
    private SelenideElement TXT_OZELLIKADI = $(By.xpath(GetObject("MAYA","TXT_OZELLIKADI","XPATH","CustomerPropertyPage","PRP")));
    private SelenideElement TXT_OZELLIKKODU = $(By.xpath(GetObject("MAYA","TXT_OZELLIKKODU","XPATH","CustomerPropertyPage","PRP")));
    private SelenideElement TXT_MINIMUMDEGER = $(By.xpath(GetObject("MAYA","TXT_MINIMUMDEGER","XPATH","CustomerPropertyPage","PRP")));
    private SelenideElement TXT_MAKSIMUMDEGER = $(By.xpath(GetObject("MAYA","TXT_MAKSIMUMDEGER","XPATH","CustomerPropertyPage","PRP")));
    private SelenideElement BTN_KAYDET = $(By.xpath(GetObject("MAYA","BTN_KAYDET","XPATH","CustomerPropertyPage","PRP")));
    private SelenideElement LBL_MSG = $(By.xpath(GetObject("MAYA","LBL_MSG","XPATH","CustomerPropertyPage","PRP")));
    @Step("Müşteri bilgileri sayfası açılır.")
    public CustomerPropertyPage musteriOzellikSayfasıAc() {
        ustMenu(MayaUstMenuData.Musteri.Ozellikler);
        return this;
    }
    @Step("Yeni Özellik Butonu Tıklanır")
    public CustomerPropertyPage btnYeniOzellikTikla() {
        BTN_YENIOZELLIK.click();
        return this;
    }
    @Step("Özellik adı alanına \"{ozellikAdi}\" yazılır.")
    public CustomerPropertyPage txtOzellikAdiDoldur(String ozellikAdi) {
        TXT_OZELLIKADI.setValue(ozellikAdi);
        return this;
    }
    @Step("Özellik kodu alanına \"{ozellikKodu}\" yazılır.")
    public CustomerPropertyPage txtOzellikKoduDoldur(String ozellikKodu) {
        TXT_OZELLIKKODU.setValue(ozellikKodu);
        return this;
    }
    @Step("Minimum Değer alanına \"{minimumDeger}\" yazılır.")
    public CustomerPropertyPage txtMinimumDegerDoldur(String minimumDeger) {
        TXT_MINIMUMDEGER.setValue(minimumDeger);
        return this;
    }
    @Step("Maksimum Değer alanına \"{maksimumDeger}\" yazılır.")
    public CustomerPropertyPage txtMaksimumDegerDoldur(String maksimumDeger) {
        TXT_MAKSIMUMDEGER.setValue(maksimumDeger);
        return this;
    }
    @Step("Kaydet Butonu Tıklanır")
    public CustomerPropertyPage btnKaydetTikla() {
        BTN_KAYDET.click();
        return this;
    }
    @Step("Mesaj kontrolü yapılır.")
    public void mesajKontrol(String mesaj) {
        Assert.assertEquals(LBL_MSG.text().contains(mesaj),true);
        takeScreenshot();
    }

}
