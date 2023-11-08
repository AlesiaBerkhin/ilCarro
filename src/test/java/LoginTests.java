
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

    @Test(groups ={"positive"})
    public void loginPositiveTest(){

        openLoginForm();
        fillLoginForm("katy@mail.ru", "Kk12345!" );
        submitLogin();
        logger.info("loginPositiveTest1 " + "katy@mail.ru" + " & " + "Kk12345!");
        Assert.assertTrue(isLoggedSuccess());
        pause(2000);
    }
    @Test(groups ={"positive"})
    public void loginPositiveTestProps(){

        openLoginForm();
        fillLoginForm(getEmail(), getPassword() );
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
        pause(2000);
    }

    @Test(groups ={"positive"})
    public void loginPositiveTest1(){

        User user = new User()
                .withEmail("taty@mail.ru")
                .withPassword("Tt12345!");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        logger.info("loginPositiveTest1 " + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }
}
