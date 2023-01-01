package main.navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddNewClient extends JDialog {

    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 460;
    public AddNewClient(Frame owner) {
        super(owner, "Добавить нового пользователя");
        setVisible(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize(); //получили размер основного экрана
        setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height / 2 - DEFAULT_HEIGHT / 2);
    }
}
