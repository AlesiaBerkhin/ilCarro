package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public interface ApplicationManager {

    WebDriver wd = new ChromeDriver();

    default void init() {
    //    wd = new ChromeDriver();
        //   wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    default void tearDown() {

        wd.quit();
    }
}
