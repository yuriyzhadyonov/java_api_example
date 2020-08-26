package api.test.ideals;


import api.test.ideals.core.models.UserPojo;
import api.test.ideals.core.models.UserPojoBuilder;
import api.test.ideals.core.specification.ResponseSpec;
import api.test.ideals.core.testClasses.TestUserClass;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(DataProviderRunner.class)
public class UserTests {

    private TestUserClass testUser;
    private Response response;

    @Before
    public void getTestClassInstance(){
        testUser = new TestUserClass();
    }

    @DataProvider
    public static Object[][] TestDataForSelectUser() {
        return new Object[][]{
                {7, ResponseSpec.response_code_200},
                {300, ResponseSpec.response_code_404}
        };
    }

    @Test
    @UseDataProvider("TestDataForSelectUser")
    public void testGetUserByID(int id, ResponseSpecification responseSpec) {

        testUser.selectUserByID(id).checkResponseCode(responseSpec);
        response = testUser.getLast_response();
        assert (testUser.checkData()) : "Some message to know what's that";
    }

    @DataProvider
    public static Object[][] TestDataForCreateUser() {
        return new Object[][]{
                {new UserPojoBuilder()
                        .adCompany("company").adText("texttt")
                        .dataFirstName("1st").dataLastName("last name").dataEmail("email@mail.com")
                        .build(), ResponseSpec.response_code_201},
                {new UserPojoBuilder()
                        .adCompany("company")
                        .build(), ResponseSpec.response_code_200}
        };
    }

    @Test
    @UseDataProvider("TestDataForCreateUser")
    public void testCreateUser(UserPojo userPojo, ResponseSpecification responseSpec) {

        testUser.createUser(userPojo);
        response = testUser.getLast_response();
        testUser.checkResponseCode(responseSpec);
        assert (testUser.checkData()) : "Some message to know what's that";
    }

    @DataProvider
    public static Object[][] TestDataForUpdateUser() {
        return new Object[][]{
                {7, new UserPojoBuilder()
                            .adCompany("company").adText("texttt")
                            .dataFirstName("1st").dataLastName("last name").dataEmail("email@mail.com")
                        .buildForUpdate(), ResponseSpec.response_code_200},
                {10, new UserPojoBuilder()
                            .adCompany("company")
                            .dataFirstName("new cool name")
                        .buildForUpdate(), ResponseSpec.response_code_404}
        };
    }

    @Test
    @UseDataProvider("TestDataForUpdateUser")
    public void testUpdateUser(int id, String body, ResponseSpecification responseSpec) {
        testUser.updateUserViaPut(id, body);
        response = testUser.getLast_response();
        testUser.checkResponseCode(responseSpec);
        assert (testUser.checkData()) : "Some message to know what's that";
    }

    @DataProvider
    public static Object[][] TestDataForDeleteUser() {
        return new Object[][]{
                {2, ResponseSpec.response_code_204},
                {300, ResponseSpec.response_code_404}
        };
    }

    @Test
    @UseDataProvider("TestDataForDeleteUser")
    public void testDeleteUser(int id, ResponseSpecification responseSpec) {

        testUser.deleteUser(id).checkResponseCode(responseSpec);
        response = testUser.getLast_response();
        assert (testUser.checkData()) : "Some message to know what's that";
    }
}
