/*

    Eksamensbesvarelse 5 - Brugere
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 1.0


*/


import java.util.ArrayList;

public class Main {

    // Attributes

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        // Normal
        users.add(new User("Jonaslarsen", "Jonaslarsen_password"));
        users.add(new User("TessLærer", "cphbusiness", "tess@tess.dk"));
        users.add(new User("TineLærer", "cphbusiness", "tine@tine.dk", 50505050));

        // On purpose fails

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

        // Display users
        for (User u : users){

            Validation val = new Validation(u);

            boolean nameValid = val.validateName();
            boolean passwordValid = val.validatePassword();
            boolean emailValid = val.validateEmail();
            boolean numberValid = val.validateNumber();

            // Checks if they pass or not. Display users that pass and don't.

            if (nameValid && passwordValid && emailValid && numberValid) {
                System.out.println(u);
            } else {
                System.out.println("User " + u.getName() + " failed validation.");
            }

        } // For-each end

    }

} // Main end