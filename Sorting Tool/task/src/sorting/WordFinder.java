package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder extends Finder {
    private String longestWord;


    public WordFinder(ArrayList<String> listOfItems) {
        super(listOfItems);
    }

    @Override
    public int scanAndAdd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            super.listOfItems.add(word);
        }
        return listOfItems.size();
    }

    @Override
    public Object findHighestValue() {
        String longestWord = (String) listOfItems.get(0);
        for (Object l : listOfItems) {
            if ((l.toString().length() > longestWord.length())) {
                longestWord = (String) l;
            }
        }
        this.longestWord = longestWord;
        return longestWord;
    }

    @Override
    public int howManyTimeOccurred() {
        int counter = 0;
        for (Object s : listOfItems
        ) {
            if (s.toString().equals(longestWord)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String displayInfo() {
        return String.format("Total words: %d.\nThe longest word: %s (%d time(s), %d%%).", listOfItems.size(), longestWord, howManyTimeOccurred(), getPercentage());
    }
}
