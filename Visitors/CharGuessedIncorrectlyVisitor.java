package Visitors;

import GUIComponents.CharBanks.IncorrectlyGuessedCharsBank;
import GUIComponents.HangmanImage;

/**
 * update when char is guessed incorrectly by the user
 */
public class CharGuessedIncorrectlyVisitor extends CharGuessedVisitor{
    @Override
    public void visitIncorrectlyGuessedCharsBank(IncorrectlyGuessedCharsBank incorrectlyGuessedCharsBank) {
        incorrectlyGuessedCharsBank.getCharsInBank().add(getSelectedChar());
        incorrectlyGuessedCharsBank.draw();
    }

    @Override
    public void visitHangmanImage(HangmanImage hangmanImage) {
        hangmanImage.NextStage();
        hangmanImage.draw();
    }
}
