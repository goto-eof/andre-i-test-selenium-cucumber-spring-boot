package com.andreidodu.andre_i_test.configuration.webdriverstrategy;

import com.andreidodu.andre_i_test.configuration.webdriverstrategy.common.WebDriverUtil;
import com.andreidodu.andre_i_test.constants.ConfigurationConstants;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FirefoxWebDriverStrategyImpl implements WebDriverStrategy {

    public static final String BROWSER_NAME = "firefox";
    public static final String CAPABILITY_PROXY = "proxy";

    @Value("${filename.web-driver.firefox}")
    private String webDriverChrome;

    @Override
    public boolean accept(String browserName) {
        return (BROWSER_NAME.equalsIgnoreCase(browserName));
    }

    @Override
    public WebDriver buildDriver() {
        System.setProperty(ConfigurationConstants.WEB_DRIVER_GECKO_DRIVER, webDriverChrome);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        Proxy proxy = WebDriverUtil.buildProxy();
        firefoxOptions.setCapability(CAPABILITY_PROXY, proxy);
        return new FirefoxDriver(firefoxOptions);
    }

}
