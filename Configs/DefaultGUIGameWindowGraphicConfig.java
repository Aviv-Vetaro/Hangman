package Configs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DefaultGUIGameWindowGraphicConfig implements GraphicsConfig
{
    private String borderTitle;
    public DefaultGUIGameWindowGraphicConfig(String borderTitle)
    {
        this.borderTitle = borderTitle;
    }
    @Override
    public Color getTextFrontColor() {
        return Color.BLACK;
    }

    @Override
    public Color getTextBackColor() {
        return Color.WHITE;
    }

    @Override
    public Color getBackColor() {
        return Color.WHITE;
    }

    @Override
    public Border getBorder() {
        return BorderFactory.createTitledBorder(borderTitle);
    }
}
