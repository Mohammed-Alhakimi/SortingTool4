package sorting;

import java.util.ArrayList;

public abstract class Finder<T> {

    public ArrayList<T> listOfItems;

    public Finder(ArrayList<T> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public abstract void scanAndAdd();

    public abstract T findHighestValue();

    public abstract int howManyTimeOccurred();

    public abstract String displayInfo();

    public abstract void displayInfo(boolean displaySortedInfo);

    public int getPercentage() {
        return (howManyTimeOccurred() * 100) / listOfItems.size();
    }

    public abstract void sort();

    public abstract void sort(String type);
}