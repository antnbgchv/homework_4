import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSelenideTests {

    @BeforeAll
    static void config() {
        //configParams
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void JUnit5Test() {
        //added a variable for the code example
        String codeExample = """
                        @ExtendWith({SoftAssertsExtension.class})
                                             class Tests {
                                                  @Test
                                                  void test() {
                                                    Configuration.assertionMode = SOFT;
                                                    open("page.html");
                                                    
                                                    $("#first").should(visible).click();
                                                    $("#second").should(visible).click();
                                                  }
                                            }
                """;

        //open the page
        open("https://github.com/selenide/selenide");
        //click wiki tab
        $("#wiki-tab").click();
        //see if SoftAssertions is there and click the button
        $("#wiki-pages-box button").scrollTo().click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //checking if there is a sample code for JUnit5 on the page
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:"))
                .sibling(0).shouldHave(text(codeExample));

    }


}
