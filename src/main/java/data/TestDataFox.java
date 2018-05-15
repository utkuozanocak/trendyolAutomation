package data;

import common.BaseLibrary;

public class TestDataFox extends BaseLibrary {
    public static final String foxURL = "http://172.20.165.150/netflowsolprp/LoginForm.aspx";
    public static final String taskIdAdsl = GetTestParameter("FoxAdslKurulumKapatTest", "AdslKurulumTaskId")[0];
    public static final String flowStatusAdsl = GetTestParameter("FoxAdslKurulumKapatTest", "FiberKurulumAkisStatu")[0];
    public static final String cihazAdsl = GetTestParameter("FoxAdslKurulumKapatTest", "TestToolCihazAdsl")[0];
    public static final String flowStatus = GetTestParameter("FoxKurulumKapatTest", "FiberKurulumAkisStatu")[0];
    public static final String taskId = GetTestParameter("FoxKurulumKapatTest", "FiberKurulumTaskId")[0];
    public static final String username = GetTestParameter("FoxLoginTest", "FoxUserName")[0];
    public static final String password = GetTestParameter("FoxLoginTest", "FoxPassword")[0];
    public static final String seriNoFttb = null;
    public static final String seriNoGpon = null;
    public static final String seriNoAdsl = null;
    public static final String mesaj= GetTestParameter("FoxKurulumKapatTest", "KullaniciDegistirMesaj")[0];
    public static final String segment = GetTestParameter("FoxKurulumKapatTest", "CustomerSegmentSoho")[0];
    public static final String kurulumStatu = GetTestParameter("FoxKurulumKapatTest", "KurulumYapıldı")[0];
    public static final String kurulumAltStatu = GetTestParameter("FoxKurulumKapatTest", "TeslimEdildi")[0];
    public static final String akisDurumu = GetTestParameter("FoxKurulumKapatTest", "AkisDurumuCozuldu")[0];
    public static final String aciklama =  GetTestParameter("FoxKurulumKapatTest", "Aciklama")[0];
    public static final String sozlesmeStatu = GetTestParameter("FoxKurulumKapatTest", "sozlesmeStatu")[0];
    public static final String sozlesmeSubStatu = GetTestParameter("FoxKurulumKapatTest", "sozlesmeSubStatu")[0];
    public static final String ortamPrp = GetTestParameter("FoxKurulumKapatTest", "TestToolPRP")[0];
    public static final String depoFibertek = GetTestParameter("FoxKurulumKapatTest", "TestToolDepoFIBERTEK")[0];
    public static final String cihazFttb = GetTestParameter("FoxKurulumKapatTest", "TestToolCihazFttb")[0];
    public static final String cihazGpon = GetTestParameter("FoxKurulumKapatTest", "TestToolCihazGpon")[0];
    public static final String eamControlUrl = GetTestParameter("FoxKurulumKapatTest", "eamControlUrl")[0];
    public static final String basariliMesaj =  GetTestParameter("FoxKurulumKapatTest", "foxAkisGonderMesaj")[0];
    public static final String EAMmesaj = GetTestParameter("FoxKurulumKapatTest", "eamKontrolMesaj")[0];
}
