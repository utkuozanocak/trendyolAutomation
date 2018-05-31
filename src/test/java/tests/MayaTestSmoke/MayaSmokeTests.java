package tests.MayaTestSmoke;

import common.BaseTest;
import common.MayaReusableSteps;
import data.TestDataMaya;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerAssetPropPage;
import pages.mayaFrames.EtkilesimlerFrame;
import pages.ustMenuPagesMaya.*;


public class MayaSmokeTests extends BaseTest {


    @BeforeMethod
    public void loginBeforeTests() {

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0001 : Kurumsal Kontak Bilgisi Güncelleme.")
    public void TS0001_KurumsalKontakBilgisiGuncelleme() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        MayaCustomerContactPage mayaCustomerContactPage = new MayaCustomerContactPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        mayaCustomerContactPage
                .kontakBilgileriTikla()
                .tablodanIlkKontakSec()
                .telefonNumarasıDoldur("5555555555")
                .kaydet()
                .mesajKontrol("Kontak bilgisi başarıyla kaydedilmiştir");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0002 : Kurumsal Müşteri Sms Şifre Gönderimi")
    public void TS0002_KurumsalMusteriSmsSifreGonderimi() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        EditCorporateCustomerPage editCorporateCustomerPage = new EditCorporateCustomerPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        editCorporateCustomerPage
                .musteriBilgileriTikla()
                .btnSMS()
                .mesajKontrol("nolu telefona gönderilmiştir.");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0003 : Kurumsal Musteri Özellik Ekleme.")
    public void TS0003_KurumsalMusteriOzellikEkleme() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerPropertyPage customerPropertyPage = new CustomerPropertyPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerPropertyPage
                .musteriOzellikSayfasıAc()
                .btnYeniOzellikTikla()
                .txtOzellikAdiDoldur("Test Otomasyon Özellik Adı " + createRandomNumber(8))
                .txtOzellikKoduDoldur("Test Otomasyon Özellik Kodu " + createRandomNumber(8))
                .txtMinimumDegerDoldur("1")
                .txtMaksimumDegerDoldur("10")
                .btnKaydetTikla()
                .mesajKontrol("kodlu özellik seti başarıyla kaydedildi/güncellendi");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0004 : Kurumsal Musteriye Yeni Adres Ekle")
    public void TS0004_KurumsalMusteriyeYeniAdresEkle() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        AdresBilgileriPage adresBilgileriPage = new AdresBilgileriPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        adresBilgileriPage
                .siparisAdresEkle()
                .yeniAdresEkle()
                .sehirSec(TestDataMaya.sehir)
                .ilceSec(TestDataMaya.ilce)
                .mahalleSec(TestDataMaya.mahalle)
                .sokakSec(TestDataMaya.sokak)
                .binaNoIlkKayitSec()
                .blokEkle("Test Otomasyon")
                .adresKaydet()
                .confirmDialog().confirmEvetTikla();
        //     adresBilgileriPage .adresOnay()
        //   .adresEvetButonSec();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0005 : Kurumsal Musteri İletişim Bilgileri.")
    public void TS0005_KurumsalMusteriIletisimBilgileri() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        customerCommunicationInfoDisplayPage customerCommunicationInfoDisplay = new customerCommunicationInfoDisplayPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerCommunicationInfoDisplay
                .openPage()
                .iletisimBilgisiSec()
                .güncelleSec()
                .yeniNumaraGirisi()
                .güncellePopUpOnaySec();
        //     .mesajKontrol("kodlu özellik seti başarıyla kaydedildi/güncellendi");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0006 : Kurumsal Musteri Partner Oranı Girişi.")
    public void TS0006_KurumsalMusteriPartnerOraniGirisi() throws InterruptedException {
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla()
                .btnPartnerOranGirisiTikla()
                .cmbPartnerSec("EPİTEL")
                .btnPartnerKaydetTikla()
                .mesajKontrol("Partner Oran Girişi İşlemi Tamamlanmıştır. Partner:");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0007 : Musteri Siparisleri")
    public void TS0007_MusteriSiparisleri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        trackOrdersPage
                .openMusteriSiparisleriPage()
                .musteriSiparisleriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0008 : Musteri Etkileşimleri")
    public void TS0008_MusteriEtkilesimleri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        etkilesimlerFrame
                .openMusteriEtkilesimleriPage()
                .musteriEtkilesimleriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0009 : Musteri Bilgileri")
    public void TS0009_MusteriBilgileri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        EditCorporateCustomerPage editCorporateCustomerPage = new EditCorporateCustomerPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        editCorporateCustomerPage
                .musteriBilgileriTikla()
                .musteriBilgileriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0010 : Musteri Profil Bilgileri")
    public void TS0010_MusteriProfilBilgileri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerProfileListPage customerProfileListPage = new CustomerProfileListPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerProfileListPage
                .musteriProfilBilgileriTikla()
                .musteriProfilBilgileriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0011 : Musteri Ürünleri")
    public void TS0011_MusteriUrunleri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .musteriUrunleriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0012 : Musteri Geçmişi")
    public void TS0012_MusteriGecmisi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        ContactHistoryPage contactHistoryPage = new ContactHistoryPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        contactHistoryPage
                .musteriGecmisiTikla()
                .musteriGecmisiSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0013 : Musteri İlişkileri")
    public void TS0013_MusteriIliskileri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerRelationsDisplayPage customerRelationsDisplayPage = new CustomerRelationsDisplayPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerRelationsDisplayPage
                .musteriIliskileriTikla()
                .musteriIliskileriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0014 : Musteri Fatura Hesabı")
    public void TS0014_MusteriFaturaHesabi() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerBillAccountPage customerBillAccountPage = new CustomerBillAccountPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerBillAccountPage
                .openPage()
                .musteriFaturaHesabiSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0015 : Musteri Adres Bilgileri")
    public void TS0015_MusteriAdresBilgileri() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAddressManagementPage customerAddressManagementPage = new CustomerAddressManagementPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerAddressManagementPage
                .musteriAdresBilgileriTikla()
                .musteriAdresBilgileriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TC0016 : İş emri no ile arama.")
    public void TS0016_IsEmriNoIleArama() throws InterruptedException {

        ProjectTaskSearchPage projectTaskSearchPage = new ProjectTaskSearchPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        projectTaskSearchPage
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0017 : Muşteri Ürünü Ara")
    public void TS0017_MusteriUrunuAra() throws InterruptedException {

        CustomerAssetSearchPage customerAssetSearchPage = new CustomerAssetSearchPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        customerAssetSearchPage
                .openPage()
                .sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0018 : Taslak Siparişlerim")
    public void TS0018_TaslakSiparislerim() throws InterruptedException {

        MyTrackOrdersPage myTrackOrdersPage = new MyTrackOrdersPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        myTrackOrdersPage
                .openPage()
                .sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0019 : Hizmet No ile Sipariş")
    public void TS0019_HizmetNoIleSiparis() throws InterruptedException {

        TrackOrdersPage trackOrdersPage = new TrackOrdersPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        trackOrdersPage
                .openPageHizmetNoIleSiparis()
                .hizmetNoIleSiparisSayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0020 : BireyselMusteriOlusturma")
    public void TS0020_YeniKurumsalMusteriOlusturma() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        newCorporateCustomerPage yeniKurumsalMusteriPage = new newCorporateCustomerPage();

        yeniKurumsalMusteriPage
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0021 : YeniToptanlMusteriOlusturma")
    public void TS0021_YeniToptanlMusteriOlusturma() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        newToptanCustomerPage yeniToptanMusteriPage = new newToptanCustomerPage();

        yeniToptanMusteriPage
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0022 : XDGProfilYonetimi")
    public void TS0022_XDGProfilYonetimi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        xdgProfileManagementPage xdgProfileManagement = new xdgProfileManagementPage();

        xdgProfileManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0023 : HDMProfilTanimlama")
    public void TS0023_HDMProfilTanimlama() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        xdgProfileManagementPage hdmManagement = new xdgProfileManagementPage();

        hdmManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0024 : YonetimEslestirmeler")
    public void TS0024_YonetimEslestirmeler() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        bindingListPage eslestirmeler = new bindingListPage();
        eslestirmeler
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0025 : YonetimKurallar")
    public void TS0025_YonetimKurallar() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        RulesPage kuralListesi = new RulesPage();
        kuralListesi
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0026 : UrunAilesiSayfasi")
    public void TS0026_UrunAilesiSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductsProductsPage productsProductsPage = new ProductsProductsPage();
        //Ürün/Ürün Aileleri sayfası
        productsProductsPage.openPage();
        productsProductsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0027 : SatisKategorileriSayfasi ")
    public void TS0027_SatisKategorileriSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductSalesCategoriesPage productSalesCategoriesPage = new ProductSalesCategoriesPage();

        //Ürün/Satış Kategorileri
        productSalesCategoriesPage.openPage();
        productSalesCategoriesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0028 : RaporKategorileriSayfasi")
    public void TS0028_RaporKategorileriSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductReportCategoriesPage productReportCategoriesPage = new ProductReportCategoriesPage();

        //Ürün/Rapor Kategorileri
        productReportCategoriesPage.openPage();
        productReportCategoriesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0029 : RegexpSayfasi ")
    public void TS0029_RegexpSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductRegexpManagementPage productRegexpManagementPage = new ProductRegexpManagementPage();

        //Ürün/Regexp Sayfası
        productRegexpManagementPage.openPage();
        productRegexpManagementPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0030 : DegerlerListesiSayfasi")
    public void TS0030_DegerlerListesiSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductPropertyListsPage productPropertyListsPage = new ProductPropertyListsPage();

        //Ürün/Değer Listeleri sayfası
        productPropertyListsPage.openPage();
        productPropertyListsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0031 : OzelliklerSayfasi")
    public void TS0031_OzelliklerSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductPropertiesPage productPropertiesPage = new ProductPropertiesPage();

        //Ürün/Özellikler sayfası
        productPropertiesPage.openPage();
        productPropertiesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0032 : CFSPRSayfasi")
    public void TS0032_CFSPRSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductProductServicesPage productProductServicesPage = new ProductProductServicesPage();

        //Ürün-CFS/PR sayfası
        productProductServicesPage.openPage();
        productProductServicesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0033 : UrunGruplariSayfasi")
    public void TS0033_UrunGruplariSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductProductGroupPage productProductGroupPage = new ProductProductGroupPage();

        //Ürün/Ürün Grupları  sayfası
        productProductGroupPage.openPage();
        productProductGroupPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0034 : OdemeSablonlariSayfasi ")
    public void TS0034_OdemeSablonlariSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductPaymentPlanTemplatesPage productPaymentPlanTemplatesPage = new ProductPaymentPlanTemplatesPage();

        //Ürün/Ödeme Şablonları  sayfası
        productPaymentPlanTemplatesPage.openPage();
        productPaymentPlanTemplatesPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0035 : CaprazSatisIliskileriSayfasi")
    public void TS0035_CaprazSatisIliskileriSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductCrossSaleRelationsPage productCrossSaleRelationsPage = new ProductCrossSaleRelationsPage();

        //Ürün/Çapraz Satış İlişkileri sayfası
        productCrossSaleRelationsPage.openPage();
        productCrossSaleRelationsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0036 : UrunlerSayfasi")
    public void TS0036_UrunlerSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductCommonOffersPage productCommonOffersPage = new ProductCommonOffersPage();

        //Ürün/Ürünler sayfası
        productCommonOffersPage.openPage();
        productCommonOffersPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0037 : TaahhütlerSayfasi")
    public void TS0037_TaahhütlerSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductCommitmentsPage productCommitmentsPage = new ProductCommitmentsPage();

        //Ürün/Taahhütler sayfası
        productCommitmentsPage.openPage();
        productCommitmentsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0038 : CokluUrunAileleriSayfasi")
    public void TS0038_CokluUrunAileleriSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductBundleProductsPage productBundleProductsPage = new ProductBundleProductsPage();

        //Ürün/Çoklu Ürün Aileleri sayfası
        productBundleProductsPage.openPage();
        productBundleProductsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0039 : KampanyaGruplariSayfasi")
    public void TS0039_KampanyaGruplariSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductBundleOfferGroupsPage productBundleOfferGroupsPage = new ProductBundleOfferGroupsPage();

        //Ürün/Kampanya Grupları sayfası
        productBundleOfferGroupsPage.openPage();
        productBundleOfferGroupsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0040 : PromocodeSayfasi")
    public void TS0040_PromocodeSayfasi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        ProductActivationCodeDefinitionsPage productActivationCodeDefinitionsPage = new ProductActivationCodeDefinitionsPage();

        //Ürün/Promocode sayfası
        productActivationCodeDefinitionsPage.openPage();
        productActivationCodeDefinitionsPage.sayfaKontrolu();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0041 : fbtPriorityGroupManagement")
    public void TS0041_fbtPriorityGroupManagement() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        FbtPriorityGroupManagementPage fbtOncelik = new FbtPriorityGroupManagementPage();
        fbtOncelik
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0042_SistemParametreleriYonetimi")
    public void TS0042_SistemParametreleriYonetimi() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        systemParameterManagementPage systemParameterManagement = new systemParameterManagementPage();
        systemParameterManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0043 : BIYonetim")
    public void TS0043_BIYonetim() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        businessInteractionManagementPage businessInteractionManagement = new businessInteractionManagementPage();
        businessInteractionManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0044 : SMSEpostaSablon")
    public void TS0044_SMSEpostaSablon() throws InterruptedException {

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        SmsEmailTemplateManagementPage SmsEmailTemplateManagement = new SmsEmailTemplateManagementPage();
        SmsEmailTemplateManagement
                .openPage()
                .sayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0045 : Etkileşimler")
    public void TS0045_Etkilesimler() throws InterruptedException {
        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        EtkilesimlerFrame etkilesimlerFrame = new EtkilesimlerFrame();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);
        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunIslemlerTikla()
                .btnEtkilesimlerTikla();
        etkilesimlerFrame
                .musteriEtkilesimleriSayfaKontrolu();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0046 : Kurumsal Müşteri Özellikler")
    public void TS0046_Ozellikler() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();
        CustomerAssetPropPage ozelliklerPage = new CustomerAssetPropPage();
        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);
        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .btnAramaTikla()
                .statuSec("Aktif")
                .urunSec(TestDataMaya.fiberKampanya)
                .btnAraTikla()
                .tablodanIlkUrunKontratDetayAc()
                .tablodanKontratDetayHizOzelliklerAc("Aktif", "Mbps", "Özellikler");
        ozelliklerPage
                .SayfaKontrolu();

    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "TS0047 : Kurumsal Detay Bilgileri sayfası açılır.")
    public void TS0047_KurumsalDetayBilgileri() throws InterruptedException {

        MayaReusableSteps mayaReusableSteps = new MayaReusableSteps();
        CustomerAssetsPage customerAssetsPage = new CustomerAssetsPage();

        loginMaya(TestDataMaya.username, TestDataMaya.password, TestDataMaya.mainOrg, TestDataMaya.subOrg);

        mayaReusableSteps
                .customerSearch(TestDataMaya.unvan, TestDataMaya.statu, TestDataMaya.segment);

        customerAssetsPage
                .musteriUrunleriSayfasiAc()
                .musteriUrunleriSayfaKontrolu()
                .tablodanKontratDetayHizIslemlerAc("Aktivasyon Sürecinde","ADSL / Superonline ADSL Bireysel Satış Tarife", "Detay Bilgiler")
                .detayBilgilerSayfaKontrolu();

    }

}
