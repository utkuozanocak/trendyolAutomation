package tests.testMaya;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;
import pages.ustMenuPagesMaya.TrackOrdersPage;

public class MayaMusteriSiparisleri extends BaseTest {
    String siparisno = "1750150504";
    String tip = "Yeni";
    String status = "İşleniyor";
    String baslangicTarih = "15.05.2018 10:50";
    String tamamlanmaTarih = "15.05.2018 10:50";
    String yaratanOrganizasyon = "00001.00001";


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Siparişleri Sayfası Açılır")
    public void TS0001_MayaMusteriSiparisleriTest() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mainPage
                .musteriDetayliArama();

        searchCustomerCorparatePage
                .unvanDoldur(TestDataMaya.unvan)
                .statuSec(TestDataMaya.statu)
                .segmentSec(TestDataMaya.segment)
                .ara()
                .tablodanIlkKayitTikla();

        trackOrdersPage
                .openMusteriSiparisleriPage()
                .siparisNoGir(siparisno)
                //trackOrdersPage.islemTipiSec(tip);
                //trackOrdersPage.statuSec(status);
                //trackOrdersPage.baslangicTarihiSec(baslangicTarih);
                //trackOrdersPage.tamamlanmaTarihiSec(tamamlanmaTarih);
                //trackOrdersPage.yaratanOrganizasyonSec(yaratanOrganizasyon);
                .siparisSec()
                .yenileButtonTıkla()
                .siparisGecmisTıkla()
                .projelerTıkla()
                .siparisSatirlariTıkla()
                .siparisOzelliklerTikla()
                .siparisOzelliklerKapat()
                .siparisDetayGoruntule()
                .uruneGit();

    }
}
