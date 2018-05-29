package tests.SolCrmE2E;

import common.BaseTest;
import common.FoxReusableSteps;
import common.MayaReusableSteps;
import data.TestDataFox;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.MainPageFox;
import pages.MainPageMaya;
import pages.ustMenuPagesFox.AkisDetayPage;
import pages.ustMenuPagesFox.AkisListesiPage;
import pages.ustMenuPagesFox.KullaniciDegistirPage;
import pages.ustMenuPagesFox.StepDetayPage;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;
import pages.ustMenuPagesMaya.TrackOrdersPage;
import tests.FoxFiber.FiberFoxTests;
import tests.MayaTestFiber.MayaFiberTests;

import java.awt.*;

public class SolCrmAll extends BaseTest {
    MayaFiberTests mayaFiberTests = new MayaFiberTests();
    FiberFoxTests fiberFoxTests = new FiberFoxTests();
    String customerNo;
    String siparisNo;

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, invocationCount = 10, description = "TS0001 : Kurumsal Fiber Siparis Giris")
    public void KurumsalFiberSiparisGirisVeKapama() throws InterruptedException, AWTException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();
        FoxReusableSteps foxReusableSteps =new FoxReusableSteps();
        StepDetayPage stepDetayPage = new StepDetayPage();
        MainPageFox mainPageFox = new MainPageFox();

        foxReusableSteps.cihazSeriNoGetir("FTTB");
        foxReusableSteps.cihazSeriNoGetir("GPON");

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        customerNo = mayaReusableSteps.customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        OrderCapturePage orderCapturePage = new OrderCapturePage();
        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .fiberAc()
                .openPage()
                .degistirTikla()
                .lokasyonIDDoldur(TestDataMaya.locationId)
                .Ara()
                .tablodanLokasyonSec()
                .lokasyonSec()
                .daireNoDoldur(TestDataMaya.daireNo)
                .daireNoSec(TestDataMaya.daireNo)
                .kaydet()
                .kampanyaAra(TestDataMaya.fiberKampanya)
                .tablodanKampanyaSec(TestDataMaya.fiberKampanya)
                .kampanyaSec()
                .hizSec(TestDataMaya.hiz)
                .siparisEkle()
                .siparişOluştur();

        trackOrdersPage
                .sayfaKontrolu();
        siparisNo = trackOrdersPage.tablodanIlkSiparisNoAl();


        int testId = getTestId("TS0001_KurumsalFiberSiparisGiris")[0];

        insertCustomer(Integer.parseInt(customerNo), true, testId, getDateTime().toString(), siparisNo);

        String altYapi;

        loginFox(TestDataFox.username, TestDataFox.password);

        foxReusableSteps.foxTicketingProcess(TestDataFox.taskId, TestDataFox.flowStatus, TestDataFox.mesaj, TestDataFox.segment,
                TestDataFox.akisDurumu, TestDataFox.aciklama, TestDataFox.kurulumStatu, TestDataFox.kurulumAltStatu,
                TestDataFox.sozlesmeStatu, TestDataFox.sozlesmeSubStatu, "TS0001_KurumsalFiberSiparisGiris");
        altYapi = stepDetayPage.teknikFormTabAc().altYapiBilgisiAl();

        if (altYapi.equals("FTTb")) {

            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(foxReusableSteps.seriNoFttb())
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat();
        } else if (altYapi.equals("GPON")) {

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
}
