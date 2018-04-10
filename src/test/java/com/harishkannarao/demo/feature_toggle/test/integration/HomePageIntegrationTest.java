package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.test.page_objects.HomePage;
import org.junit.Test;

import static java.util.Optional.of;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HomePageIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void should_display_message_on_home_page() {
        HomePage homePage = pageObjectFactory.createHomePage();
        homePage.navigate();
        assertThat(homePage.getMessage(), equalTo(of("Hello World !!!")));
    }
}
