package Tests;

import DataProviders.SignUpPageDataProvider;
import Pages.SignUpPage;
import Utils.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseUITest{
    @Test(dataProvider = "signUpPageDataProvider", dataProviderClass = SignUpPageDataProvider.class)
    public void testIfSignUpPageIsAvailable(String browserType, boolean expectedPageAvailability) {
        driver = SeleniumUtils.getDriver(browserType);

        SignUpPage signUpPage = new SignUpPage(driver);
        boolean isPageAvailable = signUpPage.open(signUpPageURL);

        Assert.assertEquals(isPageAvailable, expectedPageAvailability);
    }
}
