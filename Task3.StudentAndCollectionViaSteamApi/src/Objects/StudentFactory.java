package Objects;

import java.util.Random;

public interface StudentFactory {
    Random rand = new Random();

    static String createName(int min, int max, String letters) {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt((max - min) + 1) + min;
            for (int i = 0; i < length; i++) {
                builder.append(letters.charAt(rand.nextInt(letters.length())));
            }
        }
        return builder.toString().substring(0, 1).toUpperCase() + builder.toString().substring(1);
    }

    static int createAge(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
