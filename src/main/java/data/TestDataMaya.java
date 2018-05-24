package data;

import common.BaseLibrary;

public class TestDataMaya extends BaseLibrary {

    public static final String mayaURL = "https://extprp.superonline.net/sol-crm-2.0/login.xhtml";
    public static final String foxURL = "http://172.20.165.150/netflowsolprp/LoginForm.aspx";
    public static final String username = GetTestParameter("MayaLoginTest", "Username")[0];
    public static final String password = GetTestParameter("MayaLoginTest", "Password")[0];
    public static final String mainOrg = GetTestParameter("MayaLoginTest", "MainOrg")[0];
    public static final String subOrg = GetTestParameter("MayaLoginTest", "SubOrg")[0];
    public static final String locationId = GetLocationData(GetTestParameter("MayaCreateOrderTest", "LocationTypeFTTB")[0])[0];
    public static final String fiberKampanya = GetTestParameter("MayaCreateOrderTest", "Product")[0];
    public static final String daireNo = GetLocationDaireData(GetTestParameter("MayaCreateOrderTest", "LocationTypeFTTB")[0], locationId)[0];
    public static final String hiz = GetTestParameter("MayaCreateOrderTest", "DataProduct")[0];
    public static final String sehir =GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "AdslSehir")[0];
    public static final String ilce =GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "Adslilce")[0];
    public static final String mahalle =GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "AdslMahalle")[0];
    public static final String sokak =GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "AdslSokak")[0];
    public static final String unvan =GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0];
    public static final String statu = GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0];
    public static final String segment = GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0];
    public static final String churnKontrolUrl = GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "churnKontrolUrl")[0];
    public static final String ortamPrp = GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "TestToolOrtamPRP")[0];
    public static final String testToolCity = GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "TestToolCity")[0];
    public static final String testToolChurnType = GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "TestToolChurnType")[0];
    public static final String adslKampanya = GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "adslKampanya")[0];
    public static final String adslHiz = GetTestParameter("TS0001_KurumsalADSLSiparisGiris", "adslHiz")[0];
    public static final String fiberHizSecimGrubu = GetTestParameter("HizDegisikligiTest", "HizSecimGrubu")[0];
    public static final String fiberIptalAnaNeden = GetTestParameter("TS0009_DeaktivasyonTest", "FiberIptalAnaNedeni")[0];
}
