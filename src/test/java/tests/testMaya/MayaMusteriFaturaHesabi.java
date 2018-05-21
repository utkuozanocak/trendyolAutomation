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

        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        CustomerBillAccountPage customerBillAccountPage = new CustomerBillAccountPage();
        String faturaGondermeSekli = "Kargo";
        String faturaDetayTuru = "Ses ve Data Detaylı";
        String hesapParaBirimi = "USD";
        String faturadaGorunecekAciklama = "TEST MAYA";
        String varsayilanEPosta = "testmaya@gmail.com";

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
                .openPage()
                .seciliKaydiGuncelle()
                .faturaGondermeSekli(faturaGondermeSekli)
                .faturaDetayTuru(faturaDetayTuru)
                .hesapParaBirimi(hesapParaBirimi)
                .faturadaGorunecekAciklama(faturadaGorunecekAciklama)
                .varsayilanEPosta(varsayilanEPosta)
                .guncelle();



    }
}
