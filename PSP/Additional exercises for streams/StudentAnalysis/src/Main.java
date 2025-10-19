import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Patricia", 20, List.of(85.5, 90.0, 78.5)));
        students.add(new Student("Anna", 22, List.of(88.0, 76.5, 92.0)));
        students.add(new Student("Pepe", 19, List.of(95.0, 89.5, 84.0)));
        students.add(new Student("Maria", 21, List.of(70.0, 80.5, 75.0)));
        students.add(new Student("Julia", 23, List.of(82.0, 91.5, 88.0)));

        List<String> names = students.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .map(s -> s.getName())
                .toList();

        System.out.println("The names of the students sorted by age are:");
        for(String name : names) {
            System.out.println(name);
        }

        System.out.println();

        //Calculate the average grade of all students and print the result.
        double averageGrade = students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("The average grade of all students is: " + averageGrade);

        System.out.println();

        //Find the student with the highest average grade and display their name.
        List<String> topStudents = students.stream().map(s -> new Object() {
                    String name = s.getName();
                    double average = s.getGrades().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                })
                .sorted((s1, s2) -> Double.compare(s2.average, s1.average))
                .limit(1)
                .map(s -> s.name)
                .toList();

        System.out.println("The student with the highest average grade is: " + topStudents.get(0));

        System.out.println();

        //
        List<String> namesOlder20 = students.stream().filter(s -> s.getAge() > 20).map(s -> s.getName()).toList();

        System.out.println("The names of the students older than 20 are:");
        for(String name : namesOlder20) {
            System.out.println(name);
        }

        System.out.println();

        //Create a map where the key is the student's name and the value is their average grade.
        Map<String, Double> studentAverageMap = students.stream()
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getGrades().stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

        System.out.println("Student average grades:");
        for(Map.Entry<String, Double> entry : studentAverageMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}