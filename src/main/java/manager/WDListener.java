package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WDListener extends AbstractWebDriverEventListener implements HelperBase{

    Logger logger = LoggerFactory.getLogger(WDListener.class);

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong!!!");
        logger.info(throwable.getMessage());
        logger.info(throwable.fillInStackTrace().toString());
        int i =(int) (System.currentTimeMillis()/1000)%3600;
        String link = "src/test/screenshots/screenshot- " + i + " .png";
        takeScreenshot(link);
        logger.info("Here is the path to screenshot with error ---> " + link);

    }
    public WDListener() {
        super();
    }
}
