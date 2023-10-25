import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(isLogged())logout();
    }

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Alis")
                .withlastName("Born")
                .withEmail("alis_" + i + "@mail.ru")
                .withPassword("Aa12345!");

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationPositive " + user.getName() + " & "+ user.getLastName() +" & "+ user.getEmail() +" & "+ user.getPassword()  );
        pause(3000);
        Assert.assertTrue(isLoggedSuccess());

    }
    @Test
    public void registrationNegativeTestWrongEmail(){

        User user = new User()
                .withName("Aliss")
                .withlastName("Born")
                .withEmail("alismail.ru")
                .withPassword("Aa12345!");

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationPositive " + user.getName() + " & "+ user.getLastName() +" & "+ user.getEmail() +" & "+ user.getPassword()  );
        Assert.assertTrue(isEmailWrong());
    }
    @Test
    public void registrationNegativeTestWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Aliss")
                .withlastName("Born")
                .withEmail("alis_" + i + "@mail.ru")
                .withPassword("Aa12345");

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationPositive " + user.getName() + " & "+ user.getLastName() +" & "+ user.getEmail() +" & "+ user.getPassword()  );
        Assert.assertTrue(isPasswordWrong());
    }

    @Test
    public void registrationNegativeTestWrongName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("")
                .withlastName("Born")
                .withEmail("alis_" + i + "@mail.ru")
                .withPassword("Aa12345!");

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationPositive " + user.getName() + " & "+ user.getLastName() +" & "+ user.getEmail() +" & "+ user.getPassword()  );
        Assert.assertTrue(isNameWrong());
    }
    @Test
    public void registrationNegativeTestWronglastName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Alis")
                .withlastName("")
                .withEmail("alis_" + i + "@mail.ru")
                .withPassword("Aa12345!");

        openRegistrationForm();
        pause(2000);
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationPositive " + user.getName() + " & "+ user.getLastName() +" & "+ user.getEmail() +" & "+ user.getPassword()  );
        Assert.assertTrue(isLastNameWrong());
    }

    @AfterMethod
    public void postcondition() throws IOException {
        if (isLoggedSuccess()){  clickOkButton();}
        else {init();}
    }
}
