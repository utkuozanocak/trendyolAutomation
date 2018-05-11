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

    String taskId=GetTestParameter("FoxSearchFlowTest","FiberKurulumTaskId")[0];
    String flowStatus=GetTestParameter("FoxSearchFlowTest","FiberKurulumAkisStatu")[0];

    String username = GetTestParameter("FoxLoginTest", "FoxUserName")[0];
    String password = GetTestParameter("FoxLoginTest", "FoxPassword")[0];


    @BeforeMethod
    public void loginBeforeTests() {
        loginFox(username,password);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Akış Arama")
    public void TS0001_FoxAkisArama() throws InterruptedException {

        MainPageFox mainPageFox = new MainPageFox();
        AkisListesiPage akisListesiPage = new AkisListesiPage();
        KullaniciDegistirPage kullaniciDegistirPage = new KullaniciDegistirPage();
        AkisDetayPage akisDetayPage = new AkisDetayPage();
        StepDetayPage stepDetayPage =new StepDetayPage();


        String akisNo =  FoxSearchFlowNo(taskId,flowStatus)[0].toString();
        String[] dataset = FoxGetUserForChange(akisNo);
        String name = dataset[0];
        String positionName = dataset[1];
        String mesaj="Kullanıcı değiştirilmiştir.";
        String segment = "SOHO";
        String kurulumStatu = "Teslim Edildi / Kurulum Yapıldı";
        String kurulumAltStatu = "Teslim Edildi / Kurulum Yapıldı-Test edildi";
        String akisDurumu = "COZULDU";
        String aciklama = "test otomasyon";



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

        String sozlesmeStatu = "İmzalandı";
        String sozlesmeSubStatu = "Sözleşme, Talep sahibi ile yapıldı";
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

        testToolAc("http://othertest.superonline.net/SOLTestTool/EamControl.aspx");
        String seriNo = GetSerialNumber("PRP","FIBERTEK","Fiber Modem");


    }
}
