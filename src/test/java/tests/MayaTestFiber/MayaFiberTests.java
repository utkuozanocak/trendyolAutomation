package tests.MayaTestFiber;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.ChangeBundleOfferSelectionPage;
import pages.ustMenuPagesMaya.CustomerAssetsPage;
import pages.ustMenuPagesMaya.OrderCapturePage;

public class MayaFiberTests extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0001 : Kurumsal Fiber Siparis Giris")
    public void TS0001_KurumsalFiberSiparisGiris() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
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
    @Test(enabled = true, description = "TS0008 : Kurumsal Fiber Hız Değişikliği.")
    public void TS0008_KurumsalFiberHizDegisikligi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        ChangeBundleOfferSelectionPage changeBundleOfferSelectionPage = new ChangeBundleOfferSelectionPage();
        OrderCapturePage orderCapturePage = new OrderCapturePage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

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
    @Test(enabled = true, description = "TS0009 : Kurumsal Fiber İptal Siparişi.")
    public void TS0009_KurumsalFiberIptalSiparisi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

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
    @Test(enabled = true, description = "TS0034 : Kurumsal Fiber Data Şifre Değişikliği.")
    public void TS0034_KurumsalFiberDataSifreDegisikligi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunKontratDetayAc()
                .tablodanKontratDetayHizIslemlerAc("Aktif", "Mbps", "Etkileşimler")
                .btnFiberDataSifreDegisikligi()
                .btnDataSifreDegistirTikla()
                .btnDataSifreDegisikligiEvetTikla()
                .mesajKontrol("Fiber data şifre değişikliği akışı başarıyla başlatılmıştır");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0035 : Kurumsal Guvenli Internet Profil Degisikligi.")
    public void TS0035_KurumsalGuvenliInternetProfilDegisikligi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        MainPageMaya mainPageMaya = new MainPageMaya();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunKontratDetayAc()
                .tablodanKontratDetayHizIslemlerAc("Aktif", "Mbps", "Etkileşimler")
                .btnGuvenliInternetProfilDegisikligiTikla()
                .cmbInternetProfilSec("Çocuk Profili")
                .btnDegisikligiKaydet().
                confirmDialog().confirmEvetTikla();
        //.btnPopUpEvet()
        customerAssetsPage
                .mesajKontrol("Güvenli İnternet Profil Değişikliği akışı başarıyla başlatılmıştır");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0036 : Kurumsal Fiber UpSell Kampanya Değişikliği.")
    public void TS0036_KurumsalFiberUpSellKampanyaDegisikligi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        ChangeBundleOfferSelectionPage changeBundleOfferSelectionPage = new ChangeBundleOfferSelectionPage();
        OrderCapturePage orderCapturePage = new OrderCapturePage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla()
                .btnKampanyaDegisikligiTikla();
        changeBundleOfferSelectionPage
                .cmbKampanyaGecisTipi("UPSELL")
                .cmbYeniKampanya("KonuşturanFiberİnternetKampanyası_Retention")
                .btnIleriTikla()
                .btnIleriTikla();
        orderCapturePage
                .siparisOlusturTikla();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0010 : Kurumsal Fiber İkinci Donanim Sipariş Girişi.")
    public void TS0010_KurumsalFiberIkinciDonanimSiparisGirisi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
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
                .donanimEkle("Dect Telefon C610")
                .siparisEkle()
                .siparişOluştur();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0010 : Kurumsal Fiber İkinci Donanim Sipariş Girişi.")
    public void TS0055_KurumsalFiberDevirSiparisGirisi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla();


    }
}


