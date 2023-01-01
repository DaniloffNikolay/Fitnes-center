package Main;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 1366;
    public static final int DEFAULT_HEIGHT = 768;

    public StartFrame () {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize(); //получили размер основного экрана
        setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height / 2 - DEFAULT_HEIGHT / 2);



    }

}
