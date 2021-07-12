package GUIComponents;

import Commands.Command;

import javax.swing.*;
import java.awt.*;

public class ClickableLabel extends JLabel {
    /**
     * @param text label text
     * @param onClickCommand the command to be executed when the label is clicked
     */
    public ClickableLabel(String text, Command onClickCommand)
    {
        super(text);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapterCommandExecutor(onClickCommand));
    }
    public void setOnClickCommand(Command clickCommand)
    {
        ((MouseAdapterCommandExecutor)getMouseListeners()[0]).setClickCommand(clickCommand);
    }

}
