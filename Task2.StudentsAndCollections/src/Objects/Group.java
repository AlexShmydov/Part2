package Objects;

import java.util.*;

public class Group {

    private final int minAge = 16;
    private final int maxAge = 30;
    private final int minLengthString = 5;
    private final String lexicon = "abcdefghijklmnopqrstuvwxyz";
    final Random rand = new Random();
    private List<Student> students;

    public Group(int countOfStudents) {
        createGroup(countOfStudents);
    }

    private void createGroup(int countOfStudents) {
        students = new ArrayList<>();
        while (countOfStudents > 0) {
            students.add(new Student(
                    createName(minLengthString, minLengthString * 2, lexicon),
                    createName(minLengthString, minLengthString * 3, lexicon),
                    createAge(minAge, maxAge)));
            countOfStudents--;
        }
    }

    private String createName(int min, int max, String letters) {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt((max - min) + 1) + min;
            for (int i = 0; i < length; i++) {
                builder.append(letters.charAt(rand.nextInt(letters.length())));
            }
        }
        return builder.toString().substring(0, 1).toUpperCase() + builder.toString().substring(1);
    }

    private int createAge(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public void sortByParameter(Comparator<Student> studentComparator) {
        Collections.sort(students, studentComparator);
    }

    public List<Student> getStudetByFirstLetterInLastName(Character firstLetter) {
        List<Student> tempArray = new ArrayList<>();
        for (Student student : students) {
            if (student.getLastName().substring(0, 1).toUpperCase().equals(firstLetter.toString().toUpperCase())) {
                tempArray.add(student);
            }
        }
        return tempArray;
    }

    public double getAverageOfAge() {
        double average = 0.0;
        for (Student student : students) {
            average += student.getAge();
        }
        return average / students.size();
    }

    public HashMap<Integer, Student> getStudentsMaps() {
        HashMap<Integer, Student> studentsMap = new HashMap<Integer, Student>();
        for (Student student : students) {
            studentsMap.put(student.getId(), student);
        }
        return studentsMap;
    }

    public HashMap<Integer, Student> getStudentsWithIdMoreValue(int minId) {
        HashMap<Integer, Student> studentsMap = (HashMap<Integer, Student>) getStudentsMaps().clone();

        Iterator iterator = studentsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            if ((Integer) pair.getKey() < minId) {
                iterator.remove();
            }
        }
        return studentsMap;
    }
}