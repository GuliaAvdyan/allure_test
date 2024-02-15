package guru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButtonText']").click();

        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();

        $("a[href='/eroshenkoam/allure-example']").click();
        $("#issues-tab").click();
        $(withText("#87")).should(Condition.exist);
    }
}
