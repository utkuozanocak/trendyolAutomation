package pages.pageData;

public class FoxUstMenuData {


    public enum UstMenuGroup1 {
        GelenKutusu("Gelen Kutusu"),
        AkisListesi("Akış Listesi");

        private String name;

        UstMenuGroup1(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

//    public interface UstMenuDataInterfaceFox {
//        String getName();
//    }

}
