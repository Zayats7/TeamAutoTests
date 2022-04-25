package MainPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 25.04.2022
 * \* Description:
 * \
 */
public class MyVisionMainPage {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MyVisionMainPage.class));
    private static final By CASE_BUTTON = By.xpath(".//*[@class='t396__elem tn-elem tn-elem__4216256601646835375984']");
    private static final By SCROLL_TO_TOP_BUTTON = By.xpath(".//*[@class='t890__arrow']");
    private static final By OUR_CASE_ANCHOR = By.xpath(".//*[@class='t396__elem tn-elem tn-elem__4219672471470233923389']");
    private static final By HEADER = By.xpath(".//*[@id='rec421625660']");

    public void clickToCaseButton(){
        LOGGER.warning("Проверяем видимость кнопки");
         $(CASE_BUTTON).shouldBe(visible.because("не появилось кнопка кейсы")).click();
    }

    public boolean isOurCasePresents(){
        return $(OUR_CASE_ANCHOR).isDisplayed();
    }

    public boolean isHeaderPresents(){
        return $(HEADER).isDisplayed();
    }

    public void clickScrollToTopButton(){
        LOGGER.warning("Проверяем видимость внопки возвращения к началу страницы");
        $(SCROLL_TO_TOP_BUTTON).shouldBe(visible.because("Кнопка возвращения не видна")).click();
    }
}
