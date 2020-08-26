package api.test.ideals.core.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class ResponseSpec {

    public static final ResponseSpecification response_code_200 = new ResponseSpecBuilder()
            .expectStatusCode(200).build();

    public static final ResponseSpecification response_code_201 = new ResponseSpecBuilder()
            .expectStatusCode(201).build();

    public static final ResponseSpecification response_code_204 = new ResponseSpecBuilder()
            .expectStatusCode(204).build();

    public static final ResponseSpecification response_code_404 = new ResponseSpecBuilder()
            .expectStatusCode(404).build();

}
