package app.docuport.step_definitions.stockStepDefs;

import app.docuport.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CongressionalStockTracker {


    @Given("user navigates to the congressional stock tracker")
    public void user_navigates_to_the_congressional_stock_tracker() {
        Driver.getDriver().get("https://www.quiverquant.com/congresstrading/");
    }

    @Then("user print all trades from the current day")
    public void user_print_all_trades_from_the_current_day() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM. d, yyyy");
        String todayDate = LocalDate.now().format(formatter);
        System.out.println("Congressional Trades From: "+todayDate);
        printAllCongressionalStockTradesFromToday();
        System.out.println();
    }

    private static void printAllCongressionalStockTradesFromToday() {
        boolean bool = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM. d, yyyy");
        String todayDate = LocalDate.now().format(formatter);
        int i = 1;

        do {
            if (Driver.getDriver().findElement(By.xpath("(//table[@class='table-congress table-politician']//tbody//tr)[" + i + "]//td[4]")).getText().trim().equals(todayDate)
            ) {
                System.out.print(Driver.getDriver().findElement(By.xpath("(//table[@class='table-congress table-politician']//tbody//tr)[" + i + "]//td[3]")).getText());
                System.out.print(Driver.getDriver().findElement(By.xpath("(//table[@class='table-congress table-politician']//tbody//tr)[" + i + "]//td[1]")).getText().replace("GS",""));
                System.out.print(Driver.getDriver().findElement(By.xpath("(//table[@class='table-congress table-politician']//tbody//tr)[" + i + "]//td[2]")).getText());
                System.out.print(Driver.getDriver().findElement(By.xpath("(//table[@class='table-congress table-politician']//tbody//tr)[" + i + "]//td[4]")).getText());
                System.out.print(Driver.getDriver().findElement(By.xpath("(//table[@class='table-congress table-politician']//tbody//tr)[" + i + "]//td[5]")).getText());
                System.out.println("\n");
                i++;
            } else {
                System.out.println("-No new congressional trades");
                bool = false;
            }
        } while (bool);
    }
}
