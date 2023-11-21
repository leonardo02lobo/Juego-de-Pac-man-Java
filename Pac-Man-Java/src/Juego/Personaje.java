package Juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Personaje {

    public static boolean ComioFruta = false;
    public static boolean ahMuerto = false;
    public static int x = 40;
    public static int y = 40;
    private int movimiento = 40;
    ImageIcon pacman = new ImageIcon(getClass().getResource("../images/pacman-dere.png"));
    
    public void paint(Graphics g) {
        
        g.drawImage(pacman.getImage(), x, y, null);
    }

    public void KeyPressed(KeyEvent e) {
        int[][] laberinto = Tablero.tablero;
        if (e.getKeyCode() == 37) {
            if (laberinto[y / 40][x / 40 - 1] != 1) {
                pacman = new ImageIcon(getClass().getResource("../images/pacman-izq.png"));
            x = x - movimiento;
            }
        }
        if (e.getKeyCode() == 39) {
            if (laberinto[y / 40][x / 40 + 1] != 1) {
                pacman = new ImageIcon(getClass().getResource("../images/pacman-dere.png"));
                x = x + movimiento;
            }
        }
        if (e.getKeyCode() == 38) {
            if (laberinto[y / 40 - 1][x / 40] != 1) {
                pacman = new ImageIcon(getClass().getResource("../images/pacman-arriba.png"));
                y = y - movimiento;
            }
        }
        if (e.getKeyCode() == 40) {
            if (laberinto[y / 40 + 1][x / 40] != 1) {
                pacman = new ImageIcon(getClass().getResource("../images/pacman-abajo.png"));
                y = y + movimiento;
            }
        }
        
        if(x == Fruta.x && y == Fruta.y){
            Fruta.x = 360;
            Fruta.y = 240;
            ComioFruta = true;
        }
        if(x == Enemigos.xRojo && y == Enemigos.yRojo && ComioFruta){
            Enemigos.xRojo = 120;
            Enemigos.yRojo = 320;
        }
        if(x == Enemigos.xRosa && y == Enemigos.yRosa && ComioFruta){
            Enemigos.xRosa = 120;
            Enemigos.yRosa = 120;
        }
        if((x == Enemigos.xRojo && y == Enemigos.yRojo) || (x == Enemigos.xRosa && y == Enemigos.yRosa)){
            ahMuerto = true;
            x = 40;
            y = 40;
        }
    }
}
