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
    public void AAGoToSign () {
        Assert.assertTrue(header.goToSign());
    }

    @Test
    public void ABWrongLogin () {
        Assert.assertEquals(loginPage.doBadLogin("user", "password"), "Datos incorrectos");
    }

    @Test
    public void ACCorrectLogin () {
        loginPage.doLogin("selenium@test.com", "Selenium123");
    }

    @Test
    public void ADEditProfile () {
        String textAreaText = "texto de prueba textarea...";
        Assert.assertTrue(profilePage.editProfile(textAreaText));
    }

    @Test
    public void AEUploadPost () {
        String img = "C:\\Users\\Guillermo Morillo\\Documents\\FinalProyect\\MORILLO-MORAIS-GUILLERMO\\imagenesPresentacion\\descarga.jpg";
        String title = "selenium";
        String titlePost = "selenium post";
        String desc = "post creado desde selenium, no es para comer";

        Assert.assertTrue(profilePage.uploadPost(img, title, titlePost, desc));
    }
}
