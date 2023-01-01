import main.StartFrame;

import javax.swing.*;
import java.awt.*;

public class Start {
    public static void main(String[] args) {

        if (args[0].equals("-test")) {
            System.out.println("test");
        } else {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    StartFrame frame = new StartFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                }
            });
        }
    }
}
