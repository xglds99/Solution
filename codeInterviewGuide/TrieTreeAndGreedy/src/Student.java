import java.util.Arrays;

public class Student {

    Integer age;
    String name;

    public Student(Integer age) {
        this.age = age;
    }

    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student[] clazz = new Student[5];
        Student s1 = new Student(10);
        s1.name = "a";
        Student s2 = new Student(12);
        s2.name = "bc";
        Student s3 = new Student(8);
        s3.name = "bcca";
        Student s4 = new Student(28);
        s4.name = "abb";
        Student s5 = new Student(31);
        s5.name = "11";
        clazz[0] = s1;
        clazz[1] = s2;
        clazz[2] = s3;
        clazz[3] = s4;
        clazz[4] = s5;


        Arrays.sort(clazz,(x,y)-> y.name.charAt(0) - x.name.charAt(0));
        for (Student student : clazz) {
            System.out.println(student);
        }
    }
}
