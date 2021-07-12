package Commands;

import Logic.CharWasAlreadyGuessedException;

/**
 * represent an executable command
 */
public interface Command
{
    /**
     * execute the command
     */
    void execute();
}
