package Quiz_4;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Submit_Form {

    public SelenideElement formContainer = $("#app > div > div > div.home-body > div > div:nth-child(2)");
    public SelenideElement practiceForm = $("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div > ul");

    public SelenideElement firstName = $("#firstName");
    public SelenideElement lastName = $("#lastName");

    public SelenideElement gender(String gender) {
        return switch (gender) {
            case "Male" -> $("label[for=\"gender-radio-1\"]");
            case "Female" -> $("label[for=\"gender-radio-2\"]");
            default -> $("label[for=\"gender-radio-3\"]");
        };
    }

    public SelenideElement phoneNumber = $("#userNumber");

    public SelenideElement submitBtn = $("button[id=\"submit\"]");

    public SelenideElement ModalHeader = $("body > div.fade.modal.show > div > div > div.modal-header");

    public SelenideElement StudentFirstLastName = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(1) > td:nth-child(2)");
    public SelenideElement StudentGender = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(3) > td:nth-child(2)");
    public SelenideElement StudentMobile = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");

}
