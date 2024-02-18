package app.docuport.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
     Creating the private constructor so this class' object
     is not reachable from outside
      */
    private Driver() {
    }

    /*
    Making our 'driver' instance private so that it is not reachable from outside of the class.
    We make it static, because we want it to run before everything else, and also we will use it in a static method
     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private static ChromeOptions chromeOptions;
    private static WebDriver driver;



    /*
    Creating re-usable utility method that will return same 'driver' instance everytime we call it.
     */
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            synchronized (Driver.class) {
            /*
            We read our browser type from configuration.properties file using
            .getProperty method we creating in ConfigurationReader class.
             */
                String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
//                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "headless":
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless"); // enable headless mode
                        // options.addArguments("--start-maximized"); // maximize
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(options));
                        //driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "remote-chrome-linux":
                        try {
                            // assign your grid server address
                            String gridAddress = "3.92.199.191";
                            URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            chromeOptions = new ChromeOptions();
                            chromeOptions.addArguments("--headless");
                            chromeOptions.addArguments("--no-sandbox");
                            chromeOptions.addArguments("--disable-dev-shm-usage");
                            desiredCapabilities.merge(chromeOptions);
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome-linux":
//                        WebDriverManager.chromedriver().setup();
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
//                        driverPool.set(new ChromeDriver(chromeOptions));
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(chromeOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;


                }
            }
        }

        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driverPool.get();


    }

    /*
    This method makes sure we have some form of driver sesion or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}