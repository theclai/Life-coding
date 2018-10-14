package practice;

public class Person implements Cloneable {
    private Name name;
    private int age;

    public Person() {
    }

    public Person(Name name, int age) {
        this.name = name;
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person clone() throws CloneNotSupportedException{
        return new Person(this.name,this.age);

    }
}
