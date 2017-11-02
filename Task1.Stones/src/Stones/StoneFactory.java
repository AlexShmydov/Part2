package Stones;

import java.util.Random;

public class StoneFactory {

    private static final int MAX_WEIGHT = 100;
    private static final int MAX_HARDNESS = 1000;
    private static final int MAX_SHINE = 100;
    private static final int COST_PER_CARAT = 1000;

    private static final String[] STONES_NAMES = new String[]{
            "Diamond",
            "Sapphire",
            "Diamond",
            "Emerald",
            "Garnet",
            "Amethyst",
            "Malachite"};

    public static Stone createStoneWithDefaultParameters() {
        Stone stone = new Stone(
                COST_PER_CARAT,
                STONES_NAMES[getRandomNumber(STONES_NAMES.length, 1) - 1],
                getRandomNumber(MAX_WEIGHT, 1),
                getRandomNumber(MAX_HARDNESS, 1),
                getRandomNumber(MAX_SHINE, 1));
        return stone;
    }

    private static int getRandomNumber(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
