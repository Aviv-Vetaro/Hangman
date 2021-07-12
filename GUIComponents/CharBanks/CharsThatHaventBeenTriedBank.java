package GUIComponents.CharBanks;

import Commands.Command;
import Commands.UserGuessedACharCommandPrototype;
import Configs.GraphicsConfig;
import GUIComponents.ClickableLabel;
import Visitors.UpdaterVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CharsThatHaventBeenTriedBank extends CharsBank {
    private UserGuessedACharCommandPrototype onClickCommand;
    public CharsThatHaventBeenTriedBank(ArrayList<Character> charsInBank, UserGuessedACharCommandPrototype onClickCommand)
    {
        super(charsInBank);
        this.onClickCommand = onClickCommand;

    }

    /**
     * removes a char from the bank's collection
     * @param ch the char to remove
     */
    public void removeChar(char ch)
    {
        getCharsInBank().removeIf(c -> (ch == c));
    }
    @Override
    public void accept(UpdaterVisitor visitor)  {
        visitor.visitCharsThatHaventBeenTriedBank(this);
    }

    @Override
    public String toString() {
        return "Unguessed chars:";
    }

    @Override
    protected JLabel createLabelWithChar(Character text, GraphicsConfig config, Dimension size){
        UserGuessedACharCommandPrototype newOnClickCommand = (UserGuessedACharCommandPrototype) onClickCommand.clone();
        newOnClickCommand.setGuessedChar(text);
        ClickableLabel jlabel = new ClickableLabel(text + "", (Command) onClickCommand.clone());
        jlabel.setForeground(config.getTextFrontColor());
        jlabel.setBackground(config.getTextBackColor());
        jlabel.setFont(new Font("Verdana", 1, 20));
        jlabel.setSize(size);
        jlabel.setOnClickCommand(newOnClickCommand);
        jlabel.setPreferredSize(size);
        jlabel.setVisible(true);
        return jlabel;
    }
}
