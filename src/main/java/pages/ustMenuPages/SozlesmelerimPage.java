package pages.ustMenuPages;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.pageComponents.belgenetElements.Belgenet;
import pages.pageComponents.belgenetElements.BelgenetElement;
import pages.pageData.UstMenuData;

public class SozlesmelerimPage extends MainPage {


    @Step("Sözleşmelerim sayfası açılır.")
    public SozlesmelerimPage openPage() {
        ustMenu(UstMenuData.KurumsalSozlesmeYonetimi.Sozlesmelerim);
        return this;
    }

    public SozlesmelerimPage sablonTipi(String tip) {


        return this;
    }

}
