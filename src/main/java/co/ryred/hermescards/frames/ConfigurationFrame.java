package co.ryred.hermescards.frames;

import co.ryred.hermescards.CardCounter;
import co.ryred.hermescards.frames.components.NumberField;
import co.ryred.hermescards.util.Callback;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rissa on 19/12/2016.
 */
public class ConfigurationFrame extends JFrame {

    @Getter
    @Setter
    private Callback<CardCounter> counterCallback;

    public ConfigurationFrame(Callback<CardCounter> counterCallback) throws HeadlessException {
        super("Hermes Cards - Configure the cards");

        this.counterCallback = counterCallback;

        getContentPane().setLayout(new GridLayout(3, 2));

        JLabel topCardNumber = new JLabel("Top card number");
        NumberField topNumberField = new NumberField();
        add(topCardNumber);
        add(topNumberField);

        JLabel bottomCardNumber = new JLabel("Bottom card number");
        NumberField bottomNumberField = new NumberField();
        add(bottomCardNumber);
        add(bottomNumberField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            int top = Integer.parseInt(topNumberField.getText().trim());
            int bottom = Integer.parseInt(bottomNumberField.getText().trim());

            if (this.counterCallback == null) System.out.println("Countercallback is null");
            this.counterCallback.call(new CardCounter(top, bottom));
            setVisible(false);
            bottomNumberField.setText("");
            topNumberField.setText("");
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        add(exitButton);
        add(nextButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);

    }
}
