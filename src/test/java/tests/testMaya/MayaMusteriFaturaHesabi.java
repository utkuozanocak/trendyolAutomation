package tests.testMaya;

import com.codeborne.selenide.SelenideElement;
import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.CustomerBillAccountPage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

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
        String faturadaGorunecekAciklama = " TEST MAYA";
        String varsayilanEPosta = "testmaya@gmail.com";
        String aciklama = "   TEST MAYA ";

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
                .yeniKayit()
                .aciklamaAlaniDoldur(aciklama)
                .varsayilanEPosta(varsayilanEPosta)
                .faturadaGorunecekAciklama(faturadaGorunecekAciklama)
                .hesapParaBirimi(hesapParaBirimi)
                .faturaDetayTuru(faturaDetayTuru)
                .faturaGondermeSekli(faturaGondermeSekli)
                .kaydet()
                .kapat();






    }
}
