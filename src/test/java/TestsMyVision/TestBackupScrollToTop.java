package TestsMyVision;

import Base.MyVisionBase;
import MainPages.MyVisionMainPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 25.04.2022
 * \* Description: тест проверяет работоспособность кнопки возвращения к началу страницы
 * \
 */
public class TestBackupScrollToTop extends MyVisionBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestBackupScrollToTop.class));

    @Test
    @Tag("vision")
    public void testBackupScrollToTop(){
        LOGGER.info("тест проверяет работоспособность кнопки возвращения к началу страницы");
        MyVisionMainPage mainPage = new MyVisionMainPage();
        LOGGER.warning("Нажимаем на кнопку 'Кейсы'");
        mainPage.clickToCaseButton();
        LOGGER.info("Проверяем что мы спустились в нужный раздел");
        assertTrue(mainPage.isOurCasePresents());
        LOGGER.info("Нажимаем на кнопку возврата в начало");
        mainPage.clickScrollToTopButton();
        LOGGER.info("Проверяем что мы поднялись вначало страницы");
        assertTrue(mainPage.isHeaderPresents());
        LOGGER.fine("Кнопка автоматического скрола к началу страницы работает корректно");

    }
}
