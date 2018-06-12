package test.Pages;

import test.Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends PageObject {
    public Header(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//div[@class='userch']//a[@href='/login']") private WebElement profileBtn;
    @FindBy(xpath = "//img[@src='/_nuxt/img/logo.f687c71.png']") private WebElement logo;
    @FindBy(xpath = "//a[@href='/login'][contains(text(),'Regístrate')]") private WebElement signUpBtn;
    @FindBy(xpath = "//a[@href='#'][contains(text(),'TuZona')]") private WebElement zoneBtn;
    @FindBy(xpath = "//a[@href='/favorites'][contains(text(),'Favoritos')]") private WebElement favoitesBtn;
    @FindBy(xpath = "//div[@class='men-u']//button[@type='button']") private WebElement logOutBtn;
    @FindBy(xpath = "//div[@class='men-u']//a[@href='/']") private WebElement initBtn;

    public void goToInit () {
        logo.click();
    }
    public boolean goToProfile () {
        profileBtn.click();
        return fluidGetCurentUrl().equals("https://wheretoeat-ca57a.firebaseapp.com/profile");
    }
    public boolean goToSign () {
        signUpBtn.click();
        return fluidGetCurentUrl().equals("https://wheretoeat-ca57a.firebaseapp.com/login");
    }
    public void logOut () {
        logOutBtn.click();
    }
    public boolean goToFavorites () {
        favoitesBtn.click();
        return fluidGetCurentUrl().equals("https://wheretoeat-ca57a.firebaseapp.com/favorites");
    }
    public void goToZone () {
        zoneBtn.click();
    }
}
