package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class LineFinder extends WordFinder {
    public LineFinder(ArrayList listOfItems) {
        super(listOfItems);
    }

    @Override
    public void scanAndAdd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            super.listOfItems.add(line);
        }
    }

    @Override
    public String displayInfo() {
        return String.format("Total lines: %d.\n" +
                        "The longest line: \n" +
                        "%s\n" +
                        "(%d time(s), %d%%)."
                , listOfItems.size()
                , findHighestValue()
                , howManyTimeOccurred()
                , getPercentage());
    }
}