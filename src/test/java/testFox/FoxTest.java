package testFox;

import common.BaseTestFox;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustMenuPages.SozlesmelerimPage;

public class FoxTest extends BaseTestFox {

    String username = GetTestParameter("FoxLoginTest", "FoxUserName")[0];
    String password = GetTestParameter("FoxLoginTest", "FoxPassword")[0];

    @BeforeMethod
    public void loginBeforeTests() {
        loginFox(username,password);
        //isLoginFox();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Selenide Maya first test description")
    public void TS0001_FoxFiberKurulumKapatTest() throws InterruptedException {
        SozlesmelerimPage sozlesmelerimPage = new SozlesmelerimPage();
        sozlesmelerimPage.openPage1();
    }
}
