package common;

import data.TestDataMaya;
import io.qameta.allure.Step;
import pages.MainPageMaya;
import pages.TestToolPage;
import pages.ustMenuPagesMaya.SearchCustomerCorparatePage;

public class MayaReusableSteps extends BaseLibrary {

    String erisimNo = null;

    @Step("Müşteri Araması yapılır.")
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

    @Step("Testte kullanılmak üzere erişim no alınır.")
    public String erisimNoGetir() throws InterruptedException {
        TestToolPage testToolPage = new TestToolPage();

        testToolPage.testToolAc(TestDataMaya.churnKontrolUrl);
        erisimNo = testToolPage.GetPhoneNumber(TestDataMaya.testToolCity,TestDataMaya.ortamPrp,TestDataMaya.testToolChurnType);
        return erisimNo;
    }
}
