package Base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 25.04.2022
 * \* Description: Пэйдж для работы с браузером для MyVision
 * \
 */
public class MyVisionBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MailBase.class));
    private static final String WEB_SITE = "https://prmyvision.ru/";
    public WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void startDriver() {
        LOGGER.info("Запускаем браузер");
        LOGGER.info("Переходим на страницу логина");
        Selenide.open(WEB_SITE);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    void killDriver() {
        LOGGER.info("Закрываем браузер");
        Selenide.closeWebDriver();
    }

}
