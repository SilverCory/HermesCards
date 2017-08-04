package co.ryred.hermescards.frames.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by rissa on 19/12/2016.
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // see javadoc for more info on the parameters
    }

    public void next(BufferedImage image) {
        this.image = image;
        revalidate();
        repaint();
    }

}
