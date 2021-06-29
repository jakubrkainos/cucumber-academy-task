Feature: Smoke test suite for purchasing items from Amazon.

  @smoke @smk1
  Scenario Outline: Smoke tests for electrical goods purchasing on Amazon.

    Given the client is on Amazon home page
    When the client searches for this <item> on the Amazon
    And Amazon item price is less than <maximum budget>
    Then client will add it to their Amazon basket

    Examples:
      | item                                         | maximum budget |
      | Tha Doggfather                               | 10.00          |
      | The Witcher 3 Game of the Year Edition (PS4) | 30.00          |
      | Elder Scrolls Online Elsweyr PC PC DVD       | 36.00          |
      | Football Manager 2020 PC DVD                 | 35.00          |
