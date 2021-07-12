package GUIComponents;

import Commands.UserGuessedACharCommandPrototype;
import GUIComponents.CharBanks.CharsThatHaventBeenTriedBank;
import GUIComponents.CharBanks.CorrectlyGuessesCharsBank;
import GUIComponents.CharBanks.IncorrectlyGuessedCharsBank;
import Logic.GuessableWord;
import Visitors.*;

import java.util.ArrayList;

public class DefaultHangmanGUIKit implements HangmanGUIKit {
    private GuessableWord wordToGuess;
    private GraphicComposite mainWindow;

    public DefaultHangmanGUIKit(GuessableWord wordToGuess)
    {
        this.wordToGuess = wordToGuess;
    }

    public void setMainWindow(GraphicComposite mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public CharsThatHaventBeenTriedBank getCharsThatHaventBeenTriedBank() {
        ArrayList<Character> alphabet = new ArrayList<>();
        for(char i = 'a'; i <= 'z'; i++)
            alphabet.add(i);

        return new CharsThatHaventBeenTriedBank(alphabet, new UserGuessedACharCommandPrototype(mainWindow, wordToGuess,
                new GameWonVisitor(this), new GameLostVisitor(wordToGuess.getWord(), this),
                new CharGuessedCorrectlyVisitor(wordToGuess), new CharGuessedIncorrectlyVisitor()));
    }

    @Override
    public CorrectlyGuessesCharsBank getCorrectlyGuessesCharsBank() {
        return new CorrectlyGuessesCharsBank(wordToGuess.getWordIncludeNullsForUnguessedChars());
    }

    @Override
    public IncorrectlyGuessedCharsBank getIncorrectlyGuessedCharsBank() {
        return new IncorrectlyGuessedCharsBank();
    }

    @Override
    public HangmanImage getHangmanImage() {
        return new HangmanImage();
    }

    @Override
    public void setCurrentConfiguredWord(GuessableWord wordToGuess) {
        this.wordToGuess = wordToGuess;
    }
}
