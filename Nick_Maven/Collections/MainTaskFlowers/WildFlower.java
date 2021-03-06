package Nick_Maven.Collections.MainTaskFlowers;

abstract class WildFlower extends Flower{
    String flowersType = "Wild Flower";

    public String getFlowersType() {
        return flowersType;
    }

    @Override
    public String toString() {
        return "Flower Type: " + getFlowersType()+"; Flower Name: "+ getFlowerName()+ "; Days in Stock: " +
                getFlowerFressnes()+". Salk Lenghts: "+ getStalkLengths() +"cm.\n";
    }
}
