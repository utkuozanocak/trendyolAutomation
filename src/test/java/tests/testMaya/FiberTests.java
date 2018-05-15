package tests.testMaya;

import common.BaseTest;
import data.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

public class FiberTests extends BaseTest {
    MayaTest mayaTest = new MayaTest();
    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestData.username, TestData.password, TestData.mainOrg, TestData.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Sipariş Giriş Testi")
    public void TS0001_MayaCreateOrderTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(TestData.unvan)
                .statuSec(TestData.statu)
                .segmentSec(TestData.segment);
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .fiberAc()
                .degistirTikla()
                .lokasyonIDDoldur(TestData.locationId)
                .Ara()
                .tablodanLokasyonSec()
                .lokasyonSec()
                .daireNoDoldur(TestData.daireNo)
                .daireNoSec(TestData.daireNo)
                .kaydet()
                .kampanyaAra(TestData.fiberKampanya)
                .tablodanKampanyaSec(TestData.fiberKampanya)
                .kampanyaSec()
                .hizSec(TestData.hiz)
                .siparisEkle()
                .siparişOluştur();
        //waitForLoadingJS(WebDriverRunner.getWebDriver(), 300000);
        //mainPageMaya.basariMesajKontrolu();


//        orderCapturePage.adslAc();

//        mainPageMaya.urunSecimMenu("Bulut Ürünleri","Eplatform");
    }
}
