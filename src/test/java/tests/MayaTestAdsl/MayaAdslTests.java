package tests.MayaTestAdsl;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.AdresBilgileriPage;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.ustMenuPagesMaya.TrackOrdersPage;

public class MayaAdslTests extends BaseTest {

    String customerNo;
    String siparisNo;

    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0006 : Kurumsal ADSL Siparis Giris.")
    public void TS0001_KurumsalADSLSiparisGiris() throws InterruptedException {

        OrderCapturePage orderCapturePage = new OrderCapturePage();
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();
        AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();
        String erisimNo = mayaReusableSteps.erisimNoGetir();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        customerNo= mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

//        customerNo = searchCustomerCorparatePage.tabloIlkMusteriNoAl();

        adresBilgileriPage
                .siparisAdresEkle()
                .yeniAdresEkle()
                .sehirSec(TestDataMaya.sehir)
                .ilceSec(TestDataMaya.ilce)
                .mahalleSec(TestDataMaya.mahalle)
                .sokakSec(TestDataMaya.sokak)
                .binaNoIlkKayitSec()
                .blokEkle("Test Otomasyon")
                .adresKaydet()
                .confirmDialog().confirmEvetTikla();
        //     adresBilgileriPage .adresOnay()
        //   .adresEvetButonSec();

        orderCapturePage
                .siparisOlusturSayfaAc();
        orderCapturePage.adslAc().hizmetAdresiSec();
        // String x=orderCapturePage.adslAc().getAdres();
        orderCapturePage
                .siparseUrunEkleTikla()
                .adslAc()
                .openPage()
                .dslHizSec()
                .dslTipiSec("Standart DSL");

        orderCapturePage
                .adslAc()
                .erisimNoGir(erisimNo)
                .ttHizmetSorgulama()
                .dslSunuSec()
                .kampanyaAraDsl(TestDataMaya.adslKampanya)
                .tablodanKampanyaSecDsl(TestDataMaya.adslKampanya)
                .hizSecAdsl(TestDataMaya.adslHiz)
                .siparisEkle()
                .siparişOluştur();

        trackOrdersPage
                .musteriSiparisleriSayfaKontrolu();
        siparisNo = trackOrdersPage.tablodanIlkSiparisNoAl();

        int testId = getTestId("TS0001_KurumsalADSLSiparisGiris")[0];



        insertCustomer(Integer.parseInt(customerNo),true,testId,getDateTime().toString(),siparisNo);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = false, description = "TS0007 : Kurumsal VDSL Siparis Giris.")
    public void TS0007_KurumsalVDSLSiparisGiris() throws InterruptedException {

        MainPageMaya mainPage = new MainPageMaya();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();


        String erisimNo = mayaReusableSteps.erisimNoGetir();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .adslAc()
                .openPage();

        orderCapturePage
                .vdslAc()
                .dslHizSec()
                .dslTipiSec("Standart DSL");

        orderCapturePage
                .vdslAc()
                .erisimNoGir(erisimNo)
                .ttHizmetSorgulama()
                .vdsldslSunuSec();
    }
}
