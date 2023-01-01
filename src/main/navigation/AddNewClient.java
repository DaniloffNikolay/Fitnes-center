package main.navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddNewClient extends JDialog {

    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 460;
    public AddNewClient(Frame owner) {
        super(owner, "Добавить нового пользователя");
        owner.setEnabled(false);
        setVisible(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize(); //получили размер основного экрана
        setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height / 2 - DEFAULT_HEIGHT / 2);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                owner.setEnabled(true);
            }
        });

        setLayout(new FlowLayout());

        JButton addButton = new JButton("Добавить");
        JButton cancelButton = new JButton("Отмена");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.setEnabled(true);
                dispose();//закрыть окно
            }
        });

        JTextField textField = new JTextField("Поле", 20);
        JLabel label = new JLabel("Имя: ");

        add(label);
        add(textField);
        add(addButton);
        add(cancelButton);
    }
}
