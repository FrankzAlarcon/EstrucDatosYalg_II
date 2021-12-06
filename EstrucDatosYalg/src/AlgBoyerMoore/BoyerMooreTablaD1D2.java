/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgBoyerMoore;

import java.util.Arrays;

/**
 *
 * @author Frankz
 */
public class BoyerMooreTablaD1D2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        char[] texto = "DJFBSHIFBSDU AACGTAACGBAACGDOFIOFDSOAACGTAACGBAACGDIFDSOFNSDJNAACGTAACGBAACGDJFBSDFSDUAACGTAACGBAACGDJFBSDAACGTAACGBAACGDFDSBFSDIAACGTAACGBAACGDJFBSDJFAACGTAACGBAACGD".toCharArray();
        char[] patron = "AACGTAACGBAACGD".toCharArray();
        System.out.println(Arrays.toString(construirTablaD1(patron)));
        //System.out.println("" + busquedaBM(texto, patron, construirTablaD1(patron)));
        int[] tD2 = new int[patron.length];
        tD2 = construirTablaD2(patron);
        System.out.println(busquedaBMD1D2(patron, texto, construirTablaD1(patron), construirTablaD2(patron)));
    }
    
    private static String busquedaBMD1D2(char[] patron, char[] texto, int[] tablaD1, int[] tablaD2){
        String resultado = "";
        int i = 0, j = 0;
        int n = texto.length;
        int m = patron.length;
        
        while(i <= (n-m)){
            j = m-1;
            while(j > 0 && patron[j] == texto[i + j]) j--;
            if(j < 0){
                resultado += i + ", ";
                i = tablaD2[0];
            } else {
                i += Math.max(tablaD2[j], j-tablaD1[texto[i+j]]);
            }
        }
        
        return resultado;
    }

    private static String busquedaBM(char[] texto, char[] patron, int[] tablaD1) {
        //int posicionCoincidencia = -1;
        String posicionCoincidencia = "";

        int m = patron.length;
        int n = texto.length;
        int j = m - 1;
        int k = m - 1;

        while (j < n) {
            if (k > -1 && texto[j] == patron[k]) {
                if (k == 0) {
                    posicionCoincidencia += j + ",";
                    //return posicionCoincidencia;
                }
                j--;
                k--;
            } else {
                //j += m - Math.min(k, 1 + vectorCaracteres.get(texto[j]));
                j += m - Math.min(k, 1 + tablaD1[(char) texto[j]]);
                k = m - 1;
            }
        }
        return posicionCoincidencia;
    }

    private static int[] construirTablaD1(char[] patron) {
        char a;
        int m = patron.length;
        final int LONGITUD_CARACTERES_ASCII = 256;
        int[] tablaD1 = new int[LONGITUD_CARACTERES_ASCII];
        //Llenado de informacion
        for (a = 0; a < LONGITUD_CARACTERES_ASCII; a++) {
            tablaD1[(char) a] = -1;
        }
        for (int j = 0; j < m; j++) {
            a = patron[j];//Guardo la letra del patron en la pos j
            tablaD1[(char) a] = j;
        }

        return tablaD1;
    }

    private static int[] determinarSufijos(char[] car, int m) {
        int[] sufijos = new int[car.length];
        int f = 0, g = 0, h = 0;
        sufijos[m - 1] = m;
        g = m - 1;

        for (h = m - 2; h >= 0; h--) {
            if (h > g && sufijos[h + m - 1 - f] < (h - g)) {
                sufijos[h] = sufijos[h + m - 1 - f];
            } else {
                if (h < g) {
                    g = h;
                }
                f = h;
                while (g >= 0 && car[g] == car[g + m - 1 - f]) {
                    --g;
                }
                sufijos[h] = f - g;
            }
        }
        return sufijos;
    }

    private static int[] construirTablaD2(char[] patron) {
        int m = patron.length;
        int[] tablaD2 = new int[m];
        int i, j;
        int[] sufijos = new int[m];
        sufijos = determinarSufijos(patron, m);
        for (i = 0; i < m; i++) {
            tablaD2[i] = m;
        }
        j = 0;
        for (i = m - 1; i >= -1; i--) {
            if (i == -1 || sufijos[i] == i + 1) {
                for (; j < m - 1 - i; j++) {
                    if (tablaD2[j] == m) {
                        tablaD2[j] = m - 1 - i;
                    }
                }
            }
        }
        for(i = 0; i <= m - 2; ++i){
            tablaD2[m-1-sufijos[i]] = m - 1 - i;
        }
        return tablaD2;
    }
}
