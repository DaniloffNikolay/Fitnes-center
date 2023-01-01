package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 1366;
    public static final int DEFAULT_HEIGHT = 768;

    private MainMenuBar mainMenuBar;
    private TablePanel tablePanel;
    private NavigationPanel navigationPanel;
    private InfoPanel infoPanel;

    public StartFrame () {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize(); //получили размер основного экрана
        setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height / 2 - DEFAULT_HEIGHT / 2);

        mainMenuBar = new MainMenuBar();
        setJMenuBar(mainMenuBar);

        navigationPanel = new NavigationPanel(this);
        tablePanel = new TablePanel(navigationPanel);
        infoPanel = new InfoPanel(navigationPanel, tablePanel);

        JSplitPane splitPanHor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tablePanel, infoPanel);
        splitPanHor.setResizeWeight(0.70);
        splitPanHor.setOneTouchExpandable(true);

        JSplitPane vet = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationPanel, splitPanHor);
        vet.setResizeWeight(0.15);
        vet.setOneTouchExpandable(true);
        add(vet);
    }
}
