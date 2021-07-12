package Visitors;

import GUIComponents.CharBanks.CharsThatHaventBeenTriedBank;

/**
 * update when char is guessed by the user
 */
public abstract class CharGuessedVisitor extends UpdaterVisitor {
    private char ch;
    public void setSelectedChar(char ch)
    {
        this.ch = ch;
    }
    protected char getSelectedChar()
    {
        return ch;
    }

    @Override
    public void visitCharsThatHaventBeenTriedBank(CharsThatHaventBeenTriedBank charsThatHaventBeenTriedBank){
        charsThatHaventBeenTriedBank.removeChar(getSelectedChar());
        charsThatHaventBeenTriedBank.draw();
    }
}
