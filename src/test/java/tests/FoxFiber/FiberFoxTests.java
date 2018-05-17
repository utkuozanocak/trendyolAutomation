package tests.FoxFiber;

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

public class FiberFoxTests extends BaseTest {
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
    @Test(enabled = true, description = "Fox Fiber Kurulum Kapama")
    public void TS0001_FoxKurulumKapat() throws InterruptedException, AWTException {
        String altYapi;
        foxTest.cihazSeriNoGetir();
        loginFox(TestDataFox.username, TestDataFox.password);

        foxTest.sameProcess(TestDataFox.taskId, TestDataFox.flowStatus, TestDataFox.mesaj, TestDataFox.segment,
                TestDataFox.akisDurumu, TestDataFox.aciklama, TestDataFox.kurulumStatu, TestDataFox.kurulumAltStatu,
                TestDataFox.sozlesmeStatu, TestDataFox.sozlesmeSubStatu);
         altYapi = stepDetayPage.teknikFormTabAc().altYapiBilgisiAl();

//        foxTest.cihazSeriNoGetir(altYapi);

//        switchTo().window(0);

        if (altYapi.equals("FTTb")) {
            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(foxTest.seriNoFttb())
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat();
        } else if (altYapi.equals("GPON")) {
            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(foxTest.seriNoFttb())
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat()
                    .tabloSeriNoGiris("ONT")
                    .yeniCihazSeriNoDoldur(foxTest.seriNoGpon())
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat();
        }
        stepDetayPage
                .teknikFormTabAc()
                .seriNoKontrol()
                .EAMmesajKontrol(TestDataFox.EAMmesaj)
                .EAMmesajKontrolTamam()
                .gonder();
        mainPageFox.mesajKontrol(TestDataFox.basariliMesaj);

    }
}
