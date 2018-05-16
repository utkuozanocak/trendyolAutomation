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
    public static final String sehir =GetTestParameter("MayaCreateDSLOrderTest", "AdslSehir")[0];
    public static final String ilce =GetTestParameter("MayaCreateDSLOrderTest", "Adslilce")[0];
    public static final String mahalle =GetTestParameter("MayaCreateDSLOrderTest", "AdslMahalle")[0];
    public static final String sokak =GetTestParameter("MayaCreateDSLOrderTest", "AdslSokak")[0];
    public static final String unvan =GetTestParameter("MayaCreateOrderTest", "UnvanKurum")[0];
    public static final String statu = GetTestParameter("MayaCreateOrderTest", "CustomerStatuAktif")[0];
    public static final String segment = GetTestParameter("MayaCreateOrderTest", "CustomerSegmentSoho")[0];
    public static final String churnKontrolUrl = GetTestParameter("MayaCreateDSLOrderTest", "churnKontrolUrl")[0];
    public static final String ortamPrp = GetTestParameter("MayaCreateDSLOrderTest", "TestToolOrtamPRP")[0];
    public static final String testToolCity = GetTestParameter("MayaCreateDSLOrderTest", "TestToolCity")[0];
    public static final String testToolChurnType = GetTestParameter("MayaCreateDSLOrderTest", "TestToolChurnType")[0];
}
