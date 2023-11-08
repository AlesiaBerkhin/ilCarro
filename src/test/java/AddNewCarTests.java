import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void precondition(){
      if(isLogged()== false){
          login(new User()
                  .withEmail("katy@mail.ru")
                  .withPassword("Kk12345!")
          );
      }
    }

    @Test
    public void addNewCarPositive(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .serialNumber("100-200-" + i)
                .price("150")
                .about("New car")
                .build();

        openCarForm();
        fillCarForm(car);
        submitNewCar();
        Assert.assertTrue(isAddCarSuccess());
        pause(3000);


    }

    @Test
    public void addNewContactPositiveDTO(Car car) {

        openCarForm();
        fillCarForm(car);
        submitNewCar();
        Assert.assertTrue(isAddCarSuccess());
    }

    @AfterMethod
    public void postcondition() throws IOException {
        if (isAddCarSuccess()){  clickAddNewCarButton();}
        else {init();}
    }

    
}
