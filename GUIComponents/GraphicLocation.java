package GUIComponents;

import java.awt.*;

/**
 * the location of a GUI component
 */
public class GraphicLocation {
    private final Point topLeft;
    private final int height;
    private final int width;

    /**
     * @param topLeft the top left point of the component
     * @param height the height of the component
     * @param width the width of the component
     */
    public GraphicLocation(Point topLeft, int height, int width)
    {
        this.topLeft = topLeft;
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getTopLeftPoint() {
        return topLeft;
    }
}
