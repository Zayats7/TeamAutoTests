package Bot;

import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TestBot {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestBot.class));

    private static final By LOGIN_BOX = By.xpath(".//input[contains(@name, 'username')]");
    private static final By PASSWORD_BOX = By.xpath(".//*[contains(@name, 'password')]");

    private String login;
    private String password;

    public TestBot(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        LOGGER.info("Находим поле для ввода логина и вводим логин");
        $(LOGIN_BOX).shouldBe(visible).sendKeys(login);
        return login;
    }

    public String getPassword() {
        LOGGER.info("Находим поле для ввода пароля и вводим пароль");
        $(PASSWORD_BOX).shouldBe(visible).sendKeys(password);
        return password;
    }

}
