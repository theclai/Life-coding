package practice.refactoring_to_pattern;

public class EncapsulatingTest {
    public static void main(String[] args) {
        AttributeDescriptor add= AttributeDescriptor.createDoubleAttribute("Double");
        add.hello();

        AttributeDescriptor adi= AttributeDescriptor.createIntegerAttribute("Integer");
        adi.hello();
    }
}
