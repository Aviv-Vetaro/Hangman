package Visitors;

import GUIComponents.CharBanks.CorrectlyGuessesCharsBank;
import Logic.GuessableWord;
/**
 * update when char is guessed correctly by the user
 */
public class CharGuessedCorrectlyVisitor extends CharGuessedVisitor{
    GuessableWord wordToGuess;
    public CharGuessedCorrectlyVisitor(GuessableWord wordToGuess)
    {
        this.wordToGuess = wordToGuess;
    }
    @Override
    public void visitCorrectlyGuessesCharsBank(CorrectlyGuessesCharsBank correctlyGuessesCharsBank) {
        correctlyGuessesCharsBank.setCharsInBank(wordToGuess.getWordIncludeNullsForUnguessedChars());
        correctlyGuessesCharsBank.draw();
    }
}
