package TestsMail;

import Base.MailBase;
import Bot.TestBot;
import LoginPages.NewMailLoginPage;
import MainPages.MailMainPage;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Тест проверяет логин и отправку письма самому себе
 * 1. Залогиниться пользователем
 * 2. Открыть леер сообщений
 * 3. Выбрать в адресате себя
 * 4. Заполнить тему
 * 5. Заполнить само сообщение
 * 6. Отправить сообшение
 * 7. Проверить что сообщение отправлено
 */

//TODO Написать одтельный класс логгера и вытащить его из теста (Progress: 10%)
public class TestSendMail extends MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestSendMail.class));
    public static final TestBot TEST_BOT = new TestBot("margleibblan@mail.ru", "qwedcxzasdfghjkl;'\\");

    @Test
    public void testSentMessage() {
        NewMailLoginPage loginPage = new NewMailLoginPage();
        LOGGER.info("Логин");
        loginPage.doLogin();
        String mail = TEST_BOT.getLogin();
        loginPage.doCheckBox();
        LOGGER.info("Пароль");
        loginPage.doPassword();
        String compareEmail = $(NewMailLoginPage.CHECK_E_MAIL).shouldBe(visible).getText();
        LOGGER.info("Сравниваем введенный адрес почты и отображаемый");
        Assertions.assertEquals(mail, compareEmail, "Логины не совпадают");
        TEST_BOT.getPassword();

        LOGGER.info("Заходим в почту");
        loginPage.goToMainPage();

        MailMainPage mainPage = new MailMainPage();
        LOGGER.info("Написать письмо");
        mainPage.writeMessageButton();
        LOGGER.info("Выбираем адресата");
        mainPage.whomLine();
        mainPage.mySelfButton();
        LOGGER.info("Заполняем тему и пишем письмо");
        mainPage.topic();
        mainPage.texBox();
        LOGGER.info("Отправляем письмо");
        mainPage.sendMessageButton();
        Assertions.assertTrue(mainPage.sendMessageLayer().isDisplayed());
        LOGGER.warning("Письмо отправлено, тест пройден");
    }

}

