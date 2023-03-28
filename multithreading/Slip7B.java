//display number from 1 to 100
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Slip7B extends JFrame {
    private JTextField textField;
    private JButton startButton, stopButton;
    private NumberPrinter numberPrinter;
    private Thread numberThread;

    public Slip7B() {
        setTitle("Cycle Numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);

        // Create components
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(50, 50));
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        // Add components to content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(textField);
        contentPane.add(startButton);
        contentPane.add(stopButton);

        // Add action listeners to buttons
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startNumberThread();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopNumberThread();
            }
        });
    }

    private void startNumberThread() {
        if (numberThread == null) {
            numberPrinter = new NumberPrinter();
            numberThread = new Thread(numberPrinter);
            numberThread.start();
        }
    }

    private void stopNumberThread() {
        if (numberThread != null) {
            numberPrinter.stop();
            numberThread = null;
        }
    }

    private class NumberPrinter implements Runnable {
        private boolean running;

        public void run() {
            running = true;
            int num = 1;
            while (running) {
                textField.setText(Integer.toString(num));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    running = false;
                }
                num++;
                if (num > 100) {
                    num = 1;
                }
            }
        }

        public void stop() {
            running = false;
        }
    }

    public static void main(String[] args) {
        Slip7B display = new Slip7B();
        display.setVisible(true);
    }
}

