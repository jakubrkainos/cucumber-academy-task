package uk.kainos.seleniumframework.site.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.kainos.seleniumframework.site.Site;

public class AmazonItemPage extends Site {

  @FindBy(id = "priceblock_ourprice")
  private WebElement price;

  @FindBy(id = "add-to-cart-button")
  private WebElement addToBasketButton;

  public AmazonItemPage(WebDriver driver) {
    super(driver);
  }

  public String getPrice() {
    return price.getText().replace("£", "");
  }

  public AmazonBasketConfirmationPage addToTheBasket() {
    addToBasketButton.click();
    return new AmazonBasketConfirmationPage(driver);
  }
}
