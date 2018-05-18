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

public class AdslTests extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye ADSL siparişi girilir.")
    public void TS0006_MayaCreateDslOrderTest() throws InterruptedException {

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

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteriye VDSL satışı yapılır.")
    public void TS0007_MayaCreateVdslOrderTest() throws InterruptedException {

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
