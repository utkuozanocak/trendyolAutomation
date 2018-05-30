package tests.MayaTestSmoke;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.ustMenuPagesMaya.*;

/****************************************************
 * Tarih: 2018-05-30
 * Proje: SolCRM Functional Test Automation
 * Class: 
 * Yazan: Emre Sencan
 ****************************************************/
public class Satis extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TC0050 : İş emri no ile arama.")
    public void TS0050IsEmriNoIleArama() throws InterruptedException {

        ProjectTaskSearchPage projectTaskSearchPage = new ProjectTaskSearchPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        projectTaskSearchPage
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0051 : Muşteri Ürünü Ara")
    public void TS0051MusteriUrunuAra() throws InterruptedException {

        CustomerAssetSearchPage customerAssetSearchPage = new CustomerAssetSearchPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        customerAssetSearchPage
                .openPage()
                .sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0052 : Taslak Siparişlerim")
    public void TS0052TaslakSiparislerim() throws InterruptedException {

        MyTrackOrdersPage myTrackOrdersPage = new MyTrackOrdersPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        myTrackOrdersPage
                .openPage()
                .sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0053 : Hizmet No ile Sipariş")
    public void TS0053HizmetNoIleSiparis() throws InterruptedException {

        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        trackOrdersPage
                .openPageHizmetNoIleSiparis()
                .hizmetNoIleSiparisSayfaKontrolu();

    }
}
