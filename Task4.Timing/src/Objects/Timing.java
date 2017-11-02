package Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Timing {
    private static final int MAX_VALUE = 1000;
    private long timeOfCreating;
    private long timeOfAdding;
    private long timeOfDeleting;
    private long timeOfSearching;
    List<Integer> array;

    public Timing(List<Integer> array, int counter) {
        this.array = array;
        timeOfCreating = System.nanoTime();
        while (counter > 0) {
            array.add(getRandomNumber(MAX_VALUE));
            counter--;
        }
        timeOfCreating = (System.nanoTime()) - timeOfCreating;
        printMsg(String.format("Point1. Creating of %s, time: %s", array.getClass(), timeOfCreating));
    }

    public String getClassOfArray() {
        return array.getClass().toString();
    }

    public void printTimeOfAddingElementsToArray(int countOfElements) {
        timeOfAdding = System.nanoTime();
        while (countOfElements > 0) {
            array.add(getRandomNumber(MAX_VALUE));
            countOfElements--;
        }
        timeOfAdding = (System.nanoTime()) - timeOfAdding;
        printMsg(String.format("Point2. Adding elements to %s, time: %s", array.getClass(), timeOfAdding));
    }

    public void printTimeOfDeletingElementsFromArray(int countOfElements) {
        timeOfDeleting = System.nanoTime();
        while (countOfElements > 0) {
            array.remove(countOfElements);
            countOfElements--;
        }
        timeOfDeleting = (System.nanoTime()) - timeOfDeleting;
        printMsg(String.format("Point3. Deleting elements from %s, time: %s", array.getClass(), timeOfDeleting));
    }

    public void printTimeOfSearchingElementsInArray(int countOfElements) {
        timeOfSearching = System.nanoTime();
        for (Integer integer : array) {
            if (integer != 0) countOfElements--;
            if (countOfElements == 0) break;
        }
        timeOfSearching = (System.nanoTime()) - timeOfSearching;
        printMsg(String.format("Point4. Searching elements in the %s, time: %s", array.getClass(), timeOfSearching));
    }

    public List<Long> getTimgings() {
        List<Long> times = new ArrayList<>();
        times.add(timeOfCreating);
        times.add(timeOfAdding);
        times.add(timeOfDeleting);
        times.add(timeOfSearching);
        return times;
    }

    private static int getRandomNumber(int maxValue) {
        return new Random().nextInt(maxValue);
    }

    private static void printMsg(String message) {
        System.out.println(message);
    }
}