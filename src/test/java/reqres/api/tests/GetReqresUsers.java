package reqres.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import reqres.api.dto.ReqresUserDto;

import static reqres.api.factory.UserFactory.getNewUser;
import static reqres.api.methods.GetReqresGetSingleUser.getUsers;
import static reqres.api.steps.Steps.*;

public class GetReqresUsers {
    ReqresUserDto userExpected = getNewUser();
    String regexString = "[0-9]{1,5}";

    @Test
    void getUsersTest() {
        Response userActual = getUsers(2);
        ReqresUserDto actualUserAsClass = parseResponseToReqresUserDto(userActual);
        assertThatExpectedUserIsEqualToActual(userExpected, actualUserAsClass);
        assertRegexJsonField(userActual, "data.id", regexString);
    }
}
