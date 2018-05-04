//package tests.EnUygun;
//
//import com.codeborne.selenide.Selenide;
//import common.BaseTest;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.ustMenuPages.UcakBiletiPage;
//
//import static com.codeborne.selenide.Selenide.$;
//
///****************************************************
// * Tarih: 2017-12-22
// * Proje: Türksat Functional Test Automation
// * Class: "Evrak kontroller" konulu senaryoları içerir
// * Yazan: Emre Sencan
// ****************************************************/
//public class EnUygunTest extends BaseTest {
//
//    UcakBiletiPage ucakBiletiPage;
//
//
////    MainPage mainPage;
////    VekaletVerPage vekaletVerPage;
////    GelenEvraklarPage gelenEvraklarPage;
////    VekaletOnaylariPage vekaletOnaylariPage;
////    EvrakOlusturPage evrakOlusturPage;
////    ImzaBekleyenlerPage imzaBekleyenlerPage;
////    ParafladiklarimPage parafladiklarimPage;
////    GelenEvrakKayitPage gelenEvrakKayitPage;
////    KullaniciYonetimiPage kullaniciYonetimiPage;
////    ReusableSteps reusableSteps;
////
////    String aciklama = "";
////    String redNedeni = "";
////    String vekaletVeren = "Optiim TEST1";
////    String vekaletAlan = "Optiim TEST2";
////    String evrakNo1 = "";
////    String evrakNo2 = "";
////    String basariMesaji = "İşlem başarılıdır!";
////    String tur = "IMZALAMA";
////    String icerik = "Test Otomasyon " + getSysDate();
////    String konuKodu = "010.01";
////    String kaldiralacakKlasor = "Diğer";
////    String evrakTuru = "Resmi Yazışma";
////    String evrakDili = "Türkçe";
////    String gizlilikDerecesi = "Normal";
////    String ivedilik = "Normal";
////    String geregi = "Optiim Birim";
////    String vekaletBirimi = "YAZILIM GELİŞTİRME DİREKTÖRLÜĞÜ";
//
//
////    User optiim = new User("optiim", "123");
////    User yakyol = new User("yakyol", "123");
////    User mbozdemir = new User("mbozdemir", "123");
////    User ztekin = new User("ztekin", "123");
////    User usernameVV = new User("unvv", "123");
////    User usernameVA = new User("usernameva", "123");
////    String nameVV = "Unvv TEST";
////    String nameVA = "Usernameva TEST";
//
//    @BeforeMethod
//    public void loginBeforeTests() {
//        Selenide.open("");
//        ucakBiletiPage=new UcakBiletiPage();
////        vekaletVerPage = new VekaletVerPage();
////        gelenEvraklarPage = new GelenEvraklarPage();
////        vekaletOnaylariPage = new VekaletOnaylariPage();
////        evrakOlusturPage = new EvrakOlusturPage();
////        imzaBekleyenlerPage = new ImzaBekleyenlerPage();
////        parafladiklarimPage = new ParafladiklarimPage();
////        mainPage = new MainPage();
////        gelenEvrakKayitPage = new GelenEvrakKayitPage();
////        kullaniciYonetimiPage = new KullaniciYonetimiPage();
////        reusableSteps = new ReusableSteps();
//    }
//
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(enabled = true
//            , description = "")
//    public void TS0001() throws InterruptedException {
//
//        ucakBiletiPage.openPage();
//
//    }
//}
