/*

        ^ Start
        [\w-\.] Word, dash and dot.
        $ end

*/

public class Validation {

    // Attributes
    private User currentUser;

    // _____________________________________

    public Validation(User u){
        this.currentUser = u;
    }

    // _____________________________________

    public boolean validateEmail(){
        String email = currentUser.getEmail();

        // Fixes the annoying null bug
        if(email == null || email.isEmpty()){

            return true;
        }

        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    // _____________________________________

    public boolean validateNumber() {

        int number = currentUser.getNumber();

        // Fixes 0 bug but it also allows someone to type "0"
        if (number == 0) {
            return true;
        }

        return (number >= 10000000 && number <= 99999999);
    }

    // _____________________________________

    public boolean validateName(){

        String name = currentUser.getName();

        if(name == null || name.length() <=6 || !name.matches("^[a-zA-ZæøåÆØÅ0-9_]+$")){
            return false;
        }

        return true;

    }

    // _____________________________________

    public boolean validatePassword(){
        String password = currentUser.getPassword();

        if(password == null){
            return false;
        }

        return password.matches("^.{8,}$");

    }

} // Validation end
