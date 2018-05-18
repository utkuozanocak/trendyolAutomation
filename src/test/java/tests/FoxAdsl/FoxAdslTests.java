package tests.FoxAdsl;

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

import static com.codeborne.selenide.Selenide.switchTo;

public class FoxAdslTests extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Adsl Kurulum Kapama")
    public void TS0001_FoxAdslKurulumKapat() throws InterruptedException, AWTException {

        FoxReusableSteps foxReusableSteps = new FoxReusableSteps();
        MainPageFox mainPageFox = new MainPageFox();
        StepDetayPage stepDetayPage = new StepDetayPage();

        testToolAc(TestDataFox.eamControlUrl);

        String seriNoAdsl = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazAdsl);

        loginFox(TestDataFox.username, TestDataFox.password);

        foxReusableSteps.sameProcess(TestDataFox.taskIdAdsl,TestDataFox.flowStatusAdsl,TestDataFox.mesaj,TestDataFox.segment,
                TestDataFox.akisDurumu,TestDataFox.aciklama,TestDataFox.kurulumStatu,
                TestDataFox.kurulumAltStatu,TestDataFox.sozlesmeStatu,TestDataFox.sozlesmeSubStatu);

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
