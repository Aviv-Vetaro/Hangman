package Visitors;

import GUIComponents.HangmanGUIKit;
import Visitors.GameOverVisitor;

/**
 * update when game is won
 */
public class GameWonVisitor extends GameOverVisitor {
    public GameWonVisitor(HangmanGUIKit kit) {
        super(kit);
    }

    @Override
    protected String getEndGameMessage() {
        return "game won!";
    }
}
