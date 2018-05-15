package tests.testFox;

import common.BaseTest;
import data.TestDataFox;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageFox;
import pages.ustMenuPagesFox.AkisDetayPage;
import pages.ustMenuPagesFox.AkisListesiPage;
import pages.ustMenuPagesFox.KullaniciDegistirPage;
import pages.ustMenuPagesFox.StepDetayPage;

import static com.codeborne.selenide.Selenide.switchTo;

public class AdslTests extends BaseTest {
    FoxTest foxTest = new FoxTest();
    MainPageFox mainPageFox = new MainPageFox();
    AkisListesiPage akisListesiPage = new AkisListesiPage();
    KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
    AkisDetayPage akisDetayPage = new AkisDetayPage();
    StepDetayPage stepDetayPage = new StepDetayPage();
    @BeforeMethod
    public void loginBeforeTests() {
        loginFox(TestDataFox.username, TestDataFox.password);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Adsl Kurulum Kapama")
    public void TS0001_FoxAdslKurulumKapat() throws InterruptedException {
        foxTest.sameProcess(TestDataFox.taskIdAdsl,TestDataFox.flowStatusAdsl,TestDataFox.mesaj,TestDataFox.segment,
                TestDataFox.akisDurumu,TestDataFox.aciklama,TestDataFox.kurulumStatu,
                TestDataFox.kurulumAltStatu,TestDataFox.sozlesmeStatu,TestDataFox.sozlesmeSubStatu);
        testToolAc(TestDataFox.eamControlUrl);
        foxTest.seriNoAdsl = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazAdsl);
        switchTo().window(0);
        stepDetayPage
                .teknikFormTabAc()
                .tabloSeriNoGiris("AIRTIES")
                .yeniCihazSeriNoDoldur(TestDataFox.seriNoAdsl)
                .guncelle()
                .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                .seriNoGirisEkraniKapat();
        stepDetayPage
                .teknikFormTabAc()
                .seriNoKontrol()
                .EAMmesajKontrol(TestDataFox.EAMmesaj)
                .EAMmesajKontrolTamam()
                .gonder();
        mainPageFox.mesajKontrol(TestDataFox.basariliMesaj);
    }
}
