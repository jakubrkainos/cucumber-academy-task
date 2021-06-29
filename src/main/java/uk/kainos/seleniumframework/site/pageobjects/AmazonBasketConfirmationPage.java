package uk.kainos.seleniumframework.site.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uk.kainos.seleniumframework.site.Site;

public class AmazonBasketConfirmationPage extends Site {

  public AmazonBasketConfirmationPage(WebDriver driver) {
    super(driver);
  }

  public boolean isOrderConfirmationDisplayed() {
    try {
      webDriverWait(10)
          .until(ExpectedConditions.presenceOfElementLocated(By.id("huc-v2-order-row-container")));
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
