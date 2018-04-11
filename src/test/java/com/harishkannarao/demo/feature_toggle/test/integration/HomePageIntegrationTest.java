package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.test.page_objects.HomePage;
import com.harishkannarao.demo.feature_toggle.test.property.TestPropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HomePageIntegrationTest extends AbstractBaseIntegrationTest {

    @Autowired
    private TestPropertyReader testPropertyReader;

    @Before
    @After
    public void resetPropertyReader() {
        testPropertyReader.resetDisplayHiddenProduct();
    }

    @Test
    public void should_display_message_on_home_page() {
        WebDriver webDriver = webDriverFactory.newWebDriver();
        HomePage homePage = pageObjectFactory.createHomePage(webDriver);
        homePage.navigate();
        assertThat(homePage.getMessage(), equalTo(of("Hello World !!!")));
    }

    @Test
    public void should_display_banner_message_when_enabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(true);
        WebDriver webDriver = webDriverFactory.newWebDriver();
        HomePage homePage = pageObjectFactory.createHomePage(webDriver);
        homePage.navigate();
        assertThat(homePage.getBannerMessage(), equalTo(of("New products available for sale !!!")));
    }

    @Test
    public void should_not_display_banner_message_when_disabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(false);
        WebDriver webDriver = webDriverFactory.newWebDriver();
        HomePage homePage = pageObjectFactory.createHomePage(webDriver);
        homePage.navigate();
        assertThat(homePage.getBannerMessage(), equalTo(empty()));
    }

    @Test
    public void should_not_display_banner_message_as_default_behaviour() {
        testPropertyReader.resetDisplayHiddenProduct();
        WebDriver webDriver = webDriverFactory.newWebDriver();
        HomePage homePage = pageObjectFactory.createHomePage(webDriver);
        homePage.navigate();
        assertThat(homePage.getBannerMessage(), equalTo(empty()));
    }
}
