package tests.MayaTestSmoke;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.*;
import pages.MayaTest;


public class SmokeTests extends BaseTest {
    MayaTest mayaTest = new MayaTest();

//    @BeforeMethod
//    public void loginBeforeTests() {
//
//    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Kurumsal kontak bilgisi güncelleme")
    public void TS0003_MayaKontakGuncellemeTest() throws InterruptedException {
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);

        MayaCustomerContactPage mayaCustomerContactPage = new MayaCustomerContactPage();

        mayaCustomerContactPage
                .kontakBilgileriTikla()
                .tablodanIlkKontakSec()
                .telefonNumarasıDoldur("5555555555")
                .kaydet()
                .mesajKontrol("Kontak bilgisi başarıyla kaydedilmiştir");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Sms Şifre Gönderimi")
    public void TS0004_MusteriSmsSifreGonderimiTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);

        EditCorporateCustomerPage editCorporateCustomerPage = new EditCorporateCustomerPage();

        editCorporateCustomerPage
                .musteriBilgileriTikla()
                .btnSMS()
                .mesajKontrol("nolu telefona gönderilmiştir.");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Özellik ekleme")
    public void TS0005_MusteriOzellikEklemeTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);

        CustomerPropertyPage customerPropertyPage = new CustomerPropertyPage();

        customerPropertyPage
                .musteriOzellikSayfasıAc()
                .btnYeniOzellikTikla()
                .txtOzellikAdiDoldur("Test Otomasyon Özellik Adı "+createRandomNumber(8))
                .txtOzellikKoduDoldur("Test Otomasyon Özellik Kodu "+createRandomNumber(8))
                .txtMinimumDegerDoldur("1")
                .txtMaksimumDegerDoldur("10")
                .btnKaydetTikla()
                .mesajKontrol("kodlu özellik seti başarıyla kaydedildi/güncellendi");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye yeni adres eklenir.")
    public void TS0002_MayaAdresEkleTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        MainPageMaya mainPage = new MainPageMaya();

        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);

        AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();

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
                .adresEvetButonSec();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Özellik ekleme")
    public void TS0008_MusteriKurumsalIletisimBilgileriTest() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaTest.customerSearch(GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0],
                GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0]);

        customerCommunicationInfoDisplayPage customerCommunicationInfoDisplay = new customerCommunicationInfoDisplayPage();

        customerCommunicationInfoDisplay
                .openPage()
                .iletisimBilgisiSec()
                .güncelleSec()
                .yeniNumaraGirisi()
                .güncellePopUpOnaySec();
           //     .mesajKontrol("kodlu özellik seti başarıyla kaydedildi/güncellendi");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Özellik ekleme")
    public void TS0022_PartnerOraniGirisiTest() throws InterruptedException {

    }

}
