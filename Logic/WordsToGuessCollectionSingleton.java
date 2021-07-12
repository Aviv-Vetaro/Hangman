package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class WordsToGuessCollectionSingleton {
    private static WordsToGuessCollectionSingleton instance = null;
    private HashSet<GuessableWord> unusedWordsSet;
    private HashSet<GuessableWord> usedWordsSet;
    private WordsToGuessCollectionSingleton()
    {
        unusedWordsSet = new HashSet<>();
        //path to the text file with all the words
        String path = Paths.get(".").toAbsolutePath().normalize().toString() + "/src/Logic/Words.txt";
        try {
            //read the file onto arraylist
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                unusedWordsSet.add(new GuessableWord(word));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. (path) " + path);
            e.printStackTrace();
        }
        usedWordsSet = new HashSet<>();
    }
    public static WordsToGuessCollectionSingleton getInstance() {
        if(instance == null)
            //if the singleton wasn't initialised yet
            instance = new WordsToGuessCollectionSingleton();
        return instance;
    }

    /**
     * gets random word from the collection and marks it as used
     * @return
     */
    public GuessableWord useRandomUnusedWord()
    {
        //get random word
        GuessableWord selectedWord = getRandomUnusedWordFromSet();
        //removes from the unused set
        unusedWordsSet.remove(selectedWord);
        //adds from the used set
        usedWordsSet.add(selectedWord);
        return selectedWord;
    }
    private GuessableWord getRandomUnusedWordFromSet()
    {
        int size = unusedWordsSet.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(GuessableWord word : unusedWordsSet)
        {
            if (i == item)
                return word;
            i++;
        }
        //will not be reached unless collection is empty
        return null;
    }
}
