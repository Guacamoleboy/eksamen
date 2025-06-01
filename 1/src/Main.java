/*

    Eksamensopgave 1 - Todo
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 1.0


*/

import java.util.ArrayList;

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
        //todo.displayStatus();
        //il.addTodo("Lav kaffe", true, path);

    }

} // Main class end