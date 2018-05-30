package tests.MayaTestSmoke;
import common.BaseTest;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustMenuPagesMaya.*;

public class ZEHRA_SMOKE extends BaseTest
{
    @BeforeMethod
    public void loginBeforeTests()
    {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0099_BireyselMusteriOlusturma")
    public void TS0099_YeniKurumsalMusteriOlusturma() throws InterruptedException {

    loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    newCorporateCustomerPage yeniKurumsalMusteriPage= new newCorporateCustomerPage();

    yeniKurumsalMusteriPage
            .openPage()
            .sayfaKontrolu();
}
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0098_YeniToptanlMusteriOlusturma")
    public void TS0098_YeniToptanlMusteriOlusturma() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        newToptanCustomerPage yeniToptanMusteriPage= new newToptanCustomerPage();

        yeniToptanMusteriPage
                .openPage()
                .sayfaKontrolu();
    }

}
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0098_XDGProfilYonetimi")
    public void TS0098_XDGProfilYonetimi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        newToptanCustomerPage yeniToptanMusteriPage= new newToptanCustomerPage();

        yeniToptanMusteriPage
                .openPage()
                .sayfaKontrolu();
    }

}
