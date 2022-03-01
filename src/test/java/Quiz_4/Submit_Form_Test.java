package Quiz_4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class Submit_Form_Test {
    User User;

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Dato", "Chipashvili", "Male", "1234567890"},
                {"Anano", "Chipashvili", "Female", "0987654321"},
        };
    }

    @BeforeClass
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://demoqa.com/");
    }

    class User {
        String FirstName;
        String LastName;
        String Gender;
        String PhoneNumber;

        public User(String firstName, String lastName, String gender, String phoneNumber) {
            FirstName = firstName;
            LastName = lastName;
            Gender = gender;
            PhoneNumber = phoneNumber;
        }
    }

    Submit_Form Submit_Form = new Submit_Form();

    @Test(dataProvider = "data-provider")
    public void fill_inputs(String firstName, String lastName, String gender, String phoneNumber) {

        User = new User(firstName, lastName, gender, phoneNumber);

        Submit_Form.formContainer.click();

        Submit_Form.practiceForm.click();

        Submit_Form.firstName.sendKeys(User.FirstName);

        Submit_Form.lastName.sendKeys(User.LastName);

        Submit_Form.gender(User.Gender).click();

        Submit_Form.phoneNumber.sendKeys(User.PhoneNumber);

        Submit_Form.submitBtn.click();

    }

    @AfterTest
    public void Text_Is_Visible() {
        var Text = Submit_Form.ModalHeader.getText();
        if (Text.equals("Thanks for submitting the form")) {
            System.out.println("Visible");
        } else {
            System.out.println("Hidden");
        }
    }

    @AfterTest
    public void Check_Info() {
        Assert.assertEquals(Submit_Form.StudentFirstLastName.getText(), User.FirstName + " " + User.LastName);
        Assert.assertEquals(Submit_Form.StudentGender.getText(), User.Gender);
        Assert.assertEquals(Submit_Form.StudentMobile.getText(), User.PhoneNumber);
    }
}
