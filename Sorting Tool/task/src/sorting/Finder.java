package sorting;

import java.util.ArrayList;

public abstract class Finder<T> {

    public ArrayList<T> listOfItems;

    public Finder(ArrayList<T> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public abstract int scanAndAdd();

    public abstract T findHighestValue();

    public abstract int howManyTimeOccurred();

    public abstract String displayInfo();

    public int getPercentage() {
        return (howManyTimeOccurred() * 100) / listOfItems.size();
    }
}
