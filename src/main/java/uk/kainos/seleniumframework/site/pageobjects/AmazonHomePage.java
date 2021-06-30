package uk.kainos.seleniumframework.site.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.kainos.seleniumframework.site.Site;

public class AmazonHomePage extends Site {

    private static final String PAGE_TITLE = "Home";

    @FindBy(id = "header") private WebElement pageHeader;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(id = "sp-cc-accept")
    private WebElement acceptCookiesButton;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageHeader() {
        verifyPageTitle(pageHeader.getText(), PAGE_TITLE);
    }

    public AmazonSearchResultsPage searchForItem(final String item) {
        searchBox.sendKeys(item);
        searchButton.click();
        return new AmazonSearchResultsPage(driver);
    }

    public AmazonHomePage acceptCookies() {
        acceptCookiesButton.click();
        return this;
    }
}
