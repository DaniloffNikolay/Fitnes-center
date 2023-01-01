package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuBar extends JMenuBar {


    public MainMenuBar() {
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        add(fileMenu);

        JMenu optionMenu = new JMenu("Настройки");
        add(optionMenu);

        JMenu WindowMenu = new JMenu("Окно");
        add(WindowMenu);

        JMenu HelpMenu = new JMenu("Помощь");
        add(HelpMenu);
    }
}
