package Minerals;

public abstract class Mineral {
    private double weight;
    private double hardness;
    private double shine;

    public Mineral(double weight, double hardness, double shine) {
        this.hardness = hardness;
        this.shine = shine;
        this.weight = weight;
    }

    public double getHardness() {
        return hardness;
    }

    public double getShine() {
        return shine;
    }

    public double getWeight() {
        return weight;
    }
}