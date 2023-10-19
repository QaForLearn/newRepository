package reqres.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import reqres.api.dto.ReqresUserDto;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    @Step("Проверяем, что ожидаемый объект ({userExpected}) \n== фактическому ({userActual})")
    public static void assertThatExpectedUserIsEqualToActual(ReqresUserDto userExpected, ReqresUserDto userActual){
        assertThat(userActual)
                .withFailMessage("Ожидаемый результат: " + userExpected + "\n Не соответствует фактическому: " + userActual)
                .usingRecursiveComparison()
                .ignoringFields("data.id")
                .isEqualTo(userExpected);
    }


    @Step("Проверяем, что значение в поле \"{jsonPath}\" соответствует регулярному выражению \"{regex}\"")
    public static void assertRegexJsonField(Response response, String jsonPath, String regex){
        assertThat(response.getBody().path(jsonPath).toString()).matches(regex);
    }

    @Step("Приводим ответ к необходимому классу")
    public static ReqresUserDto parseResponseToReqresUserDto(Response response){
        return response
                .then()
                .extract()
                .response()
                .getBody()
                .as(ReqresUserDto.class);
    }
}
