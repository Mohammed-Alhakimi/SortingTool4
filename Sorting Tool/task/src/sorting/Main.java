package sorting;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FinderFactory factory = new FinderFactory();
        Finder finder = null;
        boolean argsPassed = args.length > 0;
        if(argsPassed){
            if(Arrays.stream(args).anyMatch(s -> s.equals("-sortIntegers"))){
                finder= factory.makeFinder("long");
                doOperations(finder,true);
            }
            else if(Arrays.stream(args).anyMatch(s -> s.equals("-dataType"))){
                String  type = args[1];
                finder=factory.makeFinder(type);
                doOperations(finder);
            }
        }else {
            finder = factory.makeFinder("word");
            doOperations(finder);
        }
    }
    private static void doOperations(Finder finder) {
        finder.scanAndAdd();
        finder.findHighestValue();
        System.out.println(finder.displayInfo());
    }
    private static void doOperations(Finder finder,boolean sort) {
        finder.scanAndAdd();
        System.out.println("Total numbers: "+finder.listOfItems.size()+".");
        finder.sort("mergesort");
        finder.displayInfo(true);
    }
}