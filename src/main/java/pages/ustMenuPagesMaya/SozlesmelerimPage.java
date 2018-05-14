package pages.ustMenuPagesMaya;

import io.qameta.allure.Step;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

public class SozlesmelerimPage extends MainPageMaya
{


    @Step("Sözleşmelerim sayfası açılır.")
    public SozlesmelerimPage openPage() {
        ustMenu(MayaUstMenuData.KurumsalSozlesmeYonetimi.Sozlesmelerim);
        return this;
    }

    public SozlesmelerimPage sablonTipi(String tip) {


        return this;
    }

}
