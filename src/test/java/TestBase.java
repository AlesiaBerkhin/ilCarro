import manager.ApplicationManager;
import manager.HelperBase;
import manager.HelperUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase implements HelperUser {

   WebDriver wd;

    @BeforeSuite
//    public void init() {
//       wd = new ChromeDriver();
//       wd.navigate().to("https://ilcarro.web.app/search");
//       wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//   }
    public void setup(){
        init();
    }

    @AfterSuite
    public void stop(){
        pause(5000);
        tearDown();
    }
//    public void tearDown() {
//       pause(5000);
//        wd.quit();
//    }

//    public void pause(int millis) {
//
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public boolean isElementPresent(By locator) {
//        return wd.findElements(locator).size() > 0;
//    }
//    public void click(By locator) {
//        wd.findElement(locator).click();
//    }
//
//    public void type(By locator, String text) {
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//   public void  openLoginForm(){
//    click(By.xpath("//*[.=' Log in ']"));
//   }
//
//   public void fillLoginForm(String email, String password){
//    type(By.id("email"), email);
//    type(By.id("password"), password);
//   }
//
//   public void submitLogin(){
//
//        click(By.xpath("//button[@type='submit']"));
//   }
//
//   public boolean isLoggedSuccess(){
//
//        return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
//   }
//
//   public void logOut(){
//        click(By.xpath("//*[.=' Logout ']"));
//   }
//
//   public void clickOkButton(){
//        click(By.xpath("//button[@type='button']"));
//
//   }
}
