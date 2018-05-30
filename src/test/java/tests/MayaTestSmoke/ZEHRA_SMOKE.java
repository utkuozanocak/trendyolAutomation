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

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0097_XDGProfilYonetimi")
    public void TS0097_XDGProfilYonetimi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        xdgProfileManagementPage xdgProfileManagement= new xdgProfileManagementPage();

        xdgProfileManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
@Test(enabled = true, description = "TS0096_HDMProfilTanimlama")
public void TS0096_HDMProfilTanimlama() throws InterruptedException {

    loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    xdgProfileManagementPage hdmManagement= new xdgProfileManagementPage();

    hdmManagement
            .openPage()
            .sayfaKontrolu();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0096_HDMProfilTanimlama")
    public void TS0095_YonetimEslestirmeler() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        bindingListPage eslestirmeler= new bindingListPage();
        eslestirmeler
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0096_HDMProfilTanimlama")
    public void TS0094_YonetimKurallar() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        RulesPage kuralListesi= new RulesPage();
        kuralListesi
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0093_fbtPriorityGroupManagement")
    public void TS0093_fbtPriorityGroupManagement() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        FbtPriorityGroupManagementPage fbtOncelik= new FbtPriorityGroupManagementPage();
        fbtOncelik
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
@Test(enabled = true, description = "TS0092_SistemParametreleriYonetimi")
public void TS0092_SistemParametreleriYonetimi() throws InterruptedException {

    loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
    systemParameterManagementPage systemParameterManagement= new systemParameterManagementPage();
    systemParameterManagement
            .openPage()
            .sayfaKontrolu();
}
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0091_BIYonetim")
    public void TS0091_BIYonetim() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        businessInteractionManagementPage businessInteractionManagement= new businessInteractionManagementPage();
        businessInteractionManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0090_SMSEpostaSablon")
    public void TS0090_SMSEpostaSablon() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        SmsEmailTemplateManagementPage SmsEmailTemplateManagement= new SmsEmailTemplateManagementPage();
        SmsEmailTemplateManagement
                .openPage()
                .sayfaKontrolu();
    }
}
