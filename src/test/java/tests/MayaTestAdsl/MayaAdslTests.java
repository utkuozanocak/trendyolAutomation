package tests.MayaTestAdsl;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.OrderCapturePage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

public class MayaAdslTests extends BaseTest {

    String customerNo;
    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0006 : Kurumsal ADSL Siparis Giris.")
    public void TS0001_KurumsalADSLSiparisGiris() throws InterruptedException {

        OrderCapturePage orderCapturePage = new OrderCapturePage();
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        String erisimNo = mayaReusableSteps.erisimNoGetir();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerNo = searchCustomerCorparatePage.tabloIlkMusteriNoAl();
        orderCapturePage
                .siparisOlusturSayfaAc();
        orderCapturePage.adslAc().hizmetAdresiSec();
        // String x=orderCapturePage.adslAc().getAdres();
        orderCapturePage
                .siparseUrunEkleTikla()
                .adslAc()
                .openPage()
                .dslHizSec()
                .dslTipiSec("Standart DSL");

        orderCapturePage
                .adslAc()
                .erisimNoGir(erisimNo)
                .ttHizmetSorgulama()
                .dslSunuSec()
                .kampanyaAraDsl(TestDataMaya.adslKampanya)
                .tablodanKampanyaSecDsl(TestDataMaya.adslKampanya)
                .hizSecAdsl(TestDataMaya.adslHiz)
                .siparisEkle()
                .siparişOluştur();
        int testId = getTestId(Test.class.getName())[0];
        insertCustomer(testId,Integer.parseInt(customerNo),true);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = false, description = "TS0007 : Kurumsal VDSL Siparis Giris.")
    public void TS0007_KurumsalVDSLSiparisGiris() throws InterruptedException {

        MainPageMaya mainPage = new MainPageMaya();
        OrderCapturePage orderCapturePage = new OrderCapturePage();
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();


        String erisimNo = mayaReusableSteps.erisimNoGetir();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        orderCapturePage
                .siparisOlusturSayfaAc()
                .siparseUrunEkleTikla()
                .adslAc()
                .openPage();

        orderCapturePage
                .vdslAc()
                .dslHizSec()
                .dslTipiSec("Standart DSL");

        orderCapturePage
                .vdslAc()
                .erisimNoGir(erisimNo)
                .ttHizmetSorgulama()
                .vdsldslSunuSec();
    }
}
