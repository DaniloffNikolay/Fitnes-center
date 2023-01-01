package main;

import javax.swing.*;
import java.awt.*;


/**
 * Данный класс предназначен для отображения всей информации о выбранном элементе
 * @version 2023-01-01
 * @author Nikolai Danilov
 */
public class InfoPanel extends JPanel {

    private final NavigationPanel navigationPanel;
    private final TablePanel tablePanel;
    public InfoPanel(NavigationPanel navigationPanel, TablePanel tablePanel) {
        this.navigationPanel = navigationPanel;
        this.tablePanel = tablePanel;
        setBackground(new Color(0x515151));
    }
}
