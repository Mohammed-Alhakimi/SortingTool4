package sorting;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FinderFactory factory = new FinderFactory();
        Finder finder = null;
        boolean argsPassed = args.length > 0;
        if (argsPassed) {
            String[] arrayOfArgs = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                arrayOfArgs[i] = args[i];
            }
            List<String> listOfArgs = List.of(arrayOfArgs);
            if (listOfArgs.get(0).equals("-dataType")) {
                finder = factory.makeFinder(arrayOfArgs[listOfArgs.indexOf("-dataType") + 1]);
                if (listOfArgs.contains("-sortingType")) {
                    if (arrayOfArgs[listOfArgs.indexOf("-sortingType") + 1].equalsIgnoreCase("byCount")) {
                        doOperations(finder, true);
                    } else {
                        doOperations(finder);
                    }
                } else {
                    doOperations(finder);
                }
            }
            if (listOfArgs.get(0).equals("-sortingType")) {
                if (listOfArgs.contains("-dataType")) {
                    finder = factory.makeFinder(arrayOfArgs[listOfArgs.indexOf("-dataType") + 1]);
                } else {
                    finder = factory.makeFinder("word");
                }
                if (arrayOfArgs[listOfArgs.indexOf("-sortingType") + 1].equalsIgnoreCase("byCount")) {
                    doOperations(finder, true);
                } else {
                    doOperations(finder);
                }
            }
        } else {
            finder = factory.makeFinder("word");
            doOperations(finder);
        }
    }

    private static void doOperations(Finder finder) {
        finder.scanAndAdd();
        System.out.println(finder.displayInfo());
        finder.displayInfoSorting("");
    }

    private static void doOperations(Finder finder, boolean sortByCount) {
        finder.scanAndAdd();
        System.out.println(finder.displayInfo());
        finder.sortByCount();
    }
}