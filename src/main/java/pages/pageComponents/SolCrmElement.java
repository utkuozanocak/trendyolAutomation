package pages.pageComponents;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public interface SolCrmElement extends SelenideElement {


    //region ComboBox
    SolCrmElement comboBox(String selector);

    SolCrmElement comboBox(By locator);

    SolCrmElement comboText(String selector);

    SolCrmElement selectComboBox(String text, boolean... js);

    SolCrmElement selectComboText(String text, boolean... js);

    ElementsCollection getComboBoxValues();
    //endregion
}

