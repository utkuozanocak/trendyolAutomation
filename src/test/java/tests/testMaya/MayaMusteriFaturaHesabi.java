package tests.testMaya;

import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.MayaTest;
import pages.ustMenuPagesMaya.CustomerBillAccountPage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

public class MayaMusteriFaturaHesabi extends BaseTest {

    MayaTest mayaTest = new MayaTest();

    @BeforeMethod
    public void loginBeforeTests() {
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Müşteri Fatura Hesabı Sayfası Açılır")
    public void TS0001_MayaMusteriFaturaHesabi() throws InterruptedException {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(TestDataMaya.unvan)
                .statuSec(TestDataMaya.statu)
                .segmentSec(TestDataMaya.segment)
                .ara()
                .tablodanIlkKayitTikla();
        CustomerBillAccountPage customerBillAccountPage = new CustomerBillAccountPage();
        customerBillAccountPage.openPage();
        customerBillAccountPage.yeniKayit();

    }
}
