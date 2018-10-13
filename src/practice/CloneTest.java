package practice;

public class CloneTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(10);
        Name n = new Name();
        n.setfName("Omar");
        n.setlName("Faroque");
        p.setName(n);
        Person p1 = null;
        try {
            p1 = p.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Name name=null;

        try {
            name=p.getName().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        name.setlName("Test");
        p1.setAge(100);
        p1.setName(name);

        System.out.println(p.getAge());
        System.out.println(p1.getAge());
        System.out.println(p.getName().getlName());
        System.out.println(p1.getName().getlName());
    }
}
