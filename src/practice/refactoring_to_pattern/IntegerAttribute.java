package practice.refactoring_to_pattern;

public class IntegerAttribute extends AttributeDescriptor {

    public IntegerAttribute(String name) {
        super(name);
    }

    @Override
    public void hello() {
        System.out.println("Hello from " + name);

    }
}
