package test.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.Utils.ChromeDriverBase;
import test.Pages.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest extends ChromeDriverBase {
    private static Header header = new Header(driver);
    private static LoginPage loginPage = new LoginPage(driver);
    private static MainPage mainPage = new MainPage(driver);
    private static ProfilePage profilePage = new ProfilePage(driver);

    @Test
    public void AAgoToSign () {
        header.goToSign();
    }

    @Test
    public void ABwrongLogin () {
        Assert.assertEquals(loginPage.doBadLogin(properties.getProperty("user.bad"), properties.getProperty("password.bad")), properties.getProperty("message.login.incorrect"));
    }

    @Test
    public void ACcorrectLogin () {
        loginPage.doLogin(properties.getProperty("user.good"), properties.getProperty("password.good"));
    }
}
