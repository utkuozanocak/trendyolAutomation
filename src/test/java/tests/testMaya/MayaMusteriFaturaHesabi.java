package tests.testMaya;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.CustomerBillAccountPage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

public class MayaMusteriFaturaHesabi extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Fatura Hesabı Sayfası Açılır")
    public void TS0001_MayaMusteriFaturaHesabi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        CustomerBillAccountPage customerBillAccountPage = new CustomerBillAccountPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mainPage
                .musteriDetayliArama();

        searchCustomerCorparatePage
                .unvanDoldur(TestDataMaya.unvan)
                .statuSec(TestDataMaya.statu)
                .segmentSec(TestDataMaya.segment)
                .ara()
                .tablodanIlkKayitTikla();

        customerBillAccountPage
                .openPage();

        customerBillAccountPage
                .yeniKayit();

    }
}
