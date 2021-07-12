import GUIComponents.DefaultHangmanGUIKit;
import GUIComponents.GUIGameWindowGraphic;
import GUIComponents.GraphicLocation;
import Logic.GuessableWord;
import Logic.WordsToGuessCollectionSingleton;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        //create the host frame fot the game
        Frame mainFrame = new JFrame();
        mainFrame.setPreferredSize(new Dimension(1050, 1050));
        WordsToGuessCollectionSingleton wordsToGuessCollection = WordsToGuessCollectionSingleton.getInstance();
        //get random word
        GuessableWord word = wordsToGuessCollection.useRandomUnusedWord();
        //create GUI factory for that word
        DefaultHangmanGUIKit hangmanGUIKit = new DefaultHangmanGUIKit(word);
        //create main window graphic
        GUIGameWindowGraphic guiGameWindowGraphic = new GUIGameWindowGraphic();
        hangmanGUIKit.setMainWindow(guiGameWindowGraphic);
        //add it to the main frame
        guiGameWindowGraphic.setHangmanGUIKit(hangmanGUIKit);
        mainFrame.setSize(1050, 1050);
        mainFrame.add(guiGameWindowGraphic.getContainer());
        //draw it
        guiGameWindowGraphic.draw(new GraphicLocation(new Point(0, 0), 1050, 1050));
        mainFrame.repaint(0, 0, 1050, 1050);
        mainFrame.setVisible(true);

    }
}
