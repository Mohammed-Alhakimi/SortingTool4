package sorting;

import java.util.ArrayList;

public class FinderFactory {

    public Finder makeFinder(String type) {
        if (type.equalsIgnoreCase("long")) {
            ArrayList<Long> list = new ArrayList<>();
            return new HighestNumberFinder(list);
        } else if (type.equalsIgnoreCase("word")) {
            ArrayList<String> list = new ArrayList<>();
            return new WordFinder(list);
        } else if (type.equalsIgnoreCase("line")) {
            ArrayList list = new ArrayList();
            return new LineFinder(list);
        } else return null;
    }
}
