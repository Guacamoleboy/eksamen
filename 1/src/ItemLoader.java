import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemLoader {

    // Attributes

    // _____________________________________

    public ArrayList<Item> loadFile(String path) {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);

            if (!scanner.hasNextLine()) {
                System.out.println("Empty .csv file for the given path.");
                return items;
            }

            String header = scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(", ");

                if (values.length < 2) continue;

                String description = values[0].trim();
                String status = values[1].trim().toLowerCase();

                boolean isDone = status.equalsIgnoreCase("yes");

                items.add(new Item(description, isDone));

            }

        } catch (FileNotFoundException e) {

            System.out.println("File path wasn't found.. Try again!");

        }

        return items;

    }

    // ____________________________________________

    /*

        Method to add to .csv file

    */

    public void addTodo(String description, boolean status, String path) {

        String statusString = status ? "Yes" : "No";
        String lineToAdd = description + ", " + statusString;

        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write("\n"); // Fixes newline issue
            writer.write(lineToAdd);
            writer.close();

            System.out.println("Added line to .csv file: " + lineToAdd);

        } catch (IOException e) {
            System.out.println("Error adding the todo item");
        }

    }

    // ____________________________________________

    public void saveToFile(String path, String header, ArrayList<Item> items) {

        try {

            FileWriter writer = new FileWriter(path);
            writer.write(header + "\n"); // Header

            for (int i = 0; i < items.size(); i++) {

                Item item = items.get(i);
                String line = item.getDescription() + ", " + (item.getIsDone() ? "Yes" : "No");

                writer.write(line);

                if (i < items.size() - 1) {
                    writer.write("\n");
                }
            }

            writer.close();
            System.out.println("Todo list saved...");

        } catch (IOException e) {
            System.out.println("Error saving todo list: " + e.getMessage());
        }

    }

} // ItemLoader class end