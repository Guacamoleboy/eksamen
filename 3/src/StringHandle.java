import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringHandle {

    // Attributes
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    // ____________________________________________

    public void replaceText(ArrayList<String> names, ArrayList<String> msg, ArrayList<String> gender) {

        for (int i = 0; i < msg.size(); i++) {

            String finalMsg = msg.get(i).trim();
            String genderMsg = gender.get(i).trim();

            String replacementWord = "";

            switch(genderMsg){
                case "Male":
                    replacementWord = "Han";
                    break;
                case "Female":
                    replacementWord = "Hun";
                    break;
                default:
                    System.out.println("Invalid gender in your file on line " + i);
                    return;
            }

            // Fix for double names side by side
            for (int j = 0; j < names.size(); j++) {
                for (int k = j + 1; k < names.size(); k++) {

                    String doubleName = names.get(j) + " " + names.get(k);

                    if (finalMsg.contains(doubleName) && genderMsg.equalsIgnoreCase("Male")) {

                        finalMsg = finalMsg.replace(doubleName, GREEN + "han ham" + RESET);
                        break;

                    } else if(finalMsg.contains(doubleName) && genderMsg.equalsIgnoreCase("Female")){

                        finalMsg = finalMsg.replace(doubleName, GREEN + "hun hende" + RESET);
                        break;

                    } // if-else end

                } // for (2) end
            } // for (1) end

            // For each name
            for (String name : names) {
                finalMsg = finalMsg.replace(name, GREEN + replacementWord + RESET);
            }

            System.out.println(finalMsg);
        }

    }

    // _________________________________________

    public ArrayList<MessageHandle> readData(String path) {

        ArrayList<MessageHandle> data = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(path))) {

            scan.nextLine(); // skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(", ");
                if(values.length >= 2) {
                    data.add(new MessageHandle(values[0].trim(), values[1].trim()));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error - File not found...");
        }

        return data;
    }

    // ____________________________________________

    public void beforeChange(ArrayList<String> names, ArrayList<String> msg) {

        for (String line : msg) {

            String highlighted = line;

            for (String name : names) {
                highlighted = highlighted.replace(name, RED + name + RESET);
            }

            System.out.println(highlighted);
        }

    }

    // ____________________________________________

    public void saveToCsv(String path, String message, String gender) {

        String lineToAdd = message + ", " + gender;

        try (FileWriter writer = new FileWriter(path, true)) {

            writer.write("\n" + lineToAdd);
            System.out.println("Added to CSV: " + lineToAdd);

        } catch (IOException e) {
            System.out.println("Error adding to CSV: " + e.getMessage());
        }
    }

} // StringHandle class end
