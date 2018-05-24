package tests.MayaTestSmoke;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustMenuPagesMaya.*;


public class MayaSmokeTests extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0001 : Kurumsal Kontak Bilgisi Güncelleme.")
    public void TS0001_KurumsalKontakBilgisiGuncelleme() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        MayaCustomerContactPage mayaCustomerContactPage = new MayaCustomerContactPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        mayaCustomerContactPage
                .kontakBilgileriTikla()
                .tablodanIlkKontakSec()
                .telefonNumarasıDoldur("5555555555")
                .kaydet()
                .mesajKontrol("Kontak bilgisi başarıyla kaydedilmiştir");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0002 : Kurumsal Müşteri Sms Şifre Gönderimi")
    public void TS0002_KurumsalMusteriSmsSifreGonderimi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        EditCorporateCustomerPage editCorporateCustomerPage = new EditCorporateCustomerPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        editCorporateCustomerPage
                .musteriBilgileriTikla()
                .btnSMS()
                .mesajKontrol("nolu telefona gönderilmiştir.");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0003 : Kurumsal Musteri Özellik Ekleme.")
    public void TS0003_KurumsalMusteriOzellikEkleme() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerPropertyPage customerPropertyPage = new CustomerPropertyPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

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
    @Test(enabled = true, description = "TS0004 : Kurumsal Musteriye Yeni Adres Ekle")
    public void TS0004_KurumsalMusteriyeYeniAdresEkle() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        AdresBilgileriPage adresBilgileriPage= new AdresBilgileriPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

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
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0005 : Kurumsal Musteri İletişim Bilgileri.")
    public void TS0005_KurumsalMusteriIletisimBilgileri() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        customerCommunicationInfoDisplayPage customerCommunicationInfoDisplay = new customerCommunicationInfoDisplayPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerCommunicationInfoDisplay
                .openPage()
                .iletisimBilgisiSec()
                .güncelleSec()
                .yeniNumaraGirisi()
                .güncellePopUpOnaySec();
           //     .mesajKontrol("kodlu özellik seti başarıyla kaydedildi/güncellendi");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0006 : Kurumsal Musteri Partner Oranı Girişi.")
    public void TS0006_KurumsalMusteriPartnerOraniGirisi() throws InterruptedException {
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla()
                .btnPartnerOranGirisiTikla()
                .cmbPartnerSec("EPİTEL")
                .btnPartnerKaydetTikla()
                .mesajKontrol("Partner Oran Girişi İşlemi Tamamlanmıştır. Partner:");
    }

}
