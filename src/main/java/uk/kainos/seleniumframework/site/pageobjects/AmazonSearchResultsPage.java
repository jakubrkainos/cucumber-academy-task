package uk.kainos.seleniumframework.site.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.kainos.seleniumframework.site.Site;

public class AmazonSearchResultsPage extends Site {

  private final String ITEM_XPATH_SELECTOR = "//span[text() = '%s']";

  public AmazonSearchResultsPage(WebDriver driver) {
    super(driver);
  }

  public AmazonItemPage selectItemFromTheList(final String item) {
    driver.findElement(By.xpath(String.format(ITEM_XPATH_SELECTOR, item))).click();
    return new AmazonItemPage(driver);
  }
}
