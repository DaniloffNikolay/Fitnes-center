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
        setResizable(false);
        owner.setEnabled(false);
        setVisible(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize(); //получили размер основного экрана
        setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height / 2 - DEFAULT_HEIGHT / 2);

        setLayout(new GridBagLayout());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                owner.setEnabled(true);
            }
        });

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

        GridBagConstraints gbc1 =  getNewGBC(0, 0, 1, 1);
        add(label, gbc1);

        GridBagConstraints gbc2 =  getNewGBC(1, 0, 1, 1);
        add(textField, gbc2);

        GridBagConstraints gbc3 =  getNewGBC(0, 5, 1, 1);
        add(addButton, gbc3);

        GridBagConstraints gbc4 = getNewGBC(1, 5, 1, 1);
        add(cancelButton, gbc4);

        revalidate();
    }

    private GridBagConstraints getNewGBC(int gridx, int gridy, int gridheight, int gridwidth) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridheight = gridheight;
        gbc.gridwidth = gridwidth;
        return gbc;
    }
}
