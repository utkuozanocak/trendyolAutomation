package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import common.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.pageData.FoxUstMenuData;

import static com.codeborne.selenide.Selenide.$;

public class MainPageFox extends BaseLibrary {

    public void ustMenuFox(Enum menu) {
        String groupName = ((FoxUstMenuData.UstMenuGroupFox) menu).getName();
        $(By.xpath("//ul[@class='nav nav-tabs']//a[.='" + groupName + "']")).should(Condition.visible).click();
    }

    public void akisNoDoldur(String akisNo) {

        SelenideElement TXT_AKISNO_XPATH = $(By.xpath(GetObject("FOX","TXT_WFINSTANCE","XPATH","FoxMainPage","PRP")));

        TXT_AKISNO_XPATH.sendKeys(akisNo);
        TXT_AKISNO_XPATH.pressEnter();
    }

    @Step("Çıkış yapılır")
    public void logout() {
        $("ul[class='nav navbar-nav']").click();
        $("#mi_exit").click();
    }

    @Step("Kullanıcı Değiştir Tıklanır.")
    public void kullaniciDegistir() {
        $("ul[class='nav navbar-nav']").click();
        $("#mi_changeUsers").click();
    }

    @Step("Mesaj kontrolü yapılır.")
    public void mesajKontrol(String mesaj) {
        SelenideElement LBL_MESAJ = $(By.id(GetObject("FOX","LBL_MESAJ","ID","FoxChangeUserPage","PRP")));
        Assert.assertEquals(LBL_MESAJ.text().contains(mesaj),true);
        takeScreenshot();
    }

}
