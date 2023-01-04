package main.navigation;

import main.dataBase.DBHandler;
import main.utils.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddNewClient extends JDialog {
    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 460;
    private JLabel labelName;
    private JTextField fieldName;
    private JLabel labelLastName;
    private JTextField fieldLastName;
    private JLabel labelMiddleName;
    private JTextField fieldMiddleName;
    private JLabel labelBirthday;
    private JTextField fieldBirthday;
    private JLabel labelIIN;
    private JTextField fieldIIN;
    private JLabel labelSubscription;
    private JTextField fieldSubscription;
    private JLabel labelNote;
    private JTextField fieldNote;


    public AddNewClient(Frame owner) {
        super(owner, "Добавить нового пользователя");
        getContentPane().setBackground(new Color(0x515151));
        setResizable(false);
        owner.setEnabled(false);
        setVisible(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize(); //получили размер основного экрана
        setLocation(screenSize.width / 2 - DEFAULT_WIDTH / 2, screenSize.height / 2 - DEFAULT_HEIGHT / 2);
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                owner.setEnabled(true);
            }
        });

        JButton addButton = new JButton("Добавить");
        addButton.setBounds(380, 370, 100, 30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAllInfo();
                owner.setEnabled(true);
                dispose();//закрыть окно
            }
        });
        JButton cancelButton = new JButton("Отмена");
        cancelButton.setBounds(500, 370, 100, 30);
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.setEnabled(true);
                dispose();//закрыть окно
            }
        });

        JButton loadButton = new JButton("Загрузить фото");
        loadButton.setBounds(40, 300, 181, 30);
        add(loadButton);

        String path = "C:\\Users\\Даниловы\\Downloads\\photo_5301045359566504793_y.jpg"; //99954237.png, photo_5301045359566504793_y.jpg
        ImagePanel imagePanel = new ImagePanel(path, 196, 256);
        imagePanel.setBounds(25, 25, 196, 256);
        add(imagePanel);

        labelName = new JLabel("Имя: ");
        labelName.setBounds(250, 25, 100, 30);
        add(labelName);
        fieldName = new JTextField("", 20);
        fieldName.setBounds(350, 25, 250, 30);
        add(fieldName);

        labelLastName = new JLabel("Фамилия: ");
        labelLastName.setBounds(250, 70, 100, 30);
        add(labelLastName);
        fieldLastName = new JTextField("", 20);
        fieldLastName.setBounds(350, 70, 250, 30);
        add(fieldLastName);

        labelMiddleName = new JLabel("Отчество: ");
        labelMiddleName.setBounds(250, 115, 100, 30);
        add(labelMiddleName);
        fieldMiddleName = new JTextField("", 20);
        fieldMiddleName.setBounds(350, 115, 250, 30);
        add(fieldMiddleName);

        labelBirthday = new JLabel("Дата рождения: ");
        labelBirthday.setBounds(250, 160, 100, 30);
        add(labelBirthday);
        fieldBirthday = new JTextField("", 20);
        fieldBirthday.setBounds(350, 160, 250, 30);
        add(fieldBirthday);

        labelIIN = new JLabel("ИИН: ");
        labelIIN.setBounds(250, 205, 100, 30);
        add(labelIIN);
        fieldIIN = new JTextField("", 20);
        fieldIIN.setBounds(350, 205, 250, 30);
        add(fieldIIN);

        labelSubscription = new JLabel("Абонимент: ");
        labelSubscription.setBounds(250, 250, 100, 30);
        add(labelSubscription);
        fieldSubscription = new JTextField("", 20);
        fieldSubscription.setBounds(350, 250, 250, 30);
        add(fieldSubscription);

        labelNote = new JLabel("Заметка: ");
        labelNote.setBounds(250, 295, 100, 30);
        add(labelNote);
        fieldNote = new JTextField("", 20);
        fieldNote.setBounds(350, 295, 250, 30);
        add(fieldNote);
    }

    private void loadAllInfo() {
        DBHandler dbHandler = DBHandler.getDBHandler();
        dbHandler.addUser(fieldName.getText(), fieldLastName.getText(), fieldMiddleName.getText(), fieldBirthday.getText(),
                fieldIIN.getText(), fieldSubscription.getText(), fieldNote.getText());
        dbHandler.printAllUsers();
    }
}
