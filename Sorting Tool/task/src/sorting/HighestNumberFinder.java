package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class HighestNumberFinder extends Finder {
    Long highestNumber;

    public HighestNumberFinder(ArrayList<Long> listOfItems) {
        super(listOfItems);
    }

    @Override
    public int howManyTimeOccurred() {
        int counter = 0;
        for (Object l : listOfItems
        ) {
            if ((Long) l == this.highestNumber) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String displayInfo() {
        return String.format("Total numbers: %d.\nThe greatest number: %d (%d time(s), %d%%).", listOfItems.size(), highestNumber, howManyTimeOccurred(), getPercentage());
    }

    @Override
    public int getPercentage() {
        return (howManyTimeOccurred() * 100) / listOfItems.size();
    }

    @Override
    public int scanAndAdd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            super.listOfItems.add(number);
        }
        return listOfItems.size();
    }

    @Override
    public Long findHighestValue() {
        Long highestNumber = (Long) listOfItems.get(0);
        for (Object l : listOfItems) {
            if ((Long) l > highestNumber) {
                highestNumber = (Long) l;
            }
        }
        this.highestNumber = highestNumber;
        return highestNumber;
    }
}