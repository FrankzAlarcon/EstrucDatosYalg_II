/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgFuerzaBruta;


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
        char[] textoOriginal = new String("Bienvenidos a esta demo de busqueda.").toCharArray();
        char[] patron = "de".toCharArray();
        char[] busquedaAdicional = "e".toCharArray();
        String textoLorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras condimentum ullamcorper leo, blandit posuere magna sodales nec. Nulla commodo lacus quis turpis lobortis, sed tincidunt nisi consectetur. Aliquam viverra et mauris ut mattis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc et turpis neque. Praesent vestibulum euismod dolor. Sed tempus sapien a mauris dapibus, ut cursus lectus porta. Quisque in erat eros. Proin ut enim sit amet lectus molestie interdum. Aenean sit amet lobortis nibh. Nunc sed justo leo. Pellentesque in laoreet risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean imperdiet risus erat, non condimentum dolor malesuada vel.";
        System.out.println("Por arreglo de char");
        System.out.println(fuerzaBruta(textoOriginal, patron));
        System.out.println(fuerzaBruta(textoOriginal, busquedaAdicional));
        System.out.println("Por String");
        System.out.println(fuerzaBruta(textoLorem, "Lorem"));
        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo utilizado (ms): " + tiempoFinal);
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
