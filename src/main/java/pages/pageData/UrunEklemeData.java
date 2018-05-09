package pages.pageData;

public class UrunEklemeData {

    private enum UrunEklemeGroup {
        ATipiTHK("A Tipi ve THK"),
        AkilliSantral("Akıllı Santral"),
        Internet("Internet");

        private String name;

        UrunEklemeGroup(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum ATipiTHK implements UrunEklemeDataInterface {
        ATipiTHK("A Tipi ve THK");

        private String name;
        private String groupName = UrunEklemeGroup.ATipiTHK.getName();

        ATipiTHK(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum AkilliSantral implements UrunEklemeDataInterface {

        AkilliSantral("");

        private String name;
        private String groupName = UrunEklemeGroup.AkilliSantral.getName();

        AkilliSantral(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public enum Internet implements UrunEklemeDataInterface {
        ADSL("ADSL"),
        Fiber("Fiber"),
        GVaeInternet("G.Vae Internet");

        private String name;
        private String groupName = UrunEklemeGroup.Internet.getName();

        Internet(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getGroupName() {
            return groupName;
        }
    }

    public interface UrunEklemeDataInterface {
        String getName();

        String getGroupName();
    }
}
