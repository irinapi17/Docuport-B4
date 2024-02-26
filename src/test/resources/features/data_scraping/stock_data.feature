
@ui @stockData
Feature: Scrape stock data and print in console

  Scenario: Print market index's from yahoo finance
    Given user navigates to Yahoo Finance most active
    Then print the market index's information

  Scenario: Print any congressional stock trades
    Given user navigates to the congressional stock tracker
    Then user print all trades from the current day


  Scenario: Print market movers data from yahoo finance
    Given user navigates to Yahoo Finance most active
    Then print the information within the console

