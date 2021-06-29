package step_definitions;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import uk.kainos.seleniumframework.driver.DriverManager;
import uk.kainos.seleniumframework.site.pageobjects.AmazonHomePage;
import uk.kainos.seleniumframework.site.pageobjects.AmazonItemPage;

public class AmazonPurchaseStepDefinitions {
    private final String AMAZON_HOME_PAGE = "https://www.amazon.co.uk";
    protected WebDriver driver = DriverManager.getDriver();

    @Given("^the client is on Amazon home page$")
    public AmazonPurchaseStepDefinitions theClientOpenAmazonHomePage() {
        driver.navigate().to(AMAZON_HOME_PAGE);
        AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.acceptCookies();
        return this;
    }

    @When("^the client searches for this (.*) on the Amazon$")
    public AmazonPurchaseStepDefinitions theClientSearchesForItemOnTheAmazon(String item) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.searchForItem(item)
            .selectItemFromTheList(item);
        return this;
    }

    @When("^Amazon item price is less than ((\\d+\\.\\d+))$")
    public AmazonPurchaseStepDefinitions thePriceOfAmazonItemIsLessThen(float maximumPrice) {
        AmazonItemPage amazonItemPage = new AmazonItemPage(driver);
        float amazonItemPrice = Float.parseFloat(amazonItemPage.getPrice());
        assertTrue(String.format("Price for an item is over the budget. Item price: %f", amazonItemPrice),
            amazonItemPrice <= maximumPrice);
        return this;
    }

    @Then("^client will add it to their Amazon basket$")
    public AmazonPurchaseStepDefinitions clientWillAddItToTheirAmazonBasket() {
        AmazonItemPage amazonItemPage = new AmazonItemPage(driver);
        boolean orderConfirmed = amazonItemPage.addToTheBasket()
            .isOrderConfirmationDisplayed();
        assertTrue("Order confirmation is not displayed", orderConfirmed);
        return this;
    }
}
