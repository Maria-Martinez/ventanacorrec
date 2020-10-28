package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorCSV {

    private final String SEPARATOR = ",";          //declaracion de una variable
    private ArrayList<String[]> datos;            //creacion de un arreglo

    public void extraerDatos(String url) {

        datos = new ArrayList<>();               //creacion de un nuevo arreglo
        BufferedReader br = null;               //lee un archivo csv

        try {

            br = new BufferedReader(new FileReader(url));         //creacion de una clase para lectura de un archivo
            String line = br.readLine();                         //declaracion de variables tipo texto
            while (null != line) {                              //ciclo repetitivo hasta que acabe la operacion
                String[] fields = line.split(SEPARATOR);
                datos.add(fields);
                line = br.readLine();
            }

        } catch (Exception e) {                           //contiene sentencias
            System.out.println(e);                       //metodo para imprimir
        } finally {
            if (null != br) {                          //metodo que proporciona instrucciones al programa
                try {                                 //se utiliza para tener escepciones en el programa
                    br.close();                      //cierre de operacion
                } catch (IOException ex) {          //contiene sentencias 
                    Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public String[][] calcularPromedio() {                              //metodo principal del programa 
        String[][] promedios = new String[datos.size()][2];
        
        for (int i = 0; i < datos.size(); i++) {
            promedios[i][0] = datos.get(i)[1];
            float prom = (Float.parseFloat(datos.get(i)[2]) + Float.parseFloat(datos.get(i)[3])   //declara una variable tipo decimal
                    + Float.parseFloat(datos.get(i)[4]) + Float.parseFloat(datos.get(i)[5])) / 4;
            promedios[i][1] = prom + "";
        }
        return promedios;
    }
    
    public float getPromedioNota(int nota){
        float promedio = 0;                  //declara una variable tipo decimal
        int posicionNota = 1+nota;
        for(String[] x : datos){
            promedio+=Float.parseFloat(x[posicionNota]);
        }
        promedio/=datos.size();
        
        return promedio;
    }
}
