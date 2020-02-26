package WebTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils
{

    public  void setUpBrowser()
    {
        String browser = "chrome";
        if (browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserDriver\\chromedriver.exe");
            driver= new ChromeDriver();
            //driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://demo.nopcommerce.com/");
        }
        else  if  (browser.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\BrowserDriver\\geckodriver.exe");
            driver= new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://demo.nopcommerce.com/");
        }
        else  if  (browser.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\BrowserDriver\\IEDriverServer.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

            ieCapabilities.setCapability("nativeEvents", false);
            ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
            ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
            ieCapabilities.setCapability("disable-popup-blocking", true);
            ieCapabilities.setCapability("enablePersistentHover", true);

            driver = new InternetExplorerDriver(ieCapabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://demo.nopcommerce.com/");
        }
        else
        {
            System.out.println("Beowser name is wrong or empty :"+browser);
        }
    }
    public void closeBrowser() {
        driver.quit();
    }

}
