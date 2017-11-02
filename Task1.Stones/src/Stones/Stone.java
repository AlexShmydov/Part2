package Stones;

import Minerals.NobleMineral;

import java.util.Comparator;

public class Stone extends NobleMineral implements Comparable<Stone> {
    private Double cost;
    private final double jewelsMultiplier = 2;
    boolean isJewel;

    public Stone(int costPerCarat, String name, double weight, double hardness, double shine) {
        super(name, weight, hardness, shine);
        identifyIsJewel();
        calculateCostOfStone(costPerCarat);
    }

    private void calculateCostOfStone(int costPerCarat) {
        this.cost = (double) costPerCarat * getCarats() / getRarity();
        if (isJewel) {
            this.cost *= jewelsMultiplier;
        }
    }

    public double getCost() {
        return cost;
    }

    public boolean getIsJewelling() {
        return isJewel;
    }

    private void identifyIsJewel() {
        this.isJewel = getRarity() > getWeight() / (getShine() * getHardness());
    }

    @Override
    public double getCarats() {
        return super.getCarats();
    }

    @Override
    public double getHardness() {
        return super.getHardness();
    }

    @Override
    public double getRarity() {
        return super.getRarity();
    }

    @Override
    public double getShine() {
        return super.getShine();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int compareTo(Stone stone) {
        return Comparators.COST.compare(this, stone);
    }

    public static class Comparators {
        public static Comparator<Stone> COST = Comparator.comparing(stone -> stone.cost);

        public static Comparator<Stone> IS_JEWEL = Comparator.comparing(stone -> stone.isJewel);

        public static Comparator<Stone> WEIGHT = Comparator.comparing(stone -> stone.getWeight());

        public static Comparator<Stone> RARITY = Comparator.comparing(stone -> stone.getRarity());

        public static Comparator<Stone> CARATS = Comparator.comparing(stone -> stone.getCarats());

        public static Comparator<Stone> HARDNESS = Comparator.comparing(stone -> stone.getHardness());

        public static Comparator<Stone> SHINE = Comparator.comparing(stone -> stone.getShine());
    }
}