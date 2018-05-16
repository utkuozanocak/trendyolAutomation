package tests.testMaya;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.AdresBilgileriPage;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;
import pages.ustMenuPagesMaya.TrackOrdersPage;

public class MayaMusteriSiparisleri extends BaseTest {
    String  siparisno = "1750150504";
    String  tip = "Yeni";
    String  status = "İşleniyor";
    String  baslangicTarih ="15.05.2018 10:50";
    String  tamamlanmaTarih ="15.05.2018 10:50";
    String  yaratanOrganizasyon ="00001.00001";

    MayaTest mayaTest = new MayaTest();
    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Siparişleri Sayfası Açılır")
    public void TS0001_MayaMusteriSiparisleriTest() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(TestDataMaya.unvan)
                .statuSec(TestDataMaya.statu)
                .segmentSec(TestDataMaya.segment)
                .ara()
                .tablodanIlkKayitTikla();
        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();
        trackOrdersPage.openPage();
        trackOrdersPage.siparisNoGir(siparisno);
        //trackOrdersPage.islemTipiSec(tip);
        //trackOrdersPage.statuSec(status);
        //trackOrdersPage.baslangicTarihiSec(baslangicTarih);
        //trackOrdersPage.tamamlanmaTarihiSec(tamamlanmaTarih);
        //trackOrdersPage.yaratanOrganizasyonSec(yaratanOrganizasyon);
        trackOrdersPage.siparisSec();


    }
}
