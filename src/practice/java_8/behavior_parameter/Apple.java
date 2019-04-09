package practice.java_8.behavior_parameter;

public class Apple {

    int weight;

    String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple(int i, String c) {
        this.weight=i;
        this.color=c;
    }
}
