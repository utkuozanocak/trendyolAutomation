package tests.BirimYonetimi;

import com.codeborne.selenide.Condition;
import common.BaseTest;
import data.TestData;
import data.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ustMenuPages.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;

/******************
 * Tarih: 2018-02-15
 * Proje: Türksat Functional Test Automation
 * Class: "Birim Yönetimi" konulu senaryoları içerir
 * Yazan: Sezai Çelik
 ******************/

@Feature("Birim Yönetimi")
public class BirimYonetimiTest extends BaseTest {

    BirimYonetimiPage birimYonetimiPage;
    GelenEvrakKayitPage gelenEvrakKayitPage;
    GidenEvrakKayitPage gidenEvrakKayitPage;
    EvrakOlusturPage evrakOlusturPage;
    OlurYazisiOlusturPage olurYazisiOlusturPage;
    KullaniciYonetimiPage kullaniciYonetimiPage;
    MainPage mainPage;

    @BeforeMethod
    public void loginBeforeTests() {

        birimYonetimiPage = new BirimYonetimiPage();
        gelenEvrakKayitPage = new GelenEvrakKayitPage();
        gidenEvrakKayitPage = new GidenEvrakKayitPage();
        evrakOlusturPage = new EvrakOlusturPage();
        olurYazisiOlusturPage = new OlurYazisiOlusturPage();
        kullaniciYonetimiPage = new KullaniciYonetimiPage();
        mainPage = new MainPage();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS2337: Yeni birim kayıt ve evrak işlemlerinden kontrolü - Görünür Seçilmez")
    public void TS2337() {

        String testID = "TS2337";
        String sistemTarihi = getSysDate();
        String birimAdi = "TS2337_Birim_" + sistemTarihi;
        String birimKisaAdi = "ts2337b_" + sistemTarihi;
        String idariBirimKimlikKodu = sistemTarihi;
        String birim = "Optiim Birim";
        String birimDetail = "YGD";
        String birimTipi = "Genel Müdürlüğü";
        String gelenEvrakNumaratoru = "Türksat AŞ_numarator - Gelen Evrak";
        String gidenEvrakNumaratoru = "Türksat AŞ_numarator - Giden Evrak";
        String basariMesaji = "İşlem başarılıdır!";

        login(TestData.optiim);

        testStatus(testID, "Birim Oluşturma");

        birimYonetimiPage
                .openPage()
                .ekle()
                .birimYonetimiAlanKontrolleri()
                .gorunurlukTipiSec("Görünür Seçilmez")
//                .disBirimSec(true)
                .adDoldur(birimAdi)
                .kisaAdiDoldur(birimKisaAdi)
                .antetTipiSec("Normal")
                .antetBilgisiDoldur(birimAdi)
                .idariKimlikKoduDoldur(idariBirimKimlikKodu)
                .ustBirimSec(birim, birimDetail)
                .birimTipiSec(birimTipi)
                .gelenEvraklariNumaratoruDoldur(gelenEvrakNumaratoru)
                .gidenEvraklariNumaratoruDoldur(gidenEvrakNumaratoru)
                .birimBagTuruSec("Bağlı Kuruluş")
                .postaBirimiSec(birim, birimDetail)
                .kepPostaBirimiSec(birim, birimDetail)
                .postaSekliSec("Otomatik")
                .belgenetKullanıyormuSec("Evet")
                .kaydet()
                .islemMesaji().basariliOlmali(basariMesaji);

        birimYonetimiPage
                .birimFiltreDoldur(birimAdi)
                .ara()
                .birimKayitKontrolu(birimAdi);

        gelenEvrakKayitPage
                .openPage()
                .kisiKurumSecByText("Birim")
                .geregiAlanindaBiriminGeldigiVeSecilemedigiKontrolu(birimAdi, "Birim Adı"); //TS2337_Birim_20180215155258

        gidenEvrakKayitPage
                .openPage()
                .geregiSecimTipiSecByText("Birim")
                .geregiAlanindaBiriminGeldigiSecilemedigiKontrolu(birimAdi, "Birim Adı")
                .geregiAlanindaBiriminGeldigiSecilemedigiKontrolu(idariBirimKimlikKodu, "İdari Birim Kodu ")

                .bilgiSecimTipiSecByText("Birim")
                .bilgiAlanindaBiriminGeldigiVeSecilemedigiKontrolu(birimAdi, "Birim Adı")
                .bilgiAlanindaBiriminGeldigiVeSecilemedigiKontrolu(idariBirimKimlikKodu, "İdari Birim Kodu ");

        evrakOlusturPage
                .openPage()
                .bilgilerTabiAc()
                .geregiSecimTipiSecByText("Birim")
                .geregiAlanindaBiriminGeldigiSecilemedigiKontrolu(birimAdi, "Birim Adı")
                .geregiAlanindaBiriminGeldigiSecilemedigiKontrolu(idariBirimKimlikKodu, "İdari Birim Kodu ")

                .bilgiSecimTipiSecByText("Birim")
                .bilgiAlanindaBiriminGeldigiSecilemedigiKontrolu(birimAdi, "Birim Adı")
                .bilgiAlanindaBiriminGeldigiSecilemedigiKontrolu(idariBirimKimlikKodu, "İdari Birim Kodu ");

        olurYazisiOlusturPage
                .openPage()
                .bilgilerTabiAc()
                .geregiSecimTipiSecByText("Birim")
                .geregiAlanindaBiriminGeldigiSecilemedigiKontrolu(birimAdi, "Birim Adı")
                .geregiAlanindaBiriminGeldigiSecilemedigiKontrolu(idariBirimKimlikKodu, "İdari Birim Kodu ")

                .bilgiSecimTipiSecByText("Birim")
                .bilgiAlanindaBiriminGeldigiSecilemedigiKontrolu(birimAdi, "Birim Adı")
                .bilgiAlanindaBiriminGeldigiSecilemedigiKontrolu(idariBirimKimlikKodu, "İdari Birim Kodu ");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS2336: Birimin olur metnini güncelleme")
    public void TS2336() {

        String birimAdi = "TS2336 Birim";
        String olurMetni = "TS2336 Olur Metni " + getSysDate();
        String onayAkisiKullaniciDefaultKullanici = "Ts2336 USER";
        String kaldirilacakKlasor = "2336 test";
        String basariMesaji = "İşlem başarılıdır!";

        login(TestData.usernameTS2336, TestData.passwordTS23362);

        birimYonetimiPage
                .openPage()
                .birimFiltreDoldur(birimAdi)
                .ara()
                .birimKayitKontrolu(birimAdi)
                .birimGüncelle(birimAdi)
                .olurMetniDoldur(olurMetni)
                .kaydet()
                .islemMesaji().basariliOlmali(basariMesaji);

        login(TestData.usernameTS2336, TestData.passwordTS23362);

        olurYazisiOlusturPage
                .openPage()
                .bilgilerTabiAc()
                .kaldiralacakKlasorlerSec(kaldirilacakKlasor)
                .onayAkisiEkle()
                .onayAkisiKullaniciKontrol(onayAkisiKullaniciDefaultKullanici, "PARAFLAMA")
                .onayAkisiKullaniciTipiSec(onayAkisiKullaniciDefaultKullanici, "İmzalama")
                .kullan();

        olurYazisiOlusturPage
                .editorTabAc()
                .editorHitapKontrol(olurMetni);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS1108: Birim Sorgulama")
    public void TS1108() {

        String aktifIcBirimAdi = "TS1108 Aktif İç Birim";
        String pasifIcBirimAdi = "TS1108 Pasif İç Birim";
        String pasifDisBirimAdi = "TS1108 Pasif Dış Birim";

        login();

        birimYonetimiPage
                .openPage()

                .birimTuruSec("İç Birim")
                .durumSec("Sadece Aktifler")
                .ara()
                .pasifYapButonuKontrolu()
                .aktiflerIlkBirimGuncelle()
                .disBirimChkBoxBosOlduguKontrolu()

                .birimTuruSec("İç Birim")
                .durumSec("Sadece Pasifler")
                .ara()
                .aktifYapButonuKontrolu()
                .pasiflerIlkBirimGuncelle()
                .disBirimChkBoxBosOlduguKontrolu()

                .birimTuruSec("Dış Birim")
                .filtreSorgulamaPaneliAc()
                .durumSec("Sadece Aktifler")
                .ara()
                .pasifYapButonuKontrolu()
                .aktiflerIlkBirimGuncelle()
                .disBirimChkBoxDoluOlduguKontrolu()

                .birimTuruSec("Dış Birim")
                .durumSec("Sadece Pasifler")
                .ara()
                .aktifYapButonuKontrolu()
                .pasiflerIlkBirimGuncelle()
                .disBirimChkBoxDoluOlduguKontrolu();

    }

}