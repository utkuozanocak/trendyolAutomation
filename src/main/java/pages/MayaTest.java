package pages;

import common.BaseTest;
import data.TestDataFox;
import data.TestDataMaya;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

import static com.codeborne.selenide.Selenide.switchTo;

/****************************************************
 * Tarih: 2018-05-08
 * Proje: Turkcell Functional Test Automation
 * Class:
 * Yazan: Emre Sencan
 ****************************************************/
public class MayaTest extends BaseTest {

    String erisimNo = null;

    public void customerSearch(String Unvan,String Statu,String Segment) {
        MainPageMaya mainPage = new MainPageMaya();
        SearchCustomerCorparatePage searchCustomerCorparatePage = new SearchCustomerCorparatePage();
        mainPage.musteriDetayliArama();
        searchCustomerCorparatePage
                .unvanDoldur(Unvan)
                .statuSec(Statu)
                .segmentSec(Segment)
                .ara()
                .tablodanIlkKayitTikla();
    }
    public String erisimNoGetir() throws InterruptedException {
            testToolAc(TestDataMaya.churnKontrolUrl);
            erisimNo = GetPhoneNumber(TestDataMaya.testToolCity,TestDataMaya.ortamPrp,TestDataMaya.testToolChurnType);
            return erisimNo;
    }

}
