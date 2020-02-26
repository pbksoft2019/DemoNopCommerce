package WebTest;

import org.openqa.selenium.By;

public class EmailAFriendPage extends Utils
{
    private By _friendEmail = org.openqa.selenium.By.className("friend-email");
    private By _yourEmail = org.openqa.selenium.By.className("your-email.valid");
    private By _textBox = org.openqa.selenium.By.xpath("//*[@id='PersonalMessage']");
    private By _sendEmail = org.openqa.selenium.By.name("send-email");
    private String friendEmail = "wet@gmail.com";
    private String yourEmail = "set@gmail.com";
    private String message = "This is best product";
    String expected = "Your message has been sent.";
    private By _emailSuccessMessage = org.openqa.selenium.By.xpath("//div[@class='result']");
    String expectedError = "Only registered customers can use email a friend feature";
    private By _emailErrorMessage = org.openqa.selenium.By.xpath("//div[contains(@class,'message-error')]/ul/li");

    public  void verifyUserOnEmailAFriendPage()
    {
        assertURL("productemailafriend");
    }
    public void emailAFriendDetails()
    {
        sleep(3);
        enterText(_friendEmail,friendEmail);
        enterText(_yourEmail,yourEmail);
        enterText(_textBox,message);
        scrollAndClick(_sendEmail);

    }
    public void verifyUserSeeSuccessMessageOfEmailAFriend()
    {
        //assertTextMessage("Your message has NOT been sent",expected,_emailSuccessMessage);
    }

    public void verifyUserSeeErrorMessage()
    {
        //assertTextMessage("Your message not display",expected,_emailErrorMessage);
    }
}
