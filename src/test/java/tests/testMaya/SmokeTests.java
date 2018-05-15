package tests.testMaya;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.*;


public class SmokeTests extends BaseTest {
    MayaTest mayaTest = new MayaTest();

    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Kurumsal kontak bilgisi güncelleme")
    public void TS0003_MayaKontakGuncellemeTest() throws InterruptedException {
        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .kontakBilgileriTikla();
        MayaCustomerContactPage mayaCustomerContactPage = new MayaCustomerContactPage();
        mayaCustomerContactPage
                .tablodanIlkKontakSec()
                .telefonNumarasıDoldur("5555555555")
                .kaydet()
                .mesajKontrol("Kontak bilgisi başarıyla kaydedilmiştir");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Sms Şifre Gönderimi")
    public void TS0004_MusteriSmsSifreGonderimiTest() throws InterruptedException {
        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .musteriBilgileriTikla();
        EditCorporateCustomerPage editCorporateCustomerPage = new EditCorporateCustomerPage();
        editCorporateCustomerPage
                .btnSMS()
                .mesajKontrol("nolu telefona gönderilmiştir.");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Özellik ekleme")
    public void TS0005_MusteriOzellikEkleme() throws InterruptedException {

    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye yeni adres eklenir.")
    public void TS0002_MayaAdresEkleTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0])
                .statuSec(GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0])
                .segmentSec(GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0])
                .ara()
                .tablodanIlkKayitTikla();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage.siparisAdresEkle();
        AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();
        adresBilgileriPage
                .yeniAdresEkle()
                .sehirSec(TestDataMaya.sehir)
                .ilceSec(TestDataMaya.ilce)
                .mahalleSec(TestDataMaya.mahalle)
                .sokakSec(TestDataMaya.sokak)
                .binaNoIlkKayitSec()
                .blokEkle("Test Blok")
                .adresKaydet()
                .adresOnay()
                .adresEvetButonSec();
        /*  .siparseUrunEkleTikla()
                .adslAc();
              //  .kaydet()
                .kampanyaAra(fiberKampanya); */

    }

}
