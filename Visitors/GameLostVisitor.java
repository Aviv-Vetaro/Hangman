package Visitors;

import GUIComponents.HangmanGUIKit;

/**
 * update when a game is lost
 */
public class GameLostVisitor extends GameOverVisitor {
    private String correctWord;
    public GameLostVisitor(String correctWord, HangmanGUIKit hangmanGUIKit)
    {
        super(hangmanGUIKit);
        this.correctWord = correctWord;
    }
    @Override
    protected String getEndGameMessage() {
        return "game lost! correct word was " + correctWord + "\n";
    }
}
