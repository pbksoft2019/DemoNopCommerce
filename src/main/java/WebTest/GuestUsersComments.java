package WebTest;

import org.openqa.selenium.By;

public class GuestUsersComments extends Utils
{
    public void GuestUserComments()
    {
        String expected = "News comment is successfully added.";
        clickOnElement( By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[2]/a") );
        try{Thread.sleep( 5000 );} catch (InterruptedException e) { e.printStackTrace(); }
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/div[3]/div[3]/a" ) );
        enterText( By.id( "AddNewComment_CommentTitle" ), "Verygood Prctice website" );
        enterText( By.id( "AddNewComment_CommentText" ),"thank you for providing good website" );
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/form/div[2]/input" ) );
        String actual = getTextElement( By.xpath( "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/div" ) );
        //assertTextMessage( "comment not added", expected, actual );
    }
}
