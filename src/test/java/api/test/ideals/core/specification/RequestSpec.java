package api.test.ideals.core.specification;

import api.test.ideals.core.EndPoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public final class RequestSpec {

    public static final RequestSpecification userSpec = new RequestSpecBuilder()
            .setBaseUri(EndPoints.BASE_URL)
            .setBasePath(EndPoints.USERS)
            .build();

    public static final RequestSpecification userSpecWithID = new RequestSpecBuilder()
            .setBaseUri(EndPoints.BASE_URL)
            .setBasePath(EndPoints.USERS + EndPoints.USERS_ID)
            .build();

}
