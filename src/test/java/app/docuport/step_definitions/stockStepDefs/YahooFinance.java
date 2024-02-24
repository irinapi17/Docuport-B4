package app.docuport.step_definitions.stockStepDefs;

import app.docuport.utilities.Driver;
import io.cucumber.java.en.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class YahooFinance {


    @Given("user navigates to Yahoo Finance most active")
    public void user_navigates_to_Yahoo_Finance_market_movers() {
        Driver.getDriver().get("https://finance.yahoo.com/most-active/");
    }

    @Then("print the market index's information")
    public void print_the_market_index_s_information() {
        System.out.println();
        System.out.println("Market Index Information");
        printMarketIndexInformation();
        System.out.println();
    }

    @Then("print the information within the console")
    public void print_the_information_within_the_console() {
        System.out.println("Most Active Stock Tickers");
        printDataTableInformation();
        System.out.println();
    }


    public static void printMarketIndexInformation() {
        List<WebElement> tableRows = Driver.getDriver().findElements(By.xpath("//ul[@class='Carousel-Slider Pos(r) Whs(nw)']//li"));
        for (int i = 1; i <= tableRows.size(); i++) {
            System.out.println("The "+Driver.getDriver().findElement(By.xpath("(//a[@class='Fz(s) Ell Fw(600) C($linkColor)'])[" + i + "]")).getAttribute("aria-label"));


//            String symbol = Driver.getDriver().findElement(By.xpath("(//div[@id='scr-res-table']//table//tbody//tr//a)[" + i + "]")).getText();
//            String name = Driver.getDriver().findElement(By.xpath("(//td[@aria-label='Name'])[" + i + "]")).getText();
//            String price = Driver.getDriver().findElement(By.xpath("(//td[@aria-label='Price (Intraday)'])[" + i + "]")).getText();
//            String change = Driver.getDriver().findElement(By.xpath("(//td[@aria-label='% Change'])[" + i + "]")).getText();
//
//            System.out.printf("%-30s %-20s %-10s%n", name, price, change);
        }
    }

    public static void printDataTableInformation() {
        System.out.printf("%-10s %-40s %-20s %-10s%n", "Ticker", "Company Name", "Price", "Percent Change");
        List<WebElement> tableRows = Driver.getDriver().findElements(By.xpath("//div[@id='scr-res-table']//table//tbody//tr"));
        for (int i = 1; i <= tableRows.size(); i++) {
            String symbol = Driver.getDriver().findElement(By.xpath("(//div[@id='scr-res-table']//table//tbody//tr//a)[" + i + "]")).getText();
            String name = Driver.getDriver().findElement(By.xpath("(//td[@aria-label='Name'])[" + i + "]")).getText();
            String price = Driver.getDriver().findElement(By.xpath("(//td[@aria-label='Price (Intraday)'])[" + i + "]")).getText();
            String change = Driver.getDriver().findElement(By.xpath("(//td[@aria-label='% Change'])[" + i + "]")).getText();

            System.out.printf("%-10s %-40s %-20s %-10s%n", symbol, name, price, change);
        }
        System.out.println();
    }
    //div[@id='scr-res-table']//table//tbody//tr//a   - goes down symbols
    //td[@aria-label='Name']
    //td[@aria-label='Price (Intraday)']
    //td[@aria-label='% Change']
}
