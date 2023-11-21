package Juego;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Enemigos {

    ImageIcon eneRosa = new ImageIcon(getClass().getResource("../images/ene-rosa.gif"));
    ImageIcon eneRojo = new ImageIcon(getClass().getResource("../images/ene-rojo.gif"));
    public static int xRosa = 120;
    public static int yRosa = 120;
    public static int xRojo = 120;
    public static int yRojo = 320;
    private final int movimiento = 40;
    int[][] lab = Tablero.tablero;
    int lado = 0;
    int posicion = 0;
    int contador = 0;

    public void paint(Graphics g) {
        g.drawImage(eneRosa.getImage(), xRosa, yRosa, null);
        g.drawImage(eneRojo.getImage(), xRojo, yRojo, null);

        try {
            Thread.sleep(200);
            //movimientos aqui

            if (lab[yRosa / 40][xRosa / 40 + 1] != 1 && lado == 0 && posicion == 0) {
                xRosa += movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }
            if (lab[yRosa / 40][xRosa / 40 - 1] != 1 && lado == 1 && posicion == 1) {
                xRosa -= movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }
            if (lab[yRosa / 40 - 1][xRosa / 40] != 1 && lado == 2 && posicion == 2) {
                yRosa -= movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }
            if (lab[yRosa / 40 + 1][xRosa / 40] != 1 && lado == 3 && posicion == 3) {
                yRosa += movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }

            if (lab[yRojo / 40][xRojo / 40 + 1] != 1 && lado == 0 && posicion == 0) {
                xRojo += movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }
            if (lab[yRojo / 40][xRojo / 40 - 1] != 1 && lado == 1 && posicion == 1) {
                xRojo -= movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }
            if (lab[yRojo / 40 - 1][xRojo / 40] != 1 && lado == 2 && posicion == 2) {
                yRojo -= movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }
            if (lab[yRojo / 40 + 1][xRojo / 40] != 1 && lado == 3 && posicion == 3) {
                yRojo += movimiento;
            } else {
                lado = (int) (Math.random() * (3 - 0 + 1) + 0);
                posicion = lado;
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Enemigos.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Personaje.ComioFruta) {
            eneRosa = new ImageIcon(getClass().getResource("../images/ene-muerto.gif"));
            eneRojo = new ImageIcon(getClass().getResource("../images/ene-muerto.gif"));
            contador++;

            if (contador == 100) {
                Personaje.ComioFruta = false;
                eneRosa = new ImageIcon(getClass().getResource("../images/ene-rosa.gif"));
                eneRojo = new ImageIcon(getClass().getResource("../images/ene-rojo.gif"));
                contador = 0;
            }
        }
    }
}
