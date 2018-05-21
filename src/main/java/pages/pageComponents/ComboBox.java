package pages.pageComponents;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.ElementFinder;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.By;

import java.io.IOException;

class ComboBox {

    class SelectComboBox implements Command<SolCrmElement> {
        @Override
        public SolCrmElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) throws IOException {
            if (args == null || args.length == 0)
                return (SolCrmElement) proxy;

            boolean[] jaArr = (boolean[]) args[1];
            boolean js = (jaArr.length <= 0) || jaArr[0];

            new ComboBoxHelper().selectComboBox(proxy, args[0].toString(), js);

            return (SolCrmElement) proxy;
        }
    }

    class SelectComboText implements Command<SolCrmElement> {
        @Override
        public SolCrmElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) throws IOException {
            if (args == null || args.length == 0)
                return (SolCrmElement) proxy;

            boolean[] jaArr = (boolean[]) args[1];
            boolean js = (jaArr.length <= 0) || jaArr[0];

            new ComboBoxHelper().selectComboText(proxy, args[0].toString(), js);

            return (SolCrmElement) proxy;
        }
    }

    class OpenPanel implements Command<SolCrmElement> {
        @Override
        public SolCrmElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) throws IOException {

            ComboBoxHelper helper = new ComboBoxHelper();
            helper.setLocators(proxy);
            helper.openPanel();
            return (SolCrmElement) proxy;
        }
    }

    class ClosePanel implements Command<SolCrmElement> {
        @Override
        public SolCrmElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) throws IOException {

            ComboBoxHelper helper = new ComboBoxHelper();
            helper.setLocators(proxy);
            helper.closePanel();
            return (SolCrmElement) proxy;
        }
    }

    class GetComboBoxList implements Command<SolCrmElement> {
        @Override
        public SolCrmElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) throws IOException {


            By ulLocator = new ComboBoxHelper().getComboBoxHtmlList(proxy);
            return ElementFinder.wrap(SolCrmElement.class, null, ulLocator, 0);
        }
    }

    class GetComboBoxValues implements Command<ElementsCollection> {
        @Override
        public ElementsCollection execute(SelenideElement proxy, WebElementSource locator, Object[] args) throws IOException {
            return new ComboBoxHelper().getComboBoxValues(proxy);
        }
    }
}
