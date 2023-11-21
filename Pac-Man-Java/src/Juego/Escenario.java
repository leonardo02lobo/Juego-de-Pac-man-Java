package Juego;

import java.awt.Color;
import java.awt.Graphics;

public class Escenario {

    private int fila = 0;
    private int columna = 0;
    private final int ancho = 40;
    private final int largo = 40;

    public void paint(Graphics g) {
        int[][] laberinto = Tablero.tablero;

        for (fila = 0; fila < laberinto.length; fila++) {
            for (columna = 0; columna < laberinto[0].length; columna++) {

                if (laberinto[fila][columna] == 1) {
                    g.setColor(Color.cyan);
                    g.fillRect(columna * 40, fila * 40, ancho, largo);
                    g.setColor(Color.black);
                    g.drawRect(columna * 40, fila * 40, ancho, largo);
                }

            }
        }
    }

}
