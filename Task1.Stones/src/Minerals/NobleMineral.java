package Minerals;

public class NobleMineral extends Mineral {
    private double carats;
    private double rarity;
    private String name;
    private final double WEIGHT_TO_CARATS = 0.2;

    public NobleMineral(String name, double weight, double hardness, double shine) {
        super(weight, hardness, shine);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getRarity() {
        this.rarity = getHardness() * getShine() / getWeight();
        return rarity;
    }

    public double getCarats() {
        this.carats = WEIGHT_TO_CARATS * getWeight();
        return this.carats;
    }
}