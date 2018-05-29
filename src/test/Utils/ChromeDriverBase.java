package test.Utils;

import org.openqa.selenium.WebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeDriverBase {
    protected static WebDriver driver;

    @BeforeClass
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Guillermo Morillo\\Documents\\Selenium\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\Downloads");
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://wheretoeat-ca57a.firebaseapp.com/");
    }
    /*
    @AfterClass
    public static void finishIt(){
        driver.manage().deleteAllCookies();
        driver.close();
    }*/
}
