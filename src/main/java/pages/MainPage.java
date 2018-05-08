package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.pageComponents.ConfirmDialog;
import pages.pageComponents.SearchTable;
import pages.pageData.UrunEklemeData;
import pages.pageData.UstMenuData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BaseLibrary {
    SelenideElement mainPageLeftContainer = $("#mainInboxForm");
    SelenideElement mainPageLeftContainerDataTable = $("#mainInboxForm\\:inboxDataTable");

    public SelenideElement getMainPageLeftContainer() {
        return mainPageLeftContainer;
    }

    public SelenideElement getMainPageLeftContainerDataTable() {
        return mainPageLeftContainerDataTable;
    }

    public SearchTable searchTable() {
        return new SearchTable(mainPageLeftContainerDataTable);
    }

    public void ustMenu(Enum menu) {
        String groupName = ((UstMenuData.UstMenuDataInterface) menu).getGroupName();
        String menuName = ((UstMenuData.UstMenuDataInterface) menu).getName();
        Selenide.$(By.xpath("//div[@class='headerMenu']//a[.='" + groupName + "']")).should(Condition.visible).click();
        Selenide.$(By.xpath("//div[@class='headerMenu']//a[.='" + menuName + "']")).should(Condition.visible).click();
    }

    public void urunSecimMenu(String kategori, String... altKategori) {

        if (altKategori.length > 0) {
            Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']"))
                    .filterBy(text(kategori)).first().
                    $("span[class='ui-treetable-toggler ui-icon ui-icon-triangle-1-e ui-c']").click();
            if (kategori.equals(altKategori[0]))
                Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(altKategori[0])).get(1).click();
            else
                Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(altKategori[0])).first().click();
        }
        else {
            Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(kategori)).first().click();
            Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(altKategori[0])).first().click();
        }

    }

    public void urunSecimMenu(Enum menu) {

        String groupName = ((UrunEklemeData.UrunEklemeDataInterface) menu).getGroupName();
        String menuName = ((UrunEklemeData.UrunEklemeDataInterface) menu).getName();
        if (menuName.toString().length() > 0) {
            Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']"))
                    .filterBy(text(groupName)).first().
                    $("span[class='ui-treetable-toggler ui-icon ui-icon-triangle-1-e ui-c']").click();
            if (groupName.equals(menuName))
                Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(menuName)).get(1).click();
            else
                Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(menuName)).first().click();
        }
        else {
            Selenide.$$(("tbody[id='productSelectionWizardForm:salesCategoryTreeTableId_data'] tr[role='row']")).filterBy(text(groupName)).first().click();
        }

    }
    @Step("Çıkış yap")
    public void logout() {
        $("button[id='topMenuForm:userMenuButton_button']").click();
        $("#topMenuForm\\:logOutButton").click();

        for (int i = 0; i < 5; i++) {
            if (getIslemOnayDialog().is(visible))
                getIslemOnayDialog().$x("descendant::button[.='Evet']").click();
            sleep(1000);
        }
    }

    public SelenideElement getIslemOnayDialog() {
        return $x("//div[@id='baseConfirmationDialog:dialog']");
    }

    public ConfirmDialog confirmDialog() {
        return new ConfirmDialog();
    }

    public ElementsCollection getPageCloseButtons() {
        return $$("div[id^='window'][id$='Dialog'] > div[class~='ui-dialog-titlebar'] > a[class~='ui-dialog-titlebar-close']");
    }

    public ElementsCollection getPageTitles() {
        return $$("div[id^='window'][id$='Dialog'] > div[class~='ui-dialog-titlebar'] > span[class='ui-dialog-title']");
    }

    @Step("Footer'da açılan sayfa butonu bul")
    public SelenideElement getFooterPageButton(String pageTitle) {
        return $x("//div[@id='mainTaskBar']//div[@type='button']/span[contains(.,'" + pageTitle + "')]");
    }

    @Step("User Menu listesinde \"{menuName}\" menusu bulunur.")
    public MainPage userMenuKontrol(String menuName) {

        ElementsCollection elementList = $$(By.id("topMenuForm:userMenuButton_menu")).last().$$("li");

        boolean status = elementList
                .filterBy(Condition.text(menuName))
                .first().isDisplayed();

        Assert.assertEquals(status, true, "Listede menu ismi mevcut.");

        return this;
    }

    @Step("Müşteri Detaylı Arama butonu tıklanır.")
    public void musteriDetayliArama() {
        $(By.id(GetObject("MAYA", "BTN_CUSTOMERNOSEARCHDOWN_ID", "ID", "MayaMainPage", "PRP"))).click();
        $x(GetObject("MAYA", "BTN_CUSTOMERNODETAILSEARCH_XPATH", "XPATH", "MayaMainPage", "PRP")).click();
    }
}
