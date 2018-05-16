package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

public class customerCommunicationInfoDisplayPage extends MainPageMaya {

    @Step("Kurumsal İletişim Bilgileri sayfası açılır.")
    public customerCommunicationInfoDisplayPage openPage() {
        ustMenu(MayaUstMenuData.Islemler.KurumIletisimBilgileri);
        return this;
    }

    @Step("yeni kayıt butonuna tıklanır.")
    public customerCommunicationInfoDisplayPage yeniAdresEkle() {
        //     BTN_YENIKAYIT_XPATH.click();
           return this;
    }
}

