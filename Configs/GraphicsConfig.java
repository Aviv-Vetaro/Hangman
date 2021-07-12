package Configs;

import javax.swing.border.Border;
import java.awt.*;

/**
 * determines the look and feel standards of a GUI component
 */
public interface GraphicsConfig
{
    Color getTextFrontColor();
    Color getTextBackColor();
    Color getBackColor();
    Border getBorder();
}
