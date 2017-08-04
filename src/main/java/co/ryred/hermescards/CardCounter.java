package co.ryred.hermescards;

import lombok.Data;

/**
 * Created by rissa on 19/12/2016.
 */
@Data
public class CardCounter {

    private final int min;
    private final int max;
    private int current;

    public CardCounter(int min, int max) {

        if (min < max) {
            this.min = min;
            this.max = max;
            this.current = max;
        } else if (min > max) {
            this.min = max;
            this.max = min;
            this.current = min;
        } else {
            throw new IllegalStateException("Min is max?");
        }

        System.out.println("Min: " + min + ", Max: " + max + ", Current: " + current);

    }

    public int next() throws DoneException {
        if (current >= min) return current--;
        throw new DoneException();
    }
}
