package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

    public class TestSuit extends BaseTest {
        String registrationSuccessMessageExpected = "Your registration completed";
        HomePage homePage = new HomePage();
        CompareSuccessPage compareSuccessPage = new CompareSuccessPage();
        RegistrationPage registrationPage = new RegistrationPage();
        RegistrationresultPage registrationResultPage = new RegistrationresultPage();
        ProductPage productPage = new ProductPage();
        EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
        BooksCategoryPage booksCategoryPage = new BooksCategoryPage();
        CheckOutGuestUser checkOutGuestUser =new CheckOutGuestUser();
        PaymentPage paymentPage = new PaymentPage();
        GuestUsersComments guestUsersComments =new GuestUsersComments();
        ChangeCurrency changeCurrency = new ChangeCurrency();
        AddToCartButton addToCartButton = new AddToCartButton();


        @Test
        public void userShouldAbleToRegisterSuccessfully() {
            //user clicks on register button
            homePage.clickOnRegisterButton();
            //verify that user is on register page
            registrationPage.verifyUserIsOnRegisterPage();
            //fill up registration details
            registrationPage.userEntrsRegistrationDetails();
            //verify registration success message
            registrationResultPage.verifyUserSeeRegistrationSuccessMessage();

        }

        @Test
        public void userShouldBeAbleToCompareTwoDifferentProductSuccessfully() {

            //select two products & click compare
            homePage.clickOnCompareProduct();
            //verify compare success massage
            compareSuccessPage.verifyUserShouldSeeCompareSuccessMassage();

        }

        @Test
        public void registeredUserShouldBeAbleToReferAProductTOAFriend() {
            homePage.clickOnRegisterButton();
            registrationPage.userEntrsRegistrationDetails();

            registrationResultPage.verifyUserSeeRegistrationSuccessMessage();

            //click on continue registration
            registrationResultPage.pageContinue();

            //click on any product
            homePage.clickOnProduct();

            //click on product
            productPage.clickOnEmail();

            //verify user in product email a friend page
            emailAFriendPage.verifyUserOnEmailAFriendPage();

            //user entering details
            emailAFriendPage.emailAFriendDetails();

            //verify email a friend massage display
            emailAFriendPage.verifyUserSeeSuccessMessageOfEmailAFriend();


        }

        @Test
        public void nonRegisteredUserShouldNotBeAbleToReferAProductToAFriend() {
//        click on any product
            homePage.clickOnProduct();

            //  Enter friends email
            productPage.clickOnEmail();

            //verify user in product email a friend page
            emailAFriendPage.verifyUserOnEmailAFriendPage();

            //Enter friend details
            emailAFriendPage.emailAFriendDetails();

            // verify error massage
            emailAFriendPage.verifyUserSeeErrorMessage();

            sleep(10);

        }

        @Test
        public void userShouldBeAbleToSortProductHighToLowByPrice()
        {
            sleep(3);

            //click on book category
            homePage.clickOnBookCategory();

            //verify user on books category page
            booksCategoryPage.verifyUserShouldOnCategoryPage();


            //select sort by opitions High to Low
            booksCategoryPage.selectCategoryOpitionsHighToLow();

            // verify price organised high to low
            booksCategoryPage.verifyPriceOrganisedHighToLow();
        }
        @Test
        public void printPriceForAllProducts()
        {
            driver.findElement( By.linkText( "Register" ) ).click();
            List<WebElement> priceList = driver.findElements( By.xpath("//span[@class='price actual-price']") );
            //System.out.println(priceList.size());
            for (WebElement we:priceList)
            {
                System.out.println(we.getText());
                Assert.assertTrue(we.getText().contains( "£" ) );
            }
        }
        @Test
        public void VarifyGaustUserCheckOutSuccessfully()
        {
            String expected ="Your order has been successfully processed!";
            homePage.clickOnBookCategory();
            try{Thread.sleep( 5000 );} catch (InterruptedException e) { e.printStackTrace(); }
            booksCategoryPage.addToCart();
            try{Thread.sleep( 5000 );} catch (InterruptedException e) { e.printStackTrace(); }
            checkOutGuestUser.guastCheckOut();
            paymentPage.paymentInstruction();
            String actual = getTextElement( By.xpath( "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong" ) );
            //assertTextMessage( "Order not processed", expected, actual );
        }

        @Test
        public void GuestUsersShouldBeAbleToLeaveComment()
        {
            guestUsersComments.GuestUserComments();
        }

        @Test
        public void changeCurrencySymbol()
        {
            changeCurrency.dropDownValue( By.id( "customerCurrency"), "https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F" ) ;
        }

        @Test
        public void verifyAddToCartButtonOnAllFeaturedProduct()
        {addToCartButton.addToCartButtonVerification();
        }
}
