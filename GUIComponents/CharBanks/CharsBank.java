package GUIComponents.CharBanks;

import Configs.DefaultCharsBankConfig;
import Configs.GraphicsConfig;
import GUIComponents.GraphicComposite;
import GUIComponents.GraphicLocation;
import Visitors.UpdaterVisitor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;


/**
 * represents a GUI component that contains a collection characters
 */
public class CharsBank extends GraphicComposite {
    private JPanel charsBankImp;
    private ArrayList<Character> charsInBank;

    /**
     * creates an empty collection char bank
     */
    public CharsBank()
    {
        charsBankImp = new JPanel();
        charsInBank = new ArrayList<>();
    }

    /**
     * @param charsInBank the collection of chars in the bank
     */
    public CharsBank(ArrayList<Character> charsInBank)
    {
        charsBankImp = new JPanel();
        this.charsInBank = charsInBank;
    }
    public ArrayList<Character> getCharsInBank() {
        return charsInBank;
    }

    public void setCharsInBank(ArrayList<Character> charsInBank) {
        this.charsInBank = charsInBank;
    }

    /**
     * creates a JLabel that contains a char in it
     * @param text the char
     * @param config the look and feel standard for the label
     * @param size the label size
     * @return the new label
     */
    protected JLabel createLabelWithChar(Character text, GraphicsConfig config, Dimension size){
        JLabel jlabel = new JLabel(text + "");
        jlabel.setForeground(config.getTextFrontColor());
        jlabel.setBackground(config.getTextBackColor());
        jlabel.setFont(new Font("Verdana", 1, 20));
        jlabel.setSize(size);
        jlabel.setPreferredSize(size);
        jlabel.setVisible(true);
        return jlabel;
    }

    /**
     * creates a panel wrapper for a given JLabel
     * @param label the label to be wrapped
     * @param config the look and feel standard for the panel
     * @return the new panel wrapper
     */
    protected JPanel createPanelWrapperForLabel(JLabel label, GraphicsConfig config)  {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBackground(config.getTextBackColor());
        panel.setVisible(true);
        return panel;
    }
    @Override
    public void draw(GraphicLocation location)  {
        charsBankImp.removeAll();
        for(Character charInBank : charsInBank) {
            JLabel label = createLabelWithChar(charInBank, createGraphicsConfig(), new Dimension(40, 40));
            JPanel panel = createPanelWrapperForLabel(label, createGraphicsConfig());
            charsBankImp.add(panel);
        }
        LayoutManager layout = new FlowLayout();
        charsBankImp.setLayout(layout);
        super.draw(location);
    }

    @Override
    public void accept(UpdaterVisitor visitor){
        visitor.visitCharsBank(this);
    }

    @Override
    public JPanel getContainer() {
        return charsBankImp;
    }


    @Override
    public GraphicsConfig createGraphicsConfig() {
        return new DefaultCharsBankConfig(toString());
    }

    @Override
    protected ArrayList<GraphicComposite> getSons() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CharsBank";
    }
}

