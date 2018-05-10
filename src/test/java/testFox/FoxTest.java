package testFox;

import common.BaseTestFox;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageFox;
import pages.ustMenuPagesFox.AkisListesiPage;

public class FoxTest extends BaseTestFox {

    String taskId=GetTestParameter("FoxSearchFlowTest","FiberKurulumTaskId")[0];
    String flowStatus=GetTestParameter("FoxSearchFlowTest","FiberKurulumAkisStatu")[0];

    String username = GetTestParameter("FoxLoginTest", "FoxUserName")[0];
    String password = GetTestParameter("FoxLoginTest", "FoxPassword")[0];


    @BeforeMethod
    public void loginBeforeTests() {
        loginFox(username,password);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(enabled = true, description = "Fox Akış Arama")
    public void TS0001_FoxAkisArama() throws InterruptedException {

        String akisNo =  FoxSearchFlowNo(taskId,flowStatus)[0].toString();
        String[] dataset = FoxGetUserForChange(akisNo);
        String name = dataset[0];
        String positionName = dataset[1];
        System.out.println(akisNo);
        System.out.println(name);
        System.out.println(positionName);

        MainPageFox mainPageFox = new MainPageFox();
        AkisListesiPage akisListesiPage = new AkisListesiPage();

        akisListesiPage.openPage();
        mainPageFox
                .akisNoDoldur(akisNo);
        akisListesiPage
                .akisDetay(akisNo);
        logout();

    }
}
