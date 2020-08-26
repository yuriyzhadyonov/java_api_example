package api.test.ideals.core.testClasses;

import api.test.ideals.core.models.IPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractTestClass {

    protected RequestSpecification request;
    protected Response last_response;

    public Response getLast_response() {
        return last_response;
    }

    public Response get(String end_point, int id) {

        last_response = request
                .pathParam("id", id)
                .when().get(end_point);

        return last_response;
    }

    public Response post(String body) {

        last_response = request
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post();

        return last_response;
    }

    public Response post(IPojo body) {

        last_response = request
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post();

        return last_response;
    }

    public Response put (String end_point, int id, String body) {

        last_response = request
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .put(end_point);

        return last_response;
    }

    public Response patch (String end_point, int id, String body) {

        last_response = request
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .patch(end_point);

        return last_response;
    }

    public Response delete (String end_point, int id) {

        last_response = request
                .pathParam("id", id)
                .when()
                .delete(end_point);

        return last_response;
    }
}
