package tests.MayaTestAdsl;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.MayaTest;

public class AdslTests extends BaseTest {
    MayaTest mayaTest = new MayaTest();
    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye ADSL siparişi girilir.")
    public void TS0006_MayaCreateDslOrderTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        mayaTest.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);
   /*     AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();
        adresBilgileriPage
                .siparisAdresEkle()
                .yeniAdresEkle()
                .sehirSec(TestDataMaya.sehir)
                .ilceSec(TestDataMaya.ilce)
                .mahalleSec(TestDataMaya.mahalle)
                .sokakSec(TestDataMaya.sokak)
                .binaNoIlkKayitSec()
                .blokEkle("Test Blok")
                .adresKaydet()
                .adresOnay()
                .adresEvetButonSec(); */
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .adslAc()
                .openPage()
                .dslHizSec()
                .dslTipiSec("Standart DSL");
        String erisimNo = mayaTest.erisimNoGetir();
        orderCapturePage.adslAc().erisimNoGir(erisimNo)
                .ttHizmetSorgulama()
                .dslSunuSec()
                .kampanyaAraDsl(TestDataMaya.adslKampanya)
                .tablodanKampanyaSecDsl(TestDataMaya.adslKampanya)
                .hizSecAdsl(TestDataMaya.adslHiz)
                .siparisEkle()
                .siparişOluştur();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye VDSL satışı yapılır.")
    public void TS0007_MayaCreateVdslOrderTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        mayaTest.customerSearch(TestDataMaya.unvan,TestDataMaya.statu,TestDataMaya.segment);
   /*     AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();
        adresBilgileriPage
                .siparisAdresEkle()
                .yeniAdresEkle()
                .sehirSec(TestDataMaya.sehir)
                .ilceSec(TestDataMaya.ilce)
                .mahalleSec(TestDataMaya.mahalle)
                .sokakSec(TestDataMaya.sokak)
                .binaNoIlkKayitSec()
                .blokEkle("Test Blok")
                .adresKaydet()
                .adresOnay()
                .adresEvetButonSec(); */
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .adslAc()
                .openPage();
        orderCapturePage.vdslAc().dslHizSec()
                 .dslTipiSec("Standart DSL");
        String erisimNo = mayaTest.erisimNoGetir();
        orderCapturePage.vdslAc().erisimNoGir(erisimNo)
                .ttHizmetSorgulama()
                .vdsldslSunuSec();
      /*          .kampanyaAraDsl(TestDataMaya.adslKampanya)
                .tablodanKampanyaSecDsl(TestDataMaya.adslKampanya)
                .hizSecAdsl(TestDataMaya.adslHiz)
                .siparisEkle()
                .siparişOluştur(); */

    }
}
