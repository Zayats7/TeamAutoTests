package Layers;

import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 25.04.2022
 * \* Description: леер формы обратной связи
 * \
 */
public class MyVisionOrderLayer {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MyVisionOrderLayer.class));
    private static final By POPUP = By.xpath(".//*[@data-track-popup='/tilda/popup/rec422606151/opened']");
    private static final By CLOSE_BUTTON = By.xpath(".//*[@class='t-popup__close-icon']");
    private static final By HEADIND = By.xpath(".//strong['Расскажите о Вашей задаче']");
    private static final By NAME_BOX = By.xpath(".//*[@name='Name']");
    private static final By PHONE_BOX = By.xpath(".//*[@name='Phone']");
    private static final By EMAIL_BOX = By.xpath(".//*[@name='Email']");
    private static final By DESCRIPTION_BOX = By.xpath(".//*[@name='Textarea']");
    private static final By SENT_BUTTON = By.xpath(".//*[@class='t-form__submit']");
    private static final By PRIVACY_TEXT = By.xpath(".//*[@class='t702__form-bottom-text t-text t-text_xs t-align_center']");

    public void check() {
        $(POPUP).shouldBe(visible.because("Не загрузился леер формы обратной связи"));
        $(CLOSE_BUTTON).shouldBe(visible.because("Не загрузилась нопка закрытия леера"));
        $(HEADIND).shouldBe(visible.because("Не загрузился заголовок формы"));
        $(NAME_BOX).shouldBe(visible.because("Не загрузилось поле имени"));
        $(PHONE_BOX).shouldBe(visible.because("Не загрузилось поле телефона"));
        $(EMAIL_BOX).shouldBe(visible.because("Не загрузилось поле электронной почты"));
        $(DESCRIPTION_BOX).shouldBe(visible.because("Не загрузилось поле описания"));
        $(SENT_BUTTON).shouldBe(visible.because("Не загрузилась кнопка отправки"));
        $(PRIVACY_TEXT).shouldBe(visible.because("Не загрузился текст соглашения с отправкой"));

        LOGGER.fine("Корректно отобразилась форма обратной связи");
    }
}
