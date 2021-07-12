package Configs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DefaultHangmanImageConfig implements GraphicsConfig
{
    private String borderTitle;
    public DefaultHangmanImageConfig(String borderTitle)
    {
        this.borderTitle = borderTitle;
    }
    @Override
    public Color getTextFrontColor() {
        return Color.BLACK;
    }

    @Override
    public Color getTextBackColor() {
        return Color.BLUE;
    }

    @Override
    public Color getBackColor() {
        return Color.YELLOW;
    }

    @Override
    public Border getBorder() {
        return BorderFactory.createTitledBorder(borderTitle);
    }

}
