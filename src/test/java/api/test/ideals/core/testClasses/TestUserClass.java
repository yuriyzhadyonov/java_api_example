package api.test.ideals.core.testClasses;

import api.test.ideals.core.EndPoints;
import api.test.ideals.core.models.UserPojo;
import api.test.ideals.core.specification.RequestSpec;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;

public class TestUserClass extends AbstractTestClass {

    private UserPojo responseUserPojo;

    public TestUserClass() {
        request = RestAssured.given()
                .spec(RequestSpec.userSpec);
    }

    public TestUserClass selectUserByID(int id) {
        get(EndPoints.USERS_ID, id);
        responseUserPojo = getDataAsPojo();
        return this;
    }

    public TestUserClass createUser(UserPojo userPojo) {
        post(userPojo);
        responseUserPojo = getDataAsPojo();
        responseUserPojo.getData().setId(Integer.parseInt(last_response.then().extract().path("id")));
        return this;
    }

    public TestUserClass updateUserViaPut(int id, String body) {
        put(EndPoints.USERS_ID, id, body);
        responseUserPojo = getDataAsPojo();
        responseUserPojo.getData().setId(id);
        return this;
    }

    public TestUserClass updateUserViaPatch(int id, String body) {
        patch(EndPoints.USERS_ID, id, body);
        responseUserPojo = getDataAsPojo();
        responseUserPojo.getData().setId(id);
        return this;
    }

    public TestUserClass deleteUser(int id) {
        delete(EndPoints.USERS_ID, id);
        return this;
    }

    public void checkResponseCode(int responseCode){
        last_response.then().statusCode(responseCode);
    }

    public void checkResponseCode(ResponseSpecification responseCode){
        last_response.then().spec(responseCode);
    }

    public UserPojo getResponseUserPojo() {
        return responseUserPojo;
    }

    private UserPojo getDataAsPojo(){
        return last_response.then().extract().body().as(UserPojo.class);
    }

    public Boolean checkData() {
//        need to define how to compare object
//        obj to obj --> compare built obj with response obj and/or get data via get method
//     or any DAO to obj --> compare built obj with data from DB
//        also provide info in case of any diff
        return true;
    }

}
