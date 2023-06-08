package Tests;

import Utils.SeleniumUtils;
import DataProviders.SignUpDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.SignUpPage;

public class SignUpTest extends BaseUITest{
    @Test(dataProvider = "negativeSignUpDataProvider", dataProviderClass = SignUpDataProvider.class)
    public void testNegativeSignUp(String browserType, String username, String password, String confirmPassword, String gender,
                                   String firstName, String lastName, String email, String dateOfBirth, String nationality,
                                   boolean termsAndConditionSelected, String expectedUserNameErr, String expectedPasswordErr,
                                   String expectedConfirmationPasswordErr, String expectedFirstNameError, String expectedLastNameError,
                                   String expectedEmailError, String expectedTermsAndConditionError) {

        driver = SeleniumUtils.getDriver(browserType);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open(signUpPageURL);

        signUpPage.registerNewUser(username, password, confirmPassword, gender, firstName, lastName, email, dateOfBirth, nationality, termsAndConditionSelected);
        Assert.assertTrue(signUpPage.checkErr(expectedUserNameErr, "username"));
        Assert.assertTrue(signUpPage.checkErr(expectedPasswordErr, "password"));
        Assert.assertTrue(signUpPage.checkErr(expectedConfirmationPasswordErr, "confirmPassword"));
        Assert.assertTrue(signUpPage.checkErr(expectedFirstNameError, "firstName"));
        Assert.assertTrue(signUpPage.checkErr(expectedLastNameError, "lastName"));
        Assert.assertTrue(signUpPage.checkErr(expectedEmailError, "email"));
    }
}
