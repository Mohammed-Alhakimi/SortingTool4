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
            for (String s : listOfArgs
            ) {
                if (!s.equals("-dataType") && !s.equals("-sortingType") && !s.equals("natural") && !s.equals("byCount") && !s.equals("long") && !s.equals("word") && !s.equals("line")) {
                    System.out.println("\"" + s + "\" is not a valid parameter. It will be skipped.");
                }
            }
            if (listOfArgs.get(0).equals("-dataType")) {
                try {
                    if (arrayOfArgs[listOfArgs.indexOf("-dataType") + 1].equals("long") || arrayOfArgs[listOfArgs.indexOf("-dataType") + 1].equals("word") || arrayOfArgs[listOfArgs.indexOf("-dataType") + 1].equals("line")) {
                        finder = factory.makeFinder(arrayOfArgs[listOfArgs.indexOf("-dataType") + 1]);
                    } else {
                        System.out.println("No data type defined!");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("No data type defined!");
                }
                if (listOfArgs.contains("-sortingType")) {
                    try {
                        if (arrayOfArgs[listOfArgs.indexOf("-sortingType") + 1].equalsIgnoreCase("byCount")) {
                            doOperations(finder, true);
                        } else if (arrayOfArgs[listOfArgs.indexOf("-sortingType") + 1].equalsIgnoreCase("natural")) {
                            doOperations(finder);
                        } else {
                            System.out.println("No sorting type defined!");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No sorting type defined!");
                    }
                } else {
                    doOperations(finder);
                }
            }
            if (listOfArgs.get(0).equals("-sortingType")) {

                if (listOfArgs.contains("-dataType")) {
                    try {
                        if (arrayOfArgs[listOfArgs.indexOf("-dataType") + 1].equals("long") || arrayOfArgs[listOfArgs.indexOf("-dataType") + 1].equals("word") || arrayOfArgs[listOfArgs.indexOf("-dataType") + 1].equals("line")) {
                            finder = factory.makeFinder(arrayOfArgs[listOfArgs.indexOf("-dataType") + 1]);
                        } else {
                            System.out.println("No data type defined!");
                            System.exit(0);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No data type defined!");
                        System.exit(0);
                    }
                } else {
                    finder = factory.makeFinder("word");
                }
                try {
                    if (arrayOfArgs[listOfArgs.indexOf("-sortingType") + 1].equalsIgnoreCase("byCount")) {
                        doOperations(finder, true);
                    } else if (arrayOfArgs[listOfArgs.indexOf("-sortingType") + 1].equalsIgnoreCase("natural")) {
                        doOperations(finder);
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("No sorting type defined!");
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