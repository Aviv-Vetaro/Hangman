package GUIComponents;

import GUIComponents.CharBanks.CharsThatHaventBeenTriedBank;
import GUIComponents.CharBanks.CorrectlyGuessesCharsBank;
import GUIComponents.CharBanks.IncorrectlyGuessedCharsBank;
import Logic.GuessableWord;

/**
 * a GUI component kit (a.k.a factory) for the hangman game
 */
public interface HangmanGUIKit
{
    CharsThatHaventBeenTriedBank getCharsThatHaventBeenTriedBank();
    CorrectlyGuessesCharsBank getCorrectlyGuessesCharsBank();
    IncorrectlyGuessedCharsBank getIncorrectlyGuessedCharsBank();
    HangmanImage getHangmanImage();
    void setCurrentConfiguredWord(GuessableWord wordToGuess);
}
