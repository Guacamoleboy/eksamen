/*

    Eksamensopgave 1 - Todo
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 2.0


*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Attributes
    private static final ItemLoader il = new ItemLoader();
    private static final String path = "data/todo.csv";

    // _______________________________________________

    public static void main(String[] args) {

        // Instantiate and store
        ArrayList<Item> items = il.loadFile(path);
        TodoList todo = new TodoList(items);

        // Display
        todo.displayItems();

        // Display by status
        //todo.displayStatus();

        // Add more to .csv file
        //il.addTodo("Lav kaffe", true, path);

        // Change status on input
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Changing Task Status..\nTask number: ");
        int number = scanner.nextInt();
        todo.displayChangeStatus(number);*/

        // Save entire file again after being set
        //il.saveToFile(path, "Description, Done", items);

    }

} // Main class end