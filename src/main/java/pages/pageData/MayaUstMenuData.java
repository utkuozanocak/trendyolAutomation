package pages.pageData;

/**
 * Yazan: Ilyas Bayraktar
 * Tarih: 25.12.2017
 * Açıklama:
 */
public class MayaUstMenuData {

    private enum UstMenuGroup1 {
        KurumsalSozlesmeYonetimi("Kurumsal Sözleşme Yönetimi"),
        Musteri("Müşteri"),
        Satis("Satış"),
        Urun("Ürün"),
        Akislar("Akışlar"),
        Yonetim("Yönetim"),
        Islemler("İşlemler");


        private String name;

        UstMenuGroup1(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum KurumsalSozlesmeYonetimi implements UstMenuDataInterface {
        Sozlesmelerim("Sözleşmelerim"),
        SozlesmeOlustur("Sözleşme Olulştur");

        private String name;
        private String groupName = UstMenuGroup1.KurumsalSozlesmeYonetimi.getName();

        KurumsalSozlesmeYonetimi(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum Musteri implements UstMenuDataInterface {
        ToptanMusteriOlusturma("Toptan Müşteri Oluşturma"),
        OnedeskMusteriEnteg("Onedesk Müsteri Enteg"),
        Ozellikler("Özellikler"),
        TopluProfilEkleme("Toplu Profil Ekleme"),
        OnedeskKontakEnteg("Onedesk Kontak Enteg"),
        ProfilListesi("Profil Listesi"),
        MusteriGrubu("Müşteri Grubu"),
        MusteriOlusturma("Müşteri Oluşturma"),
        IsOrtagiPrimGuncelleme("Is Ortagi Prim Güncelleme"),
        MusteriVergiDairesiGuncelleme("Müşteri Vergi Dairesi Güncelleme");

        private String name;
        private String groupName = UstMenuGroup1.Musteri.getName();

        Musteri(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }


    public enum Satis implements UstMenuDataInterface {
        IsEmriNoIleArama("İş Emri No ile Arama"),
        PromosyonluSatis("Promosyonlu Satış"),
        TopluSatis("Toplu Satış"),
        TopluFBTDegisikligi("Toplu FBT Değişikliği"),
        BenimSiparislerim("Benim Siparişlerim"),
        TopluIptal("Toplu İptal"),
        TopluVoipTakip("Toplu Voip Takip"),
        MusteriUrunAra("Müşteri Ürünü Ara"),
        HizmetNoIleSiparis("Hizmet No ile Sipariş"),
        TopluIslemTakip("Toplu İşlem Takip"),
        ATipiTHKSorgulamaEkranlari("A Tipi/THK Sorgulama Ekranları"),
        TopluTarifeDegisimi("Toplu Tarife Değişimi"),
        DSLIslemleri("DSL İşlemleri"),
        TopluIndirimGuncelleme("Toplu İndirim Güncelleme"),
        TaslakSiparislerim("Taslak Siparişlerim");

        private String name;
        private String groupName = UstMenuGroup1.Satis.getName();

        Satis(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum Urun implements UstMenuDataInterface {
        CaprazSatisIliskileri("Çapraz Satış İlişkileri"),
        Promocode("Promocode"),
        Urunler("Ürünler"),
        Taahhutler("Taahhütler"),
        CokluUrunAileleri("Çoklu Ürün Aileleri"),
        CFSPR("CFS/PR"),
        UrunGruplari("Ürün Grupları"),
        SatisKategorileri("Satış Kategorileri"),
        DegerListeleri("Değer Listeleri"),
        UrunAileleri("Ürün Aileleri"),
        Ozellikler("Özellikler"),
        KapanyaGruplari("Kampanya Grupları"),
        Regexp("Regexp"),
        RaporKategorileri("Rapor Kategorileri"),
        OdemeSablonlari("Ödeme Şablonları");

        private String name;
        private String groupName = UstMenuGroup1.Urun.getName();

        Urun(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum Akislar implements UstMenuDataInterface {
        PortOut("Port-out"),
        PSTNTakip("PSTN-Takip"),
        PortIn("Port-in");

        private String name;
        private String groupName = UstMenuGroup1.Akislar.getName();

        Akislar(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum Yonetim implements UstMenuDataInterface {
        XDGProfilYonetimi("XDG Profil Yönetimi"),
        HDMProfilTanimlama("HDM Profil Tanımlama"),
        Eslestirmeler("Eşleştirmeler"),
        KuralTanimlama("Kural Tanımlama"),
        FBTOncelik("FBT Öncelik"),
        SistemParametreleriYonetim("Sistem Parametreleri Yönetim"),
        BIYonetim("BI Yönetim"),
        SMSEPostaSablonlari("SMS / E-posta Şablonları");

        private String name;
        private String groupName = UstMenuGroup1.Yonetim.getName();

        Yonetim(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum Islemler implements UstMenuDataInterface {
        SiparisOlustur("Sipariş Oluştur"),
        SabitKullaniciEkrani("Sabit Kullanıcı Ekranı"),
        DSLIslemleri("DSL İşlemleri"),
        AdresBilgileri("Adres Bilgileri"),
        IsEmirleri("İş Emirleri"),
        MusteriBilgileri("Müşteri Bilgileri"),
        MusteriProfilBilgileri("Müşteri Profil Bilgileri"),
        MusteriUrunleri("Müşteri Ürünleri"),
        KurumIletisimBilgileri("Kurum İletişim Bilgileri"),
        MusteriGecmisi("Müşteri Geçmişi"),
        MusteriIliskileri("Müşteri İlişkileri"),
        KontakBilgleri("Kontak Bilgileri"),
        MusteriFaturaHesabi("Müşteri Fatura Hesabı"),
        Dokumanlar("Dokümanlar"),
        MusteriEtkilesimleri("Müşteri Etkileşimleri"),
        MusteriSiparisleri("Müşteri Siparişleri");

        private String name;
        private String groupName = UstMenuGroup1.Islemler.getName();

        Islemler(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }


    public interface UstMenuDataInterface {
        String getName();

        String getGroupName();
    }

}
