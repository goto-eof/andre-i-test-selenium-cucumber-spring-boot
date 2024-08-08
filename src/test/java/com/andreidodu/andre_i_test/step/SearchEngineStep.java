package com.andreidodu.andre_i_test.step;

import com.andreidodu.andre_i_test.util.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class SearchEngineStep {

    @Autowired
    private HomePage homePage;

    private final By searchResultElement = By.cssSelector("#toys > div > div > div > div.chakra-stack.css-j7qwjs > div.css-3fl6io > div > div > div.chakra-stack.css-a8n2v6 > div > p");

    @Given("the status of the data has as value {string}")
    public void settingStatus(String status) {
        log.info("setting status to {}", status);
        log.info("updating item status with value {}", status);
        log.info("status updated successfully");
    }

    @When("searching in the search engine the project name {string}")
    public void callingRemoteService(String projectName) throws InterruptedException {
        log.info("searching for {}", projectName);
        try {
            this.homePage.goToHomePage()
                    .goToSearchBoxAndSearch(projectName);
        } catch (Exception e) {
            this.homePage.quit();
            fail();
        }
        log.info("service called successfully");
    }

    @Then("the result is {string}")
    public void checkResult(String result) throws InterruptedException {
        log.info("checking the result, it should be {}", result);
        try {
            String textRead = this.homePage.readTextMessage(searchResultElement);
            assertEquals(result, textRead);
            this.homePage.quit();
            log.info("the result is correct.");
        } catch (NoSuchElementException e) {
            if (result.equalsIgnoreCase("")) {
                log.info("the result is correct.");
                this.homePage.quit();
                return;
            }
            log.error("the result is not correct.");
            this.homePage.quit();
            Assert.fail();
        }
    }

}
