package main;

import main.navigation.AddNewClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Данный класс предназначен для отображения навигации по базе
 * @version 2023-01-01
 * @author Nikolai Danilov
 */
public class NavigationPanel extends JPanel {

    private final JFrame owner;

    public NavigationPanel(JFrame owner) {
        this.owner = owner;
        setBackground(new Color(0x515151));

        JButton button = new JButton("Новый пользователь");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewClient addNewClient = new AddNewClient(owner);
            }
        });
        add(button);

    }
}
