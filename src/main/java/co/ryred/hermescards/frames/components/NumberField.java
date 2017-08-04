package co.ryred.hermescards.frames.components;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Created by rissa on 19/12/2016.
 */
public class NumberField extends JTextField {

    @Override
    protected Document createDefaultModel() {
        return new Numberdocument();
    }

    class Numberdocument extends PlainDocument {
        String numbers = "1234567890-";

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (numbers.contains(str)) super.insertString(offs, str, a);
        }
    }

}