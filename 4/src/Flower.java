public class Flower {

    // Attributes
    private static int counter = 1;
    private int number;
    private String flowerName;
    private int price;

    // ___________________________________________

    public Flower(String flowerName, int price){
        this.flowerName = flowerName;
        this.number = counter++;
        this.price = price;
    }

    // ___________________________________________

    public String getFlowerName() {
        return flowerName;
    }

    // ___________________________________________

    public int getNumber() {
        return number;
    }

    // ___________________________________________

    public int getPrice() {
        return price;
    }

} // Flower class end
