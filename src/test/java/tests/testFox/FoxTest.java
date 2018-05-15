package tests.testFox;

import common.BaseTest;
import data.TestDataFox;
import pages.MainPageFox;
import pages.ustMenuPagesFox.AkisDetayPage;
import pages.ustMenuPagesFox.AkisListesiPage;
import pages.ustMenuPagesFox.KullaniciDegistirPage;
import pages.ustMenuPagesFox.StepDetayPage;

import static com.codeborne.selenide.Selenide.switchTo;

public class FoxTest extends BaseTest {

    String seriNoFttb = null;
    String seriNoGpon = null;
    String seriNoAdsl = null;
    MainPageFox mainPageFox = new MainPageFox();
    AkisListesiPage akisListesiPage = new AkisListesiPage();
    KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
    AkisDetayPage akisDetayPage = new AkisDetayPage();
    StepDetayPage stepDetayPage = new StepDetayPage();


    public void cihazSeriNoGetir(String altYapi) {
        if(altYapi.equals("FTTb"))
        {
            testToolAc(TestDataFox.eamControlUrl);
            seriNoFttb = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazFttb);
            switchTo().window(0);
        }
        else if (altYapi.equals("GPON"))
        {
            testToolAc(TestDataFox.eamControlUrl);
            seriNoFttb = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazFttb);
            testToolAc(TestDataFox.eamControlUrl);
            seriNoGpon = GetSerialNumber(TestDataFox.ortamPrp,TestDataFox.depoFibertek,TestDataFox.cihazGpon);
            switchTo().window(0);

        }
    }
    public void sameProcess(String foxTaskId,String foxFlowStatu,String foxUserChangeMessage,
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
