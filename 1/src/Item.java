public class Item {

    // Attributes
    private String description;
    private boolean isDone;

    // _______________________________________

    public Item(String description, boolean isDone){
        this.description = description;
        this.isDone = isDone;
    }

    // _______________________________________

    public String getDescription(){
        return this.description;
    }

    // _______________________________________

    public boolean getIsDone(){
        return this.isDone;
    }

    // _______________________________________

    public void setStatus(boolean status){
        this.isDone = status;
    }

    // _______________________________________

    public void setDescription(String description){
        this.description = description;
    }

} // Item class end
