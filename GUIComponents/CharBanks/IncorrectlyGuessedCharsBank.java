package GUIComponents.CharBanks;

import Configs.GraphicsConfig;
import Configs.DefaultIncorrectlyGuessedCharsBankConfig;
import Visitors.UpdaterVisitor;

import java.util.ArrayList;

public class IncorrectlyGuessedCharsBank extends CharsBank {
    public IncorrectlyGuessedCharsBank() { }
    @Override
    public void accept(UpdaterVisitor visitor) {
        visitor.visitIncorrectlyGuessedCharsBank(this);
    }

    @Override
    public String toString() {
        return "Incorrect chars:";
    }

    @Override
    public GraphicsConfig createGraphicsConfig() {
        return new DefaultIncorrectlyGuessedCharsBankConfig(toString());
    }
}
