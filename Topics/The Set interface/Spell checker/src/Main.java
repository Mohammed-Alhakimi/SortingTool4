import java.util.*;

// SpellChecker
class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
// Scanner to get the number of words we want in our dictionary
        int numberOfWords = s.nextInt();
        Set<String> dictionary = new HashSet<>();
// adding the words to our dictionary
        for (int i = 0; i < numberOfWords; i++) {

            dictionary.add(s.next().toLowerCase(Locale.ROOT));
            s.nextLine();
        }
        int numberOfLines = s.nextInt();
        s.nextLine();
// adding lines for input
        Set<String> wordsInLines = new HashSet<>();

        for (int i = 0; i < numberOfLines; i++) {

            String line = s.nextLine().toLowerCase(Locale.ROOT);
            String[] arrayForLine = line.split("[\\s]+");
            Collections.addAll(wordsInLines, arrayForLine);
        }

//Set to contain wrong words

        Set<String> wrongWords = new HashSet<>();
//Comparing to check validation of words
        for (String word : wordsInLines
        ) {
            if (!dictionary.contains(word)) {
                wrongWords.add(word);
            }
        }
//Printing out the wrong words
        wrongWords.forEach(System.out::println);

    }
}
