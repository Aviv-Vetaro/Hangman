package GUIComponents;

import Commands.Command;
import Commands.NullCommand;
import Logic.CharWasAlreadyGuessedException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterCommandExecutor extends MouseAdapter {
    private Command clickCommand;

    /**
     * @param clickCommand the command to be executed when the mouseClicked() event is called
     */
    public MouseAdapterCommandExecutor(Command clickCommand)
    {
        this.clickCommand = clickCommand;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickCommand.execute();
        super.mouseClicked(e);
    }


    public void setClickCommand(Command clickCommand) {
        this.clickCommand = clickCommand;
    }
}
