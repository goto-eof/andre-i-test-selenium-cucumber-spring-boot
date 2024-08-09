package com.andreidodu.andre_i_test.util;

import com.andreidodu.andre_i_test.util.webdriverstrategy.WebDriverStrategy;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class WebDriverBuilder {

    private final List<WebDriverStrategy> webDriverStrategyList;

    public WebDriver createNewWebDriver(String browserName) {
        return this.webDriverStrategyList
                .stream()
                .filter(webDriverStrategy -> webDriverStrategy.accept(browserName))
                .findFirst()
                .map(WebDriverStrategy::buildDriver)
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid browser value"));
    }

}

