package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BaseLibrary;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class ConfirmDialog extends MainPageMaya {

    String dialogLocator = "div.ui-confirm-dialog.ui-dialog,div.ui";

    private ElementsCollection dialogs(){
        return $$(dialogLocator);
    }

    public ConfirmDialog confirmDialog(){
        return new ConfirmDialog();
    }

    public SelenideElement getDialog(){return dialogs().filterBy(Condition.visible).first();}

    @Step("Onay dialog mesajı")
    public SelenideElement dialogMessage(){
        return $$(dialogLocator + ",span.ui-confirm-dialog-message" )
                .filterBy(Condition.visible).last();
    }

    @Step("Onay dialog butonu")
    public SelenideElement getConfirmButton(String button){
        return getDialog().$x("descendant::button[span[text()='"+button+"']]");
    }

    @Step("Evet butoun tıklanır.")
    public ConfirmDialog confirmEvetTikla() {
        getConfirmButton("Evet").shouldBe(Condition.visible).pressEnter();
        getConfirmButton("Evet").should(Condition.disappear);
        return this;
    }
    @Step("Hayır butoun tıklanır.")
    public ConfirmDialog confirmHayirTikla() {
        getConfirmButton("Hayır").shouldBe(Condition.visible).pressEnter();
        getConfirmButton("Hayır").should(Condition.disappear);
        return this;
    }
}
