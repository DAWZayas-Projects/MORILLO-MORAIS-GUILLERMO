package test.Pages;

import test.Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//div[@class='col']//div[@class='login']//input[@type='text']") private WebElement userInput;
    @FindBy(xpath = "//div[@class='col']//div[@class='login']//input[@type='password']") private WebElement passwordInput;
    @FindBy(xpath = "//html//div[@class='col']/div[@class='login']/button[1]") private WebElement loginBtn;
    @FindBy(xpath = "//div[@class='fillF']//h5") private WebElement warning;

    public void doLogin(String user, String password) {
        fluidInput(userInput, user);
        fluidInput(passwordInput, password);
        loginBtn.click();
    }

    public String doBadLogin (String user, String password) {
        fluidInput(userInput, user);
        fluidInput(passwordInput, password);
        loginBtn.click();

        return warning.getText();
    }
}
