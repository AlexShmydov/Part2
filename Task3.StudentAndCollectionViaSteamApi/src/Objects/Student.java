package Objects;

import java.util.Comparator;

public class Student extends BaseStudent {
    private String firstName;
    private String lastName;
    private int age;

    private final int minAge = 16;
    private final int maxAge = 30;
    private final int minLengthString = 5;
    private final String lexicon = "abcdefghijklmnopqrstuvwxyz";

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(){
        setAge(StudentFactory.createAge(minAge, maxAge));
        setFirstName(StudentFactory.createName(minLengthString, minLengthString * 2, lexicon));
        setLastName(StudentFactory.createName(minLengthString, minLengthString * 3, lexicon));
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int compareTo(Student student) {
        return Comparators.AGE.compare(this, student);
    }

    public static class Comparators {
        public static Comparator<Student> AGE = Comparator.comparing(student -> student.age);

        public static Comparator<Student> LAST_NAME = Comparator.comparing(student -> student.lastName);

        public static Comparator<Student> FIRST_NAME = Comparator.comparing(student -> student.firstName);
    }

}
