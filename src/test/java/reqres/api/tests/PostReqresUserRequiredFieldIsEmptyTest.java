package reqres.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reqres.api.dto.PostReqresUser;

import java.util.stream.Stream;

import static reqres.api.factory.PostUserFactory.getNewPostUser;
import static reqres.api.methods.PostUser.postUser;

public class PostReqresUserRequiredFieldIsEmptyTest {

    static Stream<Arguments> postUserRequiredFiledIsEmpty(){
        PostReqresUser newUser = getNewPostUser();
        newUser.setJob("");
        PostReqresUser newUserSecond = getNewPostUser();
        newUserSecond.setName("");

        return Stream.of(
                Arguments.of(newUser, 201),
                Arguments.of(newUserSecond, 201)
        );

    }

    @ParameterizedTest
    @MethodSource("postUserRequiredFiledIsEmpty")
    void postUserRequiredFiledIsEmptyTest(PostReqresUser newUser, int statusCode){
        Response userResponse = postUser(newUser);
        userResponse.then().assertThat().statusCode(statusCode);
    }

}
