package com.andreidodu.andre_i_test.util.webdriverstrategy;

import org.openqa.selenium.WebDriver;

public interface WebDriverStrategy {

    boolean accept(String browserName);

    WebDriver buildDriver();

}
