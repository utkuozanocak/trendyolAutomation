package tests.testMaya;

import common.BaseTest;
import pages.MainPageMaya;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

/****************************************************
 * Tarih: 2018-05-08
 * Proje: Turkcell Functional Test Automation
 * Class:
 * Yazan: Emre Sencan
 ****************************************************/
public class MayaTest extends BaseTest {



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

}
