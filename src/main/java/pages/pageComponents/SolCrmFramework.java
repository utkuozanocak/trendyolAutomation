package pages.pageComponents;

import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.impl.ElementFinder;
import org.openqa.selenium.By;

public class SolCrmFramework {

    public static void setUp() {

        // region ComboBox
        Commands.getInstance().add("selectComboBox", new ComboBox().new SelectComboBox());
        Commands.getInstance().add("selectComboText", new ComboBox().new SelectComboText());
        Commands.getInstance().add("getComboBoxValues", new ComboBox().new GetComboBoxValues());
        Commands.getInstance().add("getComboBoxHtmlList", new ComboBox().new GetComboBoxList());
        Commands.getInstance().add("openPanel", new ComboBox().new OpenPanel());
        Commands.getInstance().add("closePanel", new ComboBox().new ClosePanel());
        //endregion

    }

    public static SolCrmElement comboBox(By selector) {
        return ElementFinder.wrap(SolCrmElement.class, null, selector, 0);
    }

    public static SolCrmElement comboBox(String selector) {
        return ElementFinder.wrap(SolCrmElement.class, null, By.cssSelector(selector), 0);
    }

    public static SolCrmElement comboText(String selector) {
        return ElementFinder.wrap(SolCrmElement.class, null, By.cssSelector(selector), 0);
    }
}
