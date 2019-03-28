package practice.refactoring_to_pattern.specialcase_behavior_to_decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRentalRefactorTest {
    CarRental carRental1, carRental2, carRental3;

    @BeforeEach
    public void init() {
       /* Model m = new Model(10.0f, 50.0f, "Ford Taurus");
        carRental1 = new CarRental(m, 5);
        carRental2 = new CarRental(m, 5);
        carRental2.setInsurance(12.5f);
        carRental3 = new CarRental(m, 5);
        carRental3.setInsurance(12.5f);
        carRental3.setRefuelOnReturn(3.75f);*/
    }

    @Test
    public void firstTest() {
       // Assertions.assertEquals(carRental1.calcPrice(), 250.0f);
    }

    @Test
    public void secondTest() {
       // Assertions.assertEquals(carRental2.calcPrice(), 312.5f);
    }

    @Test
    public void thirdTest() {
       // Assertions.assertEquals(carRental3.calcPrice(), 350.0f);
    }
}
