import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<Double> grades;

    public Student(String name, int age, List<Double> grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Double> getGrades() {
        return grades;
    }
}
