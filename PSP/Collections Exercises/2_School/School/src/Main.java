import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Student, HashSet<Teacher>> studentTeachers = new TreeMap<>();

        studentTeachers.put(new Student("Alice", 9), new HashSet<>(Set.of(
                new Teacher("Mr. Smith", "Math"),
                new Teacher("Ms. Johnson", "Science")
        )));

        studentTeachers.put(new Student("Anna", 8), new HashSet<>(Set.of(
                new Teacher("Mr. Oliver", "History"),
                new Teacher("Ms. Allison", "Art")
        )));

        studentTeachers.put(new Student("Elle", 10), new HashSet<>(Set.of(
                new Teacher("Mr. Iborra", "Geography"),
                new Teacher("Ms. Arenas", "Physical Education")
        )));

        for (var entry : studentTeachers.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getKey().getGrade() + " -> " + entry.getValue().stream().map(Teacher::getName).toList());
        }
    }
}

