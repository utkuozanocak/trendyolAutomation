package tests.testFox;

import common.BaseTestFox;
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

public class FoxTest extends BaseTestFox {



    String taskIdAdsl = GetTestParameter("FoxAdslKurulumKapatTest", "AdslKurulumTaskId")[0];
    String flowStatusAdsl = GetTestParameter("FoxAdslKurulumKapatTest", "FiberKurulumAkisStatu")[0];
    String cihazAdsl = GetTestParameter("FoxAdslKurulumKapatTest", "TestToolCihazAdsl")[0];

    String flowStatus = GetTestParameter("FoxKurulumKapatTest", "FiberKurulumAkisStatu")[0];
    String taskId = GetTestParameter("FoxKurulumKapatTest", "FiberKurulumTaskId")[0];
    String username = GetTestParameter("FoxLoginTest", "FoxUserName")[0];
    String password = GetTestParameter("FoxLoginTest", "FoxPassword")[0];
    String seriNoFttb = null;
    String seriNoGpon = null;
    String seriNoAdsl = null;
    String mesaj= GetTestParameter("FoxKurulumKapatTest", "KullaniciDegistirMesaj")[0];
    String segment = GetTestParameter("FoxKurulumKapatTest", "CustomerSegmentSoho")[0];
    String kurulumStatu = GetTestParameter("FoxKurulumKapatTest", "KurulumYapıldı")[0];
    String kurulumAltStatu = GetTestParameter("FoxKurulumKapatTest", "TeslimEdildi")[0];
    String akisDurumu = GetTestParameter("FoxKurulumKapatTest", "AkisDurumuCozuldu")[0];
    String aciklama =  GetTestParameter("FoxKurulumKapatTest", "Aciklama")[0];
    String sozlesmeStatu = GetTestParameter("FoxKurulumKapatTest", "sozlesmeStatu")[0];
    String sozlesmeSubStatu = GetTestParameter("FoxKurulumKapatTest", "sozlesmeSubStatu")[0];
    String ortamPrp = GetTestParameter("FoxKurulumKapatTest", "TestToolPRP")[0];
    String depoFibertek = GetTestParameter("FoxKurulumKapatTest", "TestToolDepoFIBERTEK")[0];
    String cihazFttb = GetTestParameter("FoxKurulumKapatTest", "TestToolCihazFttb")[0];
    String cihazGpon = GetTestParameter("FoxKurulumKapatTest", "TestToolCihazGpon")[0];
    String eamControlUrl = GetTestParameter("FoxKurulumKapatTest", "eamControlUrl")[0];
    String basariliMesaj =  GetTestParameter("FoxKurulumKapatTest", "foxAkisGonderMesaj")[0];
    String EAMmesaj = GetTestParameter("FoxKurulumKapatTest", "eamKontrolMesaj")[0];


    MainPageFox mainPageFox = new MainPageFox();
    AkisListesiPage akisListesiPage = new AkisListesiPage();
    KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
    AkisDetayPage akisDetayPage = new AkisDetayPage();
    StepDetayPage stepDetayPage = new StepDetayPage();

    @BeforeMethod
    public void loginBeforeTests() {
        loginFox(username, password);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Fiber Kurulum Kapama")
    public void TS0001_FoxKurulumKapat() throws InterruptedException {
        sameProcess(taskId,flowStatus,mesaj,segment,akisDurumu,aciklama,kurulumStatu,kurulumAltStatu,sozlesmeStatu,sozlesmeSubStatu);
        String altYapi = stepDetayPage.teknikFormTabAc().altYapiBilgisiAl();
        cihazSeriNoGetir(altYapi);
        if (altYapi.equals("FTTb")) {
            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(seriNoFttb)
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat();
        } else if (altYapi.equals("GPON")) {
            stepDetayPage
                    .teknikFormTabAc()
                    .tabloSeriNoGiris("GENERIC")
                    .yeniCihazSeriNoDoldur(seriNoFttb)
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat()
                    .tabloSeriNoGiris("ONT")
                    .yeniCihazSeriNoDoldur(seriNoGpon)
                    .guncelle()
                    .mesajKontrolu("Güncelleme işlemi tamamlanmıştır")
                    .seriNoGirisEkraniKapat();
        }
        stepDetayPage
                .teknikFormTabAc()
                .seriNoKontrol()
                .EAMmesajKontrol(EAMmesaj)
                .EAMmesajKontrolTamam()
                .gonder();
        mainPageFox.mesajKontrol(basariliMesaj);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Adsl Kurulum Kapama")
    public void TS0001_FoxAdslKurulumKapat() throws InterruptedException {
        sameProcess(taskIdAdsl,flowStatusAdsl,mesaj,segment,akisDurumu,aciklama,kurulumStatu,kurulumAltStatu,sozlesmeStatu,sozlesmeSubStatu);
        testToolAc(eamControlUrl);
        seriNoAdsl = GetSerialNumber(ortamPrp,depoFibertek,cihazAdsl);
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
                .EAMmesajKontrol(EAMmesaj)
                .EAMmesajKontrolTamam()
                .gonder();
        mainPageFox.mesajKontrol(basariliMesaj);
    }
    
    private void cihazSeriNoGetir(String altYapi) {
        if(altYapi.equals("FTTb"))
        {
            testToolAc(eamControlUrl);
            seriNoFttb = GetSerialNumber(ortamPrp,depoFibertek,cihazFttb);
            switchTo().window(0);
        }
        else if (altYapi.equals("GPON"))
        {
            testToolAc(eamControlUrl);
            seriNoFttb = GetSerialNumber(ortamPrp,depoFibertek,cihazFttb);
            testToolAc(eamControlUrl);
            seriNoGpon = GetSerialNumber(ortamPrp,depoFibertek,cihazGpon);
            switchTo().window(0);

        }
    }
    private void sameProcess(String foxTaskId,String foxFlowStatu,String foxUserChangeMessage,
                             String foxCustomerSegment,String foxAkisDurumu,String Aciklama,
                             String foxKurulumStatu,String foxKurulumAltStatu,String foxSozlesmeStatu,String foxSozlesmeSubStatu) {
        String akisNo = FoxSearchFlowNo(foxTaskId, foxFlowStatu)[0].toString();
        String[] dataset = FoxGetUserForChange(akisNo);
        String name = dataset[0];
        String positionName = dataset[1];
        akisListesiPage.openPage();
        mainPageFox.akisNoDoldur(akisNo);
        akisListesiPage.akisDetay(akisNo);
        mainPageFox.kullaniciDegistir();
        kullaniciDegistirPage
                .organizasyonSec(name)
                .pozisyonSec(positionName)
                .ara()
                .tablodanIlkKayitSec();
        mainPageFox.mesajKontrol(foxUserChangeMessage);
        akisListesiPage.openPage();
        mainPageFox.akisNoDoldur(akisNo);
        akisListesiPage.akisDetay(akisNo);
        akisDetayPage.kurulumAdımınaTikla();
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
