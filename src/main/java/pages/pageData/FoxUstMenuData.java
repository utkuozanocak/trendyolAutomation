package pages.pageData;

public class FoxUstMenuData {


    public enum UstMenuGroupFox {
        GelenKutusu("Gelen Kutusu"),
        GidenKutusu("Giden Kutusu"),
        DenetimKutusu("Denetim Kutusu"),
        Askidakiler("Askıdakiler"),
        AltAkislar("Alt Akışlar"),
        AkisListesi("Akış Listesi"),
        TakipEttiklerim("Takip Ettiklerim"),
        Arsiv("Arşiv");

        private String name;

        UstMenuGroupFox(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
