package org.launchcode.cheesemvc.models;

public class Cheese {
    public String cheeseName;
    public String cheeseDescription;

    public Cheese(String cheeseName, String cheeseDescription) {
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String newName) {
        cheeseName = newName;
    }

    public String getCheeseDescription() {

        return cheeseDescription;
    }

    public void setCheeseDescription(String newDescription) {
        cheeseDescription = newDescription;
    }

}
