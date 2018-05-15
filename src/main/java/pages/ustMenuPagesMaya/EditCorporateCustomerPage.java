package pages.ustMenuPagesMaya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;

import static com.codeborne.selenide.Selenide.$;

public class EditCorporateCustomerPage extends MainPageMaya {
    private SelenideElement BTN_SMSGONDER_ID = $(By.id(GetObject("MAYA","BTN_SMSGONDER_ID","ID","EditCorporateCustomerPage","PRP")));
    private SelenideElement LBL_SMSMSG_ID = $(By.id(GetObject("MAYA","LBL_SMSMSG_ID","ID","EditCorporateCustomerPage","PRP")));
    @Step("SMS butonu tıklanır.")
    public EditCorporateCustomerPage btnSMS() {
        BTN_SMSGONDER_ID.click();
        return this;
    }
    @Step("Mesaj kontrolü yapılır.")
    public void mesajKontrol(String mesaj) {
        Assert.assertEquals(LBL_SMSMSG_ID.text().contains(mesaj),true);
        takeScreenshot();
    }
}
