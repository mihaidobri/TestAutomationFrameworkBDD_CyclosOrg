package Tests.TestData.DataProviders;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class LoginDataProivders {

    @DataProvider
    public static Object[][] validUsernamesDataProvider() {
        return new Object[][]{
                {"demo", "1234"},
                {"demo2", "1234"},
                {"demo3", "1234"},
        };
    }

    @DataProvider
    public static Object[][] validUsernamesInvalidPasswordsDataProvider() {
        return new Object[][]{
                {"demo", "1234567"},
                {"demo2", "test"},
                {"demo3", "placeholder password"},
        };


    }

    @DataProvider
    public static Object[][] invalidUsernamesInvalidPasswordsDataProvider() {
        return new Object[][]{
                {"testuser", "1234"},
                {"placeholder", "testing"},
                {"automation", "password"},
        };
    }
}
