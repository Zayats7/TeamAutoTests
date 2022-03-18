package TestsMail;

import Base.MailBase;
import LoginPages.LoginLeer;
import LoginPages.NewMailLoginPage;
import MainPages.MailMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

/**
 * 1. Переходим на главную страницу Мейла https://mail.ru
 * 2. Нажимаем на кнопку "Войти"
 * 3. Вводим имя тестового аккаунта
 * 4. Проверяем корректность отображения почты в леере пароля с введенной ранее
 * 5. Вводим пароль
 * 6. Отключаем чекбокс "Запомнить"
 * 7. Нажимаем войти
 * 8. Кликаем по своему аккаунту в правом верхнем углу
 * 9. Нажимаем добавит аккаунт
 * 10. Вводим имя тестового аккаунта
 * 11. Проверяем корректность отображения почты в леере пароля с введенной ранее
 * 12. Вводим пароль
 * 13. Отключаем чекбокс "Запомнить"
 * 14. Нажимаем войти
 * 15. Кликаем по своему аккаунту в правом верхнем углу
 * 16. Проверяем что появился второй аккаунт
 * 17. Проверяем что отображаемые почты отличаются
 */

public class TestAddSecondAccount extends MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestSendMail.class));
    public static final String LOGIN = "margleibblan@mail.ru";
    private static final String PASSWORD = "qwedcxzasdfghjkl;'\\";
    public static final String SECOND_LOGIN = "mrgleibblan@mail.ru";
    private static final String SECOND_PASSWORD = "qwedcxzasdfghjkl;'\\";

    @Test
    public void testAddSecondAccount() {
        NewMailLoginPage loginPage = new NewMailLoginPage();
        LOGGER.info("Логин");
        loginPage.doLogin(LOGIN);
        loginPage.doCheckBox();
        LOGGER.info("Пароль");
        loginPage.doPassword(PASSWORD);
        LOGGER.info("Заходим в почту");
        loginPage.goToMainPage();

        MailMainPage mainPage = new MailMainPage();
        LOGGER.info("Открываем леер");
        mainPage.accountButton();
        LOGGER.info("Добавить второй аккаунт");
        mainPage.addAccount();

        LoginLeer loginLeer = new LoginLeer();
        LOGGER.info("Второй логин");
        loginLeer.doLogin(SECOND_LOGIN);
        loginLeer.doCheckBox();
        LOGGER.info("Второй пароль");
        loginLeer.doPassword(SECOND_PASSWORD);
        LOGGER.info("Заходим во вторую почту");
        loginLeer.goToMainPage();
        LOGGER.info("Открываем леер");
        mainPage.accountButton();
        String first_login = $(loginLeer.FIRST_LOGIN).getText();
        String second_login = $(loginLeer.SECOND_LOGIN).getText();
        Assertions.assertNotEquals(first_login, second_login, "Логины совпадают, тест не пройден");
        LOGGER.warning("Логины не совпадают, тест пройден");
    }
}
