package Objects;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private List<Student> students;

    public Group(int countOfStudents) {
        createGroup(countOfStudents);
    }

    private void createGroup(int countOfStudents) {
        students = new ArrayList<>();
        while (countOfStudents > 0) {
            students.add(new Student());
            countOfStudents--;
        }
        students.stream().forEach(student -> System.out.println(String.format("ID: %s Student: %s %s Age: %s", student.getId(), student.getFirstName(), student.getLastName(), student.getAge())));
    }

    public void sortByParameter(Comparator<Student> studentComparator) {
        students.stream().sorted(studentComparator);
    }

    public List<Student> getStudentsByFirstLetterInLastName(Character firstLetter) {
        return students.stream()
                .filter(student -> student.getLastName().substring(0, 1).toUpperCase().equals(firstLetter.toString().toUpperCase()))
                .collect(Collectors.toList());
    }

    public double getAverageOfAge() {
        return students.stream()
                .collect(Collectors.averagingDouble(student -> student.getAge()));
    }

    public HashMap<Integer, Student> getStudentsMaps() {
        HashMap<Integer, Student> studentsMap = new HashMap<Integer, Student>();
        students.stream()
                .forEach(student -> studentsMap.put(student.getId(), student));
        return studentsMap;
    }

    public HashMap<Integer, Student> getStudentsWithIdMoreValue(int minId) {
        HashMap<Integer, Student> studentsMap = new HashMap<Integer, Student>();
        students.stream()
                .filter(student -> student.getId() >= minId)
                .forEach(student -> studentsMap.put(student.getId(), student));
        return studentsMap;
    }
}