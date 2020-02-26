package WebTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartButton extends Utils
{
    public void addToCartButtonVerification()
    {
       List<WebElement> listOfItems = driver.findElements( By.xpath( "//div[@class='product-item']" ) );
       for(WebElement item : listOfItems)
       {
           if(!item.getAttribute( "innerHTML" ).contains( "add to cart" ))
           {
               System.out.println("This  item doesn't have add to cart Button "+item.getText());
           }
       }
    }
}

    /*public void addToCart() {
        By _itemBoxesField = By.className( "product-item" );
        By _addCartButtonField = By.cssSelector( "[type='button'][value='Add to cart']" );
        By _productNameField = By.cssSelector( "h2.product-title > a" );

        List<WebElement> webElementList = driver.findElements( _itemBoxesField );
        int count = 0;
        for (
                WebElement element : webElementList) {
            if (element.findElements( (_addCartButtonField).size() == 1 ))
            {count++;}
            else {
                System.out.println( "No add to cart Button----------->" + element.findElement( _productNameField ) );
            }
            assertTextMessage( "some product dont have add to cart buton", webElementList.size(), count );
        }}*/
