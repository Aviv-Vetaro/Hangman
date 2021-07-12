package Visitors;

import GUIComponents.GUIGameWindowGraphic;
import GUIComponents.GraphicLocation;
import GUIComponents.HangmanGUIKit;
import Logic.WordsToGuessCollectionSingleton;

import javax.swing.*;
import java.awt.*;

/**
 * update when game is over
 */
public abstract class GameOverVisitor extends UpdaterVisitor {
    HangmanGUIKit kit;
    protected GameOverVisitor(HangmanGUIKit kit)
    {
        this.kit = kit;
    }
    @Override
    public void visitGUIGameWindowGraphic(GUIGameWindowGraphic GUIGameWindow) {
        int input = JOptionPane.showConfirmDialog(null,getEndGameMessage() + " play again?");
        if(input == 0) {
            //if user said yes
            //use the kit with a new word to create new GUI components
            kit.setCurrentConfiguredWord(WordsToGuessCollectionSingleton.getInstance().useRandomUnusedWord());
            GUIGameWindow.setHangmanGUIKit(kit);
            Dimension currentDimensions = GUIGameWindow.getContainer().getSize();
            //then redraw the main window
            GUIGameWindow.draw(new GraphicLocation(new Point(0, 0), currentDimensions.height, currentDimensions.width));
        }
        else
            System.exit(0);
    }

    protected abstract String getEndGameMessage();
}
