package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordFinder extends Finder<String> {
    private String longestWord;

    public WordFinder(ArrayList<String> listOfItems) {
        super(listOfItems);
    }

    @Override
    public void scanAndAdd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            super.listOfItems.add(word);
        }
    }

    @Override
    public String findHighestValue() {
        String longestWord =  listOfItems.get(0);
        for (String s : listOfItems) {
            if (s.length() > longestWord.length()) {
                longestWord =  s;
            }
        }
        this.longestWord = longestWord;
        return longestWord;
    }

    @Override
    public int howManyTimeOccurred() {
        int counter = 0;
        for (String s : listOfItems
        ) {
            if (s.equals(longestWord)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String displayInfo() {
        return String.format("Total words: %d." +
                        "\nThe longest word: %s (%d time(s), %d%%)."
                , listOfItems.size()
                , longestWord
                , howManyTimeOccurred()
                , getPercentage());
    }

    @Override
    public void displayInfo(boolean displaySortedInfo) {
        System.out.print("Sorted data: ");
        for (String s: listOfItems
        ) {
            System.out.print(s + " ");
        }
    }

    @Override
    public void sort() {
        Collections.sort(this.listOfItems);
    }

    @Override
    public void sort(String type) {

    }
}