package guru.qa.allure;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 87;


    @Test
    @Feature("Issue в репозитории") // behaviors в allure отчете
    @Story("Создание Issue")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void staticLabelsTest() {
    }

    @Test
    public void dynamicLabelsTest() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("sevetiry", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }

}
