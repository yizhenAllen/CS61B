package gh2;

import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        long capacity = Math.round(SR / frequency);
        buffer = new LinkedListDeque<>();
        for (int i = 0; i < capacity; i++) {
            buffer.addFirst(0.0);
        }
        // Your should initially fill your buffer array with zeros.
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            double addItem = Math.random() - 0.5;
            buffer.removeLast();
            buffer.addFirst(addItem);
        }
//        you should repeatedly call Math.random() - 0.5
//        to generate new random numbers for each array index.
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double newLast = (buffer.get(0) + buffer.get(1)) / 2 * 0.996;
        buffer.removeFirst();
        buffer.addLast(newLast);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
