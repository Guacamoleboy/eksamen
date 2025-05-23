public class User {

    // Attributes
    private String name;
    private String password;
    private String email;
    private int number;

    // _____________________________________

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    // _____________________________________
    // Overload 1
    public User(String name, String password, String email){
        this(name, password);
        this.email = email;
    }

    // _____________________________________
    // Overload 2
    public User(String name, String password, String email, int number){
        this(name, password, email);

        // Fixes null input bug
        if(number == 0){
            this.number = 694206922; // Random number that's hard to guess
        } else {
            this.number = number;
        }

    }

    // _____________________________________

    public String getName(){
        return this.name;
    }

    // _____________________________________

    public String getPassword(){
        return this.password;
    }

    // _____________________________________

    public String getEmail(){
        return this.email;
    }

    // _____________________________________

    public int getNumber(){
        return this.number;
    }

    // _____________________________________

    @Override
    public String toString() {
        String result = "Name: " + name + ", Password: " + password;

        if (email != null) {
            result += ", Email: " + email;
        }
        if (number != 0) {
            result += ", Number: " + number;
        }

        return result;
    }

} // User class end
