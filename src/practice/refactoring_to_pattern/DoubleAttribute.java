package practice.refactoring_to_pattern;

public class DoubleAttribute extends AttributeDescriptor {

    public DoubleAttribute(String name) {
        super(name);
    }

    @Override
    public void hello() {
        System.out.println("Hello from " + name);
    }
}
