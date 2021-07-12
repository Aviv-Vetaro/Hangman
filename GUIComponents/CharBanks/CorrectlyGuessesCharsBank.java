package GUIComponents.CharBanks;

import Configs.DefaultCorrectlyGuessedCharsBankConfig;
import Configs.GraphicsConfig;
import GUIComponents.CharBanks.CharsBank;
import Visitors.UpdaterVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CorrectlyGuessesCharsBank extends CharsBank {
    public CorrectlyGuessesCharsBank(ArrayList<Character> charsInBank)
    {
        super(charsInBank);
    }
    @Override
    protected JLabel createLabelWithChar(Character text, GraphicsConfig config, Dimension size)
    {
        JLabel jlabel;
        if(text == null)
            jlabel = new JLabel("");
        else
            jlabel = new JLabel(text + "");

        jlabel.setForeground(config.getTextFrontColor());
        jlabel.setBackground(config.getTextBackColor());
        jlabel.setFont(new Font("Verdana", 1, 20));
        jlabel.setSize(size);
        jlabel.setPreferredSize(size);
        jlabel.setVisible(true);
        return jlabel;
    }
    @Override
    public void accept(UpdaterVisitor visitor)  {
        visitor.visitCorrectlyGuessesCharsBank(this);
    }

    @Override
    public GraphicsConfig createGraphicsConfig() {
        return new DefaultCorrectlyGuessedCharsBankConfig(toString());
    }

    @Override
    public String toString() {
        return "Word:";
    }
}
