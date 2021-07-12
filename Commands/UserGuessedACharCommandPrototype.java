package Commands;

import GUIComponents.GraphicComposite;
import Logic.CharWasAlreadyGuessedException;
import Logic.GuessableWord;
import Logic.TriesCounterSingleton;
import Visitors.*;

/**
 * a command that represents user request when guessing a character from thw word
 */
public class UserGuessedACharCommandPrototype implements Command, Cloneable {
    private GraphicComposite mainWindow;
    private GuessableWord wordToGuess;
    private GameWonVisitor gameWonVisitor;
    private GameLostVisitor gameLostVisitor;
    private CharGuessedVisitor charGuessedCorrectlyVisitor;
    private CharGuessedIncorrectlyVisitor charGuessedIncorrectlyVisitor;
    private char guessedChar;

    /**
     * @param mainWindow the main window of the game
     * @param wordToGuess the word that needs to be guessed
     * @param gameWonVisitor a visitor for cases the game is won
     * @param gameLostVisitor a visitor for cases the game is lost
     * @param charGuessedCorrectlyVisitor a visitor for cases the game was not won but the character was correct
     * @param charGuessedIncorrectlyVisitor a visitor for cases the game was not lost but the character was incorrect
     */
    public UserGuessedACharCommandPrototype(GraphicComposite mainWindow, GuessableWord wordToGuess,
                                            GameWonVisitor gameWonVisitor, GameLostVisitor gameLostVisitor,
                                            CharGuessedCorrectlyVisitor charGuessedCorrectlyVisitor,
                                            CharGuessedIncorrectlyVisitor charGuessedIncorrectlyVisitor)
    {
        this.mainWindow = mainWindow;
        this.wordToGuess = wordToGuess;
        this.gameWonVisitor = gameWonVisitor;
        this.gameLostVisitor = gameLostVisitor;
        this.charGuessedCorrectlyVisitor = charGuessedCorrectlyVisitor;
        this.charGuessedIncorrectlyVisitor = charGuessedIncorrectlyVisitor;
        this.charGuessedCorrectlyVisitor.setSelectedChar(guessedChar);
        this.charGuessedIncorrectlyVisitor.setSelectedChar(guessedChar);
    }


    @Override
    public void execute(){
        boolean result = true;
        try {
            //try guess the word
            result = wordToGuess.Guess(guessedChar);
        }
        //catch block will only execute if GUI failed such that a user was able to enter a char twice
        catch (CharWasAlreadyGuessedException e){
            System.out.println(e.getMessage());
        }
        //if was guessed correctly
        if(result)
        {
            //if the game was won (i.e the entire word was guessed correctly)
            if(wordToGuess.isGuessedCorrectly())
            {
                //use visitor to update GUI
                mainWindow.accept(gameWonVisitor);
                //reset the word so that it will be able to be selected yet again
                wordToGuess.reset();
                //reset the attempts count
                TriesCounterSingleton.getInstance().reset();
            }
            else
                {
                    //use visitor to update GUI
                    mainWindow.accept(charGuessedCorrectlyVisitor);
                }

        }
        //if char was incorrect
        else
        {
            //register as failed attempt
            TriesCounterSingleton.getInstance().tryOneTime();
            //check if game is lost
            if(!TriesCounterSingleton.getInstance().hasTriesLeft()) {
                //reset game
                mainWindow.accept(gameLostVisitor);
                wordToGuess.reset();
                TriesCounterSingleton.getInstance().reset();
            }
            else
                //use visitor to update GUI
                mainWindow.accept(charGuessedIncorrectlyVisitor);

        }
    }

    public void setGuessedChar(char guessedChar) {
        this.guessedChar = guessedChar;
        this.charGuessedCorrectlyVisitor.setSelectedChar(guessedChar);
        this.charGuessedIncorrectlyVisitor.setSelectedChar(guessedChar);
    }
    @Override
    public Object clone()  {
        try {
            //deep clone
            UserGuessedACharCommandPrototype newItem = (UserGuessedACharCommandPrototype) super.clone();
            newItem.charGuessedCorrectlyVisitor = (CharGuessedVisitor) charGuessedCorrectlyVisitor.clone();
            newItem.charGuessedIncorrectlyVisitor = (CharGuessedIncorrectlyVisitor) charGuessedIncorrectlyVisitor.clone();
            return newItem;
        } catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
}
