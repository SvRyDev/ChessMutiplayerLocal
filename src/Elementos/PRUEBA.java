/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Elementos;

import java.util.ArrayList;

/**
 *
 * @author Arturo
 */
public class PRUEBA {

    static int posicionX = 0;
    static int posicionY = 4;

    public static void main(String[] args) {

        ArrayList<Coordenada> coo = new ArrayList<>();
        System.out.println("DERECHA ARRIBA ");
        int xm = posicionX;
        int ym = posicionY;
        while (xm < 7 && ym < 7) {
            coo.add(new Coordenada((xm + 1), (ym + 1)));
            xm++;
            ym++;
            System.out.println(": " + xm + ":" + ym);
        }

        System.out.println("IZQUIERDA ARRIBA ");
        xm = posicionX;
        ym = posicionY;
        while (xm > 0 && ym < 7) {
            coo.add(new Coordenada((xm - 1), (ym + 1)));
            xm--;
            ym++;
            System.out.println(": " + xm + ":" + ym);
        }

        System.out.println("DERECHA ABAJO ");
        xm = posicionX;
        ym = posicionY;
        while (xm < 7 && ym > 0) {
            coo.add(new Coordenada((xm + 1), (ym - 1)));
            xm++;
            ym--;
            System.out.println(": " + xm + ":" + ym);
        }

        System.out.println("IZQUIERDA ABAJO ");
        xm = posicionX;
        ym = posicionY;
        while (xm > 0 && ym > 0) {
            coo.add(new Coordenada((xm - 1), (ym - 1)));
            xm--;
            ym--;
            System.out.println(": " + xm + ":" + ym);
        }

        
        System.out.println("TOTAL ▓");
        for (int i = 0; i < coo.size(); i++) {
              System.out.println(i + ": " + coo.get(i).x + ":" + coo.get(i).y);
        }
        System.out.println("TOTAL DE MOVIMIENTOS " + coo.size());
    }

}
