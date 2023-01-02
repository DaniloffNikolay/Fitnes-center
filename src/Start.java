import main.StartFrame;
import main.dataBase.DBHandler;

import javax.swing.*;
import java.awt.*;

public class Start {
    public static void main(String[] args) {
        loadDB();

        if (args[0].equals("-test")) {
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

    private static void loadDB() {
        DBHandler dbHandler = new DBHandler();
        dbHandler.connectionDB();
    }
}
