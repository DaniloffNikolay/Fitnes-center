package main.utils;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JComponent {
    private Image image;
    /**высота изображения
    */
    private int heightImage;
    /**ширина изображения
     */
    private int widthImage;
    /**высота панели
     */
    private int heightPanel;
    /**ширина панели
     */
    private int widthPanel;
    public ImagePanel(String path, int widthPanel, int heightPanel) {
        image = new ImageIcon(path).getImage();
        heightImage = image.getHeight(null);
        widthImage = image.getWidth(null);
        this.widthPanel = widthPanel;
        this.heightPanel = heightPanel;
    }
    public ImagePanel(String path) {
        image = new ImageIcon(path).getImage();
        heightImage = image.getHeight(null);
        widthImage = image.getWidth(null);
        heightPanel = 0;
        widthPanel = 0;
    }

    /**
     * Рисует изображение пропорционально выделенному размеру окна
     * если размеры окна не установлены рисует изображение во весь размер
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        int x = 0;
        int y = 0;
        int width;
        int height;
        if ((heightPanel == 0) || (widthPanel == 0)) { //размеры панели не заданы, рисуем по размеру изображения
            width = widthImage;
            height = heightImage;
        } else {
            int proportionValue = heightImage / heightPanel;
            if (widthImage > heightImage) {   //ширина изображения больше чем высота
                proportionValue = widthImage / widthPanel;
            }
            width = widthImage / proportionValue;
            height = heightImage / proportionValue;
        }
        g.drawImage(image, x, y, width, height, null);
    }
}
