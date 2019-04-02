package practice.java_8.behavior_parameter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BehaviorParam {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(165, "green"),
                new Apple(120, "red"));

        List<Apple> green=inventory.stream().filter(a->a.getColor().equals("green")).collect(Collectors.toList());
        green.forEach(apple -> System.out.println("Weight: "+apple.getWeight()+" color: "+apple.getColor()));
    }
}
