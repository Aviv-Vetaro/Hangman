package GUIComponents;

import Configs.DefaultHangmanImageConfig;
import Configs.GraphicsConfig;
import Logic.TriesCounterSingleton;
import Visitors.UpdaterVisitor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HangmanImage extends GraphicComposite {
    private ArrayList<String> stages;
    private JPanel imageImp;
    private int currentStage;
    public HangmanImage()
    {
        stages = new ArrayList<>();
        //get all the paths to the files of the images of the different states
        for(int i = 0; i <= TriesCounterSingleton.TRIES_LEFT_AT_START; i++)
            stages.add( Paths.get(".").toAbsolutePath().normalize().toString() + "/src/GUIComponents/HangmanImages/stage" + i + ".png");
        imageImp = new JPanel();
        currentStage = 0;
    }


    @Override
    public void draw(GraphicLocation location) {
        try {
            //remove previous image (if any)
            imageImp.removeAll();
            //get current path to current image state
            BufferedImage currentImage = ImageIO.read(new File(stages.get(currentStage)));
            //an hack-ish way to add image to panel
            JLabel picLabel = new JLabel(new ImageIcon(currentImage));
            imageImp.add(picLabel);
            super.draw(location);
        } catch (IOException e)
        {
            JOptionPane.showConfirmDialog(null, e.getMessage() + ": failed to load image, restart the app and try again");
            System.exit(0);
        }

    }

    @Override
    public void accept(UpdaterVisitor visitor) {
        visitor.visitHangmanImage(this);
    }

    @Override
    public JPanel getContainer() {
        return imageImp;
    }

    @Override
    protected GraphicsConfig createGraphicsConfig() {
        return new DefaultHangmanImageConfig(toString());
    }

    @Override
    protected ArrayList<GraphicComposite> getSons() {
        return null;
    }

    public void NextStage()
    {
        currentStage++;
    }
    @Override
    public String toString() {
        return "Figure:";
    }
}
