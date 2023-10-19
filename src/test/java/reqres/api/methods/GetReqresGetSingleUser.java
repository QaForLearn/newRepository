package reqres.api.methods;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static reqres.common.GetSpecs.getSpec;

public class GetReqresGetSingleUser {
    @Step("Отправляем запрос GET /users/{userId}")
    public static Response getUsers(int userId){
        return getSpec()
                .get("https://reqres.in/api/users/"+userId)
                .then()
                .log()
                .all()
                .extract().response();
    }
}
