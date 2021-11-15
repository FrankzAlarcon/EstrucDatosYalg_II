/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgFuerzaBruta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 *
 * @author Frankz
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();
        char[] textoOriginal = new String("Hola Frankz").toCharArray();
        char[] patron = "nkz".toCharArray();
        /*char[] busquedaAdicional = "e".toCharArray();
        String textoLorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras condimentum ullamcorper leo, blandit posuere magna sodales nec. Nulla commodo lacus quis turpis lobortis, sed tincidunt nisi consectetur. Aliquam viverra et mauris ut mattis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc et turpis neque. Praesent vestibulum euismod dolor. Sed tempus sapien a mauris dapibus, ut cursus lectus porta. Quisque in erat eros. Proin ut enim sit amet lectus molestie interdum. Aenean sit amet lobortis nibh. Nunc sed justo leo. Pellentesque in laoreet risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean imperdiet risus erat, non condimentum dolor malesuada vel.";
        System.out.println("Por arreglo de char");
        System.out.println(fuerzaBruta(textoOriginal, patron));
        System.out.println(fuerzaBruta(textoOriginal, busquedaAdicional));
        System.out.println("Por String");
        System.out.println(fuerzaBruta(textoLorem, "Lorem"));
        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo utilizado (ms): " + tiempoFinal); */
        String patronString = "fuerza";
        //Lectura de Archivos
        try{
            File doc = new File("C:\\Users\\Frankz\\OneDrive\\Documentos\\NetBeansProjects\\EDA_II\\src\\AlgFuerzaBruta\\contenido.txt"); 
            
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            
            String linea;
            int cont=0;
            while((linea = obj.readLine()) != null){
                //System.out.println(linea);
                cont++;
                System.out.println("En la linea " + cont + ": " +fuerzaBruta(linea, patronString));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo utilizado (ms): " + tiempoFinal);
    }   
    
    private static int patternMatchingfuerzaBruta(char[] texto, char [] patron){
        int longitudTexto = texto.length;
        int longitudPatron = patron.length;
        
        if(longitudTexto < longitudPatron){
            return -1;
        }
        
        for(int i = 0; i <= (longitudTexto - longitudPatron); i++){
            int j = 0;
            while(j < longitudPatron && texto[i + j] == patron[j]){
                j++;
            }
            if(j == longitudPatron){
                return i;
            }
        }
        return -1;
    }
    private static String fuerzaBruta(char[] texto, char[] patron){
        int longitudTexto = texto.length;
        int longitudPatron = patron.length;
        String strPosiciones = "Se encontraron las siguientes posiciones: ";
        if(longitudTexto < longitudPatron){
            return strPosiciones;
        }        
        for (int i = 0; i <= (longitudTexto - longitudPatron); i++) {
            int j = 0; //Itera dentro del patron
            while(j < longitudPatron && texto[i+j]==patron[j]){
                j++;
            }            
            if(j == longitudPatron){
                strPosiciones = strPosiciones + i + " hasta " + (i + longitudPatron-1) + ", ";                
            }
        }
        return strPosiciones;        
    }
        private static String fuerzaBruta(String texto, String patron){
        int longitudTexto = texto.length();
        int longitudPatron = patron.length();        
        String strPosiciones = "Se encontraron las siguientes posiciones: ";
        if(longitudTexto < longitudPatron){
            return strPosiciones;
        }        
        for (int i = 0; i <= (longitudTexto - longitudPatron); i++) {
            int j = 0; //Itera dentro del patron
            while(j < longitudPatron && texto.charAt(i+j)==patron.charAt(j)){
                j++;
            }            
            if(j == longitudPatron){
                strPosiciones = strPosiciones + i + " hasta " + (i + longitudPatron - 1) + ", ";                
            }
        }
        return strPosiciones;       
    }
}
