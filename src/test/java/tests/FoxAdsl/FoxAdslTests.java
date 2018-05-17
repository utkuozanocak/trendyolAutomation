package tests.FoxAdsl;

import common.BaseTest;
import data.TestDataFox;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FoxTest;
import pages.MainPageFox;
import pages.ustMenuPagesFox.AkisDetayPage;
import pages.ustMenuPagesFox.AkisListesiPage;
import pages.ustMenuPagesFox.KullaniciDegistirPage;
import pages.ustMenuPagesFox.StepDetayPage;

import java.awt.*;

import static com.codeborne.selenide.Selenide.switchTo;

public class FoxAdslTests extends BaseTest {
    FoxTest foxTest = new FoxTest();
    MainPageFox mainPageFox = new MainPageFox();
    AkisListesiPage akisListesiPage = new AkisListesiPage();
    KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
    AkisDetayPage akisDetayPage = new AkisDetayPage();
    StepDetayPage stepDetayPage = new StepDetayPage();
    @BeforeMethod
    public void loginBeforeTests() {

    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Adsl Kurulum Kapama")
    public void TS0001_FoxAdslKurulumKapat() throws InterruptedException, AWTException {

        testToolAc(TestDataFox.eamControlUrl);
        String seriNoAdsl = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazAdsl);

        loginFox(TestDataFox.username, TestDataFox.password);

        foxTest.sameProcess(TestDataFox.taskIdAdsl,TestDataFox.flowStatusAdsl,TestDataFox.mesaj,TestDataFox.segment,
                TestDataFox.akisDurumu,TestDataFox.aciklama,TestDataFox.kurulumStatu,
                TestDataFox.kurulumAltStatu,TestDataFox.sozlesmeStatu,TestDataFox.sozlesmeSubStatu);



//        testToolAc(TestDataFox.eamControlUrl);

//        String seriNoAdsl = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazAdsl);

        switchTo().window(0);

        stepDetayPage
                .teknikFormTabAc()
                .tabloSeriNoGiris("AIRTIES")
                .yeniCihazSeriNoDoldur(seriNoAdsl)
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
