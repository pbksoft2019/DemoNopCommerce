package WebTest;

import org.testng.annotations.BeforeMethod;


    public class BaseTest extends Utils {
        BrowserSelector browserSelector = new BrowserSelector();
        @BeforeMethod
        public void openBrowser() {
            browserSelector.setUpBrowser();

        }

        // @AfterMethod
        //  public void closeBrowser() {
        //     browserSelector.closeBrowser();



}
