/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red;

import java.io.*;

public class archivo {
    public double[][] entradas(double[][]entraFigura){                               
        BufferedReader acu;
        try{                                                                                 
            File archivo=new File("C:\\Users\\miran\\OneDrive\\Escritorio\\Trabajos\\Laboratorio\\RED\\src\\red\\entradas.txt");
            FileReader datos= new FileReader(archivo);
            acu=new BufferedReader(datos);                      
            for(int i = 0;i< 1000; i++){
                String lee_archivo=acu.readLine();                
                String vector[]=lee_archivo.split(",");
                double y1;
                double y2;
                double y3;
                double y4;
                double y5;
                double y6;
                double y7;                     
                y1=Double.parseDouble(vector[0]);                    
                y2=Double.parseDouble(vector[1]);
                y3=Double.parseDouble(vector[2]);
                y4=Double.parseDouble(vector[3]);
                y5=Double.parseDouble(vector[4]);
                y6=Double.parseDouble(vector[5]);
                y7=Double.parseDouble(vector[6]);
                entraFigura[i] = new double[]{y1,y2,y3,y4,y5,y6,y7};                                                 
            }    
        }
        catch(IOException ex){
            System.err.println("error "+ex.getMessage());                   
        }
        return entraFigura;
    }
    
    
    
    
    public double[] salidas(double[] sal){                               
        BufferedReader acu;
        try{                                                                                 
            File archivo=new File("C:\\Users\\miran\\OneDrive\\Escritorio\\Trabajos\\Laboratorio\\RED\\src\\red\\salidas.txt");
            FileReader datos= new FileReader(archivo);
            acu=new BufferedReader(datos);                      
            for(int i = 0;i< 1000; i++){
                String lee_archivo=acu.readLine();
     
                double y;
                y=Double.parseDouble(lee_archivo);    
                sal[i]=y ;//= new double[]{y};                                                 
            }    
        }
        catch(IOException ex){
            System.err.println("error "+ex.getMessage());           
        
        }
        return sal;
    }
     
}