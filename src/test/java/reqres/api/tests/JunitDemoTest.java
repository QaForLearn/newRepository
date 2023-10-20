package reqres.api.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;


@Slf4j
@DisplayName("Тесты для демонстрации аннотаций джиюнита.")
public class JunitDemoTest extends BeforeAllClass {
    @BeforeEach
    void everyTestSetUp(){
        log.info("  Я выполняюсь перед каждым тестом");
    }

    @Test
    void firstTest(){
        log.info("      Первый тест");
    }

    @Test
    void secondTest(){
        log.info("      Второй тест");
    }

    @Test
    void thirdTest(){
        log.info("      Третий тест");
    }

    @AfterEach
    void everyTestTearDown(){
        log.info("  Я выполняюсь после каждого теста");
    }

    @AfterAll
    static void testClassTearDown(){
        log.info("Я выполняюсь один раз, после прогона тестов в классе");
    }
}
