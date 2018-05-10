package pages.ustMenuPagesFox;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageFox;

import static com.codeborne.selenide.Selenide.$;

public class AkisDetayPage extends MainPageFox {

    private SelenideElement BTN_KURULUM_XPATH = $(By.xpath(GetObject("FOX","BTN_KURULUM_XPATH","XPATH","FoxAkisDetayPage","PRP")));

    @Step("Kurulum tıklanır.")
    public AkisDetayPage kurulumAdımınaTikla() {
        BTN_KURULUM_XPATH.click();
        return this;
    }
}
