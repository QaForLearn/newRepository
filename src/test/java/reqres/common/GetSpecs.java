package reqres.common;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetSpecs {
    public static RequestSpecification getSpec(){
        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .when();
    }
}
