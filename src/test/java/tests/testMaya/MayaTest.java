package tests.testMaya;

import common.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ustMenuPages.OrderCapturePage;
import pages.ustMenuPages.SearchCustomerCorparatePage;

/****************************************************
 * Tarih: 2018-05-08
 * Proje: Turkcell Functional Test Automation
 * Class:
 * Yazan: Emre Sencan
 ****************************************************/
public class MayaTest extends BaseTest {

    String username = GetTestParameter("MayaLoginTest", "Username")[0];
    String password = GetTestParameter("MayaLoginTest", "Password")[0];
    String mainOrg = GetTestParameter("MayaLoginTest", "MainOrg")[0];
    String subOrg = GetTestParameter("MayaLoginTest", "SubOrg")[0];
    String locationId = GetLocationData(GetTestParameter("MayaCreateOrderTest", "LocationTypeFTTB")[0])[0];
    String fiberKampanya = GetTestParameter("MayaCreateOrderTest", "Product")[0];
    String daireNo = GetLocationDaireData(GetTestParameter("MayaCreateOrderTest", "LocationTypeFTTB")[0], locationId)[0];

    @BeforeMethod
    public void loginBeforeTests() {
        login(username, password, mainOrg, subOrg);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Selenide Maya first test description")
    public void TS0001_MayaCreateOrderTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();

        mainPage.musteriDetayliArama();

        searchCustomerCorparatePage
                .unvanDoldur(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0])
                .statuSec(GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0])
                .segmentSec(GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0])
                .ara()
                .tablodanIlkKayitTikla();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturTikla()
                .siparseUrunEkleTikla()
                .fiberAc()
                .degistirTikla()
                .lokasyonIDDoldur(locationId)
                .Ara()
                .tablodanLokasyonSec()
                .lokasyonSec()
                .daireNoDoldur(daireNo)
                .daireNoSec(daireNo)
                .kaydet()
                .kampanyaAra(fiberKampanya)
                .tablodanKampanyaSec(fiberKampanya);


//        orderCapturePage.adslAc();

//        mainPage.urunSecimMenu("Bulut Ürünleri","Eplatform");
    }
}
