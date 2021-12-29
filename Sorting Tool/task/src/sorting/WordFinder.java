package sorting;

import java.util.*;

public class WordFinder extends Finder<String> {
    private String longestWord;


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
        String longestWord = listOfItems.get(0);
        for (String s : listOfItems) {
            if (s.length() > longestWord.length()) {
                longestWord = s;
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
    public void sortByCount() {
        for (String s : listOfItems
        ) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        ArrayList<String[]> list = new ArrayList<>();

        int index = 0;
        for (String s : map.keySet()
        ) {
            list.add(index, new String[]{s, map.get(s).toString()});
        }
        list.sort(Comparator.comparing(o -> o[0]));

        list.sort((o1, o2) -> {
            if (Integer.parseInt(o1[1]) > Integer.parseInt(o2[1]))
                return 1;
            else if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1]))
                return 0;
            else return -1;
        });
        for (String[] array : list
        ) {
            System.out.println(array[0] + ": " + array[1] + " time(s), " + getPercentage(Integer.parseInt(array[1])) + "%");
        }
    }

    public WordFinder(ArrayList<String> listOfItems, TreeMap<String, Integer> map) {
        super(listOfItems, map);
    }

    @Override
    public String displayInfo() {
        return String.format("Total words: %d."
                , listOfItems.size());
    }

    @Override
    public void displayInfoSorting(String sortingType) {
        System.out.print("Sorted data: ");
        sort();
        for (String s : listOfItems
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