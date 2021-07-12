package Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * represents a word that can be guessed
 */
public class GuessableWord
{
    private String word;
    private HashSet<Character> charsGuessed;
    public GuessableWord(String word)
    {
        this.word = word;
        charsGuessed = new HashSet<>();
    }

    /**
     * try guess a char in the word
     * @param charToGuess the char to be guessed
     * @return true if guessed correctly, otherwise false
     * @throws CharWasAlreadyGuessedException if char was already guessed
     */
    public boolean Guess(char charToGuess) throws CharWasAlreadyGuessedException {
        //convert char to lower case
        charToGuess = (charToGuess + "" ).toLowerCase(Locale.ENGLISH).toCharArray()[0];
        //check if could add to set
        if(charsGuessed.add(charToGuess)){
            //if so, check if char actually exists in string
            return word.contains(String.valueOf(charToGuess));
        }
        //was already guessed
        throw new CharWasAlreadyGuessedException();
    }
    //just a Java 8 stream way to convert the word to set
    private HashSet<Character> wordToHashSet()
    {
        HashSet<Character> result = word.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toCollection(HashSet::new));
        return result;
    }

    /**
     * resets the word so that it can be tried to be guessed again
     */
    public void reset()
    {
        charsGuessed =  new HashSet<>();
    }

    /**
     * @return weather the entire word was guessed correctly
     */
    public boolean isGuessedCorrectly()
    {
        HashSet<Character> set = wordToHashSet();
        return  charsGuessed.containsAll(set);
    }

    /**
     * @return a string representation of the word
     */
    public String getWord()
    {
        return word;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuessableWord that = (GuessableWord) o;
        return Objects.equals(word, that.word);
    }

    /**
     * @return the word as collection, with nulls for each char that was guessed incorrectly
     */
    public ArrayList<Character> getWordIncludeNullsForUnguessedChars()
    {
        String word = getWord();
        ArrayList<Character> result = new ArrayList<>();
        char[] chars = word.toLowerCase(Locale.ENGLISH).toCharArray();
        for(char ch : chars)
        {
            if(charsGuessed.contains(ch))
                result.add(ch);
            else
                result.add(null);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
