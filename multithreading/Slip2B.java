import java.awt.*;
import java.applet.*;

public class Slip2B extends Applet implements Runnable {
    private Thread thread = null;
    private boolean running = false;
    private int x, y, width, height;

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            running = true;
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            running = false;
            thread = null;
        }
    }

    public void run() {
        while (running) {
            // Define flag dimensions
            x = 50;
            y = 50;
            width = 200;
            height = 100;

            // Set flag colors
            Color red = new Color(255, 0, 0);
            Color white = new Color(255, 255, 255);
            Color blue = new Color(0, 0, 255);

            // Draw flag
            Graphics g = getGraphics();
            g.setColor(red);
            g.fillRect(x, y, width, height / 3);
            g.setColor(white);
            g.fillRect(x, y + height / 3, width, height / 3);
            g.setColor(blue);
            g.fillRect(x, y + 2 * height / 3, width, height / 3);

            // Sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear flag
            g.setColor(getBackground());
            g.fillRect(x, y, width, height);
        }
    }
}

