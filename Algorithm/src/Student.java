public class Student
{

    int year;
    int gender;

    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1);
        s1.year = 21;
        s1.gender = 1;
        Student s2 = new Student();
        s2 = s1;
        System.out.println(s2);
        System.out.println(s2.gender + " "  + s2.year) ;

    }
}
