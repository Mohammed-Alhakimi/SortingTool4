package sorting;


public class Main {
    public static void main(String[] args) {
        FinderFactory factory = new FinderFactory();
        Finder finder = null;
        boolean b = args.length > 0;
        if (b) {
            String option = args[0];
            String type = args[1];
            if (option.equals("-dataType")) {
                finder = factory.makeFinder(type);
            } else {
                finder = factory.makeFinder("word");
            }
        } else {
            finder = factory.makeFinder("word");
        }
        finder.scanAndAdd();
        finder.findHighestValue();
        System.out.println(finder.displayInfo());
        ;
    }
}