import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemLoader {

    // Attributes

    // _____________________________________

    ArrayList<Item> loadFile(String path) {
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

} // ItemLoader class end
