package pages.ustMenuPagesMaya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;

public class CustomerBillAccountPage extends MainPageMaya {

    //div[@class='ui-datatable-footer ui-widget-header ui-corner-bottom']//button[1]
    private SelenideElement BTN_YENIKAYIT_XPATH = $(By.xpath(GetObject("MAYA","BTN_YENIKAYIT_XPATH","XPATH","CustomerBillAccountPage","PRP")));

    @Step("Müsteri Fatura Hesabı Sayfası Açılır.")
    public CustomerBillAccountPage openPage()
    {
        ustMenu(MayaUstMenuData.Islemler.MusteriFaturaHesabi);
        return this;
    }

    @Step("Yeni Kayıt Butonuna Tıklanır.")
    public CustomerBillAccountPage yeniKayit()
    {
        BTN_YENIKAYIT_XPATH.click();
        return this;
    }


}
