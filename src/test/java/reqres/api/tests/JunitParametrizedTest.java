package reqres.api.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@Slf4j
public class JunitParametrizedTest {
    @ParameterizedTest(name = "Выполняем тест с \"{0}\"")
    @ValueSource(strings = {
            "первым параметром",
            "вторым параметром",
            "третьим параметром"})
    void valueSourceTest(String param){
        log.info("Я выполняюсь с " + param);
    }

    @ParameterizedTest(name = "Вводим \"{0}\" и ожидаем увидеть \"{1}\"")
    @CsvSource(value = {
            "Первый входной параметр|Первый ожидаемый результат|Ещё один первый параметр|Ещё один первый ожидаемый результат",
            "Второй входной параметр|Второй ожидаемый результат|Ещё один второй параметр|Ещё один второй ожидаемый результат",
            "Третий входной параметр|Третий ожидаемый результат|Ещё один третий параметр|Ещё один третий ожидаемый результат"},
    delimiter = '|')
    void CSVSourceTest(String param, String expectedResult, String anotherParam, String anotherExpectedResult){
        log.info("Вводим " + param);
        log.info("Видим " + expectedResult);
        log.info("Вводим " + anotherParam);
        log.info("Видим " + anotherExpectedResult);
        log.info("##############################");
    }

    @ParameterizedTest(name = "{0}")
    @EnumSource(Params.class)
    void enumSourceTest(Params params){
        log.info(params.name());
    }

    static Stream<Arguments> paramsForMethodSourceTest(){
        return Stream.of(
                Arguments.of(
                        "Первый параметр первого запуска",
                        "Второй параметр первого запуска",
                        "Третий параметр первого запуска"
                ),
                Arguments.of(
                        "Первый параметр второго запуска",
                        "Второй параметр второго запуска",
                        "Третий параметр второго запуска"
                ),
                Arguments.of(
                        "Первый параметр третьего запуска",
                        "Второй параметр третьего запуска",
                        "Третий параметр третьего запуска"
                )
        );
    }

    @ParameterizedTest(name = "\"{0}\", \"{1}\", \"{2}\"")
    @MethodSource("paramsForMethodSourceTest")
    void methodSource(String firstParam, String secondParam, String thirdParam){
        log.info("Вводим " + firstParam);
        log.info("Вводим " + secondParam);
        log.info("Вводим " + thirdParam);
        log.info("##############################");
    }
}
