package Nick_Maven.Collections.MainTaskFlowers;

public class Main {
    public static void main (String[] args) {
        System.out.println("Flowers Project");
        Bouquet bouquetFirst = new Bouquet(3,1,1,1,1,1,true,
                true,true,true);

        System.out.println(bouquetFirst.displayBouquet());

        System.out.println(bouquetFirst.getPriceBouquet());

        System.out.println(bouquetFirst.sortFlowersInBouquet());

        System.out.println(bouquetFirst.findStalkLength(0,20));
        }
}
