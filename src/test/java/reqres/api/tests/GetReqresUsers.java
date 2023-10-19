package reqres.api.tests;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.api.dto.ReqresUserDto;

import static io.qameta.allure.Allure.step;
import static reqres.api.factory.UserFactory.getNewUser;
import static reqres.api.methods.GetReqresGetSingleUser.getUsers;
import static reqres.api.steps.Steps.*;

@DisplayName("Проверка запроса getUsers")
public class GetReqresUsers {
    ReqresUserDto userExpected = getNewUser();
    String regexString = "[0-9]{1,5}";

    @Test
    @DisplayName("Лямбда тест гет юзерс")
    void getUsersLambdaStepsTest() {
        final Response[] userActual = new Response[1];
        step("Отправляем запрос, получаем ответ", () -> {
                    userActual[0] = getUsers(2);
                }
        );
        step("Проверяем ответ", () -> {
            ReqresUserDto actualUserAsClass = parseResponseToReqresUserDto(userActual[0]);
            assertThatExpectedUserIsEqualToActual(userExpected, actualUserAsClass);
            assertRegexJsonField(userActual[0], "data.id", regexString);
        });
    }


    @Test
    @DisplayName("Тест с аннотациями гет юзерс")
    void getUsersAnnotationStepsTest() {
        Response userActual = getUsers(2);
        ReqresUserDto actualUserAsClass = parseResponseToReqresUserDto(userActual);
        assertThatExpectedUserIsEqualToActual(userExpected, actualUserAsClass);
        assertRegexJsonField(userActual, "data.id", regexString);
    }
}
