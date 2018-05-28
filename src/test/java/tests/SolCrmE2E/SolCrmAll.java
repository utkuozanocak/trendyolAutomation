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
import tests.FoxFiber.FiberFoxTests;
import tests.MayaTestFiber.MayaFiberTests;

import java.awt.*;

public class SolCrmAll extends BaseTest {
    MayaFiberTests mayaFiberTests = new MayaFiberTests();
    FiberFoxTests fiberFoxTests = new FiberFoxTests();
    String customerNo;

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Sipariş Giriş Testi")
    public void TS0001_MayaCreateOrderE2ETest() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();

        searchCustomerCorparatePage
                .unvanDoldur(TestDataMaya.unvan)
                .statuSec(TestDataMaya.statu)
                .segmentSec(TestDataMaya.segment)
                .ara();
        customerNo = searchCustomerCorparatePage.tabloRandomMusteriNoSecVeAl();

//        customerNo = searchCustomerCorparatePage.tabloIlkMusteriNoAl();

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
    }

    @Severity(SeverityLevel.CRITICAL)

    @Test(enabled = true, dependsOnMethods = {"TS0001_MayaCreateOrderE2ETest"}, description = "Fox Fiber Kurulum Kapama")

    public void TS0001_FoxKurulumKapat() throws InterruptedException, AWTException {

        FoxReusableSteps foxReusableSteps = new FoxReusableSteps();
        MainPageFox mainPageFox = new MainPageFox();
        StepDetayPage stepDetayPage = new StepDetayPage();

        String altYapi;

        foxReusableSteps.cihazSeriNoGetir("FTTB");
        foxReusableSteps.cihazSeriNoGetir("GPON");

        loginFox(TestDataFox.username, TestDataFox.password);
        if (customerNo.equals(null)) {
            foxTicketingProcess(TestDataFox.taskId, TestDataFox.flowStatus, TestDataFox.mesaj, TestDataFox.segment,
                    TestDataFox.akisDurumu, TestDataFox.aciklama, customerNo, TestDataFox.kurulumStatu, TestDataFox.kurulumAltStatu,
                    TestDataFox.sozlesmeStatu, TestDataFox.sozlesmeSubStatu);
        } else {
            foxTicketingProcess(TestDataFox.taskId, TestDataFox.flowStatus, TestDataFox.mesaj, TestDataFox.segment,
                    TestDataFox.akisDurumu, TestDataFox.aciklama, customerNo, TestDataFox.kurulumStatu, TestDataFox.kurulumAltStatu,
                    TestDataFox.sozlesmeStatu, TestDataFox.sozlesmeSubStatu);
        }

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

    @Step("Fox Akış işlemleri tamamladı.")
    public void foxTicketingProcess(String foxTaskId, String foxFlowStatu, String foxUserChangeMessage,
                                    String foxCustomerSegment, String foxAkisDurumu, String Aciklama, String CustomerNo,
                                    String foxKurulumStatu, String foxKurulumAltStatu, String foxSozlesmeStatu, String foxSozlesmeSubStatu) {

        MainPageFox mainPageFox = new MainPageFox();
        AkisListesiPage akisListesiPage = new AkisListesiPage();
        KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
        AkisDetayPage akisDetayPage = new AkisDetayPage();
        StepDetayPage stepDetayPage = new StepDetayPage();

        String akisNo = FoxSearchFlowNo(foxTaskId, foxFlowStatu)[0].toString();
        String[] dataset = FoxGetUserForChange(akisNo);
        String name = dataset[0];
        String positionName = dataset[1];

        akisListesiPage
                .openPage();
        mainPageFox
                .akisNoDoldur(akisNo);

        akisListesiPage
                .akisDetay(akisNo);

        mainPageFox
                .kullaniciDegistir();

        kullaniciDegistirPage
                .organizasyonSec(name)
                .pozisyonSec(positionName)
                .ara()
                .tablodanIlkKayitSec();

        mainPageFox
                .mesajKontrol(foxUserChangeMessage);

        akisListesiPage
                .openPage();

        mainPageFox
                .akisNoDoldur(akisNo);

        akisListesiPage
                .akisDetay(akisNo);

        akisDetayPage
                .kurulumAdımınaTikla();

        stepDetayPage
                .uzerineAl()
                .pazarlamaSegmentiSec(foxCustomerSegment)
                .akisDurumuSec(foxAkisDurumu)
                .bayiOtomasyondanCikar()
                .aciklamaDoldur(Aciklama)
                .aciklamaEkle()
                .teknikFormTabAc()
                .kurulumStatuSec(foxKurulumStatu)
                .kurulumAltStatuSec(foxKurulumAltStatu)
                .sozlesmeStatuSec(foxSozlesmeStatu)
                .sozlesmeSubStatuSec(foxSozlesmeSubStatu);
    }
}
