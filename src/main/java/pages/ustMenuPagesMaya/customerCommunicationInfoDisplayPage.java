package pages.ustMenuPagesMaya;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;
import static com.codeborne.selenide.Selenide.$;

public class customerCommunicationInfoDisplayPage extends MainPageMaya {
    private SelenideElement BTN_MUSTERITEL_XPATH = $(By.xpath(GetObject("MAYA","BTN_MUSTERITEL_XPATH","XPATH","customerCommunicationInfoDisplay","PRP")));
    private SelenideElement BTN_GUNCELLE_XPATH = $(By.xpath(GetObject("MAYA","BTN_GUNCELLE_XPATH","XPATH","customerCommunicationInfoDisplay","PRP")));
    private SelenideElement BTN_GUNCELLEONAY_XPATH = $(By.id(GetObject("FOX","BTN_GUNCELLEONAY_XPATH","ID","customerCommunicationInfoDisplay","PRP")));
    private SelenideElement TXT_TELDEGER_XPATH = $(By.xpath(GetObject("MAYA","TXT_TELDEGER_XPATH","XPATH","customerCommunicationInfoDisplay","PRP")));

    @Step("Kurumsal İletişim Bilgileri sayfası açılır.")
    public customerCommunicationInfoDisplayPage openPage() {
        ustMenu(MayaUstMenuData.Islemler.KurumIletisimBilgileri);
        return this;
    }

    @Step("İletişim bilgisi seçilir.")
    public customerCommunicationInfoDisplayPage iletisimBilgisiSec() {
        BTN_MUSTERITEL_XPATH.click();
        return this;
    }

    @Step("Güncelle butonuna tıklanır.")
    public customerCommunicationInfoDisplayPage güncelleSec() {
        BTN_GUNCELLE_XPATH.click();
        return this;
    }

    @Step("Yeni iletişim bilgisi girilir.")
    public customerCommunicationInfoDisplayPage yeniNumaraGirisi() {
        TXT_TELDEGER_XPATH.sendKeys("2165555555");
        return this;
    }

    @Step("Güncelle popup onay butonuna tıklanır.")
    public customerCommunicationInfoDisplayPage güncellePopUpOnaySec() {
        BTN_GUNCELLEONAY_XPATH.click();
        return this;
    }

}

