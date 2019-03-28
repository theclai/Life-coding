package practice.refactoring_to_pattern.specialcase_behavior_to_decorator.refactor;

import practice.refactoring_to_pattern.specialcase_behavior_to_decorator.Model;

public class Insurance extends CarRentalDecorator {
    protected float rate;

    public Insurance(Rental r, float rate) {
        super(r);
        this.rate = rate;
    }

    private float insuranceAmount() {
        return rate * rental.getDaysRented();
    }

    public float calcPrice() {
        return rental.calcPrice() + insuranceAmount();
    }
}
