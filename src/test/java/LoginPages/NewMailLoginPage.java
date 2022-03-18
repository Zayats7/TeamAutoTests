package LoginPages;

import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewMailLoginPage {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(NewMailLoginPage.class));
    private static final By BUTTON_TO = By.xpath(".//button[contains(@data-testid, 'enter-mail-primary')]");
    private static final By CHECKBOX = By.xpath(".//*[contains(@class, 'box-0-2-111 activeBox-0-2-116')]");
    private static final By GO_TO_PASSWORD = By.xpath(".//button[contains(@data-test-id, 'next-button')]");
    private static final By GO_TO = By.xpath(".//button[contains(@data-test-id, 'submit-button')]");
    private static final By LOGIN_FRAME = By.xpath("//iframe[contains(@class, 'ag-popup__frame__layout__iframe')]");
    private static final By LOGIN_CONTENT = By.xpath(".//div[contains(@id, 'login-content')]");
    public static By CHECK_E_MAIL = By.xpath(".//*[contains(@class, 'email-block__inner-content')]");

    public void doLogin() {
        LOGGER.warning("Находим кнопку для ввода логина и кликаем на нее");
        $(BUTTON_TO).shouldHave(text("Войти")).click();
        LOGGER.info("Переключаемся во фрейм формы логина");
        $(LOGIN_FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(LOGIN_FRAME).shouldBe(visible));
        LOGGER.warning("Ждем появления формы логина");
        $(LOGIN_CONTENT).shouldBe(visible);
    }

    public void doCheckBox() {
        LOGGER.warning("Проверяем видимость чекбокса и выключаем его");
        $(CHECKBOX).shouldBe(visible).click();
    }

    public void doPassword() {
        LOGGER.warning("Проверяем видимость кнопки для ввода пароля и кликаем на нее");
        $(GO_TO_PASSWORD).shouldBe(visible).click();

    }

    public void goToMainPage() {
        LOGGER.warning("Проверяем видимость кнопки входа и заходим в аккаунт");
        $(GO_TO).shouldBe(visible).click();
    }
}
