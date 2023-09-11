
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod //esli mi yspeshno zaloginilis to dolzni yspeshno otloginits
    public void precondition(){
        if(isLogged())logout();
    }

    @Test
    public void loginPositiveTest(){

        openLoginForm();
        fillLoginForm("katy@mail.ru", "Kk12345!" );
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
        pause(2000);
    }

    @Test
    public void loginPositiveTest1(){

        User user = new User("alis", "lily", "tyt@mail.ru", "12345Tt!")
                .withEmail("taty@mail.ru")
                .withPassword("Tt12345!");
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){

        clickOkButton();
    }
}
