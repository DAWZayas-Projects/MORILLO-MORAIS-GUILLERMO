package test.Pages;

import test.Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Properties;

public class ProfilePage extends PageObject {
    public ProfilePage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = "a.pen > i.material-icons") private WebElement editButton;
    @FindBy(css = "div.icol > input[type=\"text\"]") private WebElement nameInput;
    @FindBy(xpath = "(//input[@type='text'])[6])") private WebElement cityInput;
    @FindBy(css = "textarea") private WebElement textArea;
    @FindBy(xpath = "(//button[@type='button'])[7])") private WebElement editConfirmBtn;
    @FindBy(xpath = "(//button[@type='button'])[8])") private WebElement cancelEditBtn;

    public String editProfile (String textAreaText) {
        fluidClick(editButton);
        textArea.click();
        fluidInput(textArea, textAreaText);
        fluidClick(editConfirmBtn);
        return textArea.getText();
    }
}
