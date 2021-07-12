package GUIComponents;

import Configs.DefaultGUIGameWindowGraphicConfig;
import Configs.GraphicsConfig;
import GUIComponents.CharBanks.CharsThatHaventBeenTriedBank;
import GUIComponents.CharBanks.CorrectlyGuessesCharsBank;
import GUIComponents.CharBanks.IncorrectlyGuessedCharsBank;
import Visitors.UpdaterVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * the main GUI component of a hangman game
 */
public class GUIGameWindowGraphic extends GraphicComposite {
    private CharsThatHaventBeenTriedBank charsThatHaventBeenTriedBank;
    private CorrectlyGuessesCharsBank correctlyGuessesCharsBank;
    private IncorrectlyGuessedCharsBank incorrectlyGuessedCharsBank;
    private HangmanImage hangmanImage;
    private JPanel _GUIGameWindowGraphicImp;

    public GUIGameWindowGraphic()
    {
        _GUIGameWindowGraphicImp = new JPanel();
    }

    /**
     * sets the window based on subcomponents kit
     * @param hangmanGUIKit the subcomponents kit
     */
    public void setHangmanGUIKit(HangmanGUIKit hangmanGUIKit)
    {
        this.charsThatHaventBeenTriedBank = hangmanGUIKit.getCharsThatHaventBeenTriedBank();
        this.correctlyGuessesCharsBank = hangmanGUIKit.getCorrectlyGuessesCharsBank();
        this.incorrectlyGuessedCharsBank = hangmanGUIKit.getIncorrectlyGuessedCharsBank();
        this.hangmanImage = hangmanGUIKit.getHangmanImage();

        _GUIGameWindowGraphicImp.removeAll();
        _GUIGameWindowGraphicImp.invalidate();
        _GUIGameWindowGraphicImp.add(charsThatHaventBeenTriedBank.getContainer());
        _GUIGameWindowGraphicImp.add(correctlyGuessesCharsBank.getContainer());
        _GUIGameWindowGraphicImp.add(hangmanImage.getContainer());
        _GUIGameWindowGraphicImp.add(incorrectlyGuessedCharsBank.getContainer());
        _GUIGameWindowGraphicImp.validate();
    }

    @Override
    public void draw(GraphicLocation location) {
        charsThatHaventBeenTriedBank.draw(new GraphicLocation(new Point(0,0), 200, 800));
        incorrectlyGuessedCharsBank.draw(new GraphicLocation(new Point(0, 200), 150, 800));
        correctlyGuessesCharsBank.draw(new GraphicLocation(new Point(0, 400), 200, 1000));
        hangmanImage.draw(new GraphicLocation(new Point(0,600), 400 , 1000));
        super.draw(location);
    }

    @Override
    public JPanel getContainer() {
        return _GUIGameWindowGraphicImp;
    }


    @Override
    protected GraphicsConfig createGraphicsConfig() {
        return new DefaultGUIGameWindowGraphicConfig(toString());
    }

    @Override
    protected ArrayList<GraphicComposite> getSons() {
        ArrayList<GraphicComposite> sons = new ArrayList<>();
        sons.add(charsThatHaventBeenTriedBank);
        sons.add(incorrectlyGuessedCharsBank);
        sons.add(correctlyGuessesCharsBank);
        sons.add(hangmanImage);
        return sons;
    }

    @Override
    public String toString() {
        return "Hangman:";
    }

    @Override
    public void accept(UpdaterVisitor visitor)  {
        visitor.visitGUIGameWindowGraphic(this);
        super.accept(visitor);
    }
}
