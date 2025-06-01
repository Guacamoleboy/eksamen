import java.util.ArrayList;

public class TodoList {

    // Attributes
    ArrayList<Item> items;
    private static final String statusColorNotDone = "\u001B[31m";
    private static final String statusColorDone = "\u001B[32m";
    private static final String reset = "\u001B[0m";

    // ____________________________________________

    public TodoList(ArrayList<Item> items){
        this.items = items;
    }

    // ____________________________________________

    public void displayItems(){

        if(items.isEmpty()){
            System.out.println("There's nothing Todo.. Add some!");
            return;
        }

        int visuals = 1;

        System.out.println("\n"); // Visuals

        for (Item item : items){

            String isDoneToString = "";

            if(item.getIsDone() == true){
                isDoneToString = "Done";
                System.out.println(visuals + ") " + item.getDescription() + statusColorDone + "\nStatus: " + reset + isDoneToString + "\n");
            } else if (item.getIsDone() == false){
                isDoneToString = "Not Done.. Get going!";
                System.out.println(visuals + ") " + item.getDescription() + statusColorNotDone + "\nStatus: " + reset + isDoneToString + "\n");
            }
            visuals++;
        }

    }

    // ____________________________________________

    public void displayStatus(){

        for (Item i : items){

            if(!i.getIsDone()){ // Remove ! to get what's done
                System.out.println("This task isn't done: " + i.getDescription());
                //System.out.println("This task is done: " + i.getDescription());
            }

        }

    }

    // ____________________________________________

    public void displayChangeStatus(int number) {

        if (number < 1 || number > items.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Item item = items.get(number - 1);

        boolean currentStatus = item.getIsDone();

        item.setStatus(!currentStatus);


        System.out.println("Changed task status for: " + item.getDescription());
    }

} // TodoList class end
