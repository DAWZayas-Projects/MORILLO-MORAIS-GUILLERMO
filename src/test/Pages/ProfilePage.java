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

    // edicion de perfil
    @FindBy(xpath = "//a[@href='/editprofile']") private WebElement editButton;
    @FindBy(css = "div.icol > input[type=\"text\"]") private WebElement nameInput;
    @FindBy(xpath = "(//input[@type='text'])[6])") private WebElement cityInput;
    @FindBy(xpath = "//div[@class='icol']//textarea") private WebElement textArea;
    @FindBy(xpath = "//button[@type='button'][contains(text(),'Editar perfil')]") private WebElement editConfirmBtn;
    @FindBy(xpath = "//button[@type='button'][contains(text(),'Descartar cambios')]") private WebElement cancelEditBtn;

    //subir publicacion
    @FindBy(xpath = "//input[@type='file']") private WebElement uploadInput;
    @FindBy(xpath = "//html//div[@class='col left']/div//div[1]/input[1]") private WebElement titleInput;
    @FindBy(xpath = "//html//div[@class='bloc']//div[2]/input[1]") private WebElement titlePostInput;
    @FindBy(xpath = "//textarea[@maxlength='200']") private WebElement descriptionTextArea;

    @FindBy(xpath = "//button[@data-toggle='modal']") private WebElement uploadBtn;
    @FindBy(xpath = "//div[@class='modal-body']//h4") private WebElement modalText;
    @FindBy(xpath = "//div[@class='blocinf']//div[@tabindex='-1']//div[@role='document']//div[@class='modal-content']//div[@class='modal-footer']//button") private WebElement closeModal;

    @FindAll({@FindBy(className = "mainBloc")}) private List<WebElement> posts;



    public Boolean editProfile (String textAreaText) {
        sleep(3000);
        waitClick(editButton);
        waitClick(textArea);
        textArea.clear();
        fluidInput(textArea, textAreaText);
        if (textArea.getText().equals(textAreaText)) {
            actionClick(editConfirmBtn);
            sleep(3000);
            return true;
        }   else {
            actionClick(cancelEditBtn);
            sleep(3000);
            return false;
        }
    }

    public Boolean uploadPost (String img, String title, String titlePost, String description) {
        int postSizeBefore = posts.size();

        uploadInput.sendKeys(img);

        fluidInput(titleInput, title);
        fluidInput(titlePostInput, titlePost);
        fluidInput(descriptionTextArea, description);

        actionClick(uploadBtn);
        closeModal.click();

        return (postSizeBefore < posts.size());
    }
}
