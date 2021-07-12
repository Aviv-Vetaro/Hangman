package Configs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DefaultCorrectlyGuessedCharsBankConfig implements GraphicsConfig
{
    private String borderTitle;
    public DefaultCorrectlyGuessedCharsBankConfig(String borderTitle)
    {
        this.borderTitle = borderTitle;
    }
    @Override
    public Color getTextFrontColor() {
        return Color.GREEN;
    }

    @Override
    public Color getTextBackColor() {
        return Color.WHITE;
    }

    @Override
    public Color getBackColor() {
        return Color.ORANGE;
    }

    @Override
    public Border getBorder() {
        return BorderFactory.createTitledBorder(borderTitle);
    }
}
