package reqres.api.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class BeforeAllClass {
    @BeforeAll
    static void testClassSetUp(){
        log.info("Я выполняюсь один раз, перед запуском тестов в классе");
    }
}
