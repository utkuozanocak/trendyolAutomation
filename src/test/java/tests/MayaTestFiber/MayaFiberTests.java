package tests.MayaTestFiber;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.mayaFrames.*;
import pages.ustMenuPagesMaya.*;

public class MayaFiberTests extends BaseTest {

    String customerNo;
    String siparisNo;
    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true,description = "TS0001 : Kurumsal Fiber Siparis Giris")
    public void TS0001_KurumsalFiberSiparisGiris() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        customerNo = mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
//        customerNo = searchCustomerCorparatePage.tabloRandomMusteriNoSecVeAl();
//        int testId = getTestId("TS0001_KurumsalFiberSiparisGiris")[0];

//        insertCustomer(Integer.parseInt(customerNo),true,testId,getDateTime().toString());

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

        trackOrdersPage
                .musteriSiparisleriSayfaKontrolu();
        siparisNo = trackOrdersPage.tablodanIlkSiparisNoAl();



        int testId = getTestId("TS0001_KurumsalFiberSiparisGiris")[0];

        insertCustomer(Integer.parseInt(customerNo),true,testId,getDateTime().toString(),siparisNo);
        //waitForLoadingJS(WebDriverRunner.getWebDriver(), 300000);
        //mainPageMaya.basariMesajKontrolu();


//        orderCapturePage.adslAc();

//        mainPageMaya.urunSecimMenu("Bulut Ürünleri","Eplatform");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0002 : Kurumsal Fiber Hız Değişikliği.")
    public void TS0002_KurumsalFiberHizDegisikligi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        ChangeBundleOfferSelectionPage changeBundleOfferSelectionPage = new ChangeBundleOfferSelectionPage();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla();
        etkilesimlerFrame
                .btnForEtkilesim("Kampanya Değişiklikleri","Kampanya İçi Ürün Değişikliği");
        changeBundleOfferSelectionPage
                .tablodanDegistirButonuTikla(TestDataMaya.fiberHizSecimGrubu)
                .tablodanIlkHiziSec()
                .btnIleriTikla();

        orderCapturePage
                .siparisOlusturTikla();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0003 : Kurumsal Fiber İptal Siparişi.")
    public void TS0003_KurumsalFiberIptalSiparisi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        EtkilesimDetayiIptalFrame etkilesimDetayiIptalFrame = new EtkilesimDetayiIptalFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla();
        etkilesimlerFrame
                .btnForEtkilesim("Abonelik İşlemleri","İptal");
        etkilesimDetayiIptalFrame
                .cmbIptalAnaNedeniSec("Kurumsal_Taşınma")
                .altNedenSec("Kurumsal_Taşınma")
                .iptalSiparişiTamamla();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0004 : Kurumsal Fiber Data Şifre Değişikliği.")
    public void TS0004_KurumsalFiberDataSifreDegisikligi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        EtkilesimDetayFiberDataSifreDegisikligiFrame etkilesimDetayFiberDataSifreDegisikligiFrame = new EtkilesimDetayFiberDataSifreDegisikligiFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunKontratDetayAc()
                .tablodanKontratDetayHizIslemlerAc("Aktif", "Mbps", "Etkileşimler");
        etkilesimlerFrame
                .btnForEtkilesim("Abonelik İşlemleri","Fiber Data Şifre Değişikliği");
        etkilesimDetayFiberDataSifreDegisikligiFrame
                .btnDataSifreDegistirTikla()
                .btnDataSifreDegisikligiEvetTikla()
                .mesajKontrol("Fiber data şifre değişikliği akışı başarıyla başlatılmıştır");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0005 : Kurumsal Guvenli Internet Profil Degisikligi.")
    public void TS0005_KurumsalGuvenliInternetProfilDegisikligi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        MainPageMaya mainPageMaya = new MainPageMaya();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        EtkilesimDetayInternetProfilDegisikligiFrame etkilesimDetayInternetProfilDegisikligiFrame = new EtkilesimDetayInternetProfilDegisikligiFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunKontratDetayAc()
                .tablodanKontratDetayHizIslemlerAc("Aktif", "Mbps", "Etkileşimler");
        etkilesimlerFrame
                .btnForEtkilesim("Abonelik İşlemleri","Fiber Güvenli İnternet Profil Değişikliği");
        etkilesimDetayInternetProfilDegisikligiFrame
                .cmbInternetProfilSec("Çocuk Profili")
                .btnDegisikligiKaydet().confirmDialog().confirmEvetTikla();
        etkilesimDetayInternetProfilDegisikligiFrame
                .mesajKontrol("Güvenli İnternet Profil Değişikliği akışı başarıyla başlatılmıştır");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0006 : Kurumsal Fiber UpSell Kampanya Değişikliği.")
    public void TS0006_KurumsalFiberUpSellKampanyaDegisikligi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        ChangeBundleOfferSelectionPage changeBundleOfferSelectionPage = new ChangeBundleOfferSelectionPage();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla();
        etkilesimlerFrame
                .btnForEtkilesim("Kampanya Değişiklikleri","Kampanya Değişikliği");
        changeBundleOfferSelectionPage
                .cmbKampanyaGecisTipi("UPSELL")
                .cmbYeniKampanya("KonuşturanFiberİnternetKampanyası_Retention")
                .btnIleriTikla()
                .btnIleriTikla();
        orderCapturePage
                .siparisOlusturTikla();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0007 : Kurumsal Fiber İkinci Donanim Sipariş Girişi.")
    public void TS0007_KurumsalFiberIkinciDonanimSiparisGirisi() throws InterruptedException {
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
    @Test(enabled = true, description = "TS0055 : Kurumsal Fiber Devir Siparişi girilir.")
    public void TS0055_KurumsalFiberDevirSiparisGirisi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        EtkilesimDetayDevirFrame etkilesimDetayDevirFrame = new EtkilesimDetayDevirFrame();
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla();
        etkilesimlerFrame
                .btnForEtkilesim("Abonelik İşlemleri","Devir");
        etkilesimDetayDevirFrame
                .devirTuruIsaretle(true)
                .musteriNoGir()
                .musteriAra()
                .musteriSec()
                .devirBaslat();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0061 : Kurumsal Fiber Tahsisli Ses Siparişi girilir.")

    public void TS0061_KurumsalFiberTahsisliSesSiparisi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        customerNo = mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

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
                .sesSec(TestDataMaya.sesSecimGrubu)
                .siparisEkle();
        orderCapturePage
                .tabloSiparisDetayAc()
                .tabloKKOOzellikSec("Konuştuğun_Kadar_Öde_Res/Soho ")
                .erisimNumarasiEkle()
                .erisimNumarasiAra()
                .tablodanIlkNumaraSec()
                .erisimNoReverveEt()
                .numaraRezervasyonKaydet()
                .siparisOlusturTikla();

  //      int testId = getTestId("TS0061_KurumsalFiberTahsisliSesSiparisi")[0];
        //     insertCustomer(Integer.parseInt(customerNo),true,testId,getDateTime().toString());

    }
}


