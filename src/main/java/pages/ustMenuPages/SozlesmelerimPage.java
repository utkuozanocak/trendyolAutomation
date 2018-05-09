package pages.ustMenuPages;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.pageData.FoxUstMenuData;
import pages.pageData.MayaUstMenuData;

public class SozlesmelerimPage extends MainPage {


    @Step("Sözleşmelerim sayfası açılır.")
    public SozlesmelerimPage openPage() {
        ustMenu(MayaUstMenuData.KurumsalSozlesmeYonetimi.Sozlesmelerim);
        return this;
    }

    @Step("Sözleşmelerim sayfası açılır.")
    public SozlesmelerimPage openPage1() {
        ustMenuFox(FoxUstMenuData.UstMenuGroup1.AkisListesi);
        return this;
    }

    public SozlesmelerimPage sablonTipi(String tip) {


        return this;
    }

}
