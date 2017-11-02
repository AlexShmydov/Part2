package com.company;

import Objects.Timing;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static final int COUNT_OF_NUMBERS = 10000000;
    private static final int COUNT_OF_ELEMENTS_TO_ACTION = 1000;

    public static void main(String[] args) {
        Timing arrayList = new Timing(new ArrayList<>(), COUNT_OF_NUMBERS);
        Timing linkedList = new Timing(new LinkedList<>(), COUNT_OF_NUMBERS);

        arrayList.printTimeOfAddingElementsToArray(COUNT_OF_ELEMENTS_TO_ACTION);
        linkedList.printTimeOfAddingElementsToArray(COUNT_OF_ELEMENTS_TO_ACTION);

        arrayList.printTimeOfDeletingElementsFromArray(COUNT_OF_ELEMENTS_TO_ACTION);
        linkedList.printTimeOfDeletingElementsFromArray(COUNT_OF_ELEMENTS_TO_ACTION);

        arrayList.printTimeOfSearchingElementsInArray(COUNT_OF_ELEMENTS_TO_ACTION);
        linkedList.printTimeOfSearchingElementsInArray(COUNT_OF_ELEMENTS_TO_ACTION);

        compareTimingsAndPrintResult(arrayList, linkedList);
    }

    private static void compareTimingsAndPrintResult(Timing timing1, Timing timing2) {
        System.out.println("Point5. Subtract between two classes.");
        System.out.println(String.format("Result subtracting timings of: %s - %s in nanoseconds", timing1.getClassOfArray(), timing2.getClassOfArray()));
        for (int i = 0; i < timing1.getTimgings().size(); i++) {
            System.out.println(String.format("Point %s: %s", i + 1, timing1.getTimgings().get(i) - timing2.getTimgings().get(i)));
        }
    }

}
