package co.ryred.hermescards.frames;

import co.ryred.hermescards.CardCounter;
import co.ryred.hermescards.DoneException;
import co.ryred.hermescards.frames.components.ImagePanel;
import co.ryred.hermescards.util.Callback;
import lombok.Getter;
import lombok.Setter;
import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by rissa on 19/12/2016.
 */
public class ImageDisplayFrame extends JFrame {

    @Getter
    private final JButton nextButton;

    @Getter
    @Setter
    private CardCounter counter;

    private ImagePanel imagePanel;

    public ImageDisplayFrame(Callback<Void> done) throws HeadlessException {
        super("Hermes Cards");

        getContentPane().setLayout(new GridLayout(2, 1));
        setPreferredSize(new Dimension(453, 275));

        imagePanel = new ImagePanel(getImage(0));
        add(imagePanel);

        JPanel topPanel = new JPanel(new GridLayout(1, 2));

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {

            try {
                if (counter != null) imagePanel.next(getImage(counter.next()));
            } catch (DoneException e1) {
                done.call(null);
                setVisible(false);
                setCounter(null);
            }

        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        topPanel.add(exitButton);
        topPanel.add(nextButton);
        add(topPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);

    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);

        if (counter != null) {
            try {
                imagePanel.next(getImage(counter.next()));
            } catch (DoneException e) {
                throw new IllegalStateException("Premature done.");
            }
        }

    }

    private BufferedImage getImage(int barcodeNumber) {
        String msg = String.valueOf(barcodeNumber);

        //Create the barcode bean
        Interleaved2Of5Bean bean = new Interleaved2Of5Bean();

        final int dpi = 200;

        //Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(8.0f / dpi)); //makes a dot/module exactly eight pixels

        boolean antiAlias = false;
        int orientation = 0;
        //Set up the canvas provider to create a monochrome bitmap
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(dpi, BufferedImage.TYPE_BYTE_BINARY, antiAlias, orientation);

        //Generate the barcode
        bean.generateBarcode(canvas, msg);

        //Signal end of generation
        try {
            canvas.finish();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        //Get generated bitmap
        return canvas.getBufferedImage();
    }
}
