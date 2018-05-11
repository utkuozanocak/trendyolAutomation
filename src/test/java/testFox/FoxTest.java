package testFox;

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

public class FoxTest extends BaseTestFox {

    String taskId=GetTestParameter("FoxKurulumKapatTest","FiberKurulumTaskId")[0];
    String flowStatus=GetTestParameter("FoxKurulumKapatTest","FiberKurulumAkisStatu")[0];

    String username = GetTestParameter("FoxLoginTest", "FoxUserName")[0];
    String password = GetTestParameter("FoxLoginTest", "FoxPassword")[0];
    String seriNoFttb=null;
    String seriNoGpon=null;
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
    @BeforeMethod
    public void loginBeforeTests() {
        loginFox(username,password);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Akış Arama")
    public void TS0001_FoxKurulumKapat() throws InterruptedException {

        MainPageFox mainPageFox = new MainPageFox();
        AkisListesiPage akisListesiPage = new AkisListesiPage();
        KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
        AkisDetayPage akisDetayPage = new AkisDetayPage();
        StepDetayPage stepDetayPage =new StepDetayPage();
        String akisNo =  FoxSearchFlowNo(taskId,flowStatus)[0].toString();
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
                .tablodanIlkKayitSe();
        mainPageFox.mesajKontrol(mesaj);
        akisListesiPage.openPage();
        mainPageFox.akisNoDoldur(akisNo);
        akisListesiPage.akisDetay(akisNo);
        akisDetayPage.kurulumAdımınaTikla();
        stepDetayPage
                .uzerineAl()
                .pazarlamaSegmentiSec(segment)
                .akisDurumuSec(akisDurumu)
                .bayiOtomasyondanCikar()
                .aciklamaDoldur(aciklama)
                .aciklamaEkle()
                .teknikFormTabAc()
                .kurulumStatuSec(kurulumStatu)
                .kurulumAltStatuSec(kurulumAltStatu)
                .sozlesmeStatuSec(sozlesmeStatu)
                .sozlesmeSubStatuSec(sozlesmeSubStatu);
               String altYapi =  stepDetayPage.teknikFormTabAc().altYapiBilgisiAl();
               cihazSeriNoGetir(altYapi);
        stepDetayPage.teknikFormTabAc();
    }

    private void cihazSeriNoGetir(String altYapi) {
        if(altYapi.equals("FTTb"))
        {
            testToolAc(eamControlUrl);
            seriNoFttb = GetSerialNumber(ortamPrp,depoFibertek,cihazFttb);
        }
        else if (altYapi.equals("GPON"))
        {
            testToolAc(eamControlUrl);
            seriNoFttb = GetSerialNumber(ortamPrp,depoFibertek,cihazFttb);
            testToolAc(eamControlUrl);
            seriNoGpon = GetSerialNumber(ortamPrp,depoFibertek,cihazGpon);
        }
    }
}
