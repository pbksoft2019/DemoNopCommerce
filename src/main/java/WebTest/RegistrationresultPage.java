package WebTest;

import org.openqa.selenium.By;

public class RegistrationresultPage extends Utils
{
    private By _registerSuccessMessage = By.className("result");
    String expected = "Your registration completed";
    private By _pageContinue = By.name("register-continue");
    public void verifyUserSeeRegistrationSuccessMessage()
    {
        assertURL("registerresult");
        //assertTextMessage("Registration not successful...",expected, _registerSuccessMessage);
    }
    public void pageContinue()
    {
        sleep(3);
        clickOnElement(_pageContinue);
        System.out.println("cklciked continue");
    }
}
