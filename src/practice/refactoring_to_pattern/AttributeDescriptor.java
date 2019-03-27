package practice.refactoring_to_pattern;

public abstract class AttributeDescriptor {
    String name;
    protected AttributeDescriptor(String name) {
        this.name=name;
    }

    public static AttributeDescriptor createIntegerAttribute(String name){
        return new IntegerAttribute(name);
    }
    public static AttributeDescriptor createDoubleAttribute(String name){
        return new DoubleAttribute(name);
    }
    public  abstract void hello();
}
