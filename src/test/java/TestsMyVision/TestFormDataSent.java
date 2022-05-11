package TestsMyVision;

import Base.MyVisionBase;
import MainPages.MyVisionMainPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static MainPages.MyVisionMainPage.SUBMIT_LAYER;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 11.05.2022
 * \* Description: проверка отправки данных с формы обратной связи
 * \
 */
public class TestFormDataSent extends MyVisionBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestLayerTaskForm.class));

    @Test
    @Tag("vision")
    public void testFormDataSent() {
        LOGGER.info("тест проверяет отправку данных с формы обратной связи");
        MyVisionMainPage mainPage = new MyVisionMainPage();
        mainPage.scrollToForm();
        LOGGER.info("Показался блок формы обратной связи");
        LOGGER.info("Вводим в форму имя");
        mainPage.name("AUTO_TEST");
        LOGGER.info("Вводим в форму телефон");
        mainPage.phone("7777777777");
        LOGGER.info("Вводим мэйл");
        mainPage.email("autotest@autotest.com");
        LOGGER.info("Вводим текст сообщения");
        mainPage.text("AUTO_TEST AUTO_TEST AUTO_TEST AUTO_TEST AUTO_TEST AUTO_TEST AUTO_TEST AUTO_TEST AUTO_TEST");
        LOGGER.info("Выбираем файл с компьютера");
        mainPage.uploadFile("/Users/alexei77/Downloads/Johnny_tilda9720613.jpg");
        LOGGER.info("Нажимаем на кнопкуотправки данных");
        mainPage.submitButton();
        assertThat($(SUBMIT_LAYER).shouldBe(visible.because("Не показалось подтверждение отправки данных с формы")));
        LOGGER.fine("Данные успешно отправлены");
    }
}
