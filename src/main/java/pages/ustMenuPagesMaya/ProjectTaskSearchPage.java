package pages.ustMenuPagesMaya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Emre Sencan
 ****************************************************/
public class ProjectTaskSearchPage extends MainPageMaya {

    private SelenideElement LBL_ISEMRINOILEARAMA = $(By.xpath(GetObject("MAYA", "LBL_ISEMRINOILEARAMA", "XPATH", "ProjectTaskSearchPage", "PRP")));
    private SelenideElement TXT_ISEMRINO = $(By.id(GetObject("MAYA", "TXT_ISEMRINO", "ID", "ProjectTaskSearchPage", "PRP")));
    private SelenideElement BTN_ARA = $(By.id(GetObject("MAYA","BTN_ARA","ID","ProjectTaskSearchPage","PRP")));

    @Step("İş Emri No ile Arama sayfası açılır.")
    public ProjectTaskSearchPage openPage() {
        ustMenu(MayaUstMenuData.Satis.IsEmriNoIleArama);
        return this;
    }

    @Step("İş Emri No ile Arama sayfasının açıldığı görülür.")
    public ProjectTaskSearchPage sayfaKontrolu() {
        Assert.assertEquals(LBL_ISEMRINOILEARAMA.isDisplayed(), true, "Sayfa açıldı");
        return this;
    }

    @Step("İş Emri No alanına \"{isEmriNo}\" yazılır.")
    public ProjectTaskSearchPage isEmriNoDoldur(String isEmriNo) {
        TXT_ISEMRINO.sendKeys(isEmriNo);
        return this;
    }

    @Step("Ara butonuna tıklanır.")
    public ProjectTaskSearchPage ara() {
        BTN_ARA.click();
        return this;
    }
}
