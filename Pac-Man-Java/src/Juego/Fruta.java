package Juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fruta {

    public static int x = 240;
    public static int y = 120;

    public void paint(Graphics g) {
        ImageIcon fruta = new ImageIcon(getClass().getResource("../images/fruta.png"));

        g.drawImage(fruta.getImage(), x, y, null);
    }
}
