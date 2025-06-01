/*

    Eksamensbesvarelse 5 - Brugere
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 2.0

*/

import java.util.ArrayList;

public class Main {

    // Attributes
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    // ___________________________________________

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        // Normal
        users.add(new User("Jonaslarsen", "Jonaslarsen_password"));
        users.add(new User("TessLærer", "cphbusiness", "tess@tess.dk"));
        users.add(new User("TineLærer", "cphbusiness", "tine@tine.dk", 50505050));

        // Name validation fail
        users.add(new User("Jonas", "Jonaslarsen_password"));
        // Password validation fail
        users.add(new User("Jonaslarsen69", "Jonas"));
        // Email validation fail
        users.add(new User("Jonaslarsen420", "Jonaslarsen_password", "n.n.dk"));
        // Number validation fail
        users.add(new User("Dennis", "cphbusiness", "dennis@dennis.dk", 505050));
        // 0 validation fail
        users.add(new User("Nulvalidation", "cphbusiness", "valid@valid.dk", 0));

        // Sort after name
        //users.sort((u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName()));

        // In its own method for better helicopter overview
        validateAndDisplay(users);

    }

    // ___________________________________________

    public static void validateAndDisplay(ArrayList<User> users) {

        for (User u : users) {
            Validation val = new Validation(u);

            boolean nameValid = val.validateName();
            boolean passwordValid = val.validatePassword();
            boolean emailValid = val.validateEmail();
            boolean numberValid = val.validateNumber();

            if (nameValid && passwordValid && emailValid && numberValid) {
                System.out.println(u);
            } else {
                System.out.println("User " + RED + u.getName() + RESET + " failed validation.");
            }

        } // For-each end

    }

} // Main end