package tests.testMaya;

import common.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.*;

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
    String hiz = GetTestParameter("MayaCreateOrderTest", "DataProduct")[0];
    String sehir =GetTestParameter("MayaCreateDSLOrderTest", "AdslSehir")[0];
    String ilce =GetTestParameter("MayaCreateDSLOrderTest", "Adslilce")[0];
    String mahalle =GetTestParameter("MayaCreateDSLOrderTest", "AdslMahalle")[0];
    String sokak =GetTestParameter("MayaCreateDSLOrderTest", "AdslSokak")[0];
    String blok =GetTestParameter("MayaCreateDSLOrderTest", "blokTestOtomasyon")[0];
    MainPageMaya mainPage = new MainPageMaya();
    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(username, password, mainOrg, subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Sipariş Giriş Testi")
    public void TS0001_MayaCreateOrderTest() throws InterruptedException {
        customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturSayfaAc()
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
                .tablodanKampanyaSec(fiberKampanya)
                .kampanyaSec()
                .hizSec(hiz)
                .siparisEkle()
                .siparişOluştur();
        //waitForLoadingJS(WebDriverRunner.getWebDriver(), 300000);
        //mainPageMaya.basariMesajKontrolu();


//        orderCapturePage.adslAc();

//        mainPageMaya.urunSecimMenu("Bulut Ürünleri","Eplatform");
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
                .sehirSec(sehir)
                .ilceSec(ilce)
                .mahalleSec(mahalle)
                .sokakSec(sokak)
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

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye yeni adres eklenir.")
    public void TS0004_MayaCreateDslOrderTest() throws InterruptedException {
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
                .sehirSec(sehir)
                .ilceSec(ilce)
                .mahalleSec(mahalle)
                .sokakSec(sokak)
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

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Kurumsal kontak bilgisi güncelleme")
    public void TS0003_MayaKontakGuncellemeTest() throws InterruptedException {
        customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
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
        customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
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
    private void customerSearch(String Unvan,String Statu,String Segment) {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(Unvan)
                .statuSec(Statu)
                .segmentSec(Segment)
                .ara()
                .tablodanIlkKayitTikla();
    }

}
