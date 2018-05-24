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
    String seriNoDect = null;

    @Step("Testte kullanılmak üzere cihaz seri no alınır.")
    public void cihazSeriNoGetir(String cihaz) throws InterruptedException, AWTException {

        switch(cihaz){
            case "DECT":
                testToolAc(TestDataFox.eamControlUrl);
                seriNoDect = GetSerialNumber(TestDataFox.ortamPrp, TestDataFox.depoFibertek, TestDataFox.cihazDect);
                break;
            case "FTTB":
                testToolAc(TestDataFox.eamControlUrl);
                seriNoFttb = GetSerialNumber(TestDataFox.ortamPrp, TestDataFox.depoFibertek, TestDataFox.cihazFttb);
                break;
            case "GPON":
                testToolAc(TestDataFox.eamControlUrl);
                seriNoGpon = GetSerialNumber(TestDataFox.ortamPrp, TestDataFox.depoFibertek, TestDataFox.cihazGpon);
                break;
        }
    }

    public String seriNoFttb() {
        return seriNoFttb;
    }

    public String seriNoGpon() {
        return seriNoGpon;
    }
    public String seriNoDect() {
        return seriNoDect;
    }

    @Step("Fox Akış işlemleri tamamladı.")
    public void foxTicketingProcess(String foxTaskId, String foxFlowStatu, String foxUserChangeMessage,
                            String foxCustomerSegment, String foxAkisDurumu, String Aciklama,
                            String foxKurulumStatu, String foxKurulumAltStatu, String foxSozlesmeStatu, String foxSozlesmeSubStatu,
                                    String testName) {

        MainPageFox mainPageFox = new MainPageFox();
        AkisListesiPage akisListesiPage = new AkisListesiPage();
        KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
        AkisDetayPage akisDetayPage = new AkisDetayPage();
        StepDetayPage stepDetayPage = new StepDetayPage();
        Integer customerNo = GetCustomer(testName,true)[0];
        String CustomerNo = String.valueOf(customerNo);
        String akisNo = FoxSearchFlowNo(foxTaskId, foxFlowStatu, CustomerNo)[0].toString();
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
