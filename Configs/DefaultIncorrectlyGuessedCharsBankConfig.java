package Configs;

import java.awt.*;

public class DefaultIncorrectlyGuessedCharsBankConfig extends DefaultCharsBankConfig {

    public DefaultIncorrectlyGuessedCharsBankConfig(String borderTitle) {
        super(borderTitle);
    }

    @Override
    public Color getTextBackColor() {
        return Color.GREEN;
    }
}
