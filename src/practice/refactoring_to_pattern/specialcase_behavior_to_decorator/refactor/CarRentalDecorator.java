package practice.refactoring_to_pattern.specialcase_behavior_to_decorator.refactor;

import practice.refactoring_to_pattern.specialcase_behavior_to_decorator.Model;

public class CarRentalDecorator implements Rental {
    protected Rental rental;

    protected CarRentalDecorator(Rental r) {
        rental = r;
    }

    public float calcPrice() {
        return rental.calcPrice();
    }

    public int getDaysRented() {
        return rental.getDaysRented();
    }

    public float getFuelConsumed() {
        return rental.getFuelConsumed();
    }

    public void setFuelConsumed(float amount) {
        rental.setFuelConsumed(amount);
    }

    public Model getModel() {
        return rental.getModel();
    }
}
