package TestsMyVision;

import Base.MyVisionBase;
import Layers.MyVisionOrderLayer;
import MainPages.MyVisionMainPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 25.04.2022
 * \* Description: тест проверяет корректное открытие леера формы обратной связи
 * \
 */
public class TestLayerTaskForm extends MyVisionBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestLayerTaskForm.class));

    @Test
    @Tag("vision")
    public void testLayerTaskForm() {
        LOGGER.info("тест проверяет корректное открытие леера формы обратной связи");
        MyVisionMainPage mainPage = new MyVisionMainPage();
        LOGGER.info("Нажимаем на кнопку 'Заказать продвижение'");
        mainPage.clickOrderButton();
        MyVisionOrderLayer orderLayer = new MyVisionOrderLayer();
        LOGGER.info("Проверяем видимость леера формы обратной связи");
        orderLayer.check();
        LOGGER.fine("Леер формы отбратной связи отобразился успешно");
    }
}
