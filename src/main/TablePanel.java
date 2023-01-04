package main;

import main.dataBase.DBHandler;
import main.dataBase.User;
import org.sqlite.core.DB;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Данный класс предназначен для отображения выбранной таблицы в навигации
 * @version 2023-01-01
 * @author Nikolai Danilov
 */
public class TablePanel extends JPanel {

    private JTable tableUsers;
    private int height;
    private int width;
    private int selectUserTable = 0;

    private final NavigationPanel navigationPanel;
    public TablePanel(NavigationPanel navigationPanel, int height, int width) {
        this.navigationPanel = navigationPanel;
        this.height = height;
        this.width = width;

        setBackground(new Color(0x393939));
        setLayout(null);

        DBHandler dbHandler = DBHandler.getDBHandler();
        ArrayList<User> users = dbHandler.getAllUsers();

        TableModel tableModel = new TableModel(users);
        tableUsers = new JTable(tableModel);
        tableUsers.setBackground(new Color(0x393939));
        tableUsers.setSelectionBackground(new Color(0x555457));
        tableUsers.setForeground(new Color(0xffffff));
        tableUsers.setSelectionForeground(new Color(0xffffff));
        final Font font = new Font("Monospaced", tableUsers.getFont().getStyle(), 13);  //создали шрифт
        tableUsers.setFont(font);
        setPropColumn(tableUsers.getColumnModel().getColumn(0), 30, "ID");
        setPropColumn(tableUsers.getColumnModel().getColumn(1), 100, "Имя");
        setPropColumn(tableUsers.getColumnModel().getColumn(2), 100, "Фамилия");
        setPropColumn(tableUsers.getColumnModel().getColumn(3), 100, "Отчество");
        setPropColumn(tableUsers.getColumnModel().getColumn(4), 100, "Дата рождения");
        setPropColumn(tableUsers.getColumnModel().getColumn(5), 100, "ИИН");
        setPropColumn(tableUsers.getColumnModel().getColumn(6), 100, "Абоннимент");
        setPropColumn(tableUsers.getColumnModel().getColumn(7), 100, "Заметка");

        tableUsers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableUsers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableUsers.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tableUsers);
        scrollPane.setBounds(0, 0, width, height);
        add(scrollPane);

        JPopupMenu popupMenu = makePopupMenu();
        tableUsers.setComponentPopupMenu(popupMenu);
        tableUsers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //String str = e.toString().substring(e.toString().indexOf("{") + 1, e.toString().indexOf("}"));
                selectUserTable = Integer.parseInt(e.toString().substring(e.toString().indexOf("{") + 1, e.toString().indexOf("}")));
                System.out.println(selectUserTable);
            }
        });
        popupMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
    }
    /**
     * @return JPopupMenu
     */
    private JPopupMenu makePopupMenu() {
        JPopupMenu popup = new JPopupMenu();
        JMenu menuAction = new JMenu("Действие");
        JMenuItem edit = new JMenuItem("Изменить");
        JMenuItem delete = new JMenuItem("Удалить");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("удалить запись под id = " + selectUserTable);
            }
        });
        menuAction.add(edit);
        menuAction.add(delete);
        popup.add(menuAction);
        return popup;
    }
    /**
     * свойства колонки
     * @param column - колонка таблицы
     * @param width	- ширина колонки
     * @param header - заголовок
     */
    public static void setPropColumn(TableColumn column, int width, String header) {
        column.setMinWidth(width / 2);
        column.setMaxWidth(width * 2);
        column.setPreferredWidth(width);
        column.setHeaderValue(header);
    }
    private class TableModel extends AbstractTableModel {
        private ArrayList<User> users;
        private TableModel(ArrayList<User> users) {
            this.users = users;
        }
        @Override
        public int getRowCount() {
            return users.size();
        }
        @Override
        public int getColumnCount() {
            return 8;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            User user = users.get(rowIndex);
            switch(columnIndex) {
                case 0: return String.valueOf(user.getId());
                case 1: return String.valueOf(user.getName());
                case 2: return String.valueOf(user.getLastName());
                case 3: return String.valueOf(user.getMiddleName());
                case 4: return String.valueOf(user.getBirthday());
                case 5: return String.valueOf(user.getIin());
                case 6: return String.valueOf(user.getSubscription());
                case 7: return String.valueOf(user.getNote());
            }
            return -1;
        }
    }
}
