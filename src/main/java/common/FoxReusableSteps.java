package common;

import data.TestDataFox;
import io.qameta.allure.Step;
import pages.MainPageFox;
import pages.ustMenuPagesFox.AkisDetayPage;
import pages.ustMenuPagesFox.AkisListesiPage;
import pages.ustMenuPagesFox.KullaniciDegistirPage;
import pages.ustMenuPagesFox.StepDetayPage;

import java.awt.*;

public class FoxReusableSteps extends BaseLibrary {

    String seriNoFttb = null;
    String seriNoGpon = null;
    String seriNoAdsl = null;

    @Step("Testte kullanılmak üzere cihaz seri no alınır.")
    public void cihazSeriNoGetir() throws InterruptedException, AWTException {
        testToolAc(TestDataFox.eamControlUrl);
        seriNoFttb = GetSerialNumber(TestDataFox.ortamPrp, TestDataFox.depoFibertek, TestDataFox.cihazFttb);
        testToolAc(TestDataFox.eamControlUrl);
        seriNoGpon = GetSerialNumber(TestDataFox.ortamPrp, TestDataFox.depoFibertek, TestDataFox.cihazGpon);
    }

    public String seriNoFttb() {
        return seriNoFttb;
    }

    public String seriNoGpon() {
        return seriNoGpon;
    }

    public void sameProcess(String foxTaskId, String foxFlowStatu, String foxUserChangeMessage,
                            String foxCustomerSegment, String foxAkisDurumu, String Aciklama,
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
