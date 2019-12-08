package Nick_Maven.Collections.MainTaskFlowers;

import java.util.ArrayList;
import java.util.Random;

public class Bouquet {

    private ArrayList<Flower> flowersList = new ArrayList<>();
    private ArrayList<Accessories> accessoriesList = new ArrayList<>();
    private int price;
    Random randomStalk = new Random();
    Random randomFressnes = new Random();

    public Bouquet(int roses, int chamomiles, int orhid, int lily, int clove, int cornflower,
            boolean wrapper, boolean ribbon, boolean greenery, boolean greetingCard) {


        for (int i = 0; i < roses; i++) {
            flowersList.add(new Rose(randomStalk.nextInt(50 - 1),randomFressnes.nextInt(5-1)));
        }
        for (int i = 0; i < chamomiles; i++) {
            flowersList.add(new Chamomile(randomStalk.nextInt(50 - 1),randomFressnes.nextInt(5-1)));
        }
        for (int i = 0; i < orhid; i++) {
            flowersList.add(new Orchid(randomStalk.nextInt(50 - 1),randomFressnes.nextInt(5-1)));
        }
        for (int i = 0; i < lily; i++) {
            flowersList.add(new Lily(randomStalk.nextInt(50 - 1),randomFressnes.nextInt(5-1)));
        }
        for (int i = 0; i < clove; i++) {
            flowersList.add(new Clove(randomStalk.nextInt(50 - 1),randomFressnes.nextInt(5-1)));
        }
        for (int i = 0; i < cornflower; i++) {
            flowersList.add(new Сornflower(randomStalk.nextInt(50 - 1),randomFressnes.nextInt(5-1)));
        }

        boolean[] parametrsAccesory = new boolean[4];

        if (wrapper) {
            parametrsAccesory[0] = true;
        }
        else parametrsAccesory[0] = false;
        if (ribbon) {
            parametrsAccesory[1] = true;
        }
        else parametrsAccesory[1] = false;
        if (greenery) {
            parametrsAccesory[2] = true;
        }
        else parametrsAccesory[2] = false;
        if (greetingCard) {
            parametrsAccesory[3] = true;
        }
        else parametrsAccesory[3] = false;
        accessoriesList.add(new Accessories(parametrsAccesory[0],parametrsAccesory[1],parametrsAccesory[2],
                            parametrsAccesory[3]));

    }

    public String displayBouquet (){
        String resultBouquet = ("Full parametrs of collected bouquet: \n");
        resultBouquet = getStringBouquetWithAccessoriesList(resultBouquet);
        return resultBouquet;
    }

    private String getStringBouquetWithAccessoriesList(String resultBouquet) {
        for(int i = 0; i < flowersList.size(); i++){
            resultBouquet += (flowersList.get(i).toString());
        }
        resultBouquet += "\n";
        for(int i = 0; i < accessoriesList.size(); i++){
            resultBouquet += accessoriesList.get(i).toString();
        }
        return resultBouquet;
    }

    private String getStringBouquetList(String resultBouquet) {
        for(int i = 0; i < flowersList.size(); i++){
            resultBouquet += (flowersList.get(i).toString());
        }
        resultBouquet += "\n";
        return resultBouquet;
    }

    public String getPriceBouquet(){
        int resultPrice = 0;
        for(int i = 0; i < flowersList.size(); i++){
            resultPrice += flowersList.get(i).getPrice();
        }
        for(int i = 0; i < accessoriesList.size(); i++){
            resultPrice += accessoriesList.get(i).getPrice();
        }
        return "-------------------------------------------\n" +
               "Total Amount for chosen bouquet: " + resultPrice + " rubbles" +
               "\n-------------------------------------------\n";
    }

    public String sortFlowersInBouquet() {
        String sortedFlowersString = "";
        ArrayList<Flower> sortedFlowersList = flowersList;
        for(int j = sortedFlowersList.size() - 1; j >= 0; j--){
            for(int i = 0; i < j; i++){
                if(sortedFlowersList.get(i).getFlowerFressnes() > sortedFlowersList.get(i + 1).getFlowerFressnes()){
                    Flower temp = sortedFlowersList.get(i);
                    sortedFlowersList.set(i, sortedFlowersList.get(i + 1));
                    sortedFlowersList.set(i + 1, temp);
                }
            }
        }
        return "Sorted Bouquet on days in stock: \n"+ getStringBouquetList(sortedFlowersString);
    }

    public String findStalkLength(int minLength, int maxLength){
        String displayByStalkLenghts = "\nThere are flowers in your bouquet with Stalk Length: from " + minLength +
                " to " + maxLength + " cm. \n";
        for(int i = 0; i < flowersList.size(); i++){
            if(flowersList.get(i).getStalkLengths() >= minLength && flowersList.get(i).getStalkLengths() < maxLength){
                displayByStalkLenghts += flowersList.get(i);
            }
        }
        return displayByStalkLenghts;
    }
}