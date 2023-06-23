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
public class Alfil extends Pieza {

    static int id = 2;
    static String nombre = "alfil";
    Image fotoImage = null;
    ArrayList<Coordenada> movimientosValidos ;
    

    public Alfil(int corTableroX, int corTableroY, boolean esBlanco, LinkedList<Pieza> listaPiezas) {
        super(corTableroX, corTableroY, esBlanco, listaPiezas, nombre);
        this.fotoImage = super.fotopieza;

    }

    public Image getFotoImage() {
        return fotoImage;
    }

    @Override
    public ArrayList<Coordenada> movimiento(int posicionX, int posicionY) {
        movimientosValidos = new ArrayList<>();
        //DERECHA - ARRIBA
        int xm = posicionX;
        int ym = posicionY;
        while (xm < 7 && ym < 7) {
            movimientosValidos.add(new Coordenada((xm + 1), (ym + 1)));
            xm++;
            ym++;
        }

        xm = posicionX;
        ym = posicionY;
        while (xm > 0 && ym < 7) {
            movimientosValidos.add(new Coordenada((xm - 1), (ym + 1)));
            xm--;
            ym++;
        }

        xm = posicionX;
        ym = posicionY;
        while (xm < 7 && ym > 0) {
            movimientosValidos.add(new Coordenada((xm + 1), (ym - 1)));
            xm++;
            ym--;
        }

        xm = posicionX;
        ym = posicionY;
        while (xm > 0 && ym > 0) {
            movimientosValidos.add(new Coordenada((xm - 1), (ym - 1)));
            xm--;
            ym--;
        }

           super.movimientosValidos = this.movimientosValidos;
     
        return movimientosValidos;
    }

}
