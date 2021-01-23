package Constant;

import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railwayqa.somee.com";
    public static final String USERNAME = "satt200301@gmail.com";
    public static final String PASSWORD = "12345678";
    public static final String PID = "12345678";
    public static final int TIME_WAIT_CONTROL = 10;
    public static final String chromeDriverLocate = "\\Executables\\chromeDriver.exe";
    public static final String geckoDriverLocate = "\\Executables\\geckodriver.exe";
}
