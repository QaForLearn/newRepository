package reqres.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import reqres.api.dto.PostReqresUser;

import static reqres.api.factory.PostUserFactory.getNewPostUser;
import static reqres.api.methods.PostUser.postUser;
import static reqres.api.steps.Steps.assertRegexJsonField;

public class PostUserTest {
    PostReqresUser newUser = getNewPostUser();

    @Test
    void postUserTest(){
        Response userResponse = postUser(newUser);
        assertRegexJsonField(userResponse, "id" , "[0-9]{1,20}");
    }
}
