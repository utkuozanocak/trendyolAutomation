package tests.SolCrmE2E;

import common.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import tests.FoxFiber.FiberFoxTests;
import tests.MayaTestFiber.MayaFiberTests;

import java.awt.*;

public class SolCrmAll extends BaseTest {
    MayaFiberTests mayaFiberTests = new MayaFiberTests();
    FiberFoxTests fiberFoxTests = new FiberFoxTests();
    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fiber Sipariş Giriş Testi")
    public void TS0001_MayaCreateOrderE2ETest() throws InterruptedException {
        mayaFiberTests.TS0001_MayaCreateOrderTest();
        try {
            fiberFoxTests.TS0001_FoxKurulumKapat();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
