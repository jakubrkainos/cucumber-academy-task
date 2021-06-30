Feature: Bitly feature to shorten url

  Scenario: Bitly shortens given url
    Given user opens Bitly page
    When the user shorten https://www.netflix.com/pl-en/
    Then the https://www.netflix.com/pl-en/ can be opened using shorten link
