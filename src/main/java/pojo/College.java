package pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivaniv Ivan Ivanich");
        student.setGroup("RT-081");
        student.setEnrolled(new Date());
        System.out.println(student.getName() + " is in group " + student.getGroup());
    }
}
