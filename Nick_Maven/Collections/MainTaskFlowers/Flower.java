package Nick_Maven.Collections.MainTaskFlowers;

abstract class Flower {
    String flowerName = "Undefined Flower";
    int stalkLengths;
    int flowerFressnes;
    double price;

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getStalkLengths() {
        return stalkLengths;
    }

    public void setStalkLengths(int stalkLengths) {
        this.stalkLengths = stalkLengths;
    }

    public int getFlowerFressnes() {
        return flowerFressnes;
    }

    public void setFlowerFressnes(int flowerFressnes) {
        this.flowerFressnes = flowerFressnes;
    }

    public double getPrice() {
        return price;
    }
}
