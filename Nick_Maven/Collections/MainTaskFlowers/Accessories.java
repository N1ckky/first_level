package Nick_Maven.Collections.MainTaskFlowers;

public class Accessories {

    double price = 0;

    String accessoriesAdded = "";

    public Accessories(boolean wrapper, boolean ribbon, boolean greenery, boolean greetingCard) {
        if (wrapper) {
            this.accessoriesAdded += "Wrapper";
            if (ribbon) this.accessoriesAdded += ", ";
            this.price += 0.5;
        }
        if (ribbon) {
            this.accessoriesAdded += "Ribbon";
            if (greenery) this.accessoriesAdded += ", ";
            this.price += 0.2;
        }
        if (greenery) {
            this.accessoriesAdded += "Greenery";
            if (greetingCard) this.accessoriesAdded += ", ";
            this.price += 0.3;
        }
        if (greetingCard) {
            this.price += 1;
            this.accessoriesAdded += "Greeting Card";
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "You chose accesories: \n" + accessoriesAdded + ". " + "Price of this: " + price + " rubles";
    }
}
