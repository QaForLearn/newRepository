package reqres.api.steps;

import io.restassured.response.Response;
import reqres.api.dto.ReqresUserDto;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {
    public static void assertThatExpectedUserIsEqualToActual(ReqresUserDto userExpected, ReqresUserDto userActual){
        assertThat(userActual)
                .withFailMessage("Ожидаемый результат: " + userExpected + "\n Не соответствует фактическому: " + userActual)
                .usingRecursiveComparison()
                .ignoringFields("data.id")
                .isEqualTo(userExpected);
    }

    public static void assertRegexJsonField(Response response, String jsonPath, String regex){
        assertThat(response.getBody().path(jsonPath).toString()).matches(regex);
    }

    public static ReqresUserDto parseResponseToReqresUserDto(Response response){
        return response
                .then()
                .extract()
                .response()
                .getBody()
                .as(ReqresUserDto.class);
    }
}
