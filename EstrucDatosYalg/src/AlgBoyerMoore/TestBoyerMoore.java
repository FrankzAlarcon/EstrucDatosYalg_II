/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgBoyerMoore;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Frankz
 */
public class TestBoyerMoore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //busquedaBoyerMoore("Hola".toCharArray(), "ol".toCharArray());
        System.out.println("Posicion del dato es: ");
        System.out.println(busquedaBoyerMooreManyMatches("Esto es un texto de prueba de texto con texto texto".toCharArray(), "zzzzz".toCharArray()));
    }

    //del internet con HashMap
    private static int busquedaBoyerMoore(char[] texto, char patron[]) {
        int posicionCoincidencia = 0;
        //Longitudes del patron y del texto
        int n = texto.length;
        int m = patron.length;
        if (m == 0) {
            return posicionCoincidencia;//-1;
        }
        //Tabla D1
        Map<Character, Integer> vectorCaracteres = new HashMap<>();
        for (int i = 0; i < n; i++) {
            vectorCaracteres.put(texto[i], -1);
        }
        for (int i = 0; i < m; i++) {
            vectorCaracteres.put(patron[i], i);
        }

        int j = m - 1;
        int k = m - 1;

        while (j < n) {
            if (texto[j] == patron[k]) {
                if (k == 0) {
                    posicionCoincidencia = j;
                    return posicionCoincidencia;
                }
                j--;
                k--;
            } else {
                j += m - Math.min(k, 1 + vectorCaracteres.get(texto[j]));
                k = m - 1;
            }
        }
        return posicionCoincidencia;
    }

    private static String busquedaBoyerMooreManyMatches(char[] texto, char patron[]) {
        String result = "";
        //Longitudes del patron y del texto
        int longTexto = texto.length;
        int longPatron = patron.length;
        if (longPatron == 0 || longPatron > longTexto) {
            return result;//-1;
        }
        //Tabla D1
        Map<Character, Integer> vectorCaracteres = new HashMap<>();
        for (int i = 0; i < longTexto; i++) {
            vectorCaracteres.put(texto[i], -1);
        }
        for (int i = 0; i < longPatron; i++) {
            vectorCaracteres.put(patron[i], i);
        }

        int indexTexto = longPatron - 1;
        int indexPatron = longPatron - 1;
        //int indexTexto = 0;
        boolean coincidencia = false;
        while (indexTexto < longTexto) {
            if (texto[indexTexto] == patron[indexPatron]) {
                if (indexPatron == 0) {
                    result += indexTexto + ", ";
                    indexPatron = longPatron;
                    coincidencia = true;
                }
                indexTexto--;
                indexPatron--;
            } else {
                if (coincidencia) {
                    indexTexto += longPatron + 1;
                    coincidencia = false;
                } else {
                    indexTexto += longPatron - Math.min(indexPatron, 1 + vectorCaracteres.get(texto[indexTexto]));
                }
                indexPatron = longPatron - 1;
            }
        }
        return result;
    }
}
