package com.company;

import Jewelries.BaseJewelry;
import Jewelries.JewelryFactory;
import Stones.Stone;

import java.util.Comparator;

public class Main{
    private static String WELCOME_MSG = "Hello!. Part2. Task #1.6 Stones\n";
    private static String COST_OF_JEWELRY = "Cost of %s is %.2f%s";
    private static String WEIGHT_OF_JEWELRY = "Weight of %s is %.0f carats";
    private static final String DEFAULT_NAME = "Necklace";
    private static final Comparator<Stone> DEFAULT_PARAMETER = Stone.Comparators.SHINE;

    private static final String CURRENCY = "$";
    private static final int COUNT_OF_STONES_IN_JEWELRY = 10;

    private static int minCountOfJewels = 4;

    public static void main(String[] args) {
        printMsg(WELCOME_MSG);
        BaseJewelry necklace = JewelryFactory.createJewelry(DEFAULT_NAME, COUNT_OF_STONES_IN_JEWELRY, minCountOfJewels);
        printMsg(String.format(COST_OF_JEWELRY, necklace.getName(), necklace.getCostOfJewelry(), CURRENCY));
        printMsg(String.format(WEIGHT_OF_JEWELRY, necklace.getName(), necklace.getWeightInCaratsOfJewelry()));
        necklace.sortStonesByParameter(DEFAULT_PARAMETER);
    }

    private static void printMsg(String message) {
        System.out.println(message);
    }
}