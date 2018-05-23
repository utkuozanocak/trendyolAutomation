package tests.FoxFiber;

import common.BaseTest;
import common.FoxReusableSteps;
import data.TestDataFox;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageFox;
import pages.ustMenuPagesFox.StepDetayPage;

import java.awt.*;

public class FiberFoxTests extends BaseTest {

    @BeforeMethod
    public void loginBeforeTests() {

    }
    String customerNo;
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Fiber Kurulum Kapama")
    public void TS0001_FoxKurulumKapat() throws InterruptedException, AWTException {

        FoxReusableSteps foxReusableSteps = new FoxReusableSteps();
        MainPageFox mainPageFox = new MainPageFox();
        StepDetayPage stepDetayPage = new StepDetayPage();

        String altYapi;

        foxReusableSteps.cihazSeriNoGetir("FTTB");
        foxReusableSteps.cihazSeriNoGetir("GPON");

        loginFox(TestDataFox.username, TestDataFox.password);

        foxReusableSteps.foxTicketingProcess(TestDataFox.taskId, TestDataFox.flowStatus, TestDataFox.mesaj, TestDataFox.segment,
                TestDataFox.akisDurumu, TestDataFox.aciklama, TestDataFox.kurulumStatu, TestDataFox.kurulumAltStatu,
                TestDataFox.sozlesmeStatu, TestDataFox.sozlesmeSubStatu);
         altYapi = stepDetayPage.teknikFormTabAc().altYapiBilgisiAl();

        if (altYapi.equals("FTTb")) {

            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(foxReusableSteps.seriNoFttb())
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat();
        }
        else if (altYapi.equals("GPON")) {

            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(foxReusableSteps.seriNoFttb())
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat()
                    .tabloSeriNoGiris("ONT")
                    .yeniCihazSeriNoDoldur(foxReusableSteps.seriNoGpon())
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

        mainPageFox
                .mesajKontrol(TestDataFox.basariliMesaj);

    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = false, description = "Fox Fiber İkinci Donanım Kurulum Kapama")
    public void TS0001_FoxIkinciDonanimKurulumKapatTest() throws InterruptedException, AWTException {
        FoxReusableSteps foxReusableSteps = new FoxReusableSteps();
        StepDetayPage stepDetayPage = new StepDetayPage();
        MainPageFox mainPageFox = new MainPageFox();

        foxReusableSteps.cihazSeriNoGetir("DECT");

        loginFox(TestDataFox.username, TestDataFox.password);

        foxReusableSteps.foxTicketingProcess(TestDataFox.taskIdIkinciDonanim, TestDataFox.flowStatus, TestDataFox.mesaj, TestDataFox.segment,
                TestDataFox.akisDurumu, TestDataFox.aciklama, TestDataFox.kurulumStatu, TestDataFox.kurulumAltStatu,
                TestDataFox.sozlesmeStatu, TestDataFox.sozlesmeSubStatu);
        stepDetayPage
                .teknikFormTabAc()
                .ikinciDonanimSeriNoDoldur(foxReusableSteps.seriNoDect())
                .seriNoKontrol()
                .EAMmesajKontrol(TestDataFox.EAMmesaj)
                .EAMmesajKontrolTamam()
                .gonder();
        mainPageFox
                .mesajKontrol(TestDataFox.basariliMesaj);
    }
}
