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

    // ____________________________________

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
            System.out.println(f.getNumber() + "." + " | " + f.getFlowerName() + " | " + f.getPrice() + " kr");
        }

        for (int i = 1; i <= 3; i++) {

            System.out.print("\nEnter flower ID to buy (" + i + "/" + 3 + "): ");
            int inputId = scanner.nextInt();

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
            }
        }

        boolean answered = false;
        System.out.println("Would you like your flowers tied together as a present? | 50 kr | Yes / No");

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
        }

        System.out.println("\nYour total price: " + totalPrice + " kr");

        scanner.close();

    }

}