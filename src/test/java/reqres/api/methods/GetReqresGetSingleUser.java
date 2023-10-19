package reqres.api.methods;

import io.restassured.response.Response;

import static reqres.common.GetSpecs.getSpec;

public class GetReqresGetSingleUser {
    public static Response getUsers(int userId){
        return getSpec()
                .get("https://reqres.in/api/users/"+userId)
                .then()
                .log()
                .all()
                .extract().response();
    }
}
