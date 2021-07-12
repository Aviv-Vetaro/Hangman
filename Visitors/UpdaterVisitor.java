package Visitors;

import GUIComponents.*;
import GUIComponents.CharBanks.CharsBank;
import GUIComponents.CharBanks.CharsThatHaventBeenTriedBank;
import GUIComponents.CharBanks.CorrectlyGuessesCharsBank;
import GUIComponents.CharBanks.IncorrectlyGuessedCharsBank;

/**
 * the intent of the class is to preform actions on components according to some update
 * subclasses of this class will be update types
 */
public abstract class UpdaterVisitor implements Cloneable{
    public void visitHangmanImage(HangmanImage hangmanImage)  {}
    public void visitGUIGameWindowGraphic(GUIGameWindowGraphic GUIGameWindow) {}
    public void visitCharsBank(CharsBank charsBank){}
    public void visitIncorrectlyGuessedCharsBank(IncorrectlyGuessedCharsBank incorrectlyGuessedCharsBank)  {}
    public void visitCorrectlyGuessesCharsBank(CorrectlyGuessesCharsBank correctlyGuessesCharsBank) {}
    public void visitCharsThatHaventBeenTriedBank(CharsThatHaventBeenTriedBank charsThatHaventBeenTriedBank) {}

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (Exception e)
        {
            return null;
        }
    }
}
