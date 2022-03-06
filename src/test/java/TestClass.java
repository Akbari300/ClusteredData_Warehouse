import org.carpool.car_mng.*;
import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @Test
    public void carClassTest() {
        Car car = new Car();
        car.setType("Tesla");
        car.setColorCode("FFFFFF");
        car.setColorName("white");
        car.setPrice(1000.00);
        car.setDeleted(false);
        car.setActive(true);
        car.setNotes("verynice");
        car.setId(0L);
        Assert.assertNotNull(car);
    }
}
