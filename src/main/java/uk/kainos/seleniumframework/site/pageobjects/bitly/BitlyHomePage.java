package uk.kainos.seleniumframework.site.pageobjects.bitly;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.kainos.seleniumframework.site.Site;

public class BitlyHomePage extends Site {

  @FindBy(id = "shorten_url")
  private WebElement shortenUrlInput;

  @FindBy(id = "shorten_btn")
  private WebElement shortenUrlButton;

  public BitlyHomePage(WebDriver driver) {
    super(driver);
  }

  public BitlyHomePage shortenUrl(final String url) {
    shortenUrlInput.sendKeys(url);
    shortenUrlButton.click();
    return new BitlyHomePage(driver);
  }

  public String getShortenUrl() {
    return shortenUrlInput.getAttribute("value");
  }
}
