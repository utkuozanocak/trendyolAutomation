package pages.ustMenuPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.pageData.UstMenuData;

import static com.codeborne.selenide.Selenide.$;

public class OrderCapturePage extends MainPage {

    private SelenideElement BTN_SIPARISEURUNEKLE_ID = $(By.id(GetObject("MAYA", "BTN_SIPARISEURUNEKLE_ID", "ID", "MayaOrderCapturePage", "PRP")));


    @Step("Siparis Oluştur sayfası açılır.")
    public OrderCapturePage siparisOlusturTikla() {
        ustMenu(UstMenuData.Islemler.SiparisOlustur);
        return this;
    }

    @Step("Siparise ürün ekle butonu tıklanır.")
    public OrderCapturePage siparseUrunEkleTikla() {
        BTN_SIPARISEURUNEKLE_ID.click();
        return this;
    }

}
