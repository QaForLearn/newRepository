package reqres.api.methods;

import io.restassured.response.Response;

import static reqres.common.Constant.MAPPER;
import static reqres.common.GetSpecs.getSpec;

public class PostUser {
    public static Response postUser(Object body){
        return getSpec()
                .body(MAPPER.valueToTree(body))
                .post("https://reqres.in/api/users")
                .then()
                .log()
                .all()
                .extract().response();
    }
}
