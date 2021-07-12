package GUIComponents;

import Configs.GraphicsConfig;
import Visitors.UpdaterVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * represents a GUI component
 */
public abstract class GraphicComposite {
    private GraphicLocation prevLocation;

    /**
     * @return the panel that contain the GUI functionality
     */
    protected abstract JPanel getContainer();

    /**
     * @return the look and feel standard of the GUI component
     */
    protected abstract GraphicsConfig createGraphicsConfig();

    /**
     * @return the sons of the GUI components
     */
    protected abstract ArrayList<GraphicComposite> getSons();

    /**
     * draws the GUI component
     * @param location the position and location of the GUI component
     */
    public void draw(GraphicLocation location) {
        //store the location
        this.prevLocation = location;
        //apply look - and - feel standard to the component
        JPanel container = getContainer();
        GraphicsConfig config = createGraphicsConfig();

        container.setBackground(config.getBackColor());
        container.setBorder(config.getBorder());

        container.setBorder(config.getBorder());
        //set size and position of GUI component
        container.setPreferredSize(new Dimension(location.getWidth(), location.getHeight()));
        container.setSize(new Dimension(location.getWidth(), location.getHeight()));
        //redraw component
        container.revalidate();
        container.repaint(location.getTopLeftPoint().x, location.getTopLeftPoint().y, location.getWidth(), location.getHeight());
        //show component
        container.setVisible(true);
    }
    /**
     * draws the GUI component at the previous location drawn
     */
    public void draw()  {
        draw(prevLocation);
    }

    /**
     * accepts a visitor
     * @param visitor the visitor
     */
    public void accept(UpdaterVisitor visitor) {
        //cascade the accept request to the sons of the component
        ArrayList<GraphicComposite> sons = getSons();
        for(GraphicComposite son : sons)
            son.accept(visitor);
    }
}
