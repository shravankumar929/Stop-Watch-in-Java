package stopwatchfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StopWatchFinal {

    private static Timer myTimer1;
    public static final int ONE_SEC = 1000;   //time step in milliseconds
    public static final int TENTH_SEC = 100;
    private static int clockTick;
    private static double clockTime;
    private static String clockTimeString;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        clockTick = 0;
        clockTime = ((double) clockTick) / 10.0;
        clockTimeString = new Double(clockTime).toString();

        JFrame frame = new JFrame("Stop Watch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        
        final JLabel time = new JLabel();
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");

        time.setText(clockTimeString);
        time.setOpaque(true);
        //time.setBackground(Color.red);
        time.setFont(new Font("serif", 3, 50));
        time.setBounds(100, 30, 200, 100);
        
        start.setBounds(50, 150, 200, 50);
        
        stop.setBounds(50, 200, 200, 50);
        
        reset.setBounds(50, 250, 200, 50);

        frame.add(time);
        frame.add(start);
        frame.add(stop);
        frame.add(reset);
        
       // frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);

        myTimer1 = new Timer(TENTH_SEC, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clockTick++;
                clockTime = ((double) clockTick) / 10.0;
                clockTimeString = Double.toString(clockTime);
                time.setText(clockTimeString);
                //System.out.println(clockTime);
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                myTimer1.start();
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                myTimer1.stop();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clockTick = 0;
                clockTime = ((double) clockTick) / 10.0;
                clockTimeString = Double.toString(clockTime);
                time.setText(clockTimeString);
            }
        });

    }

}
