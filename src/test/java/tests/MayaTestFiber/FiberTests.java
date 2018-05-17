package tests.MayaTestFiber;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.ChangeBundleOfferSelectionPage;
import pages.ustMenuPagesMaya.CustomerAssetsPage;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.MayaTest;

public class FiberTests extends BaseTest {
    MayaTest mayaTest = new MayaTest();
    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Sipariş Giriş Testi")
    public void TS0001_MayaCreateOrderTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        mayaTest.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .fiberAc()
                .openPage()
                .degistirTikla()
                .lokasyonIDDoldur(TestDataMaya.locationId)
                .Ara()
                .tablodanLokasyonSec()
                .lokasyonSec()
                .daireNoDoldur(TestDataMaya.daireNo)
                .daireNoSec(TestDataMaya.daireNo)
                .kaydet()
                .kampanyaAra(TestDataMaya.fiberKampanya)
                .tablodanKampanyaSec(TestDataMaya.fiberKampanya)
                .kampanyaSec()
                .hizSec(TestDataMaya.hiz)
                .siparisEkle()
                .siparişOluştur();
        //waitForLoadingJS(WebDriverRunner.getWebDriver(), 300000);
        //mainPageMaya.basariMesajKontrolu();


//        orderCapturePage.adslAc();

//        mainPageMaya.urunSecimMenu("Bulut Ürünleri","Eplatform");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Hız Değişikliği Siparişi Testi")
    public void TS0008_HizDegisikligiTest() throws InterruptedException {
        mayaTest.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla()
                .btnKampanyaIciUrunDegisikligiTikla();
        ChangeBundleOfferSelectionPage changeBundleOfferSelectionPage = new ChangeBundleOfferSelectionPage();
        changeBundleOfferSelectionPage
                .tablodanDegistirButonuTikla("Fiber Internet")
                .tablodanIlkHiziSec()
                .btnIleriTikla();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturTikla();
    }
}
