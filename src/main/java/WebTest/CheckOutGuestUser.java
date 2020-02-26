package WebTest;

import org.openqa.selenium.By;

public class CheckOutGuestUser extends Utils
{
    private By _ShoppingCart = By.className( "cart-label" );
    private By _CheckBox = By.id( "termsofservice" );
    private By _CheckOut = By.xpath( "//button[@type='submit']" );
    private By _CheckOutGuest =  By.xpath( "//input[@class='button-1 checkout-as-guest-button']" );
    private By _FirstNme = By.id("BillingNewAddress_FirstName");
    private By _LastName =By.id("BillingNewAddress_LastName");
    private By _EmailAddress = By.id("BillingNewAddress_Email");



    public void guastCheckOut()
    {   clickOnElement( _ShoppingCart );
        try{Thread.sleep( 7000 );} catch (InterruptedException e) { e.printStackTrace(); }
        clickOnElement( _CheckBox );
        try{Thread.sleep( 7000 );} catch (InterruptedException e) { e.printStackTrace(); }
        clickOnElement( _CheckOut );
        try{Thread.sleep( 7000 );} catch (InterruptedException e) { e.printStackTrace(); }
        clickOnElement( _CheckOutGuest );
        try{Thread.sleep( 7000 );} catch (InterruptedException e) { e.printStackTrace(); }
        enterText(_FirstNme,"pk");
        try{Thread.sleep( 3000 );} catch (InterruptedException e) { e.printStackTrace(); }
        enterText( _LastName,"pk" );
        enterText( _EmailAddress, "pbk"+timeStamp()+"@gmail.com");
        dropDownValue( By.id( "BillingNewAddress_CountryId" ),"1" );
        dropDownValue( By.id( "BillingNewAddress_StateProvinceId" ),"53" );
        enterText( By.id( "BillingNewAddress_City" ), "london");
        enterText( By.id( "BillingNewAddress_Address1" ), "10 downing Street" );
        enterText(By.id( "BillingNewAddress_ZipPostalCode" ), "123456");
        enterText( By.id( "BillingNewAddress_PhoneNumber" ),"01234567890" );
        clickOnElement(By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/input" ));
        clickOnElement( By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/input" ) );
        clickOnElement( By.id( "paymentmethod_1" ) );
        clickOnElement( By.xpath( "//*[@id=\"payment-method-buttons-container\"]/input" ) );




    }
}
