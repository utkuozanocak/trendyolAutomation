package tests.TrendyolTests;

import common.BaseTest;
import data.TestDataTrendyol;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.BoutiqueDetailPage;
import pages.MainPage;
import pages.ProductDetailPage;

public class TrendyolTests extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true,description = "TS0001 : Trendyol Example Test")
    public void TS0002_TrendyolKullaniciGiris(){
        MainPage mainPage = new MainPage();
        BoutiqueDetailPage boutiqueDetailPage = new BoutiqueDetailPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        loginTrendyol(TestDataTrendyol.username, TestDataTrendyol.password);
        mainPage
                .loginKontrol()
                .tabLinkButikImageControl();
        boutiqueDetailPage
                .randomButikEntranceImageControl();
        productDetailPage
                .randomProductDetailEntrance()
                .addBasket();
    }
}


