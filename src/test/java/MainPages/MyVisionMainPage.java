package MainPages;

import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Alexei Zaitcev
 * \* Date: 25.04.2022
 * \* Description: главная страница сайта
 * \
 */
public class MyVisionMainPage {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MyVisionMainPage.class));
    private static final By CASE_BUTTON = By.xpath(".//*[@class='t396__elem tn-elem tn-elem__4216256601646835375984']");
    private static final By SCROLL_TO_TOP_BUTTON = By.xpath(".//*[@class='t890__arrow']");
    private static final By OUR_CASE_ANCHOR = By.xpath(".//*[@class='t396__elem tn-elem tn-elem__4219672471470233923389']");
    private static final By HEADER = By.xpath(".//*[@id='rec421625660']");
    private static final By ORDER_BUTTON = By.xpath(".//*[@data-elem-id='1646833094911']");
    private static final By TALK_ABOUT = By.xpath(".//*[text() = 'расскажите о ВАшей задаче']");
    private static final By NAME = By.xpath(".//*[contains(@placeholder, 'Ваше имя')]");
    private static final By PHONE = By.xpath(".//*[contains(@name, 'test_phone')]");
    private static final By EMAIL = By.xpath(".//*[contains(@name, 'second_email')]");
    private static final By INPUT = By.xpath(".//*[contains(@name, 'test_text')]");
    private static final By FILE_DOWNLOAD = By.xpath(".//*[contains(@type, 'file')]");
    private static final By FILE_DOWNLOAD_CLICK = By.xpath(".//*[@data-tilda-name= 'File']");
    private static final By SUBMIT_BUTTON = By.xpath(".//*[contains(@class, 'tn-form__submit')]");
    public static final By SUBMIT_LAYER = By.xpath(".//*[contains(@class,'t-form-success-popup__wrapper')]");

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
        LOGGER.warning("Проверяем видимость кнопки возвращения к началу страницы");
        $(SCROLL_TO_TOP_BUTTON).shouldBe(visible.because("Кнопка возвращения не видна")).click();
    }

    public void clickOrderButton(){
        LOGGER.warning("Проверяем видимость кнопки обратной связи");
        $(ORDER_BUTTON).shouldBe(visible.because("Нет кнопки обратной связи")).click();
    }

    public void scrollToForm(){
        LOGGER.warning("Скролим до формы обратной связи");
        $(TALK_ABOUT).shouldBe(visible.because("Нет блока с формой обратной связи")).scrollTo();
    }

    public void name(String sendKeys) {
        LOGGER.warning("проверяем видимочть поля имени");
        $(NAME).shouldBe(visible.because("Не показалость поле имени")).click();
        $(NAME).setValue(sendKeys);
    }

    public void phone(String sendKeys){
        LOGGER.warning("проверяем видимочть поля теелфона");
        $(PHONE).shouldBe(visible.because("Не показалость поля теелфона")).setValue(sendKeys);
    }

    public void email(String sendKeys){
        LOGGER.warning("проверяем видимочть поля мейла");
        $(EMAIL).shouldBe(visible.because("Не показалость поле мейла")).click();
        $(EMAIL).setValue(sendKeys);
    }

    public void text(String sendKeys){
        LOGGER.warning("проверяем видимочть поля текста");
        $(INPUT).shouldBe(visible.because("Не показалость поле текста")).click();
        $(INPUT).sendKeys(sendKeys);
    }

    public void uploadFile(String sendKeys) {
        LOGGER.warning("проверяем видимочть кнопки закрузки файлов");
        $(FILE_DOWNLOAD_CLICK).shouldBe(visible.because("Не показалость кнопка загрузки файлов")).click();
        sleep(100);
        $(FILE_DOWNLOAD).sendKeys(sendKeys);
    }

    public void submitButton(){
        LOGGER.warning("проверяем видимочть кнопки отправки данных");
        $(SUBMIT_BUTTON).shouldBe(visible.because("Не показалость кнопка отправки")).click();
    }
}
