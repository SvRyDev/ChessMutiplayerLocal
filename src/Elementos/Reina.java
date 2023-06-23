/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Arturo
 */
public class Reina extends Pieza{
    
    static int id = 1;
    static String nombre = "reina";
    Image fotoImage = null;
    
    ArrayList<Coordenada> movimientosValidos ;
    

    public Reina(int corTableroX, int corTableroY, boolean esBlanco, LinkedList<Pieza> listaPiezas) {
        super(corTableroX, corTableroY, esBlanco, listaPiezas, nombre);
        this.fotoImage = super.fotopieza;

    }

    public Image getFotoImage() {
        return fotoImage;
    }

    @Override
    public ArrayList<Coordenada> movimiento(int posicionX, int posicionY) {
        movimientosValidos = new ArrayList<>();
         for (int i = posicionX; i > 0; i--) {
            movimientosValidos.add(new Coordenada((i - 1), posicionY));
        }

        //HACIA LA DERECHA
        for (int i = posicionX; i < 7; i++) {
            movimientosValidos.add(new Coordenada((i + 1), posicionY));
        }

        //HACIA ABAJO
        for (int i = posicionY; i > 0; i--) {
            movimientosValidos.add(new Coordenada(posicionX, (i - 1)));
        }

        //HACIA LA ARRIBA
        for (int i = posicionY; i < 7; i++) {
            movimientosValidos.add(new Coordenada(posicionX, (i + 1)));
        }
        //DERECHA - ARRIBA
         System.out.println("DERECHA ARRIBA ");
        int xm = posicionX;
        int ym = posicionY;
        while (xm < 7 && ym < 7) {
            movimientosValidos.add(new Coordenada((xm + 1), (ym + 1)));
            xm++;
            ym++;
            System.out.println(": " + xm + ":" + ym);
        }

        System.out.println("IZQUIERDA ARRIBA ");
        xm = posicionX;
        ym = posicionY;
        while (xm > 0 && ym < 7) {
            movimientosValidos.add(new Coordenada((xm - 1), (ym + 1)));
            xm--;
            ym++;
            System.out.println(": " + xm + ":" + ym);
        }

        System.out.println("DERECHA ABAJO ");
        xm = posicionX;
        ym = posicionY;
        while (xm < 7 && ym > 0) {
            movimientosValidos.add(new Coordenada((xm + 1), (ym - 1)));
            xm++;
            ym--;
            System.out.println(": " + xm + ":" + ym);
        }

        System.out.println("IZQUIERDA ABAJO ");
        xm = posicionX;
        ym = posicionY;
        while (xm > 0 && ym > 0) {
            movimientosValidos.add(new Coordenada((xm - 1), (ym - 1)));
            xm--;
            ym--;
            System.out.println(": " + xm + ":" + ym);
        }

           super.movimientosValidos = this.movimientosValidos;
        System.out.println("TOTAL ▓");
        for (int i = 0; i < movimientosValidos.size(); i++) {
              System.out.println(i + ": " + movimientosValidos.get(i).x + ":" + movimientosValidos.get(i).y);
        }
        System.out.println("TOTAL DE MOVIMIENTOS " + movimientosValidos.size());

        return movimientosValidos;
    }

}
