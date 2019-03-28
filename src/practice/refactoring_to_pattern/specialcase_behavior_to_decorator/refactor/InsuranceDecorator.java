package practice.refactoring_to_pattern.specialcase_behavior_to_decorator.refactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.refactoring_to_pattern.specialcase_behavior_to_decorator.CarRental;
import practice.refactoring_to_pattern.specialcase_behavior_to_decorator.Model;

public class InsuranceDecorator {
    @Test
    public void firstTest() {
      /*  Model m = new Model(10.0f, 50.0f, "Ford Taurus");
        Rental ford = new CarRental(m, 5);
        ford.setInsurance(12.5f);
        float fordPrice = ford.calcPrice();

        Rental insuredFord = new Insurance(new CarRental(m, 5));
        insuredFord.setInsurance(12.5f);
        float insuredFordPrice = insuredFord.calcPrice();
        assert(fordPrice == insuredFordPrice);*/
        Model m = new Model(10.0f, 50.0f, "Ford Taurus");
        Rental insuredFord = new Insurance(new CarRental(m, 5), 12.5f); float insuredFordPrice = insuredFord.calcPrice(); assert(insuredFordPrice == 312.5f);
    }
}
