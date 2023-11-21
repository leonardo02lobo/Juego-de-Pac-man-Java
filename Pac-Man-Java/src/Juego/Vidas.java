package Juego;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Vidas {
    public static int vidas = 3;
    
    public void paint(Graphics g){
        g.setFont(new Font("calibri", 1, 25));
        g.drawString("Vidas : "+vidas, 10, 500);
        
        if(Personaje.ahMuerto){
            vidas--;
            Personaje.ahMuerto = false;
        }   
    }

}
