package WebTest;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils
{
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");
    private String firstName = "tom";
    private String lastName = "Smith";
    private static String timeStemp = timeStamp();

    public static void verifyUserIsOnRegisterPage()
    {
        assertURL("register");

    }
    public  void userEntrsRegistrationDetails()
    {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterText(_firstName,firstName);
        enterText(_lastName,lastName);
        enterText(_email,"jbond+"+timeStamp()+"@gmail.com");
        enterText(_password,"Test1234");
        enterText(_confirmPassword,"Test1234");
        clickOnElement(_registerButton);

    }

}
