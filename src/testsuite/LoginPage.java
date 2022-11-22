package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginPage extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        //Enter 'tomsmith' username
        sendTextToElements(By.id("username"), "tomsmith");

        //Enter 'SuperSecretPassword!' password
        sendTextToElements(By.name("password"), "SuperSecretPassword!");

        //Click login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //Verify the text 'Secure Area'
        //Expected text
        String expectedText = "Secure Area";

        //Find the text and get text
        String actualText = getTextFromElement(By.xpath("//h2"));

        //Compare expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter 'tomsmith1' username
        sendTextToElements(By.id("username"), "tomsmith1");

        //Enter 'SuperSecretPassword!' password
        sendTextToElements(By.name("password"), "SuperSecretPassword!");

        //Click login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        // Verify the error message “Your username is invalid!”
        //Expected text
        String expectedText = "Your username is invalid!\n" +
                "×";

        //Actual text
        String actualText = getTextFromElement(By.xpath("//div[@class='flash error']"));

        //Compare expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter 'tomsmith' username
        sendTextToElements(By.id("username"), "tomsmith");

        //Enter 'SuperSecretPassword' password
        sendTextToElements(By.name("password"), "SuperSecretPassword");

        //Click login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        // Verify the error message “Your username is invalid!”
        //Expected text
        String expectedText = "Your password is invalid!\n" +
                "×";

        //Actual text
        String actualText = getTextFromElement(By.id("flash"));

        //Compare expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
