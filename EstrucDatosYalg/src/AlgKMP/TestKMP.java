/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgKMP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 *
 * @author Frankz
 */
public class TestKMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*char []cadena = "gfjbfdgdfabcdfdfndfgjdfngudfabcdfdgfd".toCharArray();
        char []pattern = "abcd".toCharArray();
        System.out.println(findKMP(cadena, pattern));*/
        long tiempoInicio = System.currentTimeMillis();
        try{
            File doc = new File("C:\\Users\\Frankz\\OneDrive\\Documentos\\NetBeansProjects\\EstrucDatosYalg_II\\EstrucDatosYalg\\src\\AlgKMP\\CadenasKMP.txt"); 
            
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            
            String linea;
            int cont=0;
            while((linea = obj.readLine()) != null){
                //System.out.println(linea);
                cont++;
                System.out.println("En la linea " + cont + ": " +findKMP(linea.toCharArray(), "0101001001010111".toCharArray()));
            }
        }catch(Exception e){
             System.out.println(e.toString());
        }
        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo utilizado (ms): " + tiempoFinal);
    }
    
    private static String findKMP(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        String strLocations = "";
        if(m == 0){
            return strLocations;
        }
        int fail[] = computeFailKMP(pattern);
        //System.out.println(Arrays.toString(fail));
        int j = 0;
        int k = 0;
        while(j < n) {
            if(text[j] == pattern[k]){
                if(k==(m-1)){
                    int pos = j-m+1;
                    strLocations += pos + ", ";
                    k = 0;
                }
                j++;
                k++;
            }else if(k>0){
                k=fail[k-1];
            } else {
                j++;
            }
        }
        return strLocations;
    }
    
    private static int[] computeFailKMP(char[] patron) {
        int longitudPatron = patron.length;
        int []fail= new int[longitudPatron];
        int runnerIndex = 1;
        int mainIndex = 0;
        while(runnerIndex < longitudPatron){
            if(patron[mainIndex] == patron[runnerIndex]){
                fail[runnerIndex] = mainIndex + 1;
                mainIndex++;
                runnerIndex++;
            }else if(mainIndex > 0){
                mainIndex = fail[mainIndex - 1];
            } else {
                runnerIndex++;
            }
        }
        return fail;
    }
}
