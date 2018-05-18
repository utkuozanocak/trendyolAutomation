package tests.MayaTestFiber;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustMenuPagesMaya.ChangeBundleOfferSelectionPage;
import pages.ustMenuPagesMaya.CustomerAssetsPage;
import pages.ustMenuPagesMaya.OrderCapturePage;

public class FiberTests extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Sipariş Giriş Testi")
    public void TS0001_MayaCreateOrderTest() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);
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

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        ChangeBundleOfferSelectionPage changeBundleOfferSelectionPage = new ChangeBundleOfferSelectionPage();
        OrderCapturePage orderCapturePage = new OrderCapturePage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla()
                .btnKampanyaIciUrunDegisikligiTikla();

        changeBundleOfferSelectionPage
                .tablodanDegistirButonuTikla(TestDataMaya.fiberHizSecimGrubu)
                .tablodanIlkHiziSec()
                .btnIleriTikla();

        orderCapturePage
                .siparisOlusturTikla();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber İptal Siparişi Girilir.")
    public void TS0009_DeaktivasyonTest() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla()
                .btnIptalSiparisiTikla()
                .cmbIptalAnaNedeniSec("Kurumsal_Taşınma")
                .altNedenSec("Kurumsal_Taşınma")
                .iptalSiparişiTamamla();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Data Şifre Değişikliği testi")
    public void TS0034_FiberDataSifreDegisikligiTest() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunKontratDetayAc()
                .tablodanKontratDetayHizIslemlerAc()
                .btnEtkilesimlerTikla()
                .btnFiberDataSifreDegisikligi()
                .btnDataSifreDegistirTikla()
                .btnEtkilesimlerTikla();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Data Şifre Değişikliği testi")
    public void TS0010_FiberIkınciDonanimTest() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);
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
                .siparisEkle();
             // .siparişOluştur();
        //waitForLoadingJS(WebDriverRunner.getWebDriver(), 300000);
        //mainPageMaya.basariMesajKontrolu();


//        orderCapturePage.adslAc();

//        mainPageMaya.urunSecimMenu("Bulut Ürünleri","Eplatform");
    }
    }


