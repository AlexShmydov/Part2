package com.company;

import Objects.Group;
import Objects.Student;

import java.util.Comparator;

public class Main {
    private static int DEFAULT_VALUE_OF_STUDENTS = 10;
    private static final int MIN_ID = 100;
    private static final Character FIRST_LETTER = 'A';
    private static final Comparator<Student> DEFAULT_PARAMETER = Student.Comparators.AGE;

    public static void main(String[] args) {
        Group group = new Group(DEFAULT_VALUE_OF_STUDENTS);
        group.sortByParameter(DEFAULT_PARAMETER);
        group.getAverageOfAge();
        group.getStudentsByFirstLetterInLastName(FIRST_LETTER);
        group.getStudentsMaps();
        group.getStudentsWithIdMoreValue(MIN_ID);
    }
}