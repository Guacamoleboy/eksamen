/*

    Eksamensbesvarelse 3 - Anonymiseret Tekst
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 1.0


*/

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // Attributes
    private static ArrayList<String> names = new ArrayList<>();
    private static final StringHandle sh = new StringHandle();

    // ______________________________________________

    public static void main(String[] args) {

        // Add to ArrayList
        Collections.addAll(names, "Tess", "Jonas", "Tine", "Andreas", "Ebou", "Carl Emil", "Oliver", "Drake");
        ArrayList<MessageHandle> data = sh.readData("data/textData.csv");

        // get(i) had some bugs so I'm doing it this way instead
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<String> genders = new ArrayList<>();

        // For-each add to correct ArrayList
        for (MessageHandle mh : data) {
            messages.add(mh.msg);
            genders.add(mh.gender);
        }

        // Before replacement
        System.out.println("\nBefore\n");
        sh.beforeChange(names, messages);

        // Show replacement
        System.out.println("\nAfter\n");
        sh.replaceText(names, messages, genders);

    }

} // Main class end