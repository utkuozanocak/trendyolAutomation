package tests.testMaya;

import common.BaseTest;
import data.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.AdresBilgileriPage;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

public class AdslTests extends BaseTest {
    MayaTest mayaTest = new MayaTest();
    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestData.username, TestData.password, TestData.mainOrg, TestData.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye yeni adres eklenir.")
    public void TS0004_MayaCreateDslOrderTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(TestData.unvan)
                .statuSec(TestData.statu)
                .segmentSec(TestData.segment)
                .ara()
                .tablodanIlkKayitTikla();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage.siparisAdresEkle();
        AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();
        adresBilgileriPage
                .yeniAdresEkle()
                .sehirSec(TestData.sehir)
                .ilceSec(TestData.ilce)
                .mahalleSec(TestData.mahalle)
                .sokakSec(TestData.sokak)
                .binaNoIlkKayitSec()
                .blokEkle("Test Blok")
                .adresKaydet()
                .adresOnay()
                .adresEvetButonSec();
        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .adslAc()
                .dslHizSec();


              /*  .kampanyaAra(fiberKampanya)
                .tablodanKampanyaSec(fiberKampanya)
                .kampanyaSec()
                .hizSec(hiz)
                .siparisEkle()
                .siparişOluştur();
        /*        .adslAc();
              //  .kaydet()
                .kampanyaAra(fiberKampanya); */

    }
}
