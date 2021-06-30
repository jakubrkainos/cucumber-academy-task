package step_definitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import uk.kainos.seleniumframework.driver.DriverManager;
import uk.kainos.seleniumframework.site.pageobjects.bitly.BitlyHomePage;

public class BitlyUrlStepDefinitions {
  private final static String BITLY_HOME_PAGE = "https://bitly.com";
  private WebDriver driver = DriverManager.getDriver();
  private String shortenUrl;

  @Given("^user opens Bitly page$")
  public BitlyUrlStepDefinitions userOpensBitlyPage() {
    driver.navigate().to(BITLY_HOME_PAGE);
    return this;
  }

  @When("^the user shorten (.*)$")
  public BitlyUrlStepDefinitions userShortensUrl(String url) {
    BitlyHomePage bitlyHomePage = new BitlyHomePage(driver);
    bitlyHomePage.shortenUrl(url);
    shortenUrl = bitlyHomePage.getShortenUrl();
    return this;
  }

  @Then("^the (.*) can be opened using shorten link$")
  public BitlyUrlStepDefinitions theUrlCanBeOpenedUsingShortenLink(String url) {
    driver.navigate().to(shortenUrl);
    assertEquals(String.format("Shortened link does not redirect to the proper page. Shorten link: %s", shortenUrl),
        url, driver.getCurrentUrl());
    return this;
  }
}
