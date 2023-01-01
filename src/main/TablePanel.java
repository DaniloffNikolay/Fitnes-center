package main;

import javax.swing.*;
import java.awt.*;



/**
 * Данный класс предназначен для отображения выбранной таблицы в навигации
 * @version 2023-01-01
 * @author Nikolai Danilov
 */
public class TablePanel extends JPanel {

    private final NavigationPanel navigationPanel;
    public TablePanel(NavigationPanel navigationPanel) {
        this.navigationPanel = navigationPanel;
        setBackground(new Color(0x393939));
    }
}
