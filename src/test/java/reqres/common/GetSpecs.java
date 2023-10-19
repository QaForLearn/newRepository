package reqres.common;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetSpecs {
    public static RequestSpecification getSpec(){
        return given()
                .log()
                .all()
                .when();
    }
}
