package tests.testMaya;

import common.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustMenuPages.SozlesmelerimPage;

/****************************************************
 * Tarih: 2017-12-22
 * Proje: Türksat Functional Test Automation
 * Class: "Evrak kontroller" konulu senaryoları içerir
 * Yazan: Emre Sencan
 ****************************************************/
public class MayaTest extends BaseTest {

    String username = GetTestParameter("MayaLoginTest","Username")[0];
    String password = GetTestParameter("MayaLoginTest","Password")[0];
    String mainOrg = GetTestParameter("MayaLoginTest","MainOrg")[0];
    String subOrg = GetTestParameter("MayaLoginTest","SubOrg")[0];

    @BeforeMethod
    public void loginBeforeTests() {
        login(username,password,mainOrg,subOrg);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Selenide Maya first test description")
    public void TS0001() throws InterruptedException {

        SozlesmelerimPage sozlesmelerimPage = new SozlesmelerimPage();
        sozlesmelerimPage.openPage();

    }
}
