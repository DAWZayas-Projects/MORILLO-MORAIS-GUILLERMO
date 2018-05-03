package test.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PageObject {
    private Actions actions;
    JavascriptExecutor js;
    private WebDriver wd;
    private WebDriverWait wdw;

    public PageObject(WebDriver wd) {
        this.wd = wd;
        actions = new Actions(wd);
        js = (JavascriptExecutor) wd;
        wdw = new WebDriverWait(wd, 10);
        PageFactory.initElements(wd, this);
    }

    protected void actionClick(WebElement we){
        waitVisibility(we);
        actions.moveToElement(we).click(we).build().perform();
    }

    protected void actionMoveMouse(WebElement webElement){
        actions.moveToElement(webElement).build().perform();
    }

    protected void actionInput(WebElement we, String input){
        we.clear();
        actions.moveToElement(we).click(we).sendKeys(input).build().perform();
    }


    protected WebElement getParent(WebElement we){return we.findElement(By.xpath(".."));}

    protected File getProjectFolder(String folder){return new File(System.getProperty("user.dir") + folder);}

    protected boolean getFileContainedByFolder(File[] folder, String file){
        for (File f : folder) {
            if (f.isFile()) {
                if (f.getName().contains(file)){
                    f.delete();
                    return true;
                }
            }
        }

        return false;
    }


    protected void fluidClick(WebElement we){
        try {
            wdw.until(ExpectedConditions.visibilityOf(we));
            we.click();
        } catch (Exception e){
            sleep(500);
        }
    }

    protected void fluidInput(WebElement we, String input) {
        wdw.until(ExpectedConditions.visibilityOf(we));
        we.clear();
        we.sendKeys(input);
    }

    protected void waitForDownload(File f){
        long filesize1, filesize2;

        do {
            filesize1 = f.length();  // check file size

            sleep(1000);

            filesize2 = f.length();  // check file size again

        } while (filesize2 != filesize1);
    }

    protected String fluidGetCssClassesElement(WebElement we){
        wdw.until(ExpectedConditions.visibilityOf(we));
        return we.getAttribute("class");
    }

    protected String fluidGetCurentUrl(){
        waitForPageLoad();

        return wd.getCurrentUrl();
    }

    protected String fluidGetTextElement(WebElement we) {
        wdw.until(ExpectedConditions.visibilityOf(we));
        return we.getText();
    }

    protected void waitForPageLoad() {
        new WebDriverWait(wd, 30).until((ExpectedCondition<Boolean>) wd ->
                js.executeScript("return document.readyState").equals("complete"));
    }

    public String getVal(String webElement) {
        try
        {
            return (String) js.executeScript("return arguments[0].value", webElement);
        }
        catch (Exception e2)
        {
            return null;
        }
    }

    protected void waitVisibility(WebElement we) {wdw.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(we));}

    protected void waitInvisibility(WebElement we) {wdw.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOf(we));}

    protected void sleep(int miliSeconds){
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
