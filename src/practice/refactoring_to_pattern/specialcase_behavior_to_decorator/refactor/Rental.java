package practice.refactoring_to_pattern.specialcase_behavior_to_decorator.refactor;

import practice.refactoring_to_pattern.specialcase_behavior_to_decorator.Model;

public interface Rental {
    public float calcPrice();

    public int getDaysRented();

    public float getFuelConsumed();

    public void setFuelConsumed(float amount);

    public Model getModel();
}
