package tests.testMaya;

import com.codeborne.selenide.Selenide;
import common.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustMenuPages.UcakBiletiPage;

/****************************************************
 * Tarih: 2017-12-22
 * Proje: Türksat Functional Test Automation
 * Class: "Evrak kontroller" konulu senaryoları içerir
 * Yazan: Emre Sencan
 ****************************************************/
public class MayaTest extends BaseTest {

    UcakBiletiPage ucakBiletiPage;




    @BeforeMethod
    public void loginBeforeTests() {
        login("TEOASLIM","Test1234");
//        ucakBiletiPage=new UcakBiletiPage();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Selenide Maya first test description")
    public void TS0001() throws InterruptedException {

//        ucakBiletiPage.openPage();

        //deneme

    }
}
