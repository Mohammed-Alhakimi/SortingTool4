package sorting;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class LineFinder extends WordFinder {

    public LineFinder(ArrayList<String> listOfItems, TreeMap<String, Integer> map) {
        super(listOfItems, map);
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
    public void displayInfoSorting(String sortingType) {
        System.out.println("Sorted data: ");
        sort();
        for (String s : listOfItems
        ) {
            System.out.println(s);
        }
    }

    @Override
    public String displayInfo() {
        return String.format("Total lines: %d."
                , listOfItems.size());
    }
}