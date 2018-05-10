package pages.ustMenuPagesFox;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageFox;

import static com.codeborne.selenide.Selenide.$;

public class StepDetayPage extends MainPageFox {

    private SelenideElement BTN_UZERINEAL_XPATH = $(By.xpath(GetObject("FOX","BTN_UZERINEAL_XPATH","XPATH","FoxStepDetayPage","PRP")));
    private SelenideElement CMB_PAZARLAMASEGMENTI_XPATH = $(By.xpath(GetObject("FOX","CMB_PAZARLAMASEGMENTI_XPATH","XPATH","FoxStepDetayPage","PRP")));
    private SelenideElement RADIO_AKISDURUMU_XPATH = $(By.xpath(GetObject("FOX","RADIO_AKISDURUMU_XPATH","XPATH","FoxStepDetayPage","PRP")));

    @Step("Üzerine Al butonu tıklanır.")
    public StepDetayPage uzerineAl() {
        BTN_UZERINEAL_XPATH.click();
        return this;
    }

    @Step("Üzerine Al butonu tıklanır.")
    public StepDetayPage pazarlamaSegmentiSec(String segment) {
        if(CMB_PAZARLAMASEGMENTI_XPATH.isDisplayed())
            CMB_PAZARLAMASEGMENTI_XPATH.selectOption(segment);
        return this;
    }

    @Step("Üzerine Al butonu tıklanır.")
    public StepDetayPage akisDurumuSec(String text) {
        RADIO_AKISDURUMU_XPATH.click();
        return this;
    }


}
