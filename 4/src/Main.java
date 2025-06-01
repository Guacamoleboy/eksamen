/*

    Eksamensbesvarelse 4 - Køb Blomster
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 1.0

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Attributes
    private static Scanner scanner = new Scanner(System.in);
    private static int totalPrice;
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    // ______________________________________________________

    public static void main(String[] args) {

        // Visuals
        FlowerShop sh = new FlowerShop("Janus' Blomster");
        sh.displayWelcome();

        // ArrayList instantiate
        ArrayList<Flower> flowers = new ArrayList<>();

        // Add flowers to our ArrayList
        flowers.add(new Flower("Rose", 10));
        flowers.add(new Flower("Tulip", 20));
        flowers.add(new Flower("Janus", 15));
        flowers.add(new Flower("Tesslian", 22));
        flowers.add(new Flower("Tinsea", 8));
        flowers.add(new Flower("Drakonia", 10));
        flowers.add(new Flower("Yusoz", 12));
        flowers.add(new Flower("Layosss", 66));
        flowers.add(new Flower("Oilias", 44));
        flowers.add(new Flower("Tenth", 11));

        // Display all flowers
        for (Flower f : flowers){
            System.out.println(f.getNumber() + "." + " | " + f.getFlowerName() + " | " + GREEN + f.getPrice() + " kr" + RESET);
        }

        for (int i = 1; i <= 3; i++) {

            System.out.print("\nEnter flower ID to buy (" + i + "/" + 3 + "): ");
            int inputId = scanner.nextInt();
            scanner.nextLine();

            // Find flower by ID
            Flower selected = null;

            for (Flower f : flowers) {
                if (f.getNumber() == inputId) {
                    selected = f;
                    break;
                }
            }

            if (selected != null) {
                System.out.println("Added: " + selected.getFlowerName() + " - " + selected.getPrice() + " kr");
                totalPrice += selected.getPrice();
            } else {
                System.out.println("Invalid flower ID.");
                i--;
            }
        }

        displayGiftQuestion();

        System.out.println("\nYour total price: " + RED + totalPrice + " kr");

        scanner.close();

    }

    // ______________________________________________________

    public static void displayGiftQuestion(){
        boolean answered = false;

        System.out.println("\nWould you like your flowers tied together as a present? " + GREEN + "50 kr" + RESET + "\nTotal price so far: " + RED + totalPrice + " kr" + RESET);

        while (!answered) {
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")) {
                totalPrice += 50;
                answered = true;
            } else if (answer.equalsIgnoreCase("no")) {
                answered = true;
            } else {
                System.out.println("Please answer with 'Yes' or 'No':");
            }
        } // While-end

    }

} // Main class end