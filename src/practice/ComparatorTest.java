package practice;

import java.util.PriorityQueue;

public class ComparatorTest {
    static class Student {
        String name;
        int age;

        public Student(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(10);
        Student s2 = new Student(15);
        Student s3 = new Student(9);

        PriorityQueue<Student> students = new PriorityQueue<Student>(3, (a, b) -> {
            if (a.age > b.age) return -1;//to sort big to small, a is bigger than b
            else if (a.age < b.age) return 1;
            else return 0;
        });


        students.add(s1);

        students.add(s2);

        students.add(s3);

        while (!students.isEmpty()) {
            System.out.println(students.poll().age);
        }
    }
}
