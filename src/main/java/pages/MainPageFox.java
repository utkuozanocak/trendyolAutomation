package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.pageData.FoxUstMenuData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

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

    @Step("Çıkış yap")
    public void logout() {
        $("ul[class='nav navbar-nav']").click();
        $("#mi_exit").click();
    }



}
