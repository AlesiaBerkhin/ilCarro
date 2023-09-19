package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

public interface HelperUser extends HelperBase{

    default void  openLoginForm(){
        click(By.xpath("//*[.=' Log in ']"));
    }

    default void openRegistrationForm(){
        click(By.xpath("//*[.=' Sign up ']"));

    }

    default void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    default void fillLoginForm(User user){
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }
    default void fillRegistrationForm(String name, String lastName, String email, String password){
        type(By.id("name"), name);
        type(By.id("lastName"),lastName);
        type(By.id("email"),email);
        type(By.id("password"), password);
        pause(3000);
        clickCheckbox();
    }
    default void fillRegistrationForm(User user){
        type(By.id("name"), user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        pause(3000);
        clickCheckbox();
    }

    default void clickCheckbox(){
                // variant 1
 //      click(By.cssSelector("label[for='terms-of-use']"));

                // variant 2
        JavascriptExecutor js = (JavascriptExecutor) wd;  //slovno delaem casting
        js.executeScript("document.querySelector('#terms-of-use').click();");

                // variant 3
//        Rectangle rect = wd.findElement(By.id("terms-of-use")).getRect();
//        int x = rect.getX() + rect.getWidth() / 2;
//        int y = rect.getY() + rect.getHeight() / 2;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x,y).click().perform();
    }

    default void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }
    default void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }

    default boolean isLoggedSuccess(){
        return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
    }
    default boolean isLogged(){
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }

    default boolean isNameWrong(){return isElementPresent(By.xpath("//*[.=' Name is required ']"));}
    default boolean isLastNameWrong(){return isElementPresent(By.xpath("//*[.=' Last name is required ']"));}
    default boolean isEmailWrong(){return isElementPresent(By.xpath("//*[.='Wrong email format']"));}
    default boolean isPasswordWrong(){return isElementPresent(By.xpath("//*[.='Password must contain minimum 8 symbols']"));}

    default void logout(){
        click(By.xpath("//*[.=' Logout ']"));
    }

    default void clickOkButton(){
        click(By.xpath("//button[@type='button']"));
    }

    default void login (User user){
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOkButton();
    }

}
